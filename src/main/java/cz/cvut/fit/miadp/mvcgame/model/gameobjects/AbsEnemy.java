package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IGameObjectsVisitor;

public abstract class AbsEnemy extends GameObject {
    public AbsEnemy(Position position) {
        this.position = position;
    }

    public abstract String getIconName();

    @Override
    public void acceptVisitor(IGameObjectsVisitor render) {
        render.visitEnemy(this);
    }
}
