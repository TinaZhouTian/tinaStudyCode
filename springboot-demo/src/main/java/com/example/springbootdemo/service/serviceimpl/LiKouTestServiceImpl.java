package com.example.springbootdemo.service.serviceimpl;

import com.example.springbootdemo.service.LiKouTestService;
import org.springframework.stereotype.Service;

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

}
