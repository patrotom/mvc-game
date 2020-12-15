package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;

public class GameView implements IObserver {
    private final GameController controller;
    private final IGameModel model;
    private IGameGraphics graphicsContext;
    private final GameObjectsRender render;
    private int updateCnt;

    public GameView(IGameModel model) {
        this.model = model;
        controller = new GameController(model);
        graphicsContext = null;
        updateCnt = 1;
        this.model.registerObserver(this);
        render = new GameObjectsRender();
    }

    @Override
    public void update() {
        updateCnt++;
    }

    public void render() {
        if (graphicsContext == null) return;

        if (updateCnt > 0) {
            graphicsContext.clear();

            for (GameObject gameObject : model.getGameObjects()) {
                gameObject.acceptVisitor(render);
            }

            updateCnt = 0;
        }
    }

    public GameController getController() { return this.controller; }

    public void setGraphicsContext(IGameGraphics graphicsContext) {
        this.graphicsContext = graphicsContext;
        render.setGraphicsContext(graphicsContext);
    }
}
