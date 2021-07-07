package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LongestPalindromicSubstring {

    @ParameterizedTest
    @ValueSource(strings = {"ababd", "a", "bb", "fdadf"})
    public void longestPalindromicSubstring(String testString) {
       int length = testString.length();
       if (length < 2) {
           System.out.println(testString);
           return;
       }
       boolean[][] palindromicMatrix = new boolean[length][length];

       for(int i = 0; i < length; i++) {
           palindromicMatrix[i][i] = true;
       }

       int maxLength = 1;
       int beginIndex = 0;

       for (int palindromicLength = 2; palindromicLength <= length; palindromicLength++) {
           for (int i = 0; i < length; i++) {
               int j = palindromicLength + i - 1;

               if(j >= length) break;
               if(testString.charAt(i) == testString.charAt(j)) {
                   if(j - i < 3) {
                       palindromicMatrix[i][j] = true;
                   } else {
                       palindromicMatrix[i][j] = palindromicMatrix[i + 1][j - 1];
                   }
               } else {
                   palindromicMatrix[i][j] = false;
               }

               if (palindromicMatrix[i][j] && palindromicLength > maxLength) {
                   beginIndex = i;
                   maxLength = palindromicLength;
               }
           }
       }

       System.out.println(testString.substring(beginIndex, beginIndex + maxLength));
    }
}
