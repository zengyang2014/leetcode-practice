package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ZigZagConversion {

    @ParameterizedTest
    @ValueSource(strings = {"AB"})
    public void zigzag_conversion(String s) {
        int numRows = 1;
        int stringLength = s.length();
        StringBuffer stringBuffer = new StringBuffer();

        for (int r = 1; r <= numRows; r++) {
            int currentIndex = 0;
            for (int j = 1; j <= stringLength; j++) {
                if (r == 1) {
                    currentIndex = 0;

                } else {
                    currentIndex = r - 1;
                    if (currentIndex >= stringLength) break;
                }
                stringBuffer.append(s.charAt(currentIndex));
            }
        }

        System.out.println(stringBuffer);
    }
}
