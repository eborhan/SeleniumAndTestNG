package com.ersan.tests.day12_properties_driver_tests;

public class Singleton {

    //singleton class will have a private constructor, which means other classes cannot create an object of this class

    private Singleton(){}

    private static String str;

    public static String getInstance(){
        //if str has no value, initialize and return it
        if(str==null){
            System.out.println("str is null. Assign a value to it");
            str = "somevalue";
        }else{
            //if it has a value, just return it
        }
        return str;
    }
}
