package pro.liuyang.json.parse;


import pro.liuyang.json.constants.CommonConstant;

/**
 * 解析字符
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
public class StrParse {

    private StrParse() {}

    public static void parse(Object obj, StringBuilder sb) {
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS)
                .append(obj)
                .append(CommonConstant.DOUBLE_QUOTATION_MARKS);
    }

}
