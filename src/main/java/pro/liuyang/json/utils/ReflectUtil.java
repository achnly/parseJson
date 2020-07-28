package pro.liuyang.json.utils;

import pro.liuyang.json.cache.WeakReferenceCache;
import pro.liuyang.json.constants.CommonConstant;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 反射工具类
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
public class ReflectUtil {

    /**
     * 字段缓存
     */
    private static final WeakReferenceCache<Class<?>, Field[]> FIELDS_CACHE = new WeakReferenceCache<>();

    /**
     * 查找指定类中是否包含指定名称对应的字段，包括所有字段（包括非public字段），也包括父类和Object类的字段
     *
     * @param beanClass 被查找字段的类,不能为null
     * @param name      字段名
     * @return 是否包含字段
     * @throws SecurityException 安全异常
     */
    public static boolean hasField(Class<?> beanClass, String name) throws SecurityException {
        return null != getField(beanClass, name);
    }

    /**
     * 获取字段名
     * @param field 字段
     * @return 字段名
     */
    public static String getFieldName(Field field) {
        if (null == field) {
            return null;
        }
        return field.getName();
    }

    /**
     * 查找指定类中的所有字段（包括非public字段），也包括父类和Object类的字段， 字段不存在则返回<code>null</code>
     *
     * @param beanClass 被查找字段的类,不能为null
     * @param name      字段名
     * @return 字段
     * @throws SecurityException 安全异常
     */
    public static Field getField(Class<?> beanClass, String name) throws SecurityException {
        final Field[] fields = getFields(beanClass);
        for (Field field : fields) {
            if ((name.equals(getFieldName(field)))) {
                return field;
            }
        }
        return null;
    }

    /**
     * 获取指定类中字段名和字段对应的Map，包括其父类中的字段
     *
     * @param beanClass 类
     * @return 字段名和字段对应的Map
     */
    public static Map<String, Field> getFieldMap(Class<?> beanClass) {
        final Field[] fields = getFields(beanClass);
        final HashMap<String, Field> map = new HashMap<>();
        for (Field field : fields) {
            map.put(field.getName(), field);
        }
        return map;
    }

    /**
     * 获得一个类中所有字段列表，包括其父类中的字段
     *
     * @param beanClass 类
     * @return 字段列表
     * @throws SecurityException 安全检查异常
     */
    public static Field[] getFields(Class<?> beanClass) throws SecurityException {
        Field[] allFields = FIELDS_CACHE.get(beanClass);
        if (null != allFields) {
            return allFields;
        }
        allFields = getFieldsDirectly(beanClass);
        return FIELDS_CACHE.put(beanClass, allFields);
    }

    /**
     * 获得一个类中所有字段列表，直接反射获取，无缓存
     * @param beanClass           类
     * @return 属性数组
     */
    public static Field[] getFieldsDirectly(Class<?> beanClass) throws SecurityException {
        if (Objects.isNull(beanClass)) {
            return null;
        }
        return beanClass.getDeclaredFields();
    }

    /**
     * 获取字段值
     *
     * @param obj       对象，如果static字段，此处为类
     * @param fieldName 字段名
     * @return 字段值
     * @throws IllegalAccessException 非法访问异常
     */
    public static Object getFieldValue(Object obj, String fieldName) throws IllegalAccessException {
        if (null == obj || null == fieldName || CommonConstant.EMPTY.equals(fieldName)) {
            return null;
        }
        return getFieldValue(obj, getField(obj instanceof Class ? (Class<?>) obj : obj.getClass(), fieldName));
    }

    /**
     * 获取静态字段值
     *
     * @param field 字段
     * @return 字段值
     * @throws IllegalAccessException 非法访问异常
     */
    public static Object getStaticFieldValue(Field field) throws IllegalAccessException {
        return getFieldValue(null, field);
    }

    /**
     * 获取字段值
     *
     * @param obj   对象，static字段则此字段为null
     * @param field 字段
     * @return 字段值
     * @throws IllegalAccessException 非法访问异常
     */
    public static Object getFieldValue(Object obj, Field field) throws IllegalAccessException {
        if (null == field) {
            return null;
        }
        if (obj instanceof Class) {
            // 静态字段获取时对象为null
            obj = null;
        }
        setAccessible(field);
        return field.get(obj);
    }

    /**
     * 获取所有字段的值
     *
     * @param obj bean对象，如果是static字段，此处为类class
     * @return 字段值数组
     * @throws IllegalAccessException 非法访问异常
     */
    public static Object[] getFieldsValue(Object obj) throws IllegalAccessException {
        if (null != obj) {
            final Field[] fields = getFields(obj instanceof Class ? (Class<?>) obj : obj.getClass());
            if (null != fields) {
                final Object[] values = new Object[fields.length];
                for (int i = 0; i < fields.length; i++) {
                    values[i] = getFieldValue(obj, fields[i]);
                }
                return values;
            }
        }
        return null;
    }

    /**
     * 设置方法为可访问（私有方法可以被外部调用）
     *
     * @param <T>              AccessibleObject的子类，比如Class、Method、Field等
     * @param accessibleObject 可设置访问权限的对象，比如Class、Method、Field等
     */
    public static <T extends AccessibleObject> void setAccessible(T accessibleObject) {
        if (null != accessibleObject && !accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
    }


}
