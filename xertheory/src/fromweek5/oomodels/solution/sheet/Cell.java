package fromweek5.oomodels.solution.sheet;

/*
    Cell in excel sheet
 */
public class Cell  {

    private int row;
    private int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void incCol() {
        col++;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}

