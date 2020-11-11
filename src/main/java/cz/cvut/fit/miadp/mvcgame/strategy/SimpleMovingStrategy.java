package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public class SimpleMovingStrategy implements IMovingStrategy {
    @Override
    public void updatePosition(AbsMissile missile) {
        missile.move(new Vector(MvcGameConfig.MOVE_STEP, 0));
    }
}
