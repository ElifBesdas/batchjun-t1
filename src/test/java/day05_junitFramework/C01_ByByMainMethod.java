package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ByByMainMethod {

     /*
    When we use @Test annotation before a method,
    it can be executed without a mainmethod
    it comes from JUnit


     */


    @Test
    public void test01(){
        System.out.println("Test01 is executed");

    }

    @Test @Ignore
    public void test02(){
        System.out.println("Test02 is executed");
        // When we use @Ignore, the task will be ignored

    }

    @Test
    public void test03(){
        System.out.println("Test03 is executed");

    }


}
