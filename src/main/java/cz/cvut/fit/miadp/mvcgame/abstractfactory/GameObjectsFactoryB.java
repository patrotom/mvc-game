package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyb.EnemyB;

public class GameObjectsFactoryB implements IGameObjectFactory {
    @Override
    public AbsCannon createCannon() {
        return null;
    }

    @Override
    public AbsMissile createMissile(double initAngle, int initVelocity) {
        return null;
    }

    @Override
    public AbsGameInfo createGameInfo(String text) {
        return null;
    }

    @Override
    public AbsEnemy createEnemy(Position position) {
        return new EnemyB(position);
    }

    @Override
    public AbsCollision createCollision(Position position) {
        return null;
    }
}
