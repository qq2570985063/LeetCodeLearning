package Series.NumsSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NumsSum {
    // 1 两数之和
    public int[] twoSum(int[] nums, int target){
        // <nums[i], i>
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    // 167 两数之和II 有序数组
    // 双指针
    public int[] twoSum2(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                return new int[]{i + 1, j + 1};
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }

    // 15 三数之和
    // 划分成nums[i]、nums[L]、nums[R]，对L和R使用双指针
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new LinkedList<>();
        int len = nums.length;
        if(len < 3) return ans;
        Arrays.sort(nums);

        for(int i=0; i<len-2; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int L = i+1, R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L<R && nums[L] == nums[L+1]) L++;
                    while(L<R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }else if(sum < 0){
                    L++;
                }else{
                    R--;
                }
            }
        }

        return ans;
    }

    // 18 四数之和
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new LinkedList<>();
        int len = nums.length;
        if(len < 4) return ans;
        Arrays.sort(nums);

        for(int a=0; a<=len-4; a++){
            if(a>0 && nums[a] == nums[a-1]) continue;
            // min1>target 说明这4数之和已经大于target，后面只会更大，可以break
            int min1 = nums[a] + nums[a+1] + nums[a+2] + nums[a+3];
            if(min1 > target) break;
            // 当前和太小，跳过
            int max1 = nums[a] + nums[len-3] + nums[len-2] + nums[len-1];
            if(max1 < target) continue;

            for(int b=a+1; b<=len-3; b++){
                if(b>a+1 && nums[b] == nums[b-1]) continue;
                int c = b+1, d = len-1;
                // 当前和太大，跳过while
                int min2 = nums[a] + nums[b] + nums[c] + nums[c+1];
                if(min2 > target) continue;
                // 当前和太小，跳过while
                int max2 = nums[a] + nums[b] + nums[d] + nums[d-1];
                if(max2 < target) continue;

                while(c<d){
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while(c<d && nums[c] == nums[c+1]) c++;
                        while(c<d && nums[d] == nums[d-1]) d--;
                        c++;
                        d--;
                    }else if(sum < target){
                        c++;
                    }else{
                        d--;
                    }
                }
            }
        }

        return ans;
    }
}
