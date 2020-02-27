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

        new Main().d();
        out.flush();
    }

    void d() throws Exception
    {
        int[] ary = toIntArray();
        int m = ary[0], n = ary[1];
        
        char[][] g = new char[m][];

        for(int i = 0; i < m; i++) g[i] = in.readLine().toCharArray();
        
        int[][] up = new int[m][n],
                down = new int[m][n],
                left = new int[m][n],
                right = new int[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(j - 1 >= 0) left[i][j] += left[i][j - 1];
                if(g[i][j] == '#') left[i][j] = 0;
                else left[i][j] += 1;                
            }
            for(int j = n - 1; j >= 0; j--)
            {
                if(j + 1 < n) right[i][j] += right[i][j + 1];
                if(g[i][j] == '#') right[i][j] = 0;
                else right[i][j] += 1;
            }
        }


        for(int j = 0; j < n; j++)
        {
            for(int i = 0; i < m; i++)
            {
                if(i - 1 >= 0) up[i][j] += up[i - 1][j];
                if(g[i][j] == '#') up[i][j] = 0;
                else up[i][j] += 1;
            }
            for(int i = m - 1; i >= 0; i--)
            {
                if(i + 1 < m) down[i][j] = down[i + 1][j];
                if(g[i][j] == '#') down[i][j] = 0;
                else down[i][j] += 1;
            }
        }

        // System.out.println(11234);

        int maxi = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(g[i][j] == '#') continue;
                int summ = up[i][j] + down[i][j] + left[i][j] + right[i][j] - 3;
                maxi = Math.max(maxi, summ);
                // System.out.printf("%d %d %d %d %d %d\n", i, j, a, b, c, d);
            }
        }

        out.println(maxi);

    }

    int find(int[] f , int p)
    {
        int fp = f[p];
        while(fp != f[fp]) fp = f[f[fp]];
        return f[p] = fp;
    }
}
