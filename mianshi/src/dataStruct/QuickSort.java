package dataStruct;

import java.util.List;

public class QuickSort {
    //快速排序
    public static void main(String[] args) {
        //从有往左找 找到比key值小的就和key值对换,key值一般是第一个数
        //然后总左往右找比key值大的数,也调换位置  这样来的话  就是把整个数据变换成了从左往右是从小到达的位置了
        //因为从做往右还是从右往左都是一个一个来来交换  所以说只要俩个下标相等就排序完成

        int[] arr = {6,2,7,3,8,9};
        int[] sortList = getSortList(arr);
        for (int i=0;i<sortList.length-1;i++){
            System.out.println(sortList[i]);
        }

        quick_sort(arr,0,arr.length);
        for (int i=0;i<arr.length-1;i++){
            System.out.println(arr[i]);
        }
    }
    public static int[] getSortList(int[] arr){
        boolean flag = true;
        int key;
        //先让这个第一个数据成为key值然后再进行比较
        while (flag) {
            key = arr[0];
            //然后从右往左进行检索,找出比这个key更小的第一数,然后和key交换位置
            for (int i = arr.length - 1; i > 0; i--) {
                int temp;
                temp = key;
                key = arr[i];
                arr[i] = temp;
                //在里面进行了一次循环之后紧接着就是下一次循环了
                for (int j = 0; j < arr.length - 1; j++) {
                    if (i > j) {
                        int temp1;
                        temp1 = key;
                        key = arr[j];
                        arr[j] = temp1;

                    }else{
                        flag = false;
                    }

                }
            }
        }
        return arr;
    }

    public static int adjustArray(int[] s,int left,int right){
        //先将第一个值赋值给left
        int i=left,j=right;
        int x=s[left];//这个x就是第一个坑,可以将key值取出来
        //然后是进行判断,将后面的值给比x小的数,填到这个坑里面
        //这里的while是第一次判断,需要满足条件就是左边left一直小于right,等到left=right的时候就可以将x值填进最后一个坑里面了
        while (left<right){
            //先从右往左找,如果说找到了就进行填充,注意right--有俩种情况,一种是找到比x小的数,一种是没有,找到,也就是说这个值本身就比x大
            while (left<right&&x<=s[right]){
                j--;
            }
            if (s[right]<x){
                s[left]=s[right];
                right--;
            }
            //同样的,这个也是有俩个情况
            if (s[left]>x){
                s[right]=s[left];
                left++;
            }
            while (left<right&&s[left]>x){
                left++;
            }
        }
        s[left]=x;
        //返回的left
        return i;
    }

    static void quick_sort(int s[],int left,int right){
        if (left<right){
            int i = adjustArray(s, left, right);
            quick_sort(s,left,i-1);
            quick_sort(s,i+1,right);
        }
    }
}
