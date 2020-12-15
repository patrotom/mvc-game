package cz.cvut.fit.miadp.mvcgame.nullobject;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public class NullMissile extends AbsMissile {
    public NullMissile(Position position, double initAngle, int initVelocity) {
        super(position, initAngle, initVelocity);
    }

    @Override
    public void move() {
        // Nothing
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
