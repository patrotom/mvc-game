package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;

public class MissileA extends AbsMissile {
    public MissileA(Position position) {
        this.position = position;
    }

    @Override
    public void acceptVisitor(GameObjectsRender render) {
        render.visitMissile(this);
    }
}
