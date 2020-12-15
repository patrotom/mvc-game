package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;

public class CollisionA extends AbsCollision {
    public CollisionA(Position position) {
        super(position);
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
