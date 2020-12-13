package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public interface IGameObjectsVisitor {
    void visitCannon(AbsCannon cannon);
    void visitMissile(AbsMissile missile);
    void visitGameInfo(AbsGameInfo gameInfo);
    void visitEnemy(AbsEnemy enemy);
}
