package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;

public class GameInfoA extends AbsGameInfo {
    private String text;

    public GameInfoA(String text, Position position) {
        this.text = text;
        this.position = position;
    }

    @Override
    public String getText() {
        return text;
    }
}
