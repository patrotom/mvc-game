package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.Position;

public interface IGameGraphics {
    void drawImage(String path, Position position);
    void drawText(String text, Position position);
    void drawRectangle(Position leftTop, Position rightBottom);
    void clear();
}
