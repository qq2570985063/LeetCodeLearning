package MyArray;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray test = new MyArray();

//        int[] arr = {2,2,1,0,1,1,0,2,0,2,5,8,9};
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

//        System.out.println(test.majorityElement(arr));
//        test.moveZeros(arr);
//        for (int num: arr) {
//            System.out.println(num);
//        }
//        System.out.println(test.findDisappearedNumbers(arr));
        System.out.println(test.maxSubArray(arr));
    }
}
