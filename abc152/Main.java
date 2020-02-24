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

    int mod = 1_000_000_007;

    void e() throws Exception
    {
        int n = Integer.valueOf(in.readLine());
        String[] sp = in.readLine().split(" ");

        // find common factors first
        int[] ary = new int[n];
        for(int i = 0; i < n; i++)
        {
            ary[i] = Integer.valueOf(sp[i]);
        }

        int[] count = new int[1000_010];
        for(int a : ary)
        {
            int num = a;
            for(int j = 2; j * j <= num; j++)
            {
                if(num % j == 0)
                {
                    int c = 0;
                    while(num % j == 0)
                    {
                        num /= j;
                        c++;
                    }
                    count[j] = Math.max(count[j], c);
                }
                
            }
            if(num > 1) count[num] = Math.max(count[num], 1);
        }
        
        // calculate prod
        long lcm = 1;
        for(int i = 0; i <= 1000000; i++)
        {
            lcm *= pow(i, count[i]);
            lcm %= mod;
        }

        int sum = 0;
        for(int a : ary)
        {
            long val = (lcm * pow(a, mod - 2)) % mod;
            sum += val;
            sum %= mod;
        }

        System.out.println(sum);        
    }

    long pow(int aa, int b)
    {
        long re = 1, a = (long) aa;
        if(b == 0) return 1;
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
        
        return re % mod;
    }

    long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    void d() throws Exception
    {
        int n = Integer.valueOf(in.readLine());

        int[][] f = new int[10][10];
        int re = 0;

        for(int a = 1; a <= n; a++)
        {
            String s = String.valueOf(a);
            int m = s.length(),
                a0 = s.charAt(0) - '0',
                a1 = s.charAt(m - 1) - '0';
            f[a0][a1]++;
        }

        for(int a = 1; a <= n; a++)
        {
            String s = String.valueOf(a);
            int m = s.length(),
                a0 = s.charAt(0) - '0',
                a1 = s.charAt(m - 1) - '0';
            re += f[a1][a0];
        }

        System.out.println(re);
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
        int n = Integer.valueOf(in.readLine());
        String[] sp = in.readLine().split(" ");
        TreeSet<Integer> set = new TreeSet<>();

        int re = 0;

        for(int i = 0; i < n; i++)
        {
            int next = Integer.valueOf(sp[i]);
            set.add(next);
            if(set.first() >= next) re++;
        }

        System.out.println(re);
        
    }
    void b() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int a = Integer.valueOf(sp[0]),
            b = Integer.valueOf(sp[1]);
        String s1 = "", s2 = "";
        for(int i = 0; i < a; i++) s1 += "" + b;
        for(int i = 0; i < b; i++) s2 += "" + a;
        if(s1.compareTo(s2) < 0) System.out.println(s1);
        else System.out.println(s2);
    }

    void a() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            m = Integer.valueOf(sp[1]);
        if(m >= n) System.out.println("Yes");
        else System.out.println("No");
    }
}
