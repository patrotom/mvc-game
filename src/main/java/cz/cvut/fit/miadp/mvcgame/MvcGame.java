package cz.cvut.fit.miadp.mvcgame;

import java.util.List;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import javafx.scene.canvas.GraphicsContext;

public class MvcGame {
    private GameModel model;
    private GameView view;
    private GameController controller;

    public void init() {
        model = new GameModel();
        view = new GameView(model);
        controller = view.getController();
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        this.controller.processPressedKeys(pressedKeysCodes);
    }

    public void update() {
        // nothing yet
    }

    public void render(GraphicsContext gr) {
        this.view.render(gr);
    }

    public String getWindowTitle() { return "MVC Game"; }

    public int getWindowWidth()
    {
        return MvcGameConfig.MAX_X;
    }

    public int getWindowHeight()
    {
        return  MvcGameConfig.MAX_Y;
    }
}