package cz.cvut.fit.miadp;

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
}
