package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;

public interface IShootingMode {
    String getName();
    void shoot(AbsCannon cannon);
}
