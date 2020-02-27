//
import java.math.*;
import java.util.*;
import java.io.*;
  
public class Main { 
  
    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);
    static String file = "../in";
    static int test = 0; // 0 for local testing, 1 for std input
    static int inf = 1_000_000, mod = 1_000_000_007;

    void swap(int[]ary, int i, int j)
    {
        int t = ary[i];
        ary[i] = ary[j];
        ary[j] = t;
    }
    
    String[] split() throws Exception
    {
        return in.readLine().split(" ");
    }

    int readInt() throws Exception
    {
        return Integer.valueOf(in.readLine());
    }

    int[] toIntArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        int[] ary = new int[n];
        for(int i = 0; i < n; i++) ary[i] = Integer.valueOf(sp[i]);
        return ary;
    }

    String reverse(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }

    long choose(int n, int a)
    {
        long nf = 1;
        for(int i = 1; i <= a; i++)
        {
            nf *= i;
            nf %= mod;
            nf *= pow(i, mod - 2);
            nf %= mod;
        }
        return nf;
    }

    long pow(int a, int pow)
    {
        return pow(0L + a, pow);
    }
    
    long pow(long a, int pow)
    {
        long res = 1;
        while(pow > 0)
        {
            if(pow % 2 != 0) {
                res *= a;
                res %= mod;
            }
            a = a * a;
            a %= mod;
            pow /= 2;
        }

        return res;
    }    

    int gcd(int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}
/***********************************************************************/
/***********************************************************************/
/***********************************************************************/
/***********************************************************************/
        // System.out.println((-100 + 0) / 2);

        new Main().a();
        out.flush();
    }

    void a() throws Exception
    {
        int[] ary = toIntArray();
        int n = ary[0], k = ary[1];
        
        ary = toIntArray();        

        Arrays.sort(ary);
        
        int gcd = ary[0];


        for(int a : ary) 
        {
            gcd = gcd(a, gcd);
        }


        if(k % gcd == 0 && k <= ary[n - 1]) out.println("POSSIBLE");
        else out.println("IMPOSSIBLE");
    }

    int find(int[] f , int p)
    {
        int fp = f[p];
        while(fp != f[fp]) fp = f[f[fp]];
        return f[p] = fp;
    }
}
