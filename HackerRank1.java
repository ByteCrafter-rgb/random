import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// This solution is wrong, and is fking my mind. Please help

class Result {

    /*
     * Complete the 'findSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String findSubstring(String s, int k) {
    
        int n = s.length();
        int[] arr = new int[n+1];
        
        for (int i = 1; i<=n ; i++) {
            if(isVowel(s.charAt(i-1))) {
                arr[i] = 1;
            }
        }
        
        for( int i =1; i<=n;i++) {
            arr[i] += arr[i-1];
        }
        
        int b = 1, c = k;
        
        int l = -1;
        
        while (b >=0 && c <=n) {
            l = Math.max(l, arr[c]-arr[b-1]);
            // System.out.println(b);
            // System.out.println(c);
            c++; b++;
        }
        // System.out.println(b);
        //     System.out.println(c);
        String result = s.substring(b-2, c-1);
        if (l <= 0) {
            return "Not found!";
        }
        return result;

    }
    
    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' 
           || c == 'i' || c == 'o' || c == 'u'
        ) {
            return true;
        }
        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.findSubstring(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
