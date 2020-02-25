//
import java.math.*;
import java.util.*;
import java.io.*;

  
public class Main { 
  
    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);
    static String file = "../in";
    static int test = 0; // 0 for local testing, 1 for std input
    static int inf = 1_000_000;

    class Comb
    {
        long[] f, ff;
        int mod = 1_000_000_007;

        public Comb(int n)
        {
            f = new long[n + 10];
            f[0] = 1;
            for(int i = 1; i <= n; i++)
            {
                f[i] = (f[i - 1] * i) % mod;
            }
        }

        public long choose(int n, int m)
        {
            return f[n] * pow(f[m], mod - 2) % mod * pow(f[n - m], mod - 2) % mod;
        }

        long pow(long a, int b)
        {
            long re = 1;
            while(b > 0)
            {
                if(b % 2 != 0)
                {
                    re *= a;
                    re %= mod;
                }
                b /= 2;
                a = a * a;
                a %= mod;
            }
            return re;
        }

    }

    int gcd(int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

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

        new Main().d();
        out.flush();
    }

    boolean isPrime(int k)
    {
        if(k < 2) return false;
        if(k < 4) return true;

        for(int i = 2; i <= Math.sqrt(k); i++)
        {
            if(k % i == 0) return false;
        }
        return true;
    }

    void d() throws Exception
    {
        int[] f = new int[1_000_10];
        for(int i = 2; i < 100000; i++)
        {
            f[i] += f[i - 1];
            if(i * 2 >= 100000) continue;
            if(isPrime(i) && isPrime(i * 2 - 1)) f[i * 2 - 1]++;
        }

        int q = readInt();
        while(q-- > 0)
        {
            int[] ary = toIntArray();    
            int from = ary[0], to = ary[1];
            System.out.println(f[to] - f[from - 1]);
        }
        
    }

    
}
