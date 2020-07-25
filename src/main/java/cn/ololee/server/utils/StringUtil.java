package cn.ololee.server.utils;

import java.util.Random;

public class StringUtil {
    private static Random random=new Random();
    public static String generateString(int length){
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }
}
