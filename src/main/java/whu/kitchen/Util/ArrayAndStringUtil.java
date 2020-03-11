//Author:刘行
package whu.kitchen.Util;

public class ArrayAndStringUtil {
    //分隔符
    public static String separator = "#";

    public static String ArrayToString(String[] arr){
        StringBuilder str = new StringBuilder();
        for(String item : arr){
            str.append(item).append(separator);
        }
        return str.toString();
    }

    public static String[] StringToArray(String str){
        return str.split(separator);
    }
}
