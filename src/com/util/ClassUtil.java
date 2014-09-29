package com.util;

/**
 * @author ksipe
 */
public class ClassUtil {

    public static String getFileName(Class clazz) {
        return clazz.getCanonicalName().replace(".", "/");
    }
}
