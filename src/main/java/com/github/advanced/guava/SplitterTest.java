package com.github.advanced.guava;

import com.google.common.base.Splitter;

public class SplitterTest {
    public static void main(String args[]){
        SplitterTest tester = new SplitterTest();
        tester.testSplitter();
    }

    private void testSplitter(){
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog."));
    }
}
