import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClass {
    public static void main(String args[]) throws Exception {


        Scanner s = new Scanner(System.in);
        int n, k;
        n = s.nextInt();
        k = s.nextInt();
        Long[] integers = new Long[n];
        Long[] integers1 = new Long[n];
        for (int i = 0; i < n; i++) {
            integers[i] = s.nextLong();
            integers1[n-i-1] = integers[i];
        }
        int st = 0, end = 0;
        List<Long> integers2 = new ArrayList<>();
        List<Long> integers3 = new ArrayList<>();
        while (n-st > k) {
            Long c = getavg(integers, st);
            integers[st + 2] = c;
            integers2.add(c);
            Long d = getavg(integers1, st);
            integers1[st + 2] = d;
            integers3.add(d);
            st=st+2;
        }
        Long maxavg = 0L,curavg=0L;
        for (int i = 0; i < integers2.size(); i++) {
            if (i==0){ curavg=integers2.get(i);}
            else {
                curavg=(curavg*integers2.get(i))%1000000007;
            }
            if (curavg>maxavg) maxavg=curavg;
        }
        for (int i = 0; i < integers3.size(); i++) {
            if (i==0){ curavg=integers3.get(i);}
            else {
                curavg=(curavg*integers3.get(i))%1000000007;
            }
            if (curavg>maxavg) maxavg=curavg;
        }

        System.out.println(maxavg);
    }

    static Long getavg(Long[] integers, int ind) {
        Long avg = 0L;
        for (int i = ind; i < ind + 3; i++) {
            avg = avg + integers[i];
        }
        return avg / 3;
    }
}


