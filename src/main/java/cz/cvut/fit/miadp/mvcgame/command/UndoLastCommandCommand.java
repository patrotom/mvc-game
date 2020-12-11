package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class UndoLastCommandCommand extends AbstractGameCommand {
    public UndoLastCommandCommand(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    protected void execute() {
        subject.undoLastCommand();
    }
}
