package ByteDance;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class ByteDance {
    // 440 字典序的第K小数字
    public int findKthNumber(int n, int k){
        int cur = 1;
        k--;
        while(k > 0){
            int steps = getSteps(n, cur, cur+1);
            // k在cur子树内，下移cur，相当于查了一次，因此k--
            if(steps > k){
                cur *= 10;
                k--;
            }
            // k不在cur子树内， 右移cur，相当于查了steps次，k-=steps
            else{
                cur++;
                k -= steps;
            }
        }
        return cur;
    }
    private int getSteps(int n, long cur, long next){
        int steps = 0;
        while(cur <= n){
            steps += Math.min(n+1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return steps;
    }

    // 726 原子数量
    public String countOfAtoms(String formula) {
        int N = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());

        for(int i=0; i<N;){
            if(formula.charAt(i) == '('){
                stack.push(new TreeMap<>());
                i++;
            }else if(formula.charAt(i) == ')'){
                Map<String, Integer> top = stack.pop();
                int iStart = ++i;
                int multi = 1;
                while(i<N && Character.isDigit(formula.charAt(i))) i++;
                if(i > iStart) multi = Integer.parseInt(formula.substring(iStart, i));
                for(String s: top.keySet()){
                    int v = top.get(s);
                    stack.peek().put(s, stack.peek().getOrDefault(s, 0) + v * multi);
                }
            }else{
                int iStart = i++;
                while(i<N && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart, i);
                iStart = i;
                while(i<N && Character.isDigit(formula.charAt(i))) i++;
                int multi = i>iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multi);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(String s: stack.peek().keySet()){
            ans.append(s);
            int multi = stack.peek().get(s);
            if(multi > 1) ans.append("" + multi);
        }
        return new String(ans);
    }

    // 135 分发糖果
//    public int candy(int[] ratings){
//
//    }
}
