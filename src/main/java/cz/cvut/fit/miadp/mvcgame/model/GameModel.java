package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.Cannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.Enemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.GameInfo;

import java.util.ArrayList;

public class GameModel {
    private int score;
    private Cannon cannon;
    private GameInfo gameInfo;
    private ArrayList<Enemy> enemies;

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

    public Cannon getCannon() { return cannon; }

    public GameInfo getGameInfo() { return gameInfo; }

    public ArrayList<Enemy> getEnemies() { return enemies; }
}
