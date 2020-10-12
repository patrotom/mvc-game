package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;

public class GameInfo {
    private String text;
    private Position position;

    public GameInfo(String text, Position position) {
        this.text = text;
        this.position = position;
    }

    public String getText() { return text; }
}
