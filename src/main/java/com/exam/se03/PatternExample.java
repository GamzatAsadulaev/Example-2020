package com.exam.se03;

import java.util.regex.Pattern;

public class PatternExample {

    public static void main(String[] args) {
        String pattern01 = "<+";
        String pattern02 = "<?";
        String pattern03 = "<*";
        //String pattern04 = "(<body>|</body>)";

        String str = "<body><h1> a<<<b> </h1></body>";
        //printTokens(Pattern.compile(pattern01).split(str));
        //printTokens(Pattern.compile(pattern02).split(str));
        //printTokens(Pattern.compile(pattern03).split(str));
        //printTokens(Pattern.compile(pattern04).split(str));

    }

    public static void printTokens(String[] tokens) {
        for (String str : tokens) {
            if("".equals(str)){
                System.out.print("\"\"" + "|");
            } else {
                System.out.print(str + "|");
            }
        }
        System.out.println();
    }

}
