package pro.liuyang.json.utils;

import pro.liuyang.json.annotation.ParseConfig;
import pro.liuyang.json.constants.CommonConstant;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class ParseConfigUtil {

    private ParseConfigUtil() {}

    public static <T> Object parse(Object obj, ParseConfig annotation, Class<T> requiredType) {
        if (Objects.isNull(annotation)) {
            return obj;
        }
        if (CommonConstant.EMPTY.equals(annotation.dateFormat())) {
            return obj;
        }
        if (requiredType == LocalDate.class) {
            LocalDate localDate = (LocalDate) obj;
            return localDate.format(DateTimeFormatter.ofPattern(annotation.dateFormat()));
        }
        if (requiredType == LocalDateTime.class) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            return localDateTime.format(DateTimeFormatter.ofPattern(annotation.dateFormat()));
        }
        if (requiredType == LocalTime.class) {
            LocalTime localTime = (LocalTime) obj;
            return localTime.format(DateTimeFormatter.ofPattern(annotation.dateFormat()));
        }
        if (requiredType == Date.class) {
            return new SimpleDateFormat(annotation.dateFormat()).format(obj);
        }
        return obj;
    }

}
