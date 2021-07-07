package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromNumber {
    @ParameterizedTest
    @ValueSource(ints = {123, 321, -100, -2147483648, 0, 2147483647, 120, 901000, 90000, -123, 121, 3003, 1})
    public void should_return_(int testCase) {
        System.out.println(palindromeNumber(testCase));
    }
// only need to revert half number
    private boolean palindromeNumber(int x) {
        if (x < 0 || (x !=0 && x % 10 == 0)) return false;

        int ver = 0;
        while (x > ver) {
            ver = ver * 10 + x % 10;
            x = x / 10;
        }

        return ver == x || ver / 10 == x;
    }
//    private boolean palindromeNumber(int x) {
//        if (x == 0) return true;
//        if (x < 0) return false;
//
//        int ver = 0;
//        int current = x;
//
//        while (current > 0) {
//            ver = ver * 10 + current % 10;
//            current = current / 10;
//        }
//        return ver == x;
//    }
}
