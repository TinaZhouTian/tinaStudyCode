package com.example.springbootdemo.service.serviceimpl;

import com.example.springbootdemo.dto.ListNode;
import com.example.springbootdemo.service.LiKouTestService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LiKouTestServiceImpl implements LiKouTestService {

    //算法相关

    @Override
    //给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }

    @Override
    //给定一个由整数组成的 非空数组所表示的非负整数，在该数的基础上加一。
    //最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
    //你可以假设除了整数0之外，这个整数不会以零开头。
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //跳出循环的情况是当前数组元素的值不是9，也就是不再需要进位的情况
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            //如果到这说明当前元素的值9，所以直接将当前的值设为0，因为9+1=10，末尾0，需要继续参与循环
            digits[i] = 0;
        }
        //到这说明整个数组都是9，其实主要是第一位是9，也就是数组需要扩张，这里有个比较巧妙的小地方吧，不用指定其他位置的值，因为初始化后的数组，所有的值都是0，只需要在第一位设置为1，也就是原来如果是9999，新数组就是10000,，其他位默认为0
        //1:定义一个新数据，容量比digits大1
//        int temp[] = new int[digits.length + 1];
//        temp[0] = 1;
//        return temp;
        //2：通过调用系统自带的java.util.Arrays类中的方法对数组进行动态扩容。Arrays类中实现数组扩容的方法为copyof（）;
        //Arrays的copyOf()方法传回的数组是新的数组对象，改变传回数组中的元素值，不会影响原来的数组。
        //和创建一个新的数组原理是一样的
        digits = Arrays.copyOf(digits, digits.length + 1);
        digits[0] = 1;
        return digits;
    }

    @Override
    //给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
    //String不可变字符串
    //StringBuffer 可变字符串，效率低，线程安全
    //StringBuilder 可变字符序列，效率高，线程不安全
    //二进制算数：A：1100+ b:1010 = 10110
//    public String addBinary(String a, String b) {
//        StringBuffer sb = new StringBuffer();
//        //获取数组最大下标
//        int i = a.length() - 1;
//        int j = b.length() - 1;
//        int carry = 0;
//        //说明a,bString不为null
//        while (i >= 0 || j >= 0) {
//            int sum = carry;
//            if (i >= 0) {
//                //charAt () 方法用于返回指定索引处的字符。 索引范围为从 0 到 length () - 1;
//                //char字符运算与数形运算不同，char运算用到的是ASCII码,字符0-9的ASCII码：48-57;
//                // 所以清楚了这点之后，我们便知道图中 - ‘0’，减去的是0的ASCII码（48）
//                // 前面s.charAt（j）依次是s.charAt（1）、s.charAt（2）、s.charAt（3）……,
//                // 就是字符串中的第一个字符，第二个字符……，字符串和数组相似，第一个字符对应的索引是0、第二个字符对应的索引是1……,
//                // 而s.charAt（1）是1，对应的ASCII码为49，以此只有减去48，才能得到第一个数：1;
//                sum += a.charAt(i--) - '0';
//            }
//            if (j >= 0) {
//                sum += b.charAt(j--) - '0';
//            }
//            sb.insert(0, sum % 2);
//            carry = sum / 2;
//        }
//        if (carry != 0) {
    //         * StringBuffer的insert()方法
    //         * 语法格式:
    //         * 字符串.insert(位置,参数);
//            sb.insert(0, carry);
//        }
//        return sb.toString();
//    }

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            //charAt () 方法用于返回指定索引处的字符。 索引范围为从 0 到 length () - 1;
            // char字符运算与数形运算不同，char运算用到的是ASCII码,字符0-9的ASCII码：48-57;
            // 所以清楚了这点之后，我们便知道图中 - ‘0’，减去的是0的ASCII码（48）
            // 前面s.charAt（j）依次是s.charAt（1）、s.charAt（2）、s.charAt（3）……,
            // 就是字符串中的第一个字符，第二个字符……，字符串和数组相似，第一个字符对应的索引是0、第二个字符对应的索引是1……，
            // 而s.charAt（1）是1，对应的ASCII码为49，以此只有减去48，才能得到第一个数：1;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
//            StringBuffer.append()追加的字符串在同一个内存地址 例如：aa,bb,cc-> aabbcc
//            java中的算数运算符
//            sum % 2对2取余，获取当前位数的值
//            ans.append(sum % 2);
            ans.insert(0, sum % 2);
            // sum / 2对2取值，获取前进一位的值
            ca = sum / 2;
        }
//        ans.append(ca == 1 ? ca : "");
        ans.insert(0, ca == 1 ? ca : "");
        //字符串实现反转
//        return ans.reverse().toString();
        return ans.toString();
    }

    //给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
    //由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的
    //只需要对链表进行一次遍历，就可以删除重复的元素

    @Override
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        //指针 cur指向链表的头节点，随后开始对链表进行遍历
        ListNode cur = head;
        while (cur.next != null) {
            //如果当前cur与cur.next对应的元素相同，那么我们就将cur.next从链表中移除
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                //否则说明链表中已经不存在其它与cur对应的元素相同的节点，-----.next
                cur = cur.next;
            }
        }
        //当遍历完整个链表后，我们返回链表的头结点即可
        return head;
    }

    //给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    //请你 合并 nums2 到 nums1 中，使合并后的数组同样按非递减顺序 排列。
    //注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
    //为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n。
    //最直观的方法是先将数组 nums2放进数据nums1的尾部，然后对整个数组进行排序
    @Override
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = 0; i != n; ++i) {
//            nums1[m + i] = nums2[i];
//        }
//        Arrays.sort(nums1);
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //第一个数组的长度
        int len1 = m-1;
        //第二个数组的长度
        int len2 = n-1;
        //合并后数组的长度
        int len = m+n-1;
        while(len1 >= 0 && len2>=0){
            //合并后的数组
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

}
