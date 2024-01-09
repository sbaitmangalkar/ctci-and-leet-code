package com.sbaitman.ctci.stringsandarrays;

/**
 *
 */
public class ReverseInt {
    public static int reverse(int x) {
        int reversed = 0;
        int pop;

        while(x != 0) {
            pop = x % 10; // pick last number
            x /= 10; // pick numbers till last

            // handle boundary condition
            // Integer.MAX_VALUE is equal 2147483647. Integer.MIN_VALUE is equal  -2147483648. Last digits are 7 and 8.
            // This is the reason why we check  pop > 7 and pop < -8 conditions
            if(reversed > Integer.MAX_VALUE / 10 || reversed == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }
            if(reversed < Integer.MIN_VALUE / 10 || reversed == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }

            // multiply reversed by 10 times to fill in the tens position
            //creating  a format of place of one's ten  and hundreds multiply by ten shifts positions
            reversed = (reversed * 10) + pop;
        }
        return reversed;
    }
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
