package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class PowerCannonUpCommand extends AbstractGameCommand {
    public PowerCannonUpCommand(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    protected void execute() {
        subject.powerCannonUp();
    }
}
