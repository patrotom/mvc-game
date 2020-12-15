package cz.cvut.fit.miadp.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryA;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.CannonA;
import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import org.junit.Assert;
import org.junit.Test;

public class AbsCannonTest {
    @Test
    public void testToggleShootingMode() {
        IGameModel model = new GameModel();
        IGameObjectFactory factory = new GameObjectsFactoryA(model);
        Position initPos = new Position(0, 0);
        AbsCannon cannon = new CannonA(initPos, factory);

        Assert.assertTrue(cannon.getShootingMode() instanceof SingleShootingMode);
        cannon.toggleShootingMode();
        Assert.assertTrue(cannon.getShootingMode() instanceof DoubleShootingMode);
    }
}
