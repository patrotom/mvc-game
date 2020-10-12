package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.Cannon;

public class GameModel {
    private Cannon cannon;

    public GameModel() {
        Position cannonPosition = new Position(MvcGameConfig.CANNON_POS_X,
                MvcGameConfig.CANNON_POS_Y);
        cannon = new Cannon(cannonPosition);
    }

    public void moveCannonUp() {
        cannon.moveUp();
    }

    public void moveCannonDown() {
        cannon.moveDown();
    }

    public void update() {
        // TODO
    }

    public Position getCannonPosition() { return cannon.getPosition(); }
}
