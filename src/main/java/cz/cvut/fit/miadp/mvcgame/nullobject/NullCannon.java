package cz.cvut.fit.miadp.mvcgame.nullobject;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

import java.util.List;

public class NullCannon extends AbsCannon {
    @Override
    public void moveUp() {
        // Nothing
    }

    @Override
    public void moveDown() {
        // Nothing
    }

    @Override
    public List<AbsMissile> shoot() {
        return null;
    }

    @Override
    public void primitiveShoot() {
        // Nothing
    }

    @Override
    public void aimUp() {
        // Nothing
    }

    @Override
    public void aimDown() {
        // Nothing
    }

    @Override
    public void powerUp() {
        // Nothing
    }

    @Override
    public void powerDown() {
        // Nothing
    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public void setAngle(double angle) {
        // Nothing
    }

    @Override
    public void setPower(int power) {
        // Nothing
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
