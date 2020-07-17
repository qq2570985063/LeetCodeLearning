package MyArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyArray {
    // 169 多数元素
    public int majorityElement(int[] nums){
        int count = 0;
        int cur = nums[0];

        for(int i=0; i<nums.length; i++){
            if(nums[i] == cur){
                count++;
            } else{
                count--;
            }
            if(count == 0){
                cur = nums[i+1];
            }
        }

        return cur;
    }

    // 283 移动零
    public void moveZeros(int[] nums){
        int p = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }
        while(p < nums.length){
            nums[p] = 0;
            p++;
        }
    }

    // 448 找到所有数组中消失的数字
    public List<Integer> findDisappearedNumbers(int[] nums){
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int num:nums){
            map.put(num, true);
        }

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<nums.length; i++){
            if(!map.containsKey(i)) list.add(i);
        }

        return list;
    }

    // 53 最大子序和
    public int maxSubArray(int[] nums){
        int len = nums.length;
        if(len == 0) return 0;


        int dp[] = new int[len+1];
        dp[0] = 0;
        // int dp = 0;
        int res = Integer.MIN_VALUE;

        for(int i=1; i<len+1; i++){
            dp[i] = Math.max(dp[i-1], 0) + nums[i-1];
            res = Math.max(res, dp[i]);
        }

//        for(int n:nums){
//            dp = Math.max(dp, 0) + n;
//            res = Math.max(res, dp);
//        }

        return res;
    }

    // 581 最短无序连续子数组
    // 从头和尾扫描，找到第一次逆序的序号，求序号间距离即为最短逆序数组
    public int findUnsortedSubarray(int[] nums){
        int len = nums.length;
        int l = 0, r = -1;
        int max = nums[0], min = nums[len-1];

        for(int i=0; i<len; i++){
            // i从前往后扫描
            if(nums[i] < max){
                r = i;
            }else{
                max = nums[i];
            }
            // len-i-1从后往前扫描
            if(nums[len-i-1] > min){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }

        return r - l + 1;
    }

    // 238 除自身以外数组的乘积
    // 求i左侧所有数的累积L  dp
    // 求i右侧所有数的累积R  dp
    // ans = L * R
    // 空间复杂度O(N)
//    public int[] productExceptSelf(int[] nums){
//        int len = nums.length;
//        int[] L = new int[len];
//        int[] R = new int[len];
//        int[] ans = new int[len];
//
//        L[0] = 1;
//        R[len-1] = 1;
//
//        for(int i=1; i<len; i++){
//            L[i] = L[i-1] * nums[i-1];
//        }
//        for(int i=len-2; i>=0; i--){
//            R[i] = R[i+1] * nums[i+1];
//        }
//        for(int i=0; i<len; i++){
//            ans[i] = L[i] * R[i];
//        }
//
//        return ans;
//    }
    // 优化空间复杂度 O(1)
    public int[] productExceptSelf(int[] nums){
        int len = nums.length;
        int[] ans = new int[len];

        // 左侧元素积
        ans[0] = 1;
        for(int i=1; i<len; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        // R--右侧元素积
        // ans = ans * R
        int R = 1;
        for(int i=len-1; i>=0; i--){
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }

        return ans;
    }

    // 48 旋转图像
    // 先转置后水平翻转
//    public void rotate(int[][] matrix){
//        int n = matrix.length;
//
//        for(int i=0; i<n; i++){
//            for(int j=i; j<n; j++){
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n/2; j++){
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[i][n-j-1];
//                matrix[i][n-j-1] = temp;
//            }
//        }
//    }
    // 旋转4个点，i，j关系由5x5矩阵可推
    public void rotate(int[][] matrix){
        int n = matrix.length;

        for(int i=0; i<(n+1)/2; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
