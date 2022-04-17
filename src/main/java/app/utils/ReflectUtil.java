package app.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtil {

    public static String getGetterName(String fieldName) throws Exception {
        return "get" + StringFormatUtil.toUpperFirst(fieldName);
    }

    public static String getGetterName(Field field) throws Exception {
        return "get" + StringFormatUtil.toUpperFirst(field.getName());
    }

    public static Method getGetter(String fieldName, Class<?> requestClass) throws NoSuchMethodException, SecurityException, NoSuchFieldException, Exception {
        return requestClass.getDeclaredMethod(getGetterName(fieldName));
    }

    public static Method getGetter(Field field, Class<?> requestClass) throws NoSuchMethodException, SecurityException, NoSuchFieldException, Exception {
        return requestClass.getDeclaredMethod(getGetterName(field));
    }

    public static String getSetterName(String fieldName) throws Exception {
        return "set" + StringFormatUtil.toUpperFirst(fieldName);
    }

    public static String getSetterName(Field field) throws Exception {
        return "set" + StringFormatUtil.toUpperFirst(field.getName());
    }

    public static Method getSetter(String fieldName, Class<?> requestClass) throws NoSuchMethodException, SecurityException, NoSuchFieldException, Exception {
        return requestClass.getDeclaredMethod(getSetterName(fieldName), requestClass.getDeclaredField(fieldName).getType());
    }

    public static Method getSetter(Field field, Class<?> requestClass) throws NoSuchMethodException, SecurityException, NoSuchFieldException, Exception {
        return requestClass.getDeclaredMethod(getSetterName(field), field.getType());
    }

}
