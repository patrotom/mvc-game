package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class MoveCannonDownCommand extends AbstractGameCommand {
    public MoveCannonDownCommand(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    protected void execute() {
        subject.moveCannonDown();
    }
}
