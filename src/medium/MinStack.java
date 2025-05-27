package medium;
/*
155.��Сջ
���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
ʵ�� MinStack ��:
MinStack() ��ʼ����ջ����
void push(int val) ��Ԫ��val�����ջ��
void pop() ɾ����ջ������Ԫ�ء�
int top() ��ȡ��ջ������Ԫ�ء�
int getMin() ��ȡ��ջ�е���СԪ�ء�

ʾ�� 1:
���룺
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
�����
[null,null,null,null,-3,null,0,-2]
����:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> ���� -3.
minStack.pop();
minStack.top();      --> ���� 0.
minStack.getMin();   --> ���� -2.
 */


import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val){
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
        else {
            minStack.push(minStack.peek());
        }
    }
    public void pop(){
        stack.pop();
        minStack.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin()); // ���� -3
        minStack.pop();
        System.out.println(minStack.top());    // ���� 0
        System.out.println(minStack.getMin()); // ���� -2
    }
}
