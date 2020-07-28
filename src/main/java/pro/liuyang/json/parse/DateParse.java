package pro.liuyang.json.parse;

import pro.liuyang.json.annotation.ParseConfig;
import pro.liuyang.json.constants.CommonConstant;
import pro.liuyang.json.utils.ParseConfigUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 解析时间
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
public class DateParse {

    private DateParse() {}

    public static void parseDate(Object obj, StringBuilder sb, ParseConfig annotation) {
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS);
        sb.append(ParseConfigUtil.parse(obj, annotation, Date.class));
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS);
    }

    public static void parseLocalDate(Object obj, StringBuilder sb, ParseConfig annotation) {
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS);
        sb.append(ParseConfigUtil.parse(obj, annotation, LocalDate.class));
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS);
    }

    public static void parseDateTime(Object obj, StringBuilder sb, ParseConfig annotation) {
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS);
        sb.append(ParseConfigUtil.parse(obj, annotation, LocalDateTime.class));
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS);
    }

    public static void parseTime(Object obj, StringBuilder sb, ParseConfig annotation) {
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS);
        sb.append(ParseConfigUtil.parse(obj, annotation, LocalTime.class));
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS);
    }

}
