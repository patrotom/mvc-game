package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView implements IObserver {
    private GameController controller;
    private GameModel model;
    private GraphicsContext gr;
    private boolean updated;

    public GameView(GameModel model) {
        this.model = model;
        this.controller = new GameController(model);
        this.gr = null;
        this.updated = true;
        this.model.registerObserver(this);
    }

    public void render() {
        if (this.gr == null) return;

        drawCannon();
        updated = false;
    }

    public GameController getController() { return this.controller; }

    private void drawCannon() {
        Position pos = model.getCannon().getPosition();
        gr.drawImage(new Image("images/cannon.png"), pos.getX(), pos.getY());
    }

    @Override
    public void update() {
        updated = true;
        render();
    }

    public boolean getUpdated() { return updated; }

    public void setGraphicsContext(GraphicsContext gr) {
        this.gr = gr;
    }
}
