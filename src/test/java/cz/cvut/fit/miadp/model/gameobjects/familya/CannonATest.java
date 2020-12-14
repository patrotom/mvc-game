package cz.cvut.fit.miadp.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryA;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.CannonA;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CannonATest {
    private CannonA cannon;

    @Before
    public void init() {
        IGameModel model = new GameModel();
        IGameObjectFactory factory = new GameObjectsFactoryA(model);
        Position initPos = new Position(0, 0);
        cannon = new CannonA(initPos, factory);
    }

    @Test
    public void testMoveUp() {
        cannon.moveUp();
        int expectedY = cannon.getPosition().getY();
        Assert.assertEquals(expectedY, -MvcGameConfig.CANON_MOVE_STEP);
    }

    @Test
    public void testMoveDown() {
        cannon.moveDown();
        int expectedY = cannon.getPosition().getY();
        Assert.assertEquals(expectedY, MvcGameConfig.CANON_MOVE_STEP);
    }

    @Test
    public void testShoot() {
        List<AbsMissile> missiles = cannon.shoot();
        Assert.assertEquals(1, missiles.size());
        cannon.toggleShootingMode();
        missiles = cannon.shoot();
        Assert.assertEquals(2, missiles.size());
    }

    @Test
    public void testAimUp() {
        cannon.aimUp();
        double expectedAngle = MvcGameConfig.INIT_ANGLE + MvcGameConfig.ANGLE_STEP;
        Assert.assertEquals(expectedAngle, cannon.getAngle(), 0.0001);
    }

    @Test
    public void testAimDown() {
        cannon.aimDown();
        double expectedAngle = MvcGameConfig.INIT_ANGLE - MvcGameConfig.ANGLE_STEP;
        Assert.assertEquals(expectedAngle, cannon.getAngle(), 0.0001);
    }

    @Test
    public void testPowerUp() {
        cannon.powerUp();
        int expectedForce = MvcGameConfig.INIT_POWER + MvcGameConfig.POWER_STEP;
        Assert.assertEquals(expectedForce, cannon.getPower());
    }

    @Test
    public void testPowerDown() {
        cannon.powerDown();
        int expectedForce = MvcGameConfig.INIT_POWER - MvcGameConfig.POWER_STEP;
        Assert.assertEquals(expectedForce, cannon.getPower());
    }
}
