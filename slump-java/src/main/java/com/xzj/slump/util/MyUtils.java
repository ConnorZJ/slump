package com.xzj.slump.util;

import java.util.UUID;

public class MyUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
