package fromweek5.oomodels.solution.sheet;

import java.util.ArrayList;
import java.util.List;

/*
        Very simplified excel sheet
 */
public class Sheet {

    private final List<Cell> cells = new ArrayList();
    private int maxRow;
    private int maxCol;

    public Sheet(int maxRow, int maxCol) {
        this.maxRow = maxRow;
        this.maxCol = maxCol;

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                cells.add(new Cell(row, col));
            }
        }
    }

    public void insertColumnLeft(int colNumber) {
        for (Cell c : cells) {
            if (c.getCol() >= colNumber) {
                c.incCol();
            }
        }
        for (int i = 0; i < maxRow; i++) {
            cells.add(new Cell(i, colNumber));
        }
        maxCol++;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "cells=" + cells +
                ", maxRow=" + maxRow +
                ", maxCol=" + maxCol +
                '}';
    }


}

