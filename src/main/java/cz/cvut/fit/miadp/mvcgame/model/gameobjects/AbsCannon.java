package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.IGameObjectsVisitor;

import java.util.List;

public abstract class AbsCannon extends GameObject {
    protected IShootingMode shootingMode;
    protected static IShootingMode SINGLE_SHOOTING_MODE = new SingleShootingMode();
    protected static IShootingMode DOUBLE_SHOOTING_MODE = new DoubleShootingMode();

    public abstract void moveUp();
    public abstract void moveDown();
    public abstract List<AbsMissile> shoot();
    public  abstract void primitiveShoot();
    public abstract void aimUp();
    public abstract void aimDown();
    public abstract void powerUp();
    public abstract void powerDown();

    @Override
    public void acceptVisitor(IGameObjectsVisitor render) {
        render.visitCannon(this);
    }

    public void toggleShootingMode() {
        if (shootingMode instanceof SingleShootingMode) {
            shootingMode = DOUBLE_SHOOTING_MODE;
        }
        else if (shootingMode instanceof DoubleShootingMode) {
            shootingMode = SINGLE_SHOOTING_MODE;
        }
    }
}
