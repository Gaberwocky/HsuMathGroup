package application.main;

import java.util.ArrayList;
import java.util.Set;

public class Hand {

    int nimValue; // the mex Value from the nextMovesSet by passing
    // nim value subpositions into getMEX
    //Set<Integer> nextMovesSet;
    ArrayList<Integer> nextMovesSet = new ArrayList<>();
    ArrayList<Hand> subPositions = new ArrayList<>();
    int n1;
    int n2;
    int n3;
    int k; // floater, could be a boolean?

    public Hand(int n1, int n2, int k) {
        this.n1 = n1;
        this.n2 = n2;
        this.k = k;
    }


    /**
     * no args constructor with default values
     */
    public Hand(){
        this.n1 = 0;
        this.n2 = 0;
        this.k = 0;
        nimValue = 1;
    }


   public int getNimValue(){
        return this.nimValue;
    }


    // H(n1,n2,k) where the value of k indicates the
    // presence of a floater- non connected finger
    /*
    public ArrayList<Hand> getSubPositions() {
        ArrayList<Hand> subpositionsList = new ArrayList<>();
        if (n1 > 0) {
            // move here
            // move to n1-1, n2, 0

            subpositionsList.add(new Hand());
            // add to list
        }
        if (n2 > 0) {
            // n, n2-1, 0( no floater)
            // n+1, n2-1, 0
            // n, n2-1, 1(1 floater)
        }
        //if the palm is affected

        return subpositionsList;
    }

     */


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
        tableArray[0][0] = defaultHand;

        // starting iterations:
        // row = n1, col = n2

        for(int col = 0; col < tableArray[col].length - 1; col++) {
            int rowLength = tableArray.length - col;
            for (int row = 0; row < rowLength; row++) {
                if (tableArray[row][col] == tableArray[0][0]) {
                    continue;
                }
                // create a hand object at current (r,c)
                Hand current = new Hand(row, col, 0);
                // add to array:
                tableArray[row][col] = current;
                // compute sub positions
                if (current.n1 > 0) {
                    // move here
                    // move to n1-1, n2, 0
                    current.subPositions.add(tableArray[n1-1][n2]);
                    // add to list
                }
                if (current.n2 > 0) {
                    // n, n2-1, 0( no floater)
                    current.subPositions.add(tableArray[n1][n2-1]);
                    // n+1, n2-1, 0
                    current.subPositions.add(tableArray[n1+1][n2-1]);
                    // n, n2-1, 1(1 floater)
                   Hand tempHand = new Hand(tableArray[n1][n2-1].n1,tableArray[n1][n2-1].n2,0);
                   // find nimValue of tempHand
                   // pass temPhand's nimvalue and 1 to getNim()
                    //current.subPositions.add(tempHand);
                }
                //if the palm is affected:
                // Gabi proved that nim vals 0,1,2,3 always included

                // then pass subPositions to getMex

                for(Hand hand : current.subPositions){
                    current.nextMovesSet.add(hand.nimValue);
                }
                current.nimValue = NimLib.getMEXValue(current.nextMovesSet);

            }
        }
        return tableArray;
    } // end of handarray method

}



