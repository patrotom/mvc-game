package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;

public class EnemyA extends AbsEnemy {
    public EnemyA(Position position) {
        super(position);
    }

    @Override
    public String getIconName() {
        return "images/enemy1.png";
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
