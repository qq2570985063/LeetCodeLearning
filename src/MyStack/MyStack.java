package MyStack;

import java.util.Stack;

public class MyStack {
    // 20 有效括号
    public boolean isValid(String s){
        if(s == null) return true;
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }

            if(s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
            else if(s.charAt(i) == '}' && stack.peek() == '{') stack.pop();
            else if(s.charAt(i) == ']' && stack.peek() == '[') stack.pop();
            else stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }

    // 739 每日温度
    public int[] dailyTemperatures(int[] T){
        Stack<Integer> idxS = new Stack<>();
        Stack<Integer> tempS = new Stack<>();
        int[] res = new int[T.length];

        for(int i=0; i<T.length; i++){
            if(tempS.isEmpty()){
                idxS.push(i);
                tempS.push(T[i]);
            } else{
                while(T[i] > tempS.peek()){
                    int idx = idxS.pop();
                    tempS.pop();
                    res[idx] = i - idx;
                    if(tempS.isEmpty()) break;
                }
            }
            idxS.push(i);
            tempS.push(T[i]);
        }
        return res;
    }

    // 394 字符串解码
    public String decodeString(String s){
        int len = s.length();

        StringBuilder res = new StringBuilder();
        int multi = 1;

        Stack<Integer> multiS = new Stack<>();
        Stack<String> resS = new Stack<>();

        for(int i=0; i<len;){
            if(s.charAt(i) == '['){
                multiS.push(multi);
                resS.push(res.toString());

                multi = 1;
                res = new StringBuilder();

                i++;
            }else if(s.charAt(i) == ']'){
                int cur_multi = multiS.pop();
                StringBuilder tmp = new StringBuilder();

                for(int k=0; k<cur_multi; k++) tmp.append(res);
                res = new StringBuilder(resS.pop() + tmp);

                i++;

            }else if(Character.isDigit(s.charAt(i))){
                int iStart = i++;
                while(i<len && Character.isDigit(s.charAt(i))) i++;
                multi = Integer.parseInt(s.substring(iStart, i));
            }else{
                int iStart = i++;
                while(i<len && Character.isLowerCase(s.charAt(i))) i++;
                res.append(s.substring(iStart, i));
            }
        }

        return res.toString();
    }

    // 42 接雨水
    public int trap(int[] height){
        Stack<Integer> idxS = new Stack<>();

        int res = 0;
        int len = height.length;

        for(int i=0; i<len;){
            while(!idxS.isEmpty() && height[i] > height[idxS.peek()]){
                int h = height[idxS.pop()];
                if(idxS.isEmpty()) break;

                int distance = i - idxS.peek() - 1;
                int min = Math.min(height[i], height[idxS.peek()]);

                res += distance * (min - h);
            }

            idxS.push(i);
            i++;
        }

        return res;
    }

    // 84 柱状图中的最大矩形
    public int largestRectangleArea(int[] heights){
        Stack<Integer> idxS = new Stack<>();

        int maxArea = 0;
        int[] newHeights = new int[heights.length + 2];
        for(int i=0; i<heights.length; i++) newHeights[i+1] = heights[i];

        for(int i=0; i<newHeights.length; i++){
            while(!idxS.isEmpty() && newHeights[i] < newHeights[idxS.peek()]){
                int cur = idxS.pop();
                int area = newHeights[cur] * (i - idxS.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
            idxS.push(i);
        }

        return maxArea;
    }

    // 85 最大矩形
    public int maximalRectangle(char[][] matrix){
        if(matrix.length == 0) return 0;
        int max = 0;
        int[] heights = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                heights[j] = matrix[i][j] == '1' ? heights[j]+1 : 0;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }
}
