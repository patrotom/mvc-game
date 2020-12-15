package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IGameObjectsVisitor;

public abstract class AbsCollision extends LifetimeLimitedGameObject {
    public AbsCollision(Position position) { super(position); }

    @Override
    public void acceptVisitor(IGameObjectsVisitor visitor) {
        visitor.visitCollision(this);
    }

    @Override
    public long getAge() {
        return super.getAge();
    }
}
