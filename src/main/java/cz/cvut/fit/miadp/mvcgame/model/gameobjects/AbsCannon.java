package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

public abstract class AbsCannon extends GameObject {
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract AbsMissile shoot();
}
