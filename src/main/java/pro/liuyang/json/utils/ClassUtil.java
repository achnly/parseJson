package pro.liuyang.json.utils;

import pro.liuyang.json.constants.CommonConstant;

/**
 * Class工具类
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
public class ClassUtil {

    private ClassUtil() {}

    /**
     * 是否为JDK中定义的类或接口，判断依据：
     * 1、以java.、javax.开头的包名
     * 2、ClassLoader为null
     */
    public static boolean isJdkClass(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        final Package objectPackage = clazz.getPackage();
        if (null == objectPackage) {
            return false;
        }
        final String objectPackageName = objectPackage.getName();
        return objectPackageName.startsWith(CommonConstant.JAVA)
                || objectPackageName.startsWith(CommonConstant.JAVAX)
                || clazz.getClassLoader() == null;
    }

    /**
     * 是否非JDK中定义的类或接口，判断依据：
     */
    public static boolean isNotJdkClass(Class<?> clazz) {
        return !isJdkClass(clazz);
    }

    /**
     * 是否为JDK中定义的类或接口，判断依据：
     * 1、以java.、javax.开头的包名
     * 2、ClassLoader为null
     */
    public static boolean isJdkClass(Object obj) {
        if (null == obj) {
            return false;
        }
        return isJdkClass(obj.getClass());
    }

    /**
     * 是否为JDK中定义的类或接口，判断依据：
     * 1、以java.、javax.开头的包名
     * 2、ClassLoader为null
     */
    public static boolean isNotJdkClass(Object obj) {
        return !isJdkClass(obj);
    }

}
