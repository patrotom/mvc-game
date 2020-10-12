package cz.cvut.fit.miadp.mvcgame;

import java.util.List;

public class GameController {
    private GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for(String code : pressedKeysCodes) {
            switch(code) {
                case "UP":
                    this.model.moveLogoUp();
                    break;
                case "DOWN":
                    this.model.moveLogoDown();
                    break;
                case "LEFT":
                    this.model.moveLogoLeft();
                    break;
                case "RIGHT":
                    this.model.moveLogoRight();
                    break;
                default:
                    //nothing
            }
        }
    }
}
