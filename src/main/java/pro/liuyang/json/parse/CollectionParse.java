package pro.liuyang.json.parse;

import pro.liuyang.json.constants.CommonConstant;

import java.util.Collection;
import java.util.Iterator;

/**
 * 解析集合容器
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
public class CollectionParse {

    private CollectionParse() {}

    public static void parse(Collection<?> list, StringBuilder sb)  throws IllegalArgumentException, IllegalAccessException {
        sb.append(CommonConstant.LEFT_PARENTHESES_ARR);
        Iterator<?> iterator = list.iterator();
        while (true) {
            Object obj = iterator.next();
            TypeTransfer.transfer(obj, sb, null);
            if (! iterator.hasNext()) {
                sb.append(CommonConstant.RIGHT_PARENTHESES_ARR);
                return;
            }
            sb.append(CommonConstant.COMMA);
        }
    }
}
