// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class Main { 
  
    static BufferedReader in;
    static String file = "../in";

    static int test = 0;  // 0 for local testing, 1 for std input

    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}
        
        /****************************************************/
        /****************************************************/
        /****************************************************/
        /****************************************************/
    
        new Main().c();
    }

    void d() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int a = Integer.valueOf(sp[0]);
        int b = Integer.valueOf(sp[1]);
        sp = in.readLine().split(" ");
        int upper = 0;
        int[] ary =  new int[n];
        for(int i = 0; i < n; i++) 
        {
            ary[i] = Integer.valueOf(sp[i]);
            upper = Math.max(upper, (b / ary[i]) * ary[i]);
        }
        // find the minimum and maximum bound
        Arrays.sort(ary);
        // if this X is common then at least it satisfies the maximum number
        int lower = (int)(0.5 * ary[n - 1]);
        // upper bound is?
        
    }

    void c() throws Exception
    {
        int n = Integer.valueOf(in.readLine());
        String[] sp = in.readLine().split(" ");
        int[] a = new int[n], b = new int[n];
        for(int i = 0; i < n; i++) a[i] = Integer.valueOf(sp[i]);
        sp = in.readLine().split(" ");
        for(int i = 0; i < n; i++) b[i] = Integer.valueOf(sp[i]);
        
        int r1 = rank(n, a);
        int r2 = rank(n, b);
        
        // System.out.println(r1);
        // System.out.println(r2);
        System.out.println(Math.abs(r1 - r2));
    }

    int rank(int n, int[] a) throws Exception
    {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++) set.add(i);
        int[] f = new int[10];
        f[1] = 1;
        for(int i = 2; i < 10; i++) f[i] = i * f[i - 1];

        int rank = 0;
        for(int i = 0; i < n; i++)
        {
            // remove a[i]
            // count elements less than a[i]
            int count = 0;
            set.remove(a[i]);
            for(int k : set) if(k < a[i]) count++;
            // System.out.println(count);
            rank += count * f[n - 1 - i];
        }
        return rank;
    }

    void b() throws Exception
    {
        in.readLine();
        char[] chs = in.readLine().toCharArray();
        int n = chs.length;
        int re = 0;
        for(int i = 0; i < n - 2; i++)
        {
            if(chs[i] == 'A' && chs[i + 1] == 'B' && chs[i + 2] == 'C')
                re++;
        }
        System.out.println(re);
    }

    void a() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int a = Integer.valueOf(sp[0]);
        int b = Integer.valueOf(sp[1]);
        if(a * 500 >= b) System.out.println("Yes");
        else System.out.println("No");
    }
}