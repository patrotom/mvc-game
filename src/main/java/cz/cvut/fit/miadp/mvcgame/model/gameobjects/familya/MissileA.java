package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class MissileA extends AbsMissile {
    IMovingStrategy movingStrategy;

    public MissileA(Position position, double initAngle, int initVelocity, IMovingStrategy movingStrategy) {
        super(position, initAngle, initVelocity);
        this.movingStrategy = movingStrategy;
    }

    @Override
    public void move() {
        movingStrategy.updatePosition(this);
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
