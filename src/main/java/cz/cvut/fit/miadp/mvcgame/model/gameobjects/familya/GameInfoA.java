package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familya;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;

public class GameInfoA extends AbsGameInfo {
    public GameInfoA(String text, Position position) {
        super(text, position);
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
