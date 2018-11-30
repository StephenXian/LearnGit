package dataStruct;

public class FinalQuickSort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5,45,98,16};
        quickSort(arr,0,6);
        for (int i=0;i<arr.length-1;i++){
            System.out.println(arr[i]);
        }
    }


    //快速排序
    void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

    //快速排序再写
    public static int quickSort(int[] arr,int startIndex,int endIndex){
        int left=startIndex;
        int right=endIndex;
        int privot=arr[startIndex];
        while(left!=right){
            //从右往左将指针往左移动
            while(left<right&&arr[right]>privot){
                right--;
            }
            while(left<right&&arr[left]<=privot){
                left++;
            }
            if (left<right){
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        //第一个位置的元素取了出来,因为他作为left也参与了交换,等指针相遇的时候,就将这个key值放到中间
        int temp = arr[left];
        arr[left]=arr[startIndex];
        arr[startIndex]=temp;
        return left;
    }
    public static void quickSortTest(int[] arr,int startIndex,int endIndex){
        if (startIndex>=endIndex){
            return;
        }
        int i = quickSort(arr, startIndex, endIndex);
        quickSort(arr,startIndex,i-1);
        quickSort(arr,i+1,endIndex);
    }
}















