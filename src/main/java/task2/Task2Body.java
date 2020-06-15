package task2;

import java.util.Arrays;

public class Task2Body {


    private static final String errText = "Нет ни одной \"4\"";


    public int[] doIT(int[] arrIn) {
        for (int i = arrIn.length - 1; i > -1 ; i--) {
            if (arrIn[i] == 4) {
                return Arrays.copyOfRange(arrIn, i + 1, arrIn.length);
            }
        }
        throw new RuntimeException(errText);
    }
}


