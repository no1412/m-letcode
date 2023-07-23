package simple;

import java.util.Arrays;

/**
 * 7. 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */
public class Q9 {
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        String origin = sb.toString();
        return origin.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2}, {1, 5}, {3, 15}, {4, 8}};
//        Arrays.sort(x, (a,b) -> {
//            if (a[0] == b[0]) {
//                return b[1] - a[1];
//            }
//            return a[0] - b[0];
//        });
        Arrays.sort(x);
        System.out.println(Arrays.deepToString(x));
    }
}

