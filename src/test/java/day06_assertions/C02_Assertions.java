package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertions {

    // we have to use assertions ( class ) to test something. otherwise Junit won't be able to report it.

    // we are not going to use if-else statements to test something, not anymore

    // Retirement age is 65, test if the people can retire


    int P1Age = 60;
    int P2Age = 66;
    int P3Age = 70;

    @Test
    public void test01(){
        // test that if P2 can retire "65"

        Assert.assertTrue(P2Age>65); // age 66 can retire so we expect something true

    }

    @Test
    public void test02(){
        // can p1 retire?
        // test that p1 can not retire

        Assert.assertFalse(P1Age>65); // passed


    }

    @Test
    public void test03(){
        // test that p3 can not retire

        Assert.assertTrue(P3Age>65);


    }


}

