package com.test.other;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/22 18:06
 */
public class Java8NewCharacterTest {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());

        random.ints().limit(10).forEach(System.out::println);
        squaresList.forEach(System.out::println);

        long count = strings.stream().filter(str -> str.isEmpty()).count();
        System.out.println(count);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);


        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

    }
}
