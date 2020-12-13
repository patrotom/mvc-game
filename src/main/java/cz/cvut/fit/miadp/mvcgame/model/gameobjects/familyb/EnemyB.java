package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyb;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;

public class EnemyB extends AbsEnemy {
    public EnemyB(Position position) {
        super(position);
    }

    @Override
    public String getIconName() {
        return "images/enemy2.png";
    }
}
