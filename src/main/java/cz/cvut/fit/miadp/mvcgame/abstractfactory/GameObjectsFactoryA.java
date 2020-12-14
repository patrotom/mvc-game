package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya.*;

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
    public GameInfoA createGameInfo(String text, String type) {
        if (type == "up")
            return new GameInfoA(text, new Position(MvcGameConfig.INFO_POS_X, MvcGameConfig.INFO_POS_Y));

        return new GameInfoA(text, new Position(MvcGameConfig.INFO_POS_X,
                MvcGameConfig.MAX_Y - MvcGameConfig.INFO_POS_Y));
    }

    @Override
    public EnemyA createEnemy(Position position) {
        return new EnemyA(position);
    }

    @Override
    public CollisionA createCollision(Position position) {
        return new CollisionA(position);
    }
}
