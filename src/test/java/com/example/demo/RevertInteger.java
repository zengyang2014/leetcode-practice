package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RevertInteger {
    @ParameterizedTest
    @ValueSource(ints = {123, 321, -100, -2147483648, 0, 2147483647, 120, 901000, 90000, -123})
    public void should_return_(int testCase) {
        int rev = 0;
        while (testCase != 0){
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE /10) return;
            int digital = testCase % 10;
            testCase = testCase / 10;
            rev = rev * 10 + digital;
        }

        System.out.println(rev);


//        if (testCase == 0) return;
//        // when
//        StringBuilder sb = new StringBuilder();
//
//        int current = testCase < 0 ? -testCase : testCase;
//        String s = String.valueOf(current);
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            sb.append(current % 10);
//            current = current / 10;
//        }
//
//        while(sb.charAt(0) == '0') sb.deleteCharAt(0);
//
//        sb = testCase < 0 ? new StringBuilder("-" + sb) : sb;
//        try {
//            System.out.println(Integer.decode(sb.toString()));
//        } catch (Exception e) {
//            System.out.println(0);
//        }
    }
}
