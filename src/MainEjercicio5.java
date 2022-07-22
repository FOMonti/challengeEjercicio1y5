import exception.ConvertException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainEjercicio5 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("FirstWord", "SecondWord", "THIRDWORD"));
        try {
            System.out.println(convert(list));
        } catch (ConvertException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String convert(List<String> list) {
        if (list.size() > 10) {
            throw new ConvertException("The maximum array size is 10");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i).toLowerCase();
            if (word.contains("ñ") || word.length() > 32) {
                throw new ConvertException("The maximum word size is 32");
            }
            sb.append(word);
            if (!(i == list.size() - 1)) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
