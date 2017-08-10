package math;
// a is greater than b
public class LCMandGCF {
    /*
    Greatest common factor
    the GCF is the largest number which divides both the number without leaving any remainder
    e.g. if two numbers are 24 and 40 then their GCF is 8
    because 8 is the largest number which divides both 24 and 40 perfectly,
    without leaving any remainder.

    If A = B⋅Q + R and B≠0 then GCD(A,B) = GCD(B,R) where Q is an integer, R is an integer between 0 and B-1
    */
    public int GCF(int a, int b) {
        return b == 0 ? a : GCF(b, a % b);
    }

    // Lowest common multiplier
    public int LCM(int a, int b) {
        return (a * b) / GCF(a, b);
    }

    public static void main(String[] args) {
        LCMandGCF lcMandGCF = new LCMandGCF();
        System.out.println("LCM(10, 15) : " + lcMandGCF.LCM(10, 15));
        System.out.println("GCF(10, 15) : " + lcMandGCF.GCF(10, 15));
    }
}
