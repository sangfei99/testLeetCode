package simple;

import java.util.Stack;

/*
20.有效的括号（栈）
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
示例 1：
输入：s = "()"
输出：true
示例 2：
输入：s = "()[]{}"
输出：true
示例 3：
输入：s = "(]"
输出：false
 */
public class IsValid {
    public static boolean isValid(String s) {
        // 定义括号匹配的映射
        Stack<Character> stack =new Stack<>();

        // 遍历字符串中的每一个字符
        for (char c:s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                // 如果是左括号，压入栈中
                stack.push(c);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                char top =stack.pop();
                // 检查栈顶元素是否匹配当前的右括号
                if ((c==')'&&top!='(')||(c==']'&&top!='[')||(c=='}'&&top!='{')){
                    return false;
                }
            }
        }
        // 如果栈为空，说明所有括号匹配
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        boolean ret = isValid("()[]{}");
        System.out.println(ret);
    }
}
