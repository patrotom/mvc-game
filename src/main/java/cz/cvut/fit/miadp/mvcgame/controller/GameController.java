package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.command.MoveCannonDownCommand;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonUpCommand;
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
                    model.registerCommand(new MoveCannonUpCommand(model));
                    break;
                case "DOWN":
                    model.registerCommand(new MoveCannonDownCommand(model));
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
                case "M":
                    model.toggleMovingStrategy();
                    break;
//                case "S":
//                    CareTaker.getInstance().createMemento();
//                    break;
//                case "R":
//                    CareTaker.getInstance().setMemento();
//                    break;
                case "Y":
                    model.undoLastCommand();
                    break;
                default:
                    //nothing
            }
        }
    }
}
