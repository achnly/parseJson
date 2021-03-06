package pro.liuyang.json;

import pro.liuyang.json.parse.TypeTransfer;

/**
 * 解析主入口
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
public class ParamParse {

    private ParamParse() {}

    /**
     * 解析为Json
     * @param param 需要解析的对象
     * @return Json字符串
     * @throws IllegalArgumentException 非法参数异常
     * @throws IllegalAccessException 非法访问异常
     */
    public static String toJson(Object param) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        TypeTransfer.transfer(param, sb, null);
        return sb.toString();
    }
}
