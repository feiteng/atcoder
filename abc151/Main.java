//
import java.math.*;
import java.util.*;
import java.io.*;
  
public class Main { 
  
    static BufferedReader in;
    static String file = "../in";

    public static void main(String[] args) throws Exception
    {
        int test = 0,   // 0 for local testing, 1 for std input
            _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}

        new Main().e();

    }

    long[] f = new long[100_010], ff = new long[100_010];
    int mod = 1_000_000_007;
    
    void e() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            k = Integer.valueOf(sp[1]);
        int[] ary = new int[n];
        sp = in.readLine().split(" ");    
        for(int i = 0; i < n; i++) ary[i] = Integer.valueOf(sp[i]);
        Arrays.sort(ary);
        // 
        
        long sum = 0;

        f[0] = 1;
        ff[0] = 1;
        for(int i = 1; i <= 100_000; i++)
        {
            f[i] = f[i - 1] * i;
            f[i] %= mod;
            ff[i] = inverseMod(f[i]);
            ff[i] %= mod;
        }
 
        for(int i = 0; i < n; i++)
        {
            long f1 = comb(i, k - 1);
            long f2 = comb(n - 1 - i, k - 1);
            // System.out.printf("%d %d %d\n", f1, f2, ary[i]);
            sum = (sum + f1 * ary[i]) % mod;
            sum = (sum - f2 * ary[i]) % mod;
        }
 
        System.out.println(sum % mod);
    }

    long inverseMod(long a)
    {
        return pow(a, mod - 2);
    }

    long comb(int n, int k)
    {
        // n choose m
        if(n < 0 || k < 0) return 0;
        if(k > n) return 0;
        if(k == 0) return 1;
        
        return (((f[n] * ff[k]) % mod) * ff[n - k]) % mod;
    }

    long pow(long a, int b)
    {
        long re = 1;
        while(b > 0)
        {
            if(b % 2 != 0) {
                re *= a;
                re %= mod;
            }
            a = a * a;
            a %= mod;
            b /= 2;
        }

        return re;
    }
}