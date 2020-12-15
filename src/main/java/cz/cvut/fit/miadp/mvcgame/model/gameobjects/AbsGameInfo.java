package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IGameObjectsVisitor;

public abstract class AbsGameInfo extends GameObject {
    private String text;

    public AbsGameInfo(String text, Position position) {
        this.text = text;
        this.position = position;
    }

    public String getText() {
        return text;
    }

    @Override
    public void acceptVisitor(IGameObjectsVisitor visitor) {
        visitor.visitGameInfo(this);
    }
}
