package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObjectsRender implements IGameObjectsVisitor {
    private GraphicsContext graphicsContext;

    public GameObjectsRender() {
        graphicsContext = null;
    }

    @Override
    public void visitCannon(AbsCannon cannon) {
        graphicsContext.drawImage(new Image("images/cannon.png"), cannon.getPosition().getX(), cannon.getPosition().getY());
    }

    @Override
    public void visitMissile(AbsMissile missile) {
        graphicsContext.drawImage(new Image("images/missile.png"), missile.getPosition().getX(), missile.getPosition().getY());
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}
