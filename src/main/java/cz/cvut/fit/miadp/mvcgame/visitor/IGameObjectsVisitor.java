package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;

public interface IGameObjectsVisitor {
    void visitCannon(AbsCannon cannon);
    void visitMissile(AbsMissile missile);
    void visitGameInfo(AbsGameInfo gameInfo);
    void visitEnemy(AbsEnemy enemy);
    void visitCollision(AbsCollision collision);
}
