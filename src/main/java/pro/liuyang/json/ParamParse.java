package pro.liuyang.json;

import pro.liuyang.json.parse.TypeTransfer;

public class ParamParse {

    private ParamParse() {}

    public static String toJson(Object param) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        TypeTransfer.transfer(param, sb, null);
        return sb.toString();
    }
}
