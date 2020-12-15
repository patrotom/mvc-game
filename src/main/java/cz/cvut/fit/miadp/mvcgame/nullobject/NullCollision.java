package cz.cvut.fit.miadp.mvcgame.nullobject;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;

public class NullCollision extends AbsCollision {
    public NullCollision(Position position) {
        super(position);
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
