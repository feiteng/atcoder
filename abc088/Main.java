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

        new Main().b();
        out.flush();
    }

    void b() throws Exception
    {
        int[] ary = toIntArray();
        int m = ary[0], n = ary[1];
        char[][] g = new char[m][];
        int op = 0;
        for(int i = 0; i < m; i++) 
        {
            g[i] = in.readLine().toCharArray();
            for(char c : g[i])
            {
                if(c == '.') op++;
            }
        }

        int[][] dist = new int[m][n];

        for(int[] dd : dist) Arrays.fill(dd, 1 << 30);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};        

        int step = 0;
        dist[0][0] = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-- > 0)
            {
                int[] c = q.poll();
                // System.out.println(Arrays.toString(c));
                int x = c[0], y = c[1];
                
                for(int k = 0; k < 4; k++)
                {
                    int nx = x + dx[k], ny = y + dy[k];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || g[nx][ny] == '#') continue;
                    if(dist[nx][ny] <= step + 1) continue;
                    dist[nx][ny] = step + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
            step++;
        }

        if(dist[m - 1][n - 1] >= 1 << 30) out.println(-1);
        else out.println(op - 1 - dist[m - 1][n - 1]);

        // now go backward and fill back the best path

        // int i = m - 1, j = n - 1;
        // g[m - 1][n - 1] = '*';
        // while(i >= 1 && j >= 1)
        // {
        //     if(dist[i - 1][j] == dist[i][j] - 1)
        //     {
        //         g[i - 1][j] = '*';
        //         i--;
        //     }
        //     else {
        //         g[i][j - 1] = '*';
        //         j--;
        //     }
        // }
        // while(j == 0 && i >= 0)
        // {
        //     g[i][j] = '*';
        //     i--;
        // }
        // while(i == 0 && j >= 0)
        // {
        //     g[i][j] = '*';
        //     j--;
        // }

        // int op = 0;

        // // for(int[] dd : dist) System.out.println(Arrays.toString(dd));

        // for(char[] gg : g)
        // {
        //     // System.out.println(Arrays.toString(gg));
        //     for(char c : gg) 
        //     {
        //         if(c == '.') op++;
        //     }
        // }

        // out.println(op);
    }
    void d() throws Exception
    {
        int[] ary = toIntArray();
        int x = ary[0], y = ary[1];
        if((x + y) % 3 != 0) 
        {
            System.out.println("0");
            return;
        }
        int xy3 = (x + y) / 3;
        int a = y - xy3, b = x - xy3;
        if(a < 0 || b < 0)
        {
            System.out.println("0");
            return;
        }
        // answer = (a + b) choose a % MOD
        //        = (a + b)!  % mod * pow(a!, mod - 2) * pow(b!， mod - 2)
        Comb comb = new Comb(a + b);
        System.out.println(comb.choose(a + b, a));
    }

    
}
