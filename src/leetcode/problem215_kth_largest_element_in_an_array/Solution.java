package leetcode.problem215_kth_largest_element_in_an_array;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution {
    class MyHeep{
        int currentSize=0;
        int [] arr;
        public MyHeep(int x){
            arr=new int [x+1];
        }
        public void insert(int a){
            currentSize++;
            arr[currentSize]=a;
            int x=currentSize;
            while(x>1&&arr[x/2]<arr[x]){
                swap(arr,x/2,x);
                x=x/2;
            }

        }
        public int remove(){
            if(currentSize==0){
                return 0;
            }
            int result=arr[1];
            arr[1]=arr[currentSize];
            currentSize--;

            int now=1;
            while (now*2+1<=currentSize&&(arr[now]<arr[now*2]||arr[now]<arr[now*2+1])){
                if(arr[now*2]<arr[now*2+1]){
                    swap(arr,now,now*2+1);
                    now=now*2+1;
                }
                else {
                    swap(arr,now,now*2);
                    now*=2;
                }
            }
            if(now*2<=currentSize){
                if(arr[now]<arr[now*2]){
                    swap(arr,now,now*2);
                }
            }
            return result;
        }
        public void swap(int [] arr,int x,int y){
            int temp=arr[x];
            arr[x]=arr[y];
            arr[y]=temp;
        }

    }
    public int findKthLargest(int[] nums, int k) {
        MyHeep my=new MyHeep(nums.length);
        for(int x=0;x<nums.length;x++){
            my.insert(nums[x]);
        }
        int result=0;
        for(int x=0;x<k;x++){
            result=my.remove();
        }
        return result;
    }

    public static void main(String[] args) {


        int [] a={3,2,1,5,6,4};
        Solution solution=new Solution();
        System.out.println(solution.findKthLargest(a,2));
    }

}