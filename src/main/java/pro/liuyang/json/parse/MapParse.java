package pro.liuyang.json.parse;

import pro.liuyang.json.constants.CommonConstant;

import java.util.Iterator;
import java.util.Map;

/**
 * 解析键值对容器
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
public class MapParse {

    private MapParse() {}

    public static void parse(Map<?, ?> map, StringBuilder sb) throws IllegalArgumentException, IllegalAccessException  {
        sb.append(CommonConstant.LEFT_PARENTHESES_OBJ);
        Iterator<? extends Map.Entry<?, ?>> iterator = map.entrySet().iterator();
        while (true) {
            Map.Entry<?, ?> entry = iterator.next();
            sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS).append(entry.getKey()).append(CommonConstant.DOUBLE_QUOTATION_MARKS);
            sb.append(CommonConstant.COLON);
            TypeTransfer.transfer(entry.getValue(), sb, null);
            if (! iterator.hasNext()) {
                sb.append(CommonConstant.RIGHT_PARENTHESES_OBJ);
                return;
            }
            sb.append(CommonConstant.COMMA);
        }
    }

}
