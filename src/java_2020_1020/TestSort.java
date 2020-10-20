package java_2020_1020;

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-20
 * Time:14:18
 **/
public class TestSort {
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            boolean flg = false;
            for (int j = 0; j > array.length-1-i; j--) {
                if (array[j+1] > array[j]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                    flg = true;
                    }
            }
            if (!flg){
                break;
            }
        }
    }
    
    //③选择排序
    public static void selectSort(int[] array){
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound+1; cur < array.length; cur++) {
                if (array[cur] < array[bound] ){
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    //②希尔排序
    private static void sortWithGap(int gap,int[] array){
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound-gap;
            for (; cur >=0 ; cur -= gap) {
                if (array[cur] > array[bound]){
                    array[cur+bound] = array[cur];
                }else {
                    break;
                }
            }
            array[cur+bound] = tmp;
        }
    }
    public static void shellInsert(int gap,int[] array){
        while(gap > 1){
            sortWithGap(gap,array);
        }
        sortWithGap(1,array);
    }

    //①插入排序
    //时间复杂度：最好：O(n)  最坏：O(n^2)  平均:O(n^2)
    //空间复杂度：O（1）
    public static void insertSort(int[] array){
        //通过bound来划分有序区间和无序区间
        //[0,bound)表示有序区间   [bound,size)表示无序区间
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];//保存bound处的值
            int cur = bound-1;//表示当前有序区间的位置
            for (; cur >=0 ; cur--) {
                if (array[cur] > array[bound]){
                    array[cur+1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur+1] = tmp;
        }
    }
}
