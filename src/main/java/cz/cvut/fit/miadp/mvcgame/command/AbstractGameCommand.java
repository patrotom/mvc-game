package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public abstract class AbstractGameCommand {
    IGameModel subject;
    Object memento;

    protected abstract void execute();

    public void doExecute() {
        memento = subject.createMemento();
        execute();
    }

    public void unExecute() {
        subject.setMemento(memento);
    }
}
