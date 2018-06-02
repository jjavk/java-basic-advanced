package com.github.advanced.guava;

import com.google.common.base.Joiner;

import java.io.IOException;
import java.util.*;

public class JoinerTest {
    public static void main(String args[]) throws IOException{
        JoinerTest tester = new JoinerTest();
        tester.testJoiner();
        Joiner joiner = Joiner.on(",").skipNulls();
        String result = joiner.join("Harry", null, "Ron", "Hermione");
        StringBuffer stringBuffer = new StringBuffer("result：");
        List<String> list = Arrays.asList("1", "2");
        joiner.appendTo(stringBuffer, result, "Tom");
        joiner.appendTo(stringBuffer, list);
        System.out.println(stringBuffer.toString());
    }

    private void testJoiner(){
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1,2,3,4,5,null,6)));
    }
}
