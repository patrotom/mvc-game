package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyb;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;

public class GameInfoB extends AbsGameInfo {
    public GameInfoB(String text, Position position) {
        super(text, position);
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
