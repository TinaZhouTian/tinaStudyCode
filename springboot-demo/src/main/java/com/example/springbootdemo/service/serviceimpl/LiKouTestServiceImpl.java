package com.example.springbootdemo.service.serviceimpl;

import com.example.springbootdemo.service.LiKouTestService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LiKouTestServiceImpl implements LiKouTestService {

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

}
