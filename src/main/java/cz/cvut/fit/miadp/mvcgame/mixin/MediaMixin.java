package cz.cvut.fit.miadp.mvcgame.mixin;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public interface MediaMixin {
    default void playSound(String fileName) {
        Media sound = new Media(new File("src/main/resources/sounds/" + fileName).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
