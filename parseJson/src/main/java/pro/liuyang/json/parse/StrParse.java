package pro.liuyang.json.parse;


import pro.liuyang.json.constants.CommonConstant;

public class StrParse {

    private StrParse() {}

    public static void parse(Object obj, StringBuilder sb) {
        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS)
                .append(obj)
                .append(CommonConstant.DOUBLE_QUOTATION_MARKS);
    }

}
