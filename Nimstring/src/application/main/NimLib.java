package application.main;

import java.util.ArrayList;
import java.util.Arrays;

public class NimLib {

   public static int getMEXValue(ArrayList<Integer> nimValArr) throws IllegalArgumentException{


        // will tell us how many iterations
        int nimValueLength = nimValArr.size();

        //Will give us the highest number to check
        //initialize to start of the array
        int nimMax = nimValArr.get(0);
        for ( int i = 1; i < nimValueLength ; i++ )
        {	if (nimValArr.get(i) < 0)
        {   throw new IllegalArgumentException("Array had mex values smaller than 0");
        }
            if (nimValArr.get(i) > nimMax)
            { 	nimMax = nimValArr.get(i); }
        }




        //-1 will act as a flag if something is wrong
        int mex = -1;

        //The case where we have an empty game
        if (nimValueLength == 0)
        {   mex = 0;
            return mex;
        }



        //initializing boolean array
        boolean[] boolSieve = new boolean[++nimMax];

        //changing bool to true if that number is in the array
        for ( int i =0; i < nimValueLength; i++ )
        {
            int temp = nimValArr.get(i);
            boolSieve [temp] = true;
            //System.out.println("temp: " + temp + "boolSieve [temp]: " +boolSieve [temp]);
        }

        // check for first false in boolSieve
       nimMax++;
        for ( int i =0; i<nimMax; i++ )
        {
            System.out.println("in getMEX method; nimMax:  " + nimMax );
            if (boolSieve[i] == false)
            {	mex = i;
                break;
            }
            //System.out.println("index: " + i + "   bool value: " + boolSieve[i] );
        }

        // System.out.println("MEX value is: " + mex);
        return mex;
    }

    public static int[][] makeTable(int n, int k) throws IllegalArgumentException{

        if(n < 1 || k < 1){
            throw new IllegalArgumentException("Both numbers should be greater than 1");
        }

        // for mex values
        ArrayList<Integer> nimbersArrayList = new ArrayList<>();
        // adding values that we have assumed we always be present:
        for(int num = 0; num < 4; num++){
            nimbersArrayList.add(num);
        }
        int arraySize = n + k + 1;
        int[][] tableArray = new int[arraySize][arraySize];
        // Here we init the array value to -1 like in the above method
        // works but messes with the alignment of the matrix
        for (int[] row: tableArray)
            Arrays.fill(row, -1);
        // edge cases:
        // hard code in edge cases here
        tableArray[0][0] = 1;
        tableArray[0][1] = 3;

        // general cases
        // filling in the first column: hands that do not have 2-digit fingers
        for (int i = 1; i <arraySize; i++){
            if(i % 2 == 0){tableArray[i][0] = 3;}
            else {tableArray[i][0] = 2;}
        }

        // filling in the top row: hands that do not have 1-digit fingers(consist only of 2-digit fingers)
        for(int j = 2; j < arraySize;j++ ){
            if(j % 2 == 0){tableArray[0][j] = 5;}
            else {tableArray[0][j] = 7;}
        }

        // filling in the middle: values dependent on the initialization of the 1st row and 1st column
        // "1st" meaning the 0th index

        for(int col = 1; col < tableArray[col].length; col++){
            for(int row = 1; row < tableArray.length; row++){
                // add neighbors to arraylist.
                nimbersArrayList.add(tableArray[row-1][col]);
                nimbersArrayList.add(tableArray[row][col-1]);
                nimbersArrayList.add(tableArray[row+1][col-1]);
                System.out.println(nimbersArrayList.size());
                tableArray[row][col] = getMEXValue(nimbersArrayList);
                // clear array of neighbors
                for(int index = 4; 4 < nimbersArrayList.size(); index++){
                    nimbersArrayList.remove(index);
                }
            }
        }
        return tableArray;
    }

    public static void main(String[] args) {
        int[][] nimTable = makeTable(5,5);


        for (int r = 0 ; r < nimTable.length; r++)
        {	for (int c = 0; c < nimTable.length; c++ )
        {System.out.print("\t" + "[" + nimTable[r][c] + "]");	}
            System.out.println();
        }


       // int[] nimValArr = {12, 2, 14, 0 , 1 , 3, 3, 2, 3};
       // ArrayList<Integer> al = new ArrayList<>();
       // al.add(12);
       // al.add(2);
       // al.add(14);
       // al.add(0);
       // al.add(1);
       // al.add(3);
       // al.add(3);
       // al.add(2);
       // al.add(3);
       // int mex = getMEXValue(al);
       // System.out.println("The mex is:  " +mex);

    }
    }
