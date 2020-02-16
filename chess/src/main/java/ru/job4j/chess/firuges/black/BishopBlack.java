package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            Cell[] steps = new Cell[0];
            return steps;
        }
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = -1;
        int deltaY = -1;
        if (source.x < dest.x) {
            deltaX = 1;
        }
        if (source.y < dest.y) {
            deltaY = 1;
        }
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.x + deltaX * (index + 1), source.y + deltaY * (index + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        //TODO check diagonal
        if (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
