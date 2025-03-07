package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitable;

public abstract class GameObject implements IVisitable {
    protected Position position;

    public abstract boolean isNull();

    public void move(Vector v) {
        this.position.add(v);
    }

    public Position getPosition() { return position; }
}
