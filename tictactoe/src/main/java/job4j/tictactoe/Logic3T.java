package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.isWinner(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.isWinner(Figure3T::hasMarkO);
    }

    private boolean isWinner(Predicate<Figure3T> predicate) {
        boolean rsl = false;
        for (int i = 0; i < this.table.length; i++) {
            rsl = rsl || this.fillBy(predicate, 0, i, 1, 0);
        }
        for (int i = 0; i < this.table.length; i++) {
            rsl = rsl || this.fillBy(predicate, i, 0, 0, 1);
        }
        return rsl || this.fillBy(predicate, 0,0, 1, 1) ||
                this.fillBy(predicate, this.table.length - 1 , 0, -1, 1);
    }

    public boolean hasGap() {
        long gap = Arrays.stream(table).flatMap(Arrays::stream).filter(y -> y.hasMarkO() == y.hasMarkX()).count();
        return gap > 0;
    }
}
