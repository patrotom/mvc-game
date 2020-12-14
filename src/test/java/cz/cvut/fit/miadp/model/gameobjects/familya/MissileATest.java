package cz.cvut.fit.miadp.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.MissileA;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;
import org.junit.Assert;
import org.junit.Test;

public class MissileATest {
    @Test
    public void testMove() {
        Position position = new Position(0, 0);
        double initAngle = MvcGameConfig.INIT_ANGLE;
        int initVelocity = MvcGameConfig.INIT_POWER;
        IMovingStrategy strategy = new SimpleMovingStrategy();
        MissileA missile =
                new MissileA(position, initAngle, initVelocity, strategy);
        missile.move();
        int expectedX = MvcGameConfig.MOVE_STEP;
        Assert.assertEquals(expectedX, missile.getPosition().getX());
        Assert.assertEquals(0, missile.getPosition().getY());
    }
}
