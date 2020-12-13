package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class LifetimeLimitedGameObject extends GameObject{
    private final LocalDateTime bornAt;

    public LifetimeLimitedGameObject(Position position) {
        this.position = position;
        bornAt = LocalDateTime.now();
    }

    public LifetimeLimitedGameObject(Position position, LocalDateTime bornAt) {
        this.position = position;
        this.bornAt = bornAt;
    }

    public long getAge() {
        LocalDateTime now = LocalDateTime.now();
        return ChronoUnit.MILLIS.between(bornAt, now);
    }
}
