package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryA;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements IObservable {
    private int score;
    private AbsCannon cannon;
    private List<AbsMissile> missiles;
    private GameInfo gameInfo;
    private List<Enemy> enemies;
    private List<IObserver> observers;
    private IGameObjectFactory gameObjectFactory;

    public GameModel() {
        observers = new ArrayList<>();
        gameObjectFactory = new GameObjectsFactoryA();
        cannon = gameObjectFactory.createCannon();
        missiles = new ArrayList<>();
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
        missiles.add(cannon.shoot());
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

    private void destroyMissiles() {
        List<AbsMissile> toRemove = new ArrayList<>();

        for (AbsMissile missile : missiles)
            if (missile.getPosition().getX() > MvcGameConfig.MAX_X)
                toRemove.add(missile);

        missiles.removeAll(toRemove);
    }

    private void moveMissiles() {
        for (AbsMissile missile : missiles) {
            missile.move(new Vector(MvcGameConfig.MOVE_STEP, 0));
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
}
