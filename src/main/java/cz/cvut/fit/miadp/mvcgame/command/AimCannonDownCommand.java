package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class AimCannonDownCommand extends AbstractGameCommand {
    public AimCannonDownCommand(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    protected void execute() {
        subject.moveCannonDown();
    }
}
