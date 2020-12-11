package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class ToggleMovingStrategyCommand extends AbstractGameCommand {
    public ToggleMovingStrategyCommand(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    protected void execute() {
        subject.toggleMovingStrategy();
    }
}
