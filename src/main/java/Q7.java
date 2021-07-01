import java.util.Arrays;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q7 {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();
        if (sb.indexOf("-") != -1) {
            sb.insert(0,"-");
            sb.delete(sb.length() - 1, sb.length());
        }
        Long value = Long.valueOf(sb.toString());
        if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
            return value.intValue();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q7().reverse(1534216469));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}

