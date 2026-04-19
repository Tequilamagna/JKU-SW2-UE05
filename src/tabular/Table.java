package tabular;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Table implements Tabular{
    int[][] table;

    public Table(int[][] table) {
        this.table = table;
    }

    @Override
    public int rowCount() {
        return table.length;
    }

    @Override
    public int colCount() {
        return table[0].length;
    }

    @Override
    public Iterable<Integer> iterableRow(int row) {
        return new RowIterable(table[row]);
    }

    @Override
    public Iterable<Integer> iterableCol(int col) {
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    public static class RowIterable implements Iterable<Integer> {
        int[] row;

        private RowIterable(int[] row) {
            this.row = row;
        }
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                int i = 0;

                @Override
                public boolean hasNext() {
                    return i < row.length;
                }

                @Override
                public Integer next() {
                    if(!this.hasNext()) {
                        throw new NoSuchElementException("this is not the next you're looking for.");
                    }
                    int result = row[i];
                    i++;
                    return result;
                }
            };
        }
    }
}
