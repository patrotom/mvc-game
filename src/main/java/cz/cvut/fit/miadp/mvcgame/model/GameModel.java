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

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class GameModel implements IGameModel, MediaMixin {
    private final AbsCannon cannon;
    private final List<AbsMissile> missiles;
    private final List<AbsGameInfo> gameInfos;
    private final List<AbsEnemy> enemies;
    private final List<IObserver> observers;
    private final List<AbsCollision> collisions;
    private final IGameObjectFactory gameObjectFactoryA;
    private final IGameObjectFactory gameObjectFactoryB;
    private final Queue<AbstractGameCommand> unexecutedCommands = new LinkedBlockingQueue<>();
    private final Stack<AbstractGameCommand> executedCommands = new Stack<>();
    private int score;
    private IMovingStrategy movingStrategy;

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

    @Override
    public void update() {
        executeCommands();
        moveMissiles();
        updateGameInfos();
        spawnEnemies();
        destroyCollisions();
    }

    @Override
    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    @Override
    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

    @Override
    public void shootCannon() {
        missiles.addAll(cannon.shoot());
        playSound("shoot.wav");
        notifyObservers();
    }

    @Override
    public void aimCannonUp() {
        cannon.aimUp();
        notifyObservers();
    }

    @Override
    public void aimCannonDown() {
        cannon.aimDown();
        notifyObservers();
    }

    @Override
    public void powerCannonDown() {
        cannon.powerDown();
        notifyObservers();
    }

    @Override
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

    @Override
    public void timeTick() {
        update();
    }

    @Override
    public void toggleMovingStrategy() {
        if (movingStrategy instanceof SimpleMovingStrategy) {
            movingStrategy = new RealisticMovingStrategy();
        }
        else if (movingStrategy instanceof RealisticMovingStrategy) {
            movingStrategy = new SimpleMovingStrategy();
        }
    }

    @Override
    public void toggleShootingMode() {
        cannon.toggleShootingMode();
    }

    @Override
    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(missiles);
        gameObjects.add(cannon);
        gameObjects.addAll(gameInfos);
        gameObjects.addAll(enemies);
        gameObjects.addAll(collisions);

        return gameObjects;
    }

    @Override
    public IMovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    @Override
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

    @Override
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

    private void executeCommands() {
        while(!unexecutedCommands.isEmpty()) {
            AbstractGameCommand command = unexecutedCommands.poll();
            command.doExecute();
            executedCommands.push(command);
        }
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
}
