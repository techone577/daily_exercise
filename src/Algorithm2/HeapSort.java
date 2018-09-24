package Algorithm2;

public class HeapSort {
    public static void HeapSort (int[] nums) {
        buildHeap(nums);
        for(int i=nums.length-1;i>=0;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            maxHeapfy(nums,0,i);
        }
    }

    /**
     * 建堆，从下往上调整，从(n-1)/2-0，只有这些节点有子节点
     */
    private static void buildHeap (int[] nums) {
        for (int i = ((nums.length - 1) - 1) / 2; i >= 0; --i) {
            maxHeapfy(nums,i,nums.length);
        }
    }

    //length排序时用来限定排好的位数
    private static void maxHeapfy (int[] nums, int index,int length) {
        for (; ; ) {
            int max = index;
            int left = 2 * max + 1;
            int right = 2 * max + 2;
            //父节点、左孩子、右孩子选出最大
            if (left < length && nums[left] > nums[max])
                max = left;
            if (right < length && nums[right] > nums[max])
                max = right;
            //交换并递归调整
            if (max != index) {
                int temp = nums[index];
                nums[index] = nums[max];
                nums[max] = temp;
                index = max;
            } else
                break;
        }
    }
    public static void main (String[] args) {
        int []nums = new int[] {4,3,6,2,1,8,5,9,10,0};
        HeapSort(nums);
        for(int t:nums) {
            System.out.print(t+" ");
        }
    }
}
