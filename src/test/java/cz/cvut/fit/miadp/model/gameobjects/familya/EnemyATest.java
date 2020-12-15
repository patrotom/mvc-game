package cz.cvut.fit.miadp.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.EnemyA;
import org.junit.Assert;
import org.junit.Test;

public class EnemyATest {
    @Test
    public void testGetIconName() {
        Position initPos = new Position(0, 0);
        EnemyA enemy = new EnemyA(initPos);
        Assert.assertEquals("images/enemy1.png", enemy.getIconName());
    }
}
