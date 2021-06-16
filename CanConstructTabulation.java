import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class CanConstructTabulation {


    /**
     * Write a function `canConstruct(target, wordBank)` that accepts a 
     * target string and an array of strings.
     * 
     * The function should return a boolean indicating whether or not the
     * `target` can be constructed by concatenating element of the
     * `wordBank` array.
     * 
     * You may reuse elements of `wordBank` as many times as needed.
     * 
     * m = target.length
     * n = wordBack.length
     * 
     * Time: O(m^2 * n)  Space: O(m)
     */
    static boolean canConstruct(String target, String[] wordBank) {

        // **** sanity checks ****
        if (target.length() == 0) return true;

        // **** initialization (using boolean because function returns boolean) ****
        boolean table[] = new boolean[target.length() + 1];
        table[0] = true;

        // **** iterate through the table ****
        for (int i = 0; i < table.length; i++) {

            // **** skip this position in the table (if needed) ****
            if (table[i] == false)
                continue;

            // **** loop through the word bank ****
            for (int j = 0; j < wordBank.length; j++) {

                // **** for ease of use ****
                String word = wordBank[j];

                // **** if out of bounds (skip) ****
                if (i + word.length() >= table.length)
                    continue;

                // **** for ease of use ****
                String sub = target.substring(i, i + word.length());

                // **** check if this word matches (set table entry to true) ****
                if (sub.equals(word))
                    table[i + word.length()] = true;
            }

            // **** if target was found (early return true) ****
            if (table[target.length()])
                return true;
        }

        // **** return last entry in table ****
        return table[target.length()];
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // **** read target ****
        String target = br.readLine().trim();

        // **** read word bank ****
        String[] wordBank = br.readLine().trim().split(",");

        // **** close buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<< target ==>" + target + "<==");
        System.out.println("main <<< wordBank: " + Arrays.toString(wordBank));

        // **** call function of interest and display result ****
        System.out.println("main <<< canConstruct: " + canConstruct(target, wordBank));
    }
}