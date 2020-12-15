package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IGameObjectsVisitor;

public abstract class AbsMissile extends LifetimeLimitedGameObject {
    private double initAngle;
    private int initVelocity;

    protected AbsMissile(Position position, double initAngle, int initVelocity) {
        super(position);
        this.initAngle = initAngle;
        this.initVelocity = initVelocity;
    }

    public abstract void move();

    @Override
    public void acceptVisitor(IGameObjectsVisitor render) {
        render.visitMissile(this);
    }

    public int getInitVelocity() {
        return initVelocity;
    }

    public double getInitAngle() {
        return initAngle;
    }
}
