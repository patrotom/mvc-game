package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;

import java.util.List;

public class GameController {
    private GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for (String code : pressedKeysCodes) {
            switch(code) {
                case "UP":
                    this.model.moveCannonUp();
                    break;
                case "DOWN":
                    this.model.moveCannonDown();
                    break;
                default:
                    //nothing
            }
        }
    }
}
