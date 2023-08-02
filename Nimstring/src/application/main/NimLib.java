package application.main;

import java.util.Scanner;

public class NimLib {

    public static int[][] makeTable(){
        Scanner reader = new Scanner(System.in);

        int n1 = -1;
        int n2 = -1;
        int arraySize = -1;

        //input verification integer >= 0
        //ask user to imput n1 number and n2 number
        System.out.println("Please input n1 and n2 seperated by spaces.");
        n1 = reader.nextInt();
        n2 = reader.nextInt();


        //print what they inputed in format H(n1, n2)

        //initialize size of array
        // to account for H(0,0)
        arraySize = n1 + n2 + 1;

        //array [rows][columns]
        int[][] array = new int [arraySize][arraySize];

        //initializing array to -1
        for (int c = 0 ; c < arraySize; c++)
        {
            for (int r = 0; r < arraySize; r++ )
            {	array[r][c]= -1;	}
        }

        //Filling array with nim values of size H[n1 = c][n2 = r]
        for (int c = 0 ; c < arraySize; c++)
        {

            for (int r = 0; r < arraySize; r++ )
            {	if ((c == 0)&(r == 0)) { array [0][0] = 1;}

                //first column alternating odd n1 is 2, else 3
                if ((c == 0)&(r % 2 == 1)) { array [r][0] = 2; }
                if ((c == 0)&(r % 2 == 0)) { array [r][0] = 3; }


            }
        }
        //check
        System.out.println (array[1][1]);

        //print the array
        for (int r = 0 ; r < arraySize; r++)
        {	for (int c = 0; c < arraySize; c++ )
        {System.out.print("\t" + "[" + array[r][c] + "]");	}
            System.out.println();
        }

        // end close the scanner
        reader.close();
        return array;
    }

    public static int[][] makeTable2(int n, int k) throws IllegalArgumentException{

        if(n < 1 || k < 1){
            throw new IllegalArgumentException("Both numbers should be greater than 1");
        }
        // assuming a square array for now
        int arraySize = n + 1;
        int[][] tableArray = new int[arraySize][arraySize];
        // Here we could init the array value to -1 like in the above method which is probably a good idea
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


        return tableArray;

    }

    public static void main(String[] args) {

       // int[][] nimpath = makeTable();
        int[][] nimTable = makeTable2(5,5);

        for (int r = 0 ; r < nimTable.length; r++)
        {	for (int c = 0; c < nimTable.length; c++ )
        {System.out.print("\t" + "[" + nimTable[r][c] + "]");	}
            System.out.println();
        }

    }
    }
