package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public class GameObjectsRender implements IGameObjectsVisitor {
    private IGameGraphics graphicsContext;

    public GameObjectsRender() {
        graphicsContext = null;
    }

    @Override
    public void visitCannon(AbsCannon cannon) {
        graphicsContext.drawImage("images/cannon.png", cannon.getPosition());
    }

    @Override
    public void visitMissile(AbsMissile missile) {
        graphicsContext.drawImage("images/missile.png", missile.getPosition());
    }

    public void setGraphicsContext(IGameGraphics graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}
