package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: m-letcode
 * @author: Malcolm Li
 * @create: 2021-09-27 19:58
 */
public class CoinChange {

    static Integer dp(List<Integer> coins, int amount) {
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < amount + 1; i++) {
            dp.add(amount + 1);
        }
        dp.set(0, 0);
        for (int i = 0; i < dp.size(); i++) {
            for (Integer coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp.set(i, Math.min(dp.get(i), 1 + dp.get(i - coin)));
            }
        }
        return (dp.get(amount) == amount + 1) ? -1 : dp.get(amount);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 3));
        System.out.println(dp(list, 10));
    }
}
