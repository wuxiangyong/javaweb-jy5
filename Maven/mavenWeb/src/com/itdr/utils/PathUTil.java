package com.itdr.utils;

/**
 * @author Excellent吴
 * @date 2019-07-31 15:07
 */
public class PathUTil {
   public static  String  getPath(String path){
       String s1=path.replace(".","/");
       String [] sar=s1.split("/");
       return  sar[1];
   }
}
