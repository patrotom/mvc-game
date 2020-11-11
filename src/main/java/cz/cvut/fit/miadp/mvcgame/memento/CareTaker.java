package cz.cvut.fit.miadp.mvcgame.memento;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private IGameModel model;
    private final List<Object> mementos = new ArrayList<>();

    private static class SingletonHolder {
        private static final CareTaker INSTANCE = new CareTaker();
    }

    public static CareTaker getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void setModel(IGameModel model) {
        this.model = model;
    }

    public Object createMemento() {
        if (model != null) {
            Object memento = model.createMemento();
            mementos.add(memento);
            return memento;
        }

        return null;
    }

    public void setMemento() {
        if (model != null && !mementos.isEmpty())
            model.setMemento(mementos.get(mementos.size() - 1));
    }
}
