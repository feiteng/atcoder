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

    // long comb(int n, int k)
    // {
    //     if(n < 0 || k < 0 || k > n) return 0;

    //     return (((f[n] * ff[k]) % mod) * f[n - k]) % mod;
    // }

    // long[] f = new long[2_000_010], ff = new long[2_000_010];

    void f() throws Exception
    {
        
    }

    void e2(int n, int k)
    {
        for(int i = 0; i <= n; i++)
        {
            int a = i;
            int c = 0;
            while(a > 0)
            {
                if(a % 10 != 0) c++;
                a /= 10;
            }
            if(c == k) System.out.println(i);
        }
    }

    long ehelper(String str, int k)
    {
        int idx = 0;
        while(str.charAt(idx) == '0') idx++;
        str = str.substring(idx);
        char[] chs = str.toCharArray();
        int n = chs.length;
        if(n < k)
        {
            // System.out.println(0);
            return 0;
        }
        long sum = 0;

        if(k == 1)
        {
            sum += chs[0] - '0';
            sum += (n - 1) * 9;
        }
        if(k == 2)
        {
            int val = chs[0] - '0';
            sum += (n - 1) * (n - 2) / 2 * 81;
            for(int i = 1; i < val; i++)
            {
                sum += (n - 1) * 9;
            }
            for(int i = 1; i < n; i++) {
                if(chs[i] != '0')
                {
                    sum += chs[i] - '0';
                    sum += 9 * (n - i - 1);
                    break;
                }
            }
        }
        if(k == 3)
        {
            int val = chs[0] - '0';
            sum += (n - 1) * (n - 2) * (n - 3) / 6 * 729;
            for(int i = 1; i < val; i++)
            {
                sum += (n - 1) * (n - 2) / 2 * 81;
            }
            // System.out.println("..." +sum);
            sum += ehelper(str.substring(1), k - 1);
        }
        
        return sum;
    }


    void e() throws Exception
    {
        String str = in.readLine();
        int k = readInt();
        
        // e2(Integer.valueOf(str), k);
        System.out.println(ehelper(str, k));
    }

    long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    void d() throws Exception
    {
        int[] ary = toIntArray();
        int n = ary[0], a = ary[1], b = ary[2];


    }

    int bs(int[] ary, long t)
    {
        int m = ary.length;
        int n = m;
        int count = 0;
        for(int i = 0; i < m - 1; i++)
        {
            // for each row
            // System.out.println(i);
            int lo = i + 1, hi = n - 1;
            long p1 = (long) ary[i];
            while(lo < hi)
            {
                if(p1 > 0)
                {
                    int mid = (lo + hi) / 2;
                    long prod = p1 * ary[mid];
                    if(prod < t) lo = mid + 1;
                    else hi = mid;
                }
                else
                {
                    int mid = (lo + hi + 1) / 2;
                    long prod = p1 * ary[mid];
                    if(prod < t) hi = mid - 1;
                    else lo = mid;
                }

            }
            
            if(p1 == 0)
            {
                if(t > 0) count += n - i - 1;
            }
            else if(p1 < 0) {
                if(p1 * ary[lo] >= t) lo++;
                count += n - lo;
                // System.out.printf("%d %d %d \n", ary[i], lo, count);
            }
            else {  // >= 0
                if(ary[lo] * p1 > t) lo--;
                else if(ary[lo] * p1 < t) lo++;
                count += lo - i;
// System.out.printf("%d %d %d\n", ary[i], i, lo - i);                
            }
        }
        return count;
    }
    
    void c() throws Exception
    {
        int n = readInt();
        int[] ary = toIntArray();
        int dist = 1 << 30;
        for(int x = 1; x <= 100; x++)
        {
            int t = 0;
            for(int i = 0; i < n; i++)
            {
                int dx = ary[i] - x;
                t += dx * dx;
            }
            dist = Math.min(dist, t);
        }
        out.println(dist);
    }

    int dfs(long val, long cap, boolean flag){
        if(val > cap) return 0;
        // System.out.println(val);
        int re = 0;
        if(!flag)
        {
            long val2 = val;
            int c = 0;
            while(val2 > 0)
            {
                long rem = val2 % 10;
                val2 /= 10;
                if(rem == 3)  c |= 1 << 0;
                if(rem == 5)  c |= 1 << 1;
                if(rem == 7)  c |= 1 << 2;
            }
            if(c == 7) {
                flag = true;
            }
        }
        if(flag) re++;

        re += dfs(val * 10 + 3, cap, flag);
        re += dfs(val * 10 + 5, cap, flag);
        re += dfs(val * 10 + 7, cap, flag);
        return re;
    }


    boolean containsDigit(int n, int set)
    {
        while(n > 0)
        {
            int r = n % 10;
            n /= 10;
            if((set & (1 << r)) != 0) return true;
        }
        return false;
    }

    void b() throws Exception
    {
        int[] ary = toIntArray();
        int n = ary[0], k = ary[1];
        int c = 0;
        while(n > 0)
        {
            n /= k;
            c++;
        }
        out.println(c);

    }

    void a() throws Exception
    {
        int[] ary = toIntArray();
        int h = ary[0], w = ary[1], a = ary[2], b = ary[3];

<<<<<<< HEAD
        for(int i = 0; i < h; i++)
        {
            for(int j = 0; j < w; j++)
            {
                int v = 0;
                if(i < b && j < a) v = 1;
                else if(b <= i && a <= j) v = 1;
                out.printf("%d", v);
            }
            out.printf("\n");
        }
    }
}
=======
        int[][] g = new int[h][w];

        for(int i = 0; i < b; i++)
        {
            for(int j = 0; j < a; j++)
            {
                g[i][j] = 1;
            }
        }

        for(int i = b; i < h; i++)
        {
            for(int j = a; j < w; j++)
            {
                g[i][j] = 1;
            }
        }

        for(int[] gg : g)
        {
            for(int k : gg) System.out.printf("%d", k);
            System.out.printf("\n");
        }
    }
}
>>>>>>> 3e9bd86e1b5e51d0199a21b362b33b3efc142e8a
