package com.ersan.tests.day10_file_uploading;

import org.testng.annotations.Test;

public class FilePathExample {
    @Test

    public void test1(){
        //C:\Users\Hp\IdeaProjects\EU3TestNGSelenium\src\test\resources\textfile
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile";
        // only one slash is missing. It can be concatenated on the top of src/test... or creating a variable
        String fullPath = projectPath + "/" + filePath;
        System.out.println(fullPath);

    }
}
