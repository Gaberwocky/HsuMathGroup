//This is a program written to calculate the nim value of a hand with finger
//length at most 3. Currently, the program can only handle at most n3=2.
// Additionally, no palm cases are considered in this code
// as there are so few edge cases at this stage.


import java.util.ArrayList;



class NimHandCalculator32 {


    //This function was made by Gabi and Zach and was taken from Mex Value Finder
    static int mexFinder(ArrayList<Integer> nimValArr){
        // Will be built of ints
        //int[] nimValArr = {1};
        // should have tests for having all values,
        //repeated values, empty array, return error
        //if (nimValArr.length == 0) {

        // will tell us how many iterations
        int nimValueLength = nimValArr.size();
        //}
        int mex = -1;


        //-1 will act as a flag if something is wrong

        //Will give us the highest number to check
        int nimMax = nimValArr.get(0);
        for ( int i = 1; i < nimValueLength ; i++ ) {
            if (nimValArr.get(i) > nimMax){
                nimMax = nimValArr.get(i);
            }
        }
        //System.out.println(nimMax);

        boolean[] boolSieve = new boolean[nimMax+1];

        //changing bool to true if that number is in the array
        for ( int i =0; i < nimValueLength; i++ ) {
            int temp = nimValArr.get(i);
            boolSieve [temp] = true;
            //System.out.println("temp: " + temp + "boolSieve [temp]: " +boolSieve [temp]);
        }

        // check for first false in boolSieve
        for ( int i =0; i < nimMax+2 + 1; i++ ) {

            if(i==nimMax+1){
                mex=i;
                return mex;
            } else if (boolSieve[i] == false){
                mex = i;
                return mex;
            }
            //System.out.println("index: " + i + "   bool value: " + boolSieve[i] );
        }

        //System.out.println("MEX value is: " + mex);
        return mex;
    }

    //given an n1 and n2 value, this function determines the nim value of a hand
    //with finger length of at most 2.
    static Integer HandFingerLen2(Integer n1, Integer n2) {
        //NimValueLen2 set to -1 as an error catching measure
        Integer NimValueLen2=-1;
        //The following decision tree follows the theorem statement for determining
        //the nim value of a hand with finger length of at most 2.
        if(n1== 0 && n2==0){
            NimValueLen2=1;
        }else if(n1== 0 && n2==1){
            NimValueLen2=3;
        }else if(n1 == 0 && n2 > 1){
            if(n2%2==0){
                NimValueLen2=5;
            }else{
                NimValueLen2=7;
            }
        }else if(n1 > 0 && n2 == 0){
            if(n1%2==0){
                NimValueLen2=3;
            }else{
                NimValueLen2=2;
            }
        }else if(n1%2 != 0 && n2%2!=0){
            NimValueLen2=4;
        }else if (n1%2 == 0 && n2%2!=0){
            NimValueLen2=5;
        }else if (n1%2 != 0 && n2%2==0){
            NimValueLen2=6;
        }else if (n1%2 == 0 && n2%2==0){
            NimValueLen2=7;
        }
        //This is the calculated nim value.
        return NimValueLen2;
    }
    //given an n1 and n2 value, this function determines the nim value of a hand
    //with finger length n3=1.
    static Integer HandFingerLen31(Integer n1, Integer n2) {
        //NimValueLen3 set to -1 as an error catching measure
        Integer NimValueLen3=-1;
        //The following decision tree follows a not yet proven theorem statement for determining
        //the nim value of a hand with n3=1.
        if(n1== 0 && n2==0){
            NimValueLen3=4;
        }else if(n1== 0 && n2==1){
            NimValueLen3=6;
        }else if(n1 == 0 && n2 > 1){
            if(n2%2==0){
                NimValueLen3=8;
            }else{
                NimValueLen3=10;
            }
        }else if(n1 > 0 && n2 == 0){
            if(n1%2==0){
                NimValueLen3=4;
            }else{
                NimValueLen3=5;
            }
        }else if(n1%2 != 0 && n2%2!=0){
            NimValueLen3=7;
        }else if (n1%2 == 0 && n2%2!=0){
            NimValueLen3=6;
        }else if (n1%2 != 0 && n2%2==0){
            NimValueLen3=5;
        }else if (n1%2 == 0 && n2%2==0){
            NimValueLen3=4;
        }
        //This is the calculated nim value.
        return NimValueLen3;
    }
    public static void main(String[] args) {
        //Because nim values are determined recursively, it becomes necessary to
        //store a table of the current highest order of nim values that are being
        // worked with. For example, this program can handle at most n3=2, and so
        // we must store the table of nim values for n3=2. This step is only
        // necessary until a pattern can be determined in the nim values, at which
        // point the table can be replaced with a function. Take the function
        //HandFingerLen2 for example. All of that said, the following is the code that
        // populates the n3=2 table.
        ArrayList<ArrayList> nimTable = new ArrayList<>();

        //This populates the n1=0 row of the table
        ArrayList<Integer> n10 = new ArrayList<Integer>();
        n10.add(7);
        n10.add(5);
        n10.add(6);
        //adds the row to the table
        nimTable.add(n10);
////////////////////////////////////////////////////////
        //This populates the n1=1 row of the table
        ArrayList<Integer> n11 = new ArrayList<Integer>();
        n11.add(6);
        n11.add(4);
        //adds the row to the table
        nimTable.add(n11);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=2 row of the table
        ArrayList<Integer> n12 = new ArrayList<Integer>();
        n12.add(7);
        //adds the row to the table
        nimTable.add(n12);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=3 row of the table
        ArrayList<Integer> n13 = new ArrayList<Integer>();
        n13.add(-1);
        //adds the row to the table
        nimTable.add(n13);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=4 row of the table
        ArrayList<Integer> n14 = new ArrayList<Integer>();
        n14.add(-1);
        //adds the row to the table
        nimTable.add(n14);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=5 row of the table
        ArrayList<Integer> n15 = new ArrayList<Integer>();
        n15.add(-1);
        //adds the row to the table
        nimTable.add(n15);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=6 row of the table
        ArrayList<Integer> n16 = new ArrayList<Integer>();
        n16.add(-1);
        //adds the row to the table
        nimTable.add(n16);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=7 row of the table
        ArrayList<Integer> n17 = new ArrayList<Integer>();
        n17.add(-1);
        //adds the row to the table
        nimTable.add(n17);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=8 row of the table
        ArrayList<Integer> n18 = new ArrayList<Integer>();
        n18.add(-1);
        //adds the row to the table
        nimTable.add(n18);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=9 row of the table
        ArrayList<Integer> n19 = new ArrayList<Integer>();
        n19.add(-1);
        //adds the row to the table
        nimTable.add(n19);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=10 row of the table
        ArrayList<Integer> n110 = new ArrayList<Integer>();
        n110.add(-1);
        //adds the row to the table
        nimTable.add(n110);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=11 row of the table
        ArrayList<Integer> n113 = new ArrayList<Integer>();
        n113.add(-1);
        //adds the row to the table
        nimTable.add(n113);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=12 row of the table
        ArrayList<Integer> n112 = new ArrayList<Integer>();
        n112.add(-1);
        //adds the row to the table
        nimTable.add(n112);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=13 row of the table
        ArrayList<Integer> n133 = new ArrayList<Integer>();
        n133.add(-1);
        //adds the row to the table
        nimTable.add(n133);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=14 row of the table
        ArrayList<Integer> n114 = new ArrayList<Integer>();
        n114.add(-1);
        //adds the row to the table
        nimTable.add(n114);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=15 row of the table
        ArrayList<Integer> n115 = new ArrayList<Integer>();
        n115.add(-1);
        //adds the row to the table
        nimTable.add(n115);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=16 row of the table
        ArrayList<Integer> n116 = new ArrayList<Integer>();
        n116.add(-1);
        //adds the row to the table
        nimTable.add(n116);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=17 row of the table
        ArrayList<Integer> n117 = new ArrayList<Integer>();
        n117.add(-1);
        //adds the row to the table
        nimTable.add(n117);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=18 row of the table
        ArrayList<Integer> n118 = new ArrayList<Integer>();
        n118.add(-1);
        //adds the row to the table
        nimTable.add(n118);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=19 row of the table
        ArrayList<Integer> n119 = new ArrayList<Integer>();
        n119.add(-1);
        //adds the row to the table
        nimTable.add(n119);
////////////////////////////////////////////////////////////////////////
        //This populates the n1=20 row of the table
        ArrayList<Integer> n120 = new ArrayList<Integer>();
        n120.add(-1);
        //adds the row to the table
        nimTable.add(n120);
///////////////////////////////////////////////////////////////////////////
        //prints out the table of nim values that was just constructed
        System.out.println("   "+0+"  "+1+"  "+2+"  "+3+"  "+4+"  "+5+"  "+6+"  "+7+"  "+8+"  "+9+"  "+10);
        for (int i = 0; i < nimTable.size(); i++) {
            System.out.println(i+" "+nimTable.get(i));
        }

//////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
        //This is the hand for which the program computes the nim value. edit the
        //three numbers to find the nim value of the hand you want.if the value you find is not yet
        //included in the table, add it to the appropriate line.
        Integer[] hand = {3,0,2};
//////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////

        //this is the list of nim values that the mex value will be determined from
        ArrayList<Integer> nim = new ArrayList<Integer>();
        if(hand[2]==0){
            System.out.println("H("+hand[0]+", "+hand[1]+", "+hand[2]+")"+HandFingerLen2(hand[0], hand[1]));
        }else if(hand[2]==1) {
            System.out.println("H("+hand[0]+", "+hand[1]+", "+hand[2]+") = *"+HandFingerLen31(hand[0], hand[1]));

        }else if(hand[2]==2) {
            // these values are added in lieu of handling the no palm cases
            nim.add(0);
            nim.add(1);
            nim.add(2);
            nim.add(3);
            //this determines all possible nim values where a finger of length 1 is
            //effected
            if (hand[0] > 0) {
                nim.add((Integer) nimTable.get(hand[0] - 1).get(hand[1]));
            }
            //------------------------------------------------------
            //this determines all possible nim values where a finger of length 2 is
            //effected
            if (hand[1] > 0) {
                //this is the bigger piece that is left in the severed finger case
                Integer severedHand = (Integer) nimTable.get(hand[0]).get(hand[1] - 1);

                nim.add(severedHand);
                nim.add((Integer) nimTable.get(hand[0] + 1).get(hand[1] - 1));

                //handles the case where a severed finger is present
                if (severedHand % 2 == 0) {
                    nim.add(severedHand + 1);
                } else {
                    nim.add(severedHand - 1);
                }
            }

            //------------------------------------------------------------
            //this determines all possible nim values where a finger of length 3 is
            //effected

            //when a finger of length 3 is effected, there are 3 cases in which a severed
            //finger is present. of these 3 cases, there are two possibilities for what the
            //bigger portion of the hand looks like. this is the first such possibility.
            Integer severedHand1 = HandFingerLen31(hand[0], hand[1]);
            nim.add(severedHand1);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //This is the second possibility for the bigger piece of the hand.
            Integer severedHand2 = HandFingerLen31(hand[0] + 1, hand[1]);
            nim.add(severedHand2);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            nim.add(HandFingerLen31(hand[0], hand[1] + 1));
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            //determines the nim value for the severed hadn cases
            if (severedHand1 % 2 == 0) {
                nim.add(severedHand1 + 1);
            } else {
                nim.add(severedHand1 - 1);
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (severedHand2 % 2 == 0) {
                nim.add(severedHand2 + 1);
            } else {
                nim.add(severedHand2 - 1);
            }
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if ((severedHand1 / 2) % 2 == 0) {
                nim.add(severedHand1 + 2);
            } else {
                nim.add(severedHand1 - 2);
            }
            //System.out.println(c);
            System.out.println(nim);
            System.out.println(mexFinder(nim));
        }


    }

}
