public class PeakElementFinder {

    public static int find(int[] arr){
        int n=arr.length;
        int left=0;
        int right=n-1;


        while(left<=right){
            int mid=left+(right-left)/2;
            boolean isLeftSmaller = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean isRightSmaller = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (isLeftSmaller && isRightSmaller) {
                return arr[mid];
            }else if(mid > 0&&arr[mid]<arr[mid-1]){
                right=mid-1;
            }else if(arr[mid]<arr[mid+1]){
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={3,15,5,4,2,1};
        System.out.println("peek element: "+find(arr));
    }
}
