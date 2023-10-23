package application.main;

import java.util.ArrayList;
import java.util.Set;

public class Hand {
    int nimValue; // the mex Value from the nextMovesSet
    Set<Integer> nextMovesSet;
    int n1;
    int n2;
    int n3;
    int k; // floater, could be a boolean?

    public Hand(int n1, int n2, int k) {
        this.n1 = n1;
        this.n2 = n2;
        this.k = k;
    }

    public Hand(){
    }

   public void makeDefaultHand(){
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
}



