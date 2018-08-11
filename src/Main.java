import leetcode.EasyCollection;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int result;
        EasyCollection ezC = new EasyCollection();
        result = ezC.singleNumber(nums);
        System.out.println(result);
//        EasyCollection.printArr(nums);
    }
}
