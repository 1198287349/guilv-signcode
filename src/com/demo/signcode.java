package com.demo;


import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class signcode {

    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码
    //省略关键核心代码

    private static String getSignCode(String account, String pwd) {
        String sortString="";
        System.out.println(account+"  "+pwd);
        HashMap<String, String> paramHashMap = new HashMap<String, String>() {
            {


                put("version", "3.1.0");
                put("", "");
                put("", "");
                put("", "");
                put("", "");
                put("uinfo", account);
                put("password", pwd);
            }
        };
        SortedMap<String,String> sortMap= (SortedMap<String, String>) sortMap(paramHashMap);
        for(String key : sortMap.keySet()){
            String value = sortMap.get(key);
            System.out.println(key+"  "+value);
            sortString = sortString + key+value;
        }
        return getSaltCode(sortString);
    }


    
    public static String getSaltCode(String str) {
        String salt="联系QQ1198287349";
        String saltString=salt+str+salt;
        System.out.println("getSaltCode==================" + saltString);
        String upString = getUpString(saltString);
        return upString;
    }

  
        String md5CodeString=  getMD5Str(strUpString);
        System.out.println("signcode==================" + md5CodeString);
        return md5CodeString;
    }

    
//省略关键核心代码
//省略关键核心代码   
//省略关键核心代码    
//省略关键核心代码
//省略关键核心代码    
//省略关键核心代码        
//省略关键核心代码
//省略关键核心代码


   
    private static String getString(byte[] bytearray) {
        StringBuffer sb = new StringBuffer();
        for (byte b : bytearray) {
            int i = (b & 0xFF);
            if (i < 0x10) sb.append('0');
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }


}
