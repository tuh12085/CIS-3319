package project0;


import java.util.Arrays;
import java.util.StringTokenizer;

public class conventer {



        String string;
        byte[] Final;
    public conventer(String st){
            this.string = st;

    }

    public byte[] breaker(){


        StringTokenizer symbal_breaker = new StringTokenizer(string, "[]");
        String dele_begin_end =  symbal_breaker.nextToken();
        //System.out.println(dele_begin_end);
        StringTokenizer multiTokenizer = new StringTokenizer(dele_begin_end, ", ");

        int counter = 0;
        while (multiTokenizer.hasMoreTokens())
        {
            String assgn = multiTokenizer.nextToken();

            int i = Integer.parseInt(assgn);
            byte b1 = (byte) i;

            counter++;
        }
        //System.out.println(counter);


        //----------------------------------------->
        Final = new byte[counter];
        StringTokenizer symbal_breaker2 = new StringTokenizer(string, "[]");
        String dele_begin_end2 =  symbal_breaker2.nextToken();
        //System.out.println(dele_begin_end2);
        StringTokenizer multiTokenizer2 = new StringTokenizer(dele_begin_end2, ", ");

        int counter2 = 0;
        while (multiTokenizer2.hasMoreTokens())
        {
            String assgn = multiTokenizer2.nextToken();

            int i = Integer.parseInt(assgn);
            byte b1 = (byte) i;
            Final[counter2] = b1;
            counter2++;
        }
        //System.out.println(Final);
        //System.out.println(Arrays.toString(Final));





        return Final;
    }

}
