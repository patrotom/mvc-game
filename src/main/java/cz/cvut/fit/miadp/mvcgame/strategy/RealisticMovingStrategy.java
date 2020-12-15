package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public class RealisticMovingStrategy implements IMovingStrategy {
    public void updatePosition(AbsMissile missile) {
        int initVelocity = missile.getInitVelocity();
        double initAngle = missile.getInitAngle();
        long time = missile.getAge() / 100;

        int dx = (int)(initVelocity * time * Math.cos(initAngle));
        int dy = (int)(initVelocity * time * Math.sin(initAngle) + (0.5 * MvcGameConfig.GRAVITY * time * time));

        missile.move(new Vector(dx, dy));
    }

    @Override
    public String getName() {
        return "realistic";
    }
}
