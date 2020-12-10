package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonUpCommand;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import org.junit.Assert;
import org.mockito.Mockito.*;
import org.junit.Test;

public class Sample {

    @Test
    public void undoCommandTest() {
        // Illustration of mocking
        // IGameGraphics graphicsMock = mock(IGameGraphics);
        // when(graphicsMock.drawImage()).then(1);

        IGameModel model = new GameModel();
        Position positionBeforeUndo = model.getCannonPosition();
        model.registerCommand(new MoveCannonUpCommand(model));
        model.update();
//        model.registerCommand(new UndoCommand(model));

        Position positionAfterUndo = model.getCannonPosition();

        Assert.assertEquals(positionBeforeUndo, positionAfterUndo);
    }
}
