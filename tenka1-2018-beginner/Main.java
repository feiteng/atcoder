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

        new Main().c();
        out.flush();
    }

    void c() throws Exception
    {
        int n = readInt();

        int[] ary = new int[n];
        
        for(int i = 0; i < n; i++) ary[i] = readInt();

        
        Arrays.sort(ary);

        int[] f1 = new int[n];
        int[] f2 = new int[n];

        long s1 = 0, s2 = 0;

        for(int i = 0; i < n; i++)
        {
            if(i % 2 == 0)
            {
                f1[i] = -2;
                f2[i] = 2;
            }
            else
            {
                f1[i] = 2;
                f2[i] = -2;
            }
        }
        f1[0] /= 2;
        f1[n - 1] /= 2;
        f2[0] /= 2;
        f2[n - 1] /= 2;

        Arrays.sort(f1);
        Arrays.sort(f2);

        for(int i = 0; i < n; i++)
        {
            s1 += f1[i] * ary[i];
            s2 += f2[i] * ary[i];
        }

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(Math.max(s1, s2));

    }

    int find(int[] f , int p)
    {
        int fp = f[p];
        while(fp != f[fp]) fp = f[f[fp]];
        return f[p] = fp;
    }
}
