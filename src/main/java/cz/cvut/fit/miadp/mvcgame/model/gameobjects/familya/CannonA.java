package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

import java.util.ArrayList;
import java.util.List;

public class CannonA extends AbsCannon {
    private final IGameObjectFactory gameObjectFactory;
    private final List<AbsMissile> shootingBatch;
    private double angle;
    private int power;

    public CannonA(Position position, IGameObjectFactory gameObjectFactory) {
        this.position = position;
        this.gameObjectFactory = gameObjectFactory;
        power = MvcGameConfig.INIT_POWER;
        angle = MvcGameConfig.INIT_ANGLE;
        shootingBatch = new ArrayList<>();
        shootingMode = SINGLE_SHOOTING_MODE;
    }

    @Override
    public void moveUp() {
        move(new Vector(0, -MvcGameConfig.CANON_MOVE_STEP));
    }

    @Override
    public void moveDown() {
        move(new Vector(0, MvcGameConfig.CANON_MOVE_STEP));
    }

    @Override
    public List<AbsMissile> shoot() {
        shootingBatch.clear();
        shootingMode.shoot(this);

        return shootingBatch;
    }

    @Override
    public void primitiveShoot() {
        shootingBatch.add(gameObjectFactory.createMissile(angle, power));
    }

    @Override
    public void aimUp() {
        angle += MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void aimDown() {
        angle -= MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void powerUp() {
        power += MvcGameConfig.POWER_STEP;
    }

    @Override
    public void powerDown() {
        power -= MvcGameConfig.POWER_STEP;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
