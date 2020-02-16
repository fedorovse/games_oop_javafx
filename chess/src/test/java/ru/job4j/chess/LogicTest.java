package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogicTest {

    @Test
    public void whenMoveTrue() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.C1, Cell.G5);
        boolean expect = true;
        assertThat(result, is(expect));
    }

    @Test
    public void whenMoveFalse() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        BishopBlack bishopBlock = new BishopBlack(Cell.F4);
        logic.add(bishopBlack);
        logic.add(bishopBlock);
        boolean result = logic.move(Cell.C1, Cell.G5);
        boolean expect = false;
        assertThat(result, is(expect));
    }
}
