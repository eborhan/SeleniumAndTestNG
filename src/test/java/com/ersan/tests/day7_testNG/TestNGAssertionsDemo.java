package com.ersan.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open a Browser");
    }


    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals("title","tiTle");

        //Assert method will stop execution when encountering an error.

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }
    @Test
    public void test2(){

        Assert.assertEquals("test2","test2");

    }

    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle));
    }

    @Test
    public void test4(){
        //verify the email contains @

        String email = "mike@cybertek.com";

        Assert.assertTrue(email.contains("@"), "verify the email contains '@' sign");
    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1, "verify 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","two","verify one does not equal to two");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close the Browser");
    }
}
