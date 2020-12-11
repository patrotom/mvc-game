package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class PowerCannonDownCommand extends AbstractGameCommand {
    public PowerCannonDownCommand(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    protected void execute() {
        subject.powerCannonDown();
    }
}
