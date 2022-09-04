package com.dap.sort;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 简单排序
 * 1、线性时间类非比较排序
 * 2、非线性实践类比较排序
 * 题目：生成一组随机数（个数为n），排序，求出第k大的值
 * 解决：
 * 1、冒泡排序
 * 2、选择排序
 * 3、插入排序
 * 4、希尔排序
 * 5、堆排序
 * 6、快速排序
 * 7、归并排序
 * 8、计数排序
 * 9、桶排序
 * 10、基数排序
 *
 * @author hepeng
 * @date 2018/12/12 12:40
 */
public class Sorts {

    public static void main(String[] args) {
        System.out.print("排序前数组：");
        int[] data = random(10);
        out(data);

        System.out.print("冒泡排序后：");
        bubbleSort(data);
        out(data);

        System.out.print("选择排序后：");
        selectionSort(data);
        out(data);

        System.out.print("快速排序后：");
        quickSort(data);
        out(data);

        // TOTO 插入排序
        // TOTO 堆排序
        // TOTO 归并排序
    }

    /**
     * 冒泡排序
     * <li>时间 O(n^2)</li>
     * <li>空间 O(1)</li>
     */
    public static void bubbleSort(int[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                int a = data[j];
                if (a > data[j + 1]) {
                    // 两两交换
                    data[j] = data[j + 1];
                    data[j + 1] = a;
                }
            }
        }
    }

    /**
     * 选择排序
     * 在未排序数据中，找出最大/最小数据，放置起始位置，剩余的数据同等操作
     * 1、为排序数据中交换比较，记录最小数据
     * 2、删除原最小位，将最小数据插至起始位
     * 3、重复1、2步，直至完成
     */
    public static void selectionSort(int[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            int a = data[i];
            // 最小值下标
            int b = i;
            for (int j = i; j < length - 1; j++) {
                if (a > data[j + 1]) {
                    a = data[j + 1];
                    b = j + 1;
                }
            }
            // 被选择位置与其实位置交换
            data[b] = data[i];
            data[i] = a;
        }
    }

    /**
     * @Desc: 快速排序
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * <p>
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     */
    public static void quickSort(int[] data) {
        if (data != null && data.length != 0) {
            quickSort(data, 0, data.length - 1);
        }
    }

    public static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int index = partition(data, left, right);
            quickSort(data, left, index - 1);
            quickSort(data, index, right);
        }
    }

    public static int partition(int[] data, int left, int right) {
        // 基准值
        int base = left;
        int index = base + 1;
        for (int i = index; i <= right; i++) {
            // 小于基准值
            if (data[i] < data[base]) {
                // 换到基准值后面的位置
                swap(data, i, index);
                index++;
            }
        }
        swap(data, base, index - 1);
        return index;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 插入排序
     */
    public static void insertionSort(int[] data) {

    }

    /**
     * 产生随机数
     */
    public static int[] random(int n) {
        Random random = new Random();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Math.abs(random.nextInt(1000));
        }
        return data;
    }

    /**
     * 打印数组
     */
    public static void out(int[] data) {
        Arrays.stream(data).forEach(value -> {
            System.out.print(value + " ");
        });
        System.out.println();
    }
}
