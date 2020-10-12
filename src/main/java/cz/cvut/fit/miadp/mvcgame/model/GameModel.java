package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.Cannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.Enemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.GameInfo;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements IObservable {
    private int score;
    private Cannon cannon;
    private GameInfo gameInfo;
    private ArrayList<Enemy> enemies;
    private List<IObserver> observers;

    public GameModel() {
        Position cannonPosition = new Position(MvcGameConfig.CANNON_POS_X,
                MvcGameConfig.CANNON_POS_Y);
        cannon = new Cannon(cannonPosition);
        observers = new ArrayList<>();
    }

    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

    public void update() {
        // TODO
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

    public Cannon getCannon() { return cannon; }

    public GameInfo getGameInfo() { return gameInfo; }

    public ArrayList<Enemy> getEnemies() { return enemies; }
}
