package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.CannonA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.GameInfoA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.MissileA;

public class GameObjectsFactoryA implements IGameObjectFactory{
    private IGameModel model;

    public GameObjectsFactoryA(IGameModel model) {
        this.model = model;
    }

    @Override
    public CannonA createCannon() {
        return new CannonA(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y), this);
    }

    @Override
    public MissileA createMissile(double initAngle, int initVelocity) {
        return new MissileA(model.getCannonPosition(), initAngle, initVelocity, model.getMovingStrategy());
    }

    @Override
    public AbsGameInfo createGameInfo(String text) {
        return new GameInfoA(text, new Position(MvcGameConfig.INFO_POS_X, MvcGameConfig.INFO_POS_Y));
    }
}
