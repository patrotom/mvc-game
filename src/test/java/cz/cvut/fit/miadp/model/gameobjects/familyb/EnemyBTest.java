package cz.cvut.fit.miadp.model.gameobjects.familyb;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyb.EnemyB;
import org.junit.Assert;
import org.junit.Test;

public class EnemyBTest {
    @Test
    public void testGetIconName() {
        Position initPos = new Position(0, 0);
        EnemyB enemy = new EnemyB(initPos);
        Assert.assertEquals("images/enemy2.png", enemy.getIconName());
    }
}
