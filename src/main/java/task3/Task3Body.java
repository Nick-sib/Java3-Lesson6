package task3;

public class Task3Body {

    private static final String errText = "Массив пустой";


    public boolean doIT(int[] arrIn) {
        if (arrIn.length == 0) throw new RuntimeException(errText);

        for (int i = 0; i < arrIn.length - 1; i++) {
            if ((arrIn[i] != 1) && (arrIn[i] != 4))
                return false;
        }
        return true;
    }
}
