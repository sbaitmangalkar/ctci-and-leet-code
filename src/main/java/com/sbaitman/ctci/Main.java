package com.sbaitman.ctci;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    /*Object message() {
        return "Hello";
    }

    public static void main(String[] args) {
        System.out.println(new Main().message());
        System.out.println(new Main2().message());
    }*/

    /*static int count = 0;

    public static void main(String[] args) {
        if (count < 3) {
            count++;
            main(null);
        } else {
            return;
        }

        System.out.println("Hello World!");
    }*/

    /*public static void main(String[] args) {
        String[] array = {"abc", "2", "10", "0"};
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));
    }*/
}

class Main2 extends Main {
    String message() {
        return "World";
    }
}
