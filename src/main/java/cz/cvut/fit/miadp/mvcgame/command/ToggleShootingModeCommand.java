package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class ToggleShootingModeCommand extends AbstractGameCommand {
    public ToggleShootingModeCommand(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    protected void execute() {
        subject.toggleShootingMode();
    }
}
