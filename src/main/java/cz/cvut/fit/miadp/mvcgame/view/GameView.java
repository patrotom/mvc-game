package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;
import javafx.scene.canvas.GraphicsContext;

public class GameView implements IObserver {
    private GameController controller;
    private GameModel model;
    private GraphicsContext graphicsContext;
    private GameObjectsRender render;
    private int updateCnt;

    public GameView(GameModel model) {
        this.model = model;
        controller = new GameController(model);
        graphicsContext = null;
        updateCnt = 1;
        this.model.registerObserver(this);
        render = new GameObjectsRender();
    }

    public void render() {
        if (graphicsContext == null) return;

        if (updateCnt > 0) {
            graphicsContext.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);

            for (GameObject gameObject : model.getGameObjects()) {
                gameObject.acceptVisitor(render);
            }

            updateCnt = 0;
        }
    }

    public GameController getController() { return this.controller; }

    @Override
    public void update() {
        updateCnt++;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        render.setGraphicsContext(graphicsContext);
    }
}
