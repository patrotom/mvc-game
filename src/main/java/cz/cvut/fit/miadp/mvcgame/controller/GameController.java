package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

import java.util.List;

public class GameController {
    private IGameModel model;

    public GameController(IGameModel model) {
        this.model = model;
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for (String code : pressedKeysCodes) {
            switch(code) {
                case "UP":
                    model.moveCannonUp();
                    break;
                case "DOWN":
                    model.moveCannonDown();
                    break;
                case "SPACE":
                    model.shootCannon();
                    break;
                case "A":
                    model.aimCannonUp();
                    break;
                case "Z":
                    model.aimCannonDown();
                    break;
                case "Q":
                    model.powerCannonDown();
                    break;
                case "W":
                    model.powerCannonUp();
                    break;
                case "S":
                    CareTaker.getInstance().createMemento();
                    break;
                case "R":
                    CareTaker.getInstance().setMemento();
                    break;
                default:
                    //nothing
            }
        }
    }
}
