package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;

import java.time.Instant;

public abstract class LifetimeLimitedGameObject extends GameObject{
    private final Instant bornAt;

    public LifetimeLimitedGameObject(Position position) {
        super(position);
        bornAt = Instant.now();
    }

    int getAge() {
        return (int)(Instant.now().getEpochSecond() - bornAt.getEpochSecond());
    }
}
