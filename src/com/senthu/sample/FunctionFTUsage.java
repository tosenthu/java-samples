package com.senthu.sample;

import java.util.function.Function;

/**
 * FunctionFTUsage : FunctionFTUsage
 *
 * @author : Senthil Kumar Manguzhiparambil Rangan (smanguzh@cisco.com)
 * @version : 1.0 (Jun 01, 2022)
 * @since : 1.0 (Jun 01, 2022)
 */
public class FunctionFTUsage {

    public static void main(String[] args) {

        Function<String, Integer> INT_CONVERTER = s -> Integer.valueOf(s);

        System.out.println(INT_CONVERTER.apply("122"));
    }
}
