package com.zzd.tttt;

import org.junit.Test;

public abstract class ManyTest {
    @Test
    public void testi(){
        int i = -5;
        //i =  ++(i++);//++后面应该直接跟一个变量  Variable expected
        System.out.println(i);
    }
}
