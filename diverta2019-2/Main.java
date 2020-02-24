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
        // System.out.println((-100 + 0) / 2);

        new Main().b();
        out.flush();
    }

    void b() throws Exception
    {
        int n = readInt();
        int[][] points = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            points[i] = toIntArray();
        }
        
        int[] vis = new int[n];
        int total = 0;
        int re = 0;
        while(total < n)
        {
            for(int i = 0; i < n; i++)
            {
                if(vis[i] > 0) continue;
                // point[i] is starting point
                vis[i] = 1;
                total++;
                Map<String, Integer> map = new HashMap<>();
                String slp = "";
                int count = 0;
                for(int j = i + 1; j < n; j++)
                {
                    if(vis[j] > 0) continue;
                    String slope = getSlope(points[i], points[j]);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    if(count < map.get(slope)) 
                    {
                        slp = slope;
                        count = map.get(slope);
                    }
                }

                // System.out.println("...");
                // System.out.println(slp);
                // System.out.println("...");

                for(int j = i + 1; j < n; j++)
                {
                    if(vis[j] > 0) continue;
                    String slope = getSlope(points[i], points[j]);
                    if(slp.equals(slope))
                    {
                        vis[j] = 1;
                    }
                }
                // System.out.println(map);
                re++;
                total += count;
                // System.out.println(Arrays.toString(vis));
                // System.out.println(total);
            }
        }

      	out.println(re);
    }

    String getSlope(int[] a, int[] b)
    {
        int dx = b[0] - a[0], dy = b[1] - a[1];
        if(dx == 0) return "null";
        int gcd = gcd(dx, dy);
        return "" + (dy / gcd) + "/" + (dx / gcd);
    }
}
