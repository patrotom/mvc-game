package cz.cvut.fit.miadp.mvcgame;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView {
    private GameController controller;
    private GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        this.controller = new GameController(model);
    }

    public void render(GraphicsContext gr) {
        Position pos = model.getLogoPosition();
        gr.drawImage(new Image("icons/fit-icon-256x256.png"), pos.getX(), pos.getY());
    }

    public GameController getController() { return this.controller; }
}
