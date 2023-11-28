package application.main;

import java.util.ArrayList;

public class NimTable {

    /**
     * Pass in a hand(n1, n2) and get all of the nim values of hands up to
     * and including that hand
     * @param n1
     * @param n2
     * @return
     */
    public static Hand[][] make2dTable(int n1, int n2){
        if(n1 < 1 || n2 < 1){
            throw new IllegalArgumentException("Both numbers should be greater than 1");
        }
        int arraySize = n1 + n2 + 1;
        Hand[][] tableArray = new Hand[arraySize][arraySize];
        Hand defaultHand = new Hand();
       // defaultHand.makeDefaultHand();
        tableArray[0][0] = defaultHand;

        // starting iterations:
        // row = n1, col = n2

        for(int col = 0; col < tableArray[col].length - 1; col++) {
            int rowLength = tableArray.length - col;
            for (int row = 0; row < rowLength; row++) {
                if (tableArray[row][col] == tableArray[0][0]) {
                    continue;
                }
                // compute subpositions
                // get subpositions of this hand
                tableArray[row][col] = new Hand(row, col, 0);
                // do something with new hand

            }
        }
        return tableArray;
    } // end of handarray method

}
