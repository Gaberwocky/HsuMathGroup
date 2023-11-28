package application.main;

import java.util.ArrayList;
import java.util.Arrays;

public class NimLib {

    public static int getNIM(int n, int k) throws IllegalArgumentException{
        if(n < 0 || k < 0){
            throw new IllegalArgumentException("Both numbers should be non-negative");
        }
        // otherwise, continue
        String nString = Integer.toBinaryString(n);
        String kString = Integer.toBinaryString(k);
        String longest = ""; String shortest = "";
        int nStringlen = nString.length();
        int kStringlen = kString.length();
        if(nStringlen > kStringlen){
            longest = nString;
            shortest = kString;
        }
        else { longest = kString; shortest = nString;}

        // calcuating the differece between strings
        int difference = longest.length() - shortest.length();
        String result = "";
        // iterate from right to left
        for(int i = longest.length() - 1; i >= 0; i--){
            int tempNum = 0;
            if(longest.length() - i <= shortest.length()){
                tempNum += Character.getNumericValue(shortest.charAt(i - difference));
            }
            tempNum += Character.getNumericValue(longest.charAt(i));
            int mod = tempNum % 2;
            result = Integer.toString(mod) + result;
        }
        int solution = Integer.parseInt(result,2);
        return solution;
    }

    /**
     * Returns the minimum excluded value given a list of nimbers
     * @param nimValArr
     * @return
     * @throws IllegalArgumentException
     */
   public static int getMEXValue(ArrayList<Integer> nimValArr) throws IllegalArgumentException{

        // will tell us how many iterations
        int nimValueLength = nimValArr.size();

        //Will give us the highest number to check- we want to check up to and including the maximum nimber in the list
        //initialize to start of the array
        int nimMax = nimValArr.get(0);
        // iterate through the list and return the max number
        for ( int i = 1; i < nimValueLength ; i++ )
        {	if (nimValArr.get(i) < 0)
        // nimbers cannot be negative
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
        // create a boolean array with indexes up to the max nimber found in the passed in array
        boolean[] boolSieve = new boolean[nimMax + 2];

        //changing bool to true if that number is in the array
       // iterate up to the length of the nimbers array
        for ( int i =0; i < nimValueLength; i++ )
        {
            int temp = nimValArr.get(i);
            boolSieve [temp] = true;
            //System.out.println("temp: " + temp + "boolSieve [temp]: " +boolSieve [temp]);
        }

        // check for first false in boolSieve
       /*
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

        */
       // iterate through the boolseive and find the first instance of "false"
      for(int i = 0; i < boolSieve.length; i++){
          if(boolSieve[i] == false){
              mex = i;
              break;
          }
      }
        return mex;
    }

    public static int[][] makeTable(int n, int k) throws IllegalArgumentException{

        if(n < 1 || k < 1){
            throw new IllegalArgumentException("Both numbers should be greater than 1");
        }

        // for mex values
        ArrayList<Integer> nimbersArrayList = new ArrayList<>();
        // adding values that we have assumed we always be present:
        // we'll always assume we can get the nimbers: 0,1,2 and 3 by moves that include removing the palm
        for(int num = 0; num < 4; num++){
            nimbersArrayList.add(num);
            System.out.println("adding: " + num);
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

        for(int col = 1; col < tableArray[col].length - 1; col++){
            int rowLength = tableArray.length - col;
            for(int row = 1; row < rowLength; row++){
                // add neighbors to arraylist.
                nimbersArrayList.add(tableArray[row-1][col]);
                nimbersArrayList.add(tableArray[row][col-1]);
                nimbersArrayList.add(tableArray[row+1][col-1]);
                System.out.println("size of nimbers arraylist"+nimbersArrayList.size());
                tableArray[row][col] = getMEXValue(nimbersArrayList);
                System.out.println("Mex value at : " + row + "," + col + " is " + tableArray[row][col] );
                // clear array of neighbors
                //clearNeighbors(nimbersArrayList);
                nimbersArrayList.subList(4, nimbersArrayList.size()).clear();

            }
        }
        return tableArray;
    }

    public static void clearNeighbors(ArrayList<Integer> list){
        for(int index = 4; 4 < list.size(); index++){
            list.remove(index);
        }
    }

    public static void printTable(int[][] nimTable){
        for (int r = 0 ; r < nimTable.length; r++)
        {	for (int c = 0; c < nimTable.length; c++ )
        {System.out.print("\t" + "[" + nimTable[r][c] + "]");	}
            System.out.println();
        }
    }

    public static void getListContents(ArrayList<Integer> nimbersList){

    }

    public static void main(String[] args) {
        int[][] nimTable = makeTable(6,6);
        printTable(nimTable);

        int val = getNIM(1,0);
       // System.out.println(val);






    }
    }
