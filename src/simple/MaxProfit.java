package simple;

/*
����һ������ prices �����ĵ� i ��Ԫ�� prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ�����һ���㷨�����������ܻ�ȡ���������
��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��

ʾ�� 1��
���룺[7,1,5,3,6,4]
�����5
���ͣ��ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
     ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�ͬʱ���㲻��������ǰ������Ʊ��
ʾ�� 2��
���룺prices = [7,6,4,3,1]
�����0
���ͣ������������, û�н������, �����������Ϊ 0��
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length==0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            if (price < minPrice) {
                minPrice = price;
            }else if (price - minPrice > maxProfit){
                maxProfit = price -minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit solution = new MaxProfit();

        // ʾ�� 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices1)); // ���: 5

        // ʾ�� 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices2)); // ���: 0
    }
}
