package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.LifetimeLimitedGameObject;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.MissileA;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMocks {
    @Test
    public void testGetAge() {
        LifetimeLimitedGameObject missile = mock(MissileA.class);
        when(missile.getAge()).thenReturn((long) 100);
        Assert.assertEquals(100, missile.getAge());
    }

    @Test
    public void testGetCannonPosition() {
        IGameModel model = mock(GameModel.class);
        when(model.getCannonPosition()).thenReturn(new Position(0, 0));
        Assert.assertEquals(0, model.getCannonPosition().getX());
        Assert.assertEquals(0, model.getCannonPosition().getY());
    }
}
