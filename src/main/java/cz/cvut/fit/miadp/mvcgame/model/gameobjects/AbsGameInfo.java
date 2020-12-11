package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.visitor.IGameObjectsVisitor;

public abstract class AbsGameInfo extends GameObject {
    public abstract String getText();

    @Override
    public void acceptVisitor(IGameObjectsVisitor visitor) {
        visitor.visitGameInfo(this);
    }
}
