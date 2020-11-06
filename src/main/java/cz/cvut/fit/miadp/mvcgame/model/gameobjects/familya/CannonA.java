package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;

public class CannonA extends AbsCannon {
    private IGameObjectFactory gameObjectFactory;

    public CannonA(Position position, IGameObjectFactory gameObjectFactory) {
        this.position = position;
        this.gameObjectFactory = gameObjectFactory;
    }

    @Override
    public void moveUp() {
        move(new Vector(0, -MvcGameConfig.MOVE_STEP));
    }

    @Override
    public void moveDown() {
        move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }

    @Override
    public AbsMissile shoot() {
        return gameObjectFactory.createMissile();
    }

    @Override
    public void acceptVisitor(GameObjectsRender render) {
        render.visitCannon(this);
    }
}
