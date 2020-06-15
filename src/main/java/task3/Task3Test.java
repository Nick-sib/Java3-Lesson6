package task3;


import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.junit.Test;
import task2.Task2Body;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class Task3Test {

    private final static Random random = new Random();

    int[] addValue(int[] org, int added) {
        int[] res = Arrays.copyOf(org, org.length + 1);
        res[org.length] = added;
        return res;
    }

    int[] genArray(int len, boolean onlyTrue) {
        int[] arr = {};

        for (int i = 0; i < len; i++) {
            int val = random.nextInt(10);
            if (onlyTrue)
                while ((val != 4) && (val != 1))
                    val = random.nextInt(10);
            arr = addValue(arr, val);
        }
        return arr;
    }

    Task3Body task3 = new Task3Body();

    @Test(timeout = 50)
    public void test1() {
        final int ARRAYLENGTH = 50;
        int [] arr = genArray(ARRAYLENGTH, false);
        System.out.println("Тест на время\n" + Arrays.toString(arr));
        System.out.println(task3.doIT(arr));
    }

    @Test(expected = RuntimeException.class)
    public void test2() {
        int [] arr = {};
        System.out.println("Тест на исключение\n");

        task3.doIT(arr);
    }

    @Test
    public void test3() {
        int [] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};

        System.out.println("Тест корректность 1\n" + Arrays.toString(arr));
        assertFalse("Массив должен выдать FALSE", task3.doIT(arr));
    }

    @Test
    public void test4() {
        int [] arr = genArray(20, true);
        System.out.println("Тест корректность 2\n" + Arrays.toString(arr));

        assertTrue("Массив должен выдать TRUE", task3.doIT(arr));
    }

}
