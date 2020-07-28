package pro.liuyang.json.parse;

import pro.liuyang.json.annotation.ParseConfig;
import pro.liuyang.json.utils.ClassUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * 类型中转中心
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
public final class TypeTransfer {

    private TypeTransfer() {}

    public static void transfer(Object obj, StringBuilder sb, ParseConfig annotation) throws IllegalArgumentException, IllegalAccessException {
        if (isCustomObj(obj)) {
            ObjectParse.parse(obj, sb);
        } else if (isNumber(obj)) {
            sb.append(obj);
        } else if (isString(obj) || isChar(obj)) {
            StrParse.parse(obj, sb);
        } else if (isCollection(obj)) {
            CollectionParse.parse((Collection<?>) obj, sb);
        } else if (isMap(obj)) {
            MapParse.parse((Map<?, ?>) obj, sb);
        } else if (isArray(obj)) {
            ArrayParse.parse(sb, (Object[]) obj);
        } else if (isDate(obj)) {
            DateParse.parseDate(obj, sb, annotation);
        } else if (isLocalDate(obj)) {
            DateParse.parseLocalDate(obj, sb, annotation);
        } else if (isLocalDateTime(obj)) {
            DateParse.parseDateTime(obj, sb, annotation);
        } else if (isLocalTime(obj)) {
            DateParse.parseTime(obj, sb, annotation);
        } else {
            throw new IllegalArgumentException("unknown type param!");
        }
    }

    private static boolean isNumber(Object obj) {
        return obj instanceof Number;
    }

    private static boolean isString(Object obj) {
        return obj instanceof String;
    }

    private static boolean isChar(Object obj) {
        return obj instanceof Character;
    }

    private static boolean isCollection(Object obj) {
        return obj instanceof Collection;
    }

    private static boolean isMap(Object obj) {
        return obj instanceof Map;
    }

    private static boolean isArray(Object obj) {
        return obj.getClass().isArray();
    }

    private static boolean isCustomObj(Object obj) {
        return ClassUtil.isNotJdkClass(obj);
    }

    private static boolean isDate(Object obj) {
        return obj instanceof Date;
    }

    private static boolean isLocalDate(Object obj) {
        return obj instanceof LocalDate;
    }

    private static boolean isLocalDateTime(Object obj) {
        return obj instanceof LocalDateTime;
    }

    private static boolean isLocalTime(Object obj) {
        return obj instanceof LocalTime;
    }

}
