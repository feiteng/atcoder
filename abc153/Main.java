//
import java.math.*;
import java.util.*;
import java.io.*;
  
public class Main { 
  
    static BufferedReader in;
    static String file = "../in";

    public static void main(String[] args) throws Exception
    {
        int test = 10,   // 0 for local testing, 1 for std input
            _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}

        new Main().f();

    }

    void f() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            d = Integer.valueOf(sp[1]),
            a = Integer.valueOf(sp[2]);

        int[][] ary = new int[n][2];

        for(int i = 0; i < n; i++) {
            sp = in.readLine().split(" ");
            ary[i][0] = Integer.valueOf(sp[0]);
            ary[i][1] = Integer.valueOf(sp[1]);
        }
        
        Arrays.sort(ary, (u, v)->(u[0] - v[0]));

        long sum = 0;

        Queue<int[]> q = new PriorityQueue<>((u, v)->(u[0] - v[0]));
        for(int i = 0; i < n; i++)
        {
            System.out.println(re);
            while(!q.isEmpty() && q.peek()[0] < ary[i][0]) q.poll();
            long maxd = 0L + ary[i][0] + 2 * d;

            while(!q.isEmpty() && maxd <= q.peek()[0]) sum += q.poll()[1];
            
            ary[i][1] -= sum;

            if(ary[i][1] <= 0) continue;

            int op = ary[i][1] / a;

            if(ary[i][1] % a > 0) op++;

            sum += op;

            q.offer(new int[]{ary[i][0], op});
            q.offer(new int[]{(int)maxd, -op});

        }

        System.out.println(sum);
    }

    void e() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int h = Integer.valueOf(sp[0]),
            n = Integer.valueOf(sp[1]);

        int[] weight = new int[n];
        int[] cost = new int[n];

        int[] f = new int[20010];
        Arrays.fill(f, 1 << 30);
        f[0] = 0;
        for(int i = 0; i < n; i++)
        {
            sp = in.readLine().split(" ");
            int c = Integer.valueOf(sp[0]);
            int w = Integer.valueOf(sp[1]);
            for(int j = c; j <= 20000; j++)
            {
                f[j] = Math.min(f[j], f[j - c] + w);
            }
        }
        // System.out.println(Arrays.toString(f));
        for(int i = 20000; i >= 1; i--)
            f[i] = Math.min(f[i], f[i + 1]);

        // System.out.println(Arrays.toString(f));

        // for(int i = 1; i <= h; i++) 
        //     f[i] = Math.min(f[i], 1 + f[i - 1]);
        
        // System.out.println(Arrays.toString(f));
        System.out.println(f[h]);
    }

    long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    void d() throws Exception
    {
        long h = Long.valueOf(in.readLine());

        // binary heap style
        //
        long count = 1;
        long sum = 0;
        while(h > 0)
        {
            h /= 2;
            sum += count;
            count *= 2;
        }
        System.out.println(sum);
    }
    
    boolean satisfy(int a, int b)
    {
        String s1 = String.valueOf(a),
                s2 = String.valueOf(b);
        int m = s1.length(), n = s2.length();
        if(s1.charAt(0) == s2.charAt(n - 1) && 
            s1.charAt(m - 1) == s2.charAt(0)) return true;
        return false;
    }

    void c() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            k = Integer.valueOf(sp[1]);
        int[] ary = new int[n];
        sp = in.readLine().split(" ");
        for(int i = 0; i < n; i++)
        {
            ary[i] = Integer.valueOf(sp[i]);
        }

        Arrays.sort(ary);
        // use spec on k highest

        long sum = 0;
        for(int i = 0; i < n - k; i++) sum += ary[i];
        
        System.out.println(sum);
        
    }
    void b() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int h = Integer.valueOf(sp[0]),
            n = Integer.valueOf(sp[1]);
        sp = in.readLine().split(" ");
        for(int i = 0; i < n; i++)
        {
            h -= Integer.valueOf(sp[i]);
        }
        if(h <= 0) System.out.println("Yes");
        else System.out.println("No");
    }

    void a() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int h = Integer.valueOf(sp[0]),
            a = Integer.valueOf(sp[1]);
        int r = 0;
        while(h > 0)
        {
            h -= a;
            r++;
        }
        System.out.println(r);
    }
}
