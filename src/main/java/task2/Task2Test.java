package task2;


import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class Task2Test {

    private final static Random random = new Random();
    int[] addValue(int[] org, int added) {
        int[] res = Arrays.copyOf(org, org.length + 1);
        res[org.length] = added;
        return res;
    }

    int[] genArray(int len, boolean skip) {
        int[] arr = {};

        for (int i = 0; i < len; i++) {
            int val = random.nextInt(10);
            if (skip)
                while (val == 4)
                    val = random.nextInt(10);
            arr = addValue(arr, val);
        }
        return arr;
    }

    Task2Body task2 = new Task2Body();

    @Test(timeout = 50)
    public void test1() {
        System.out.println("Тест на время");
        System.out.println(Arrays.toString(task2.doIT(genArray(20, false))));
    }

    @Test(expected = RuntimeException.class)
    public void test2() {
        int [] arr = genArray(5, true);
        System.out.println("Тест на исключение\n" + Arrays.toString(arr));

        task2.doIT(arr);
    }

    @Test
    public void test3() {
        int [] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};

        System.out.println("Тест корректность\n" + Arrays.toString(arr));
        assertArrayEquals("Массивы должны совпадать", task2.doIT(arr), new int[] {1, 7});
    }

    @Test
    public void test4() {
        int [] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};

        System.out.println("Тест заведумую ошибку\n" + Arrays.toString(arr));
        //assertNotArrayEquals
        //assertArrayNotEquals или мной не найдены или не существуют поэтому тест дожнен провалиться, да это не корректно
        assertArrayEquals("Массивы должны не совпадать", task2.doIT(arr), new int[] {1, 7, 8});
    }

}
