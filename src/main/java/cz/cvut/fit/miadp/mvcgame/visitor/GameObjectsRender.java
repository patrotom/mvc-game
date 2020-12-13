package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
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

    @Override
    public void visitGameInfo(AbsGameInfo gameInfo) {
        graphicsContext.drawText(gameInfo.getText(), gameInfo.getPosition());
    }

    @Override
    public void visitEnemy(AbsEnemy enemy) {
        graphicsContext.drawImage(enemy.getIconName(), enemy.getPosition());
    }

    public void setGraphicsContext(IGameGraphics graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}
