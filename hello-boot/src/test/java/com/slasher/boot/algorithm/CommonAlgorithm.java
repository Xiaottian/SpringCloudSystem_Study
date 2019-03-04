package com.slasher.boot.algorithm;

import org.junit.Test;

/**
 * 常用的算法
 */
public class CommonAlgorithm {

    //最优化的冒泡排序
    public static void BubbleSorter(int [] a,int length){
        int j,k;
        int flag = length;
        while (flag > 0){//排序未结束标志
            k = flag;   //来记录遍历的尾边界
            flag = 0;
            for (j = 1; j < k ; j++) {
                if (a[j-1] > a[j]){//前面的数字大于后面的数字就交换
                    int temp;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    flag = j;   //记录最新的尾边界
                }
            }
        }
    }

    @Test
    public void testBubbleSorter(){
        int [] arr = {1,1,2,0,9,3,12,7,8,3,4,65,22,12,22,34,53,531,245,2467,123};
        long start = System.currentTimeMillis();
        CommonAlgorithm.BubbleSorter(arr,arr.length);
        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(end);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }


    /**
     * 归并排序
     * 归并排序是建立在归并操作上的一种有效的排序算法。
     * 该算法是采用分治法（divide-and-conquer）的一个非常典型的应用，
     * 先将待排序的序列划分成一个一个的元素，再进行两两归并，
     * 在归并的过程中保持归并之后的序列仍然有序。
     *
     */
    public void merge(int [] arr,int left,int mid,int right){
        int [] tmp = new int[arr.length];//辅助数组
        int p1 = left,p2 = mid + 1,k = left;//p1、p2是检测指针，k是存放指针
        while (p1 <= mid && p2 <=right){
            if (arr[p1] <= arr[p2]){
                tmp[k++] = arr[p1++];
            }else {
                tmp[k++] = arr[p2++];
            }
        }
        while (p1 <= mid ){//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
            tmp[k++] = arr[p1++];
        }
        while (p2<=right)
            tmp[k++] = arr[p2++];

        //复制回原数组
        for (int i = left; i <= right ; i++) {
            arr[i] = tmp[i];
        }
    }
    public void mergeSort(int [] a,int start,int end){
        if(start<end){//当子序列中只有一个元素时结束递归
            int mid=(start+end)/2;//划分子序列   疑问：（1+2）/2 = ?  答：=1
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }
    @Test
    public void testMergeSort(){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergeSort(a, 0, a.length-1);
        System.out.println("排好序的数组：");
        for (int e : a)
            System.out.print(e+" ");
    }

    /**
     * 快速排序
     * 快速排序是使用分治法（divide-and-conquer）依选定的枢轴
     * 将待排序序列划分成两个子序列，其中一个子序列的元素都小于枢轴，
     * 另一个子序列的元素都大于或等于枢轴，然后对子序列重复上面的方法，
     * 直到子序列中只有一个元素为止
     *
     */
    public void sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];

        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }

    /**
     * 二分查找实现
     * @param srcArray
     * @param start
     * @param end
     * @param key
     * @return
     */
    public static int binSearch(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }

    // 二分查找普通循环实现
    public static int binSearch(int srcArray[], int key) {
        int mid = srcArray.length / 2;
        if (key == srcArray[mid]) {
            return mid;
        }

        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a = (1+2)/2;
        System.out.println(a);
    }
}
