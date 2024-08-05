import java.util.ArrayList;

class HelloWorld {
static Integer f2(Integer n1, Integer n2) {
    Integer b=-1;
    if(n1== 0 && n2==0){
        b=1;
    }else if(n1== 0 && n2==1){
        b=3;
    }else if(n1 == 0 && n2 > 1){
        if(n2%2==0){
            b=5;
        }else{
            b=7;
        }
    }else if(n1 > 0 && n2 == 0){
        if(n1%2==0){
            b=3;
        }else{
            b=2;
        }        
    }else if(n1%2 != 0 && n2%2!=0){
        b=4;
    }else if (n1%2 == 0 && n2%2!=0){
        b=5;
    }else if (n1%2 != 0 && n2%2==0){
        b=6;
    }else if (n1%2 == 0 && n2%2==0){
        b=7;
    }
                //System.out.println(b)
    return b;
}
    public static void main(String[] args) {

        ArrayList<ArrayList> nim3 = new ArrayList<>();
    
        ArrayList<Integer> nim03 = new ArrayList<Integer>();
        nim03.add(4);
        nim03.add(6);
        nim03.add(8);
        nim03.add(10);
        nim03.add(8);
        nim03.add(10);
        nim03.add(8);
        nim03.add(10);
        nim03.add(8);
        nim03.add(10);
        nim03.add(8);
        nim3.add(nim03);
////////////////////////////////////////////////////////
        ArrayList<Integer> nim13 = new ArrayList<Integer>();
        nim13.add(5);
        nim13.add(7);
        nim13.add(9);
        nim13.add(7);
        nim13.add(5);
        nim13.add(7);
        nim13.add(5);
        nim13.add(7);
        nim13.add(5);
        nim13.add(7);
        nim13.add(5);
        nim3.add(nim13);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim23 = new ArrayList<Integer>();
        nim23.add(4);
        nim23.add(8);
        nim23.add(4);
        nim23.add(6);
        nim23.add(4);
        nim23.add(6);
        nim23.add(4);
        nim23.add(6);
        nim23.add(4);
        nim23.add(6);
        nim3.add(nim23);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim33 = new ArrayList<Integer>();
        nim33.add(5);
        nim33.add(7);
        nim33.add(5);
        nim33.add(7);
        nim33.add(5);
        nim33.add(7);
        nim33.add(5);
        nim33.add(7);
        nim33.add(5);
        nim33.add(7);
        nim3.add(nim33);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim43 = new ArrayList<Integer>();
        nim43.add(4);
        nim43.add(6);
        nim43.add(4);
        nim43.add(6);
        nim43.add(4);
        nim43.add(6);
        nim43.add(4);
        nim43.add(6);
        nim43.add(4);
        nim3.add(nim43);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim53 = new ArrayList<Integer>();
        nim53.add(5);
        nim53.add(7);
        nim53.add(5);
        nim53.add(7);
        nim53.add(5);
        nim53.add(7);
        nim53.add(5);
        nim53.add(7);
        nim3.add(nim53);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim63 = new ArrayList<Integer>();
        nim63.add(4);
        nim63.add(6);
        nim63.add(4);
        nim63.add(6);
        nim63.add(4);
        nim63.add(6);
        nim63.add(4);
        nim3.add(nim63);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim73 = new ArrayList<Integer>();
        nim73.add(5);
        nim73.add(7);
        nim73.add(5);
        nim73.add(7);
        nim73.add(5);
        nim73.add(7);
        nim3.add(nim73);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim83 = new ArrayList<Integer>();
        nim83.add(4);
        nim83.add(6);
        nim83.add(4);
        nim83.add(6);
        nim83.add(4);
        nim3.add(nim83);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim93 = new ArrayList<Integer>();
        nim93.add(5);
        nim93.add(7);
        nim93.add(5);
        nim93.add(7);
        nim3.add(nim93);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim103 = new ArrayList<Integer>();
        nim103.add(4);
        nim103.add(6);
        nim103.add(4);
        nim3.add(nim103);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim113 = new ArrayList<Integer>();
        nim113.add(5);
        nim113.add(7);
        nim3.add(nim113);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim123 = new ArrayList<Integer>();
        nim123.add(4);
        nim3.add(nim123);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim133 = new ArrayList<Integer>();
        nim133.add(5);
        nim3.add(nim133);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim143 = new ArrayList<Integer>();
        nim143.add(4);
        nim3.add(nim143);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim153 = new ArrayList<Integer>();
        nim153.add(5);
        nim3.add(nim153);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim163 = new ArrayList<Integer>();
        nim163.add(4);
        nim3.add(nim163);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim173 = new ArrayList<Integer>();
        nim173.add(5);
        nim3.add(nim173);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim183 = new ArrayList<Integer>();
        nim183.add(4);
        nim3.add(nim183);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim193 = new ArrayList<Integer>();
        nim193.add(5);
        nim3.add(nim193);
////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim203 = new ArrayList<Integer>();
        nim203.add(4);
        nim3.add(nim203);
///////////////////////////////////////////////////////////////////////////
        System.out.println("   "+0+"  "+1+"  "+2+"  "+3+"  "+4+"  "+5+"  "+6+"  "+7+"  "+8+"  "+9+"  "+10);
        for (int i = 0; i < nim3.size(); i++) {
            System.out.println(i+" "+nim3.get(i));
        }
        //ArrayList<Integer> bob = new ArrayList<Integer>();
        //bob = nim3.get(0);
        //System.out.println(nim3.get(0).get(1));
//////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
        Integer[] hand = {2,10,1};
//////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> nim = new ArrayList<Integer>();
        if(hand[0]>0){
         nim.add((Integer)nim3.get(hand[0]-1).get(hand[1]));
        }
    //------------------------------------------------------
        if(hand[1]>0){
            Integer a = (Integer)nim3.get(hand[0]).get(hand[1]-1);
            nim.add(a);
            nim.add((Integer)nim3.get(hand[0]+1).get(hand[1]-1));
            if (a%2==0){
                nim.add(a+1);
            }else{
                nim.add(a-1);
            }
        }
    //------------------------------------------------------------
        Integer b=f2(hand[0], hand[1]);
        nim.add(b);
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Integer c=f2(hand[0]+1, hand[1]);
        nim.add(c);
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        nim.add(f2(hand[0], hand[1]+1));
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if(b%2==0){
            nim.add(b+1);
        }else{
            nim.add(b-1);
        }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if(c%2==0){
            nim.add(c+1);
        }else{
            nim.add(c-1);
        }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if((b/2)%2==0){
            nim.add(b+2);
        }else{
            nim.add(b-2);
        }
                //System.out.println(c);
        System.out.println(nim);
    }

}
