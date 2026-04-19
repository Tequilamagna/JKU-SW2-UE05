package tabular;

import java.util.Iterator;

public class Table implements Tabular{

    @Override
    public int rowCount() {
        return 0;
    }

    @Override
    public int colCount() {
        return 0;
    }

    @Override
    public Iterable<Integer> iterableRow(int row) {
        return null;
    }

    @Override
    public Iterable<Integer> iterableCol(int col) {
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
