package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Excellent吴
 * @date 2019-07-31 12:55
 */
public class PoolUTil {
    public static  final ComboPooledDataSource co=new ComboPooledDataSource();
    public static  ComboPooledDataSource getCom(){
        return  co;
    }
}
