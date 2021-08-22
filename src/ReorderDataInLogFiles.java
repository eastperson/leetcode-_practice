import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReorderDataInLogFiles {
    public static void main(String[] args) {
        ReorderDataInLogFilesSolution solution = new ReorderDataInLogFilesSolution();
        int[] d = {2,2,3,3};
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};


        System.out.println(Arrays.toString(solution.reorderLogFiles(logs)));
    }
}

class ReorderDataInLogFilesSolution {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> comparator = (String s1, String s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                int comp = split1[1].compareTo(split2[1]);
                if (comp != 0) return comp;
                return split1[0].compareTo(split2[0]);
            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        };
        Arrays.sort(logs,comparator);
        return logs;
    }
}

