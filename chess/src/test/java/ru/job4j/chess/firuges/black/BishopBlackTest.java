package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void whenTakePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H3);
        Cell result = bishopBlack.position();
        Cell expect = Cell.H3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenCopyBishopBlack() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H3);
        Cell result = bishopBlack.copy(Cell.D3).position();
        Cell expect = Cell.D3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenBishopBlackWayFromC1ToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBishopBlackWayFromC1ToG4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G4);
        Cell[] expect = new Cell[0];
        assertThat(result, is(expect));
    }

}
