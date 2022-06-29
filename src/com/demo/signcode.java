package com.demo;


import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class signcode {

    //这里输入账号密码
    public static void main(String[] args) {
        getSignCode("18541214008" , "jpy890626");
    }

    private static String getSignCode(String account, String pwd) {
        String sortString="";
        System.out.println(account+"  "+pwd);
        HashMap<String, String> paramHashMap = new HashMap<String, String>() {
            {


                put("version", "3.0.0");
                put("client", "android");
                put("deviceId", "7528c0ca-9c03-3696-9a75-01d7bd7797fb");
                put("timestamp", "1655721479978");
                put("encrypt", "1");
                put("appkey", "gl_rn_bdc5bd4f38b6");
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


    // 加盐
    public static String getSaltCode(String str) {
        String salt="57F6A245D65F3B86CC58103E84C04C8F";
        String saltString=salt+str+salt;
        System.out.println("getSaltCode==================" + saltString);
        String upString = getUpString(saltString);
        return upString;
    }

    // 转化为大小写
    private static String getUpString(String str)  {
        String strUpString=str.toUpperCase();
        System.out.println("getUpString==================" + strUpString);

        String md5CodeString=  getMD5Str(strUpString);
        System.out.println("signcode==================" + md5CodeString);
        return md5CodeString;
    }



    private static Map<String, String> sortMap(Map<String, String> param) {
        TreeMap<String, String> paramTreeMap = new TreeMap<>(param);
        System.out.println(paramTreeMap);
        return paramTreeMap;
    }


    public static String getMD5Str(String val)  {
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(val.getBytes());
            byte[] m = md5.digest();// 加密
            return getString(m);
        }catch (Exception e){

        }
        return "";
    }

    /**
     *
     * @param bytearray 加密后的byte数组
     * @return byte数组转换成一个16进制字符串
     *
     * toHexString方法是把int类型转换为16进制的字符串
     */
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