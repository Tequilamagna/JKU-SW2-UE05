package tabular.app;

import inout.Out;
import tabular.Table;
import tabular.Tabular;

import java.util.Random;

public class TableApp {

    public static void main(String[] args) {
        // generate random data
        Tabular randomData = new Table(getRandom2DArray(5, 10));
        printTabular(randomData);

        Out.println();

        Tabular emptyData = new Table(new int[0][0]);
        printTabular(emptyData);
    }

    public static int[][] getRandom2DArray(int rowCnt, int colCnt) {
        Random rand = new Random(0xCAFEBABE);
        int[][] data = new int[rowCnt][colCnt];
        for (int row = 0; row < rowCnt; row++) {
            for (int col = 0; col < colCnt; col++) {
                data[row][col] = rand.nextInt(0, 128);
            }
        }
        return data;
    }
    
    public static void printTabular(Tabular data) {
        int[] rowSums = data.rowSums();
        Out.print(" DATA ");
        printNTimes("|       ", data.colCount());
        Out.println("||  sums");
        for (int i = 0; i < data.rowCount(); i++) {
            printHLine(data, '-');
            Out.print("     ");
            for (int val : data.iterableRow(i)) {
                Out.print(" |%6d".formatted(val));
            }
            Out.println(" ||%6d".formatted(rowSums[i]));
        }

        printHLine(data, '=');
        Out.print(" sums");
        for (int sum : data.colSums()) {
            Out.print(" |%6d".formatted(sum));
        }
        Out.println(" ||%6d".formatted(data.totalSum()));
    }

    public static void printHLine(Tabular data, char symbol) {
        int needed = 7 + (data.colCount() + 1) * 8;
        while (needed-- > 0) {
            Out.print(symbol);
        }
        Out.println();
    }

    public static void printNTimes(String text, int n) {
        while (n-- > 0) {
            Out.print(text);
        }
    }
}
