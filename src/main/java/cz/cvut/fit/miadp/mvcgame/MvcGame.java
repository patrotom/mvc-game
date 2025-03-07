package cz.cvut.fit.miadp.mvcgame;

import java.io.File;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.miadp.mvcgame.view.GameView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MvcGame {
    private IGameModel model;
    private GameView view;
    private GameController controller;
    private MediaPlayer mediaPlayer;

    public void init() {
        model = new GameModelProxy(new GameModel());
        view = new GameView(model);
        controller = view.getController();
        CareTaker.getInstance().setModel(model);
        initBackgroundMusic();
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        this.controller.processPressedKeys(pressedKeysCodes);
    }

    public void update() {
        model.timeTick();
    }

    public void render(IGameGraphics gr) {
        view.setGraphicsContext(gr);
        view.render();
    }

    public String getWindowTitle() { return "MVC Game"; }

    public int getWindowWidth()
    {
        return MvcGameConfig.MAX_X;
    }

    public int getWindowHeight()
    {
        return  MvcGameConfig.MAX_Y;
    }

    private void initBackgroundMusic() {
        Media sound = new Media(new File("src/main/resources/sounds/level.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();
    }
}