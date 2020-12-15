package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryA;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryB;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.mixin.MediaMixin;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.RealisticMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class GameModel implements IGameModel, MediaMixin {
    private int score;
    private AbsCannon cannon;
    private List<AbsMissile> missiles;
    private List<AbsGameInfo> gameInfos;
    private List<AbsEnemy> enemies;
    private List<IObserver> observers;
    private List<AbsCollision> collisions;
    private IGameObjectFactory gameObjectFactoryA;
    private IGameObjectFactory gameObjectFactoryB;
    private IMovingStrategy movingStrategy;
    private Queue<AbstractGameCommand> unexecutedCommands = new LinkedBlockingQueue<>();
    private Stack<AbstractGameCommand> executedCommands = new Stack<>();

    public GameModel() {
        movingStrategy = new SimpleMovingStrategy();
        observers = new ArrayList<>();
        gameObjectFactoryA = new GameObjectsFactoryA(this);
        gameObjectFactoryB = new GameObjectsFactoryB();
        cannon = gameObjectFactoryA.createCannon();
        missiles = new ArrayList<>();
        enemies = new ArrayList<>();
        collisions = new ArrayList<>();
        gameInfos = new ArrayList<>();
        score = 0;
        updateGameInfos();
        spawnEnemies();
    }

    public void update() {
        executeCommands();
        moveMissiles();
        updateGameInfos();
        spawnEnemies();
        destroyCollisions();
    }

    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

    public void shootCannon() {
        missiles.addAll(cannon.shoot());
        playSound("shoot.wav");
        notifyObservers();
    }

    public void aimCannonUp() {
        cannon.aimUp();
        notifyObservers();
    }

    public void aimCannonDown() {
        cannon.aimDown();
        notifyObservers();
    }

    public void powerCannonDown() {
        cannon.powerDown();
        notifyObservers();
    }

    public void powerCannonUp() {
        cannon.powerUp();
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public void timeTick() {
        update();
    }

    public void toggleMovingStrategy() {
        if (movingStrategy instanceof SimpleMovingStrategy) {
            movingStrategy = new RealisticMovingStrategy();
        }
        else if (movingStrategy instanceof RealisticMovingStrategy) {
            movingStrategy = new SimpleMovingStrategy();
        }
    }

    public void toggleShootingMode() {
        cannon.toggleShootingMode();
    }

    private void destroyMissiles() {
        List<AbsMissile> toRemove = new ArrayList<>();

        for (AbsMissile missile : missiles)
            if (missile.getPosition().getX() > MvcGameConfig.MAX_X)
                toRemove.add(missile);

        missiles.removeAll(toRemove);
    }

    private void moveMissiles() {
        for (int i = 0; i < missiles.size(); i++) {
            missiles.get(i).move();
            if (collisionOccurred(missiles.get(i))) {
                playSound("explosion.wav");
                missiles.remove(missiles.get(i));
                score++;
            }
        }

        destroyMissiles();
        notifyObservers();
    }

    private boolean collisionOccurred(AbsMissile missile) {
        for (int i = 0; i < enemies.size(); i++) {
            int mX = missile.getPosition().getX();
            int mY = missile.getPosition().getY();
            int eX = enemies.get(i).getPosition().getX();
            int eY = enemies.get(i).getPosition().getY();

            if (mX + MvcGameConfig.ENEMY_WIDTH >= eX && mX <= eX && mY + MvcGameConfig.ENEMY_HEIGHT + 20 >= eY && mY - 20 <= eY) {
                collisions.add(gameObjectFactoryA.createCollision(new Position(eX, eY)));
                enemies.remove(i);
                return true;
            }
        }
        return false;
    }

    private void destroyCollisions() {
        for (int i = 0; i < collisions.size(); i++) {
            if (collisions.get(i).getAge() >= 1500)
                collisions.remove(i);
        }
    }

    private void updateGameInfos() {
        gameInfos.clear();
        String text1 = "Force: " + cannon.getPower() + ", Angle: " + String.format("%.2f", cannon.getAngle()) +
                ", Gravity: " + MvcGameConfig.GRAVITY + ", Score: " + score;
        gameInfos.add(gameObjectFactoryA.createGameInfo(text1));
        String text2 = "Shooting mode: " + cannon.getShootingMode().getName() + ", Moving mode: " + movingStrategy.getName();
        gameInfos.add(gameObjectFactoryB.createGameInfo(text2));
    }

    public List<AbsEnemy> getEnemies() { return enemies; }

    public List<AbsMissile> getMissiles() { return missiles; }

    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(missiles);
        gameObjects.add(cannon);
        gameObjects.addAll(gameInfos);
        gameObjects.addAll(enemies);
        gameObjects.addAll(collisions);

        return gameObjects;
    }

    public IMovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    private class Memento {
        private int score;
        private int cannonX;
        private int cannonY;
        private double angle;
        private int power;
        private List<AbsMissile> missiles;
        private List<AbsGameInfo> gameInfos;
        private List<AbsEnemy> enemies;
        private List<AbsCollision> collisions;
    }

    public Object createMemento() {
        Memento memento = new Memento();
        memento.score = score;
        memento.cannonX = getCannonPosition().getX();
        memento.cannonY = getCannonPosition().getY();
        memento.angle = cannon.getAngle();
        memento.power = cannon.getPower();
        memento.missiles = new ArrayList<>(missiles);
        memento.gameInfos = new ArrayList<>(gameInfos);
        memento.enemies = new ArrayList<>(enemies);
        memento.collisions = new ArrayList<>(collisions);

        return memento;
    }

    public void setMemento(Object m) {
        Memento memento = (Memento)m;
        score = memento.score;
        cannon.getPosition().setX(memento.cannonX);
        cannon.getPosition().setY(memento.cannonY);
        cannon.setAngle(memento.angle);
        cannon.setPower(memento.power);
        missiles.clear();
        missiles.addAll(memento.missiles);
        gameInfos.clear();
        gameInfos.addAll(memento.gameInfos);
        enemies.clear();
        enemies.addAll(memento.enemies);
        collisions.clear();
        collisions.addAll(memento.collisions);
    }

    @Override
    public Position getCannonPosition() {
        return new Position(this.cannon.getPosition().getX(), this.cannon.getPosition().getY());
    }

    private void spawnEnemies() {
        while (enemies.size() < MvcGameConfig.MAX_ENEMIES) {
            Random rand = new Random();
            int x = rand.ints(
                    1, MvcGameConfig.ENEMIES_OFFSET_X, MvcGameConfig.MAX_X - MvcGameConfig.ENEMIES_OFFSET
            ).findFirst().getAsInt();
            int y = rand.ints(
                    1, MvcGameConfig.ENEMIES_OFFSET, MvcGameConfig.MAX_Y - MvcGameConfig.ENEMIES_OFFSET
            ).findFirst().getAsInt();
            Position enemyPos = new Position(x, y);
            if (rand.nextInt(2) == 0)
                enemies.add(gameObjectFactoryA.createEnemy(enemyPos));
            else
                enemies.add(gameObjectFactoryB.createEnemy(enemyPos));
            notifyObservers();
        }
    }

    @Override
    public void registerCommand(AbstractGameCommand command) {
        unexecutedCommands.add(command);
    }

    @Override
    public void undoLastCommand() {
        if (executedCommands.isEmpty()) return;

        AbstractGameCommand command = executedCommands.pop();
        command.unExecute();
        notifyObservers();
    }

    private void executeCommands() {
        while(!unexecutedCommands.isEmpty()) {
            AbstractGameCommand command = unexecutedCommands.poll();
            command.doExecute();
            executedCommands.push(command);
        }
    }
}
