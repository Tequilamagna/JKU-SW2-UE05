package tabular;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Tabular extends Iterable<Integer> {
    int rowCount();
    int colCount();
    Iterable<Integer> iterableRow(int row);
    Iterable<Integer> iterableCol(int col);

    default int[] rowSums() {
        int[] result = new int[rowCount()];

        for(int i = 0; i < result.length; i++) {
            int sum = 0;
            Iterable<Integer> row = iterableRow(i);
            for(int val : row) {
                sum += val;
            }
            result[i] = sum;
        }
        return result;
    }

    default int[] colSums() {
        int[] result = new int[colCount()];

        for(int i = 0; i < result.length; i++) {
            int sum = 0;
            Iterable<Integer> col = iterableCol(i);
            for(int val : col) {
                sum += val;
            }
            result[i] = sum;
        }
        return result;
    }

    default int totalSum() {
        int sum = 0;
        for(int val : this) {
            sum += val;
        }

        return sum;
    }

    @Override
    default Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int i = 0;
            private Iterator<Integer> row;

            {
                if(rowCount() <= 0 || colCount() <= 0) {
                    row = null;
                } else {
                    row = iterableRow(i).iterator();
                    i++;
                }

            }

            @Override
            public boolean hasNext() {
                return row != null;
            }

            @Override
            public Integer next() {
                if(!this.hasNext()) {
                    throw new NoSuchElementException("this is not the next you are looking for.");
                }
                int result = row.next();
                if(!row.hasNext()) {
                    if(i < rowCount()) {
                        row = iterableRow(i).iterator();
                        i++;
                    } else {
                        row = null;
                    }
                }
                return result;
            }
        };
    }
}
