package com.sbaitman.ctci.stringsandarrays;

public class StringCompress {
    public static int compress(char[] chars) {
        if(chars.length <= 0) {
            return 0;
        }

        StringBuilder res = new StringBuilder();
        int count = 1;
        for(int i = 0; i < chars.length; i++) {
            if(i == chars.length - 1) {
                res.append(chars[i]).append(count);
                break;
            }
            if(chars[i] == chars[i + 1]) {
                count++;
            } else {
                res.append(chars[i]);
                res.append(count);
                count = 1;
            }
        }
        System.out.println(res.toString());
        return res.length();
    }

    public static void main(String[] args) {
        System.out.println(compress(new String("aabbccc").toCharArray()));
    }
}
