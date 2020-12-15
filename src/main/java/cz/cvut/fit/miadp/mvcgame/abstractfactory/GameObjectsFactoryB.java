package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyb.EnemyB;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyb.GameInfoB;
import cz.cvut.fit.miadp.mvcgame.nullobject.NullCannon;
import cz.cvut.fit.miadp.mvcgame.nullobject.NullCollision;
import cz.cvut.fit.miadp.mvcgame.nullobject.NullMissile;

public class GameObjectsFactoryB implements IGameObjectFactory {
    @Override
    public AbsCannon createCannon() {
        return new NullCannon();
    }

    @Override
    public AbsMissile createMissile(double initAngle, int initVelocity) {
        return new NullMissile(null, initAngle, initVelocity);
    }

    @Override
    public AbsGameInfo createGameInfo(String text) {
        return new GameInfoB(text, new Position(MvcGameConfig.INFO_POS_X,
                MvcGameConfig.MAX_Y - MvcGameConfig.INFO_POS_Y));
    }

    @Override
    public AbsEnemy createEnemy(Position position) {
        return new EnemyB(position);
    }

    @Override
    public AbsCollision createCollision(Position position) {
        return new NullCollision(position);
    }
}
