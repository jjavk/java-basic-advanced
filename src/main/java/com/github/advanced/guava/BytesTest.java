package com.github.advanced.guava;

import com.google.common.primitives.Bytes;

import java.util.*;

public class BytesTest {
    public static void main(String args[]){
        BytesTest tester = new BytesTest();
        tester.testBytes();
        System.out.println(new ArrayList<String>(Arrays.asList("123", "qwe")).toString());
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("2", "2");
        System.out.println(map.toString());

        byte[] b1 = {1,2,3};
        byte[] b2 = {4,5,6};
        System.out.println(Bytes.asList(Bytes.concat(b1, b2)).toString());

        byte[] b3 = Bytes.ensureCapacity(b2, 3, 3);
        System.out.println(Bytes.asList(b3).toString());
    }

    private void testBytes(){
        byte[] byteArray = {0x1f,0x2,0x3,0x4,5,5,7,9,9};

        //convert array of primitives to array of objects
        List<Byte> objectArray = Bytes.asList(byteArray);
        System.out.println(objectArray.toString());

        //convert array of objects to array of primitives
        byteArray = Bytes.toArray(objectArray);
        System.out.print("[ ");
        for(int i = 0; i< byteArray.length ; i++){
            System.out.print(byteArray[i] + " ");
        }
        System.out.println("]");
        byte data = 5;
        //check if element is present in the list of primitives or not
        System.out.println("5 is in list? "+ Bytes.contains(byteArray, data));

        //Returns the index
        System.out.println("Index of 5: " + Bytes.indexOf(byteArray,data));

        //Returns the last index maximum
        System.out.println("Last index of 5: " + Bytes.lastIndexOf(byteArray,data));
    }

}
