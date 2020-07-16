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
}
