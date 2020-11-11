package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.CannonA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.MissileA;

public class GameObjectsFactoryA implements IGameObjectFactory{
    private IGameModel model;

    public GameObjectsFactoryA(IGameModel model) {
        this.model = model;
    }

    public CannonA createCannon() {
        return new CannonA(new Position(MvcGameConfig.CANNON_POS_X,
                MvcGameConfig.CANNON_POS_Y), this);
    }

    public MissileA createMissile(double initAngle, int initVelocity) {
        return new MissileA(new Position(MvcGameConfig.CANNON_POS_X,
                MvcGameConfig.CANNON_POS_Y), initAngle, initVelocity, model.getMovingStrategy());
    }
}
