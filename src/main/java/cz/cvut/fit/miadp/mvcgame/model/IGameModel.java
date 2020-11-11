package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.List;

public interface IGameModel extends IObservable {
    void moveCannonUp();
    void moveCannonDown();
    void shootCannon();
    void aimCannonUp();
    void aimCannonDown();
    void powerCannonDown();
    void powerCannonUp();
    List<GameObject> getGameObjects();
    void timeTick();
    Object createMemento();
    void setMemento(Object m);
    public IMovingStrategy getMovingStrategy();
}
