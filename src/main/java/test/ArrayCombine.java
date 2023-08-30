package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数组元素合并
 * example
 * array: [1,2,3]
 * m: 2
 * <p>
 * return: [[1,2],[1,3],[2,1],[2,3],[3,1],[3,2]]
 *
 * @author ll
 */
public class ArrayCombine {

    /**
     * 返回 array中m个组合
     *
     * @param array 数组
     * @param m     组合数
     * @return List<List < Integer>>
     */
    public static List<List<Integer>> combineResult(int[] array, int m) {
        List<List<Integer>> results = new ArrayList<>();

        if (m > array.length) {
            return results;
        }

        // 递归处理
        combine(results, null, null, array, m);

        return results;
    }

    /**
     * 递归组合数组中的元素
     *
     * @param results          数组猎豹
     * @param itemList         待组合的猎豹
     * @param excludeIndexList 需要排除的数组索引
     * @param array            数组
     * @param m                需要组合的长度
     */
    public static void combine(List<List<Integer>> results, List<Integer> itemList, List<Integer> excludeIndexList, int[] array, int m) {
        // null处理
        if (null == itemList) {
            itemList = new ArrayList<>();
        }
        // null处理
        if (null == excludeIndexList) {
            excludeIndexList = new ArrayList<>();
        }
        // 遍历数组
        for (int j : array) {
            if (excludeIndexList.contains(j)) {
                continue;
            }

            // 每个循环重置待排除的数组索引猎豹对象，防止影响其他外层循环
            List<Integer> newExcludeIndexList = new ArrayList<>(excludeIndexList);
            // 加入当前循环索引
            newExcludeIndexList.add(j);

            // 每个循环重置待组合的列表，防止影响其他外层循环
            List<Integer> newItemList = new ArrayList<>(itemList);
            newItemList.add(j);

            // 递归条件判断
            if (newItemList.size() < m) {
                combine(results, newItemList, newExcludeIndexList, array, m);
            } else {
                results.add(newItemList);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(combineResult(arr, 3));
    }
}
