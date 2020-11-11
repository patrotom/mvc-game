package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryA;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.RealisticMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements IGameModel {
    private int score;
    private AbsCannon cannon;
    private List<AbsMissile> missiles;
    private GameInfo gameInfo;
    private List<Enemy> enemies;
    private List<IObserver> observers;
    private IGameObjectFactory gameObjectFactory;
    private IMovingStrategy movingStrategy;

    public GameModel() {
        movingStrategy = new SimpleMovingStrategy();
        observers = new ArrayList<>();
        gameObjectFactory = new GameObjectsFactoryA(this);
        cannon = gameObjectFactory.createCannon();
        missiles = new ArrayList<>();
        score = 0;
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

    public void update() {
        moveMissiles();
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

    private void destroyMissiles() {
        List<AbsMissile> toRemove = new ArrayList<>();

        for (AbsMissile missile : missiles)
            if (missile.getPosition().getX() > MvcGameConfig.MAX_X)
                toRemove.add(missile);

        missiles.removeAll(toRemove);
    }

    private void moveMissiles() {
        for (AbsMissile missile : missiles) {
            missile.move();
        }

        destroyMissiles();
        notifyObservers();
    }

    public AbsCannon getCannon() { return cannon; }

    public GameInfo getGameInfo() { return gameInfo; }

    public List<Enemy> getEnemies() { return enemies; }

    public List<AbsMissile> getMissiles() { return missiles; }

    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(missiles);
        gameObjects.add(cannon);

        return gameObjects;
    }

    public IMovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    private class Memento {
        private int score;
    }

    public Object createMemento() {
        Memento memento = new Memento();
        memento.score = score;

        return memento;
    }

    public void setMemento(Object m) {
        Memento memento = (Memento)m;
        score = memento.score;
    }
}
