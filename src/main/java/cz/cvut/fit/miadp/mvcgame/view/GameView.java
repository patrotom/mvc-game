package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
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
        drawCannon(gr);
    }

    public GameController getController() { return this.controller; }

    private void drawCannon(GraphicsContext gr) {
        Position pos = model.getCannonPosition();
        gr.drawImage(new Image("images/cannon.png"), pos.getX(), pos.getY());
    }
}
