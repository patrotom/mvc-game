package cz.cvut.fit.miadp.mvcgame;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;

public class GameModel {
    private Position logoPos;

    public GameModel() {
        logoPos = new Position((MvcGameConfig.MAX_X/2)-128, (MvcGameConfig.MAX_Y/2)-128);
    }

    public void moveLogoUp() {
        logoPos.setY(logoPos.getY() - 10);
    }

    public void moveLogoDown() {
        logoPos.setY(logoPos.getY() + 10);
    }

    public void moveLogoLeft() {
        logoPos.setY(logoPos.getX() - 10);
    }

    public void moveLogoRight() {
        logoPos.setY(logoPos.getX() + 10);
    }

    public Position getLogoPosition() { return this.logoPos; }
}
