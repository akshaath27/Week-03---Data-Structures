import java.util.*;
public class DataStructureSearchComparsion {
    public static void main(String[]args){
        int N=1_000_000;
        Random random=new Random();
        int[]dataset=new int[N];
        for(int i=0;i<N;i++)
        {
            dataset[i]= random.nextInt();
        }
        int target=dataset[random.nextInt(N)];
        long start=System.nanoTime();
        boolean arrayResult=arraySearch(dataset,target);
        long arrayTime=System.nanoTime()-start;

        HashSet<Integer>hashSet=new HashSet<>();
        for(int num:dataset)hashSet.contains(target);
        start = System.nanoTime();
        boolean hashSetResult = hashSet.contains(target);
        long hashSetTime=System.nanoTime()-start;

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : dataset) treeSet.add(num);
        start = System.nanoTime();
        boolean treeSetResult = treeSet.contains(target);
        long treeSetTime = System.nanoTime() - start;

        System.out.println("Dataset Size: " + N);
        System.out.println("Target: " + target);
        System.out.println("Array Search Time: " + (arrayTime / 1_000_000.0) + " ms, Found: " + arrayResult);
        System.out.println("HashSet Search Time: " + (hashSetTime / 1_000_000.0) + " ms, Found: " + hashSetResult);
        System.out.println("TreeSet Search Time: " + (treeSetTime / 1_000_000.0) + " ms, Found: " + treeSetResult);
    }

    // Method for Array Search (O(N))
    public static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}




