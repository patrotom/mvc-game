package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;

public interface IGameObjectFactory {
    AbsCannon createCannon();
    AbsMissile createMissile(double initAngle, int initVelocity);
    AbsGameInfo createGameInfo(String text);
    AbsEnemy createEnemy(Position position);
    AbsCollision createCollision(Position position);
}
