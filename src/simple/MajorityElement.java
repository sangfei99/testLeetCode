package simple;

/*
169. ����Ԫ��
����һ����СΪ n ������ nums ���������еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ���� ?n/2? ��Ԫ�ء�
����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�

ʾ�� 1��
���룺nums = [3,2,3]
�����3

ʾ�� 2��
���룺nums = [2,2,1,1,1,2,2]
�����2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count =0;
        for (int num:nums){
            if (count == 0) {
                candidate = num;
            }
            count += (num==candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums3 = {1};

        System.out.println(solution.majorityElement(nums1));  // �����3
        System.out.println(solution.majorityElement(nums2));  // �����2
        System.out.println(solution.majorityElement(nums3));  // �����1
    }
}
