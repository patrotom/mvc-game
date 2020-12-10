package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class JavaFxGraphics implements IGameGraphicsImplementor {
    protected GraphicsContext gc;

    public JavaFxGraphics(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void drawImage(String path, Position position) {
        Image image = new Image(path);
        gc.drawImage(image, position.getX(), position.getY());
    }

    @Override
    public void drawText(String text, Position position) {
        gc.fillText(text, position.getX(), position.getY());
    }

    @Override
    public void drawLine(Position beginPosition, Position endPosition) {
        gc.strokeLine(beginPosition.getX(), beginPosition.getY(), endPosition.getX(), endPosition.getY());
    }

    public void clear() {
        gc.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);
    }
}
