package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.Position;

public class GameGraphics implements IGameGraphics {
    IGameGraphicsImplementor implementor;

    public GameGraphics(IGameGraphicsImplementor implementor) {
        this.implementor = implementor;
    }

    @Override
    public void drawImage(String path, Position position) {
        implementor.drawImage(path, position);
    }

    @Override
    public void drawText(String text, Position position) {
        implementor.drawText(text, position);
    }

    @Override
    public void drawRectangle(Position leftTop, Position rightBottom) {
        implementor.drawLine(leftTop, new Position(rightBottom.getX(), leftTop.getY()));
        implementor.drawLine(new Position(rightBottom.getX(), leftTop.getY()), rightBottom);
        implementor.drawLine(rightBottom, new Position(leftTop.getX(), rightBottom.getY()));
        implementor.drawLine(new Position(leftTop.getX(), rightBottom.getY()), leftTop);
    }

    @Override
    public void clear() {
        implementor.clear();
    }
}
