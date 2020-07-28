package pro.liuyang.json.annotation;

import java.lang.annotation.*;

/**
 * 解析配置注解
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParseConfig {

    /**
     * 时间格式化
     * 注解值例如：
     *  yyyy-MM-dd
     *  yyyy-MM-dd HH:mm
     *  yyyyMMddHHmmssSSS
     */
    String dateFormat() default "";

    /**
     * 忽略属性值开关，false：取消忽略，true：开启忽略
     */
    boolean ignoreSwitch() default false;

    /**
     * 如果 ignoreSwitch 为开启状态，那么改属性值将替换原对象属性值
     */
    String ignore() default "忽略属性值";

}
