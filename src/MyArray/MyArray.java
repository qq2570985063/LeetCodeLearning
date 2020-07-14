package MyArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyArray {
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
}
