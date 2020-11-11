package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;

public interface IShootingMode {
    public String getName();
    public void shoot(AbsCannon cannon);
}
