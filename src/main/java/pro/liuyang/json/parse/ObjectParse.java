package pro.liuyang.json.parse;

import pro.liuyang.json.annotation.ParseConfig;
import pro.liuyang.json.constants.CommonConstant;
import pro.liuyang.json.utils.ReflectUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Objects;

/**
 * 解析对象
 * @author Yang.Liu
 * @version 1.0
 * 2020-07-28
 */
public class ObjectParse {

    private ObjectParse() {}

    public static void parse(Object obj, StringBuilder sb) throws IllegalArgumentException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = ReflectUtil.getFields(clazz);
        int len = fields.length;
        sb.append(CommonConstant.LEFT_PARENTHESES_OBJ);
        for (int i = 0; i < len; i++) {
            Field field = fields[i];
            Object value = ReflectUtil.getFieldValue(obj, field);
            if (i != 0 && Objects.nonNull(value)) {
                sb.append(CommonConstant.COMMA);
            }
            if (Objects.nonNull(value)) {
                String name = ReflectUtil.getFieldName(field);
                sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS).append(name).append(CommonConstant.DOUBLE_QUOTATION_MARKS);
                sb.append(CommonConstant.COLON);
                ParseConfig annotation = null;
                if (field.isAnnotationPresent(ParseConfig.class)) {
                    annotation = field.getAnnotation(ParseConfig.class);
                    if (annotation.ignoreSwitch()) {
                        sb.append(CommonConstant.DOUBLE_QUOTATION_MARKS).append(annotation.ignore()).append(CommonConstant.DOUBLE_QUOTATION_MARKS);
                        continue;
                    }
                }
                TypeTransfer.transfer(value, sb, annotation);
            }
        }
        sb.append(CommonConstant.RIGHT_PARENTHESES_OBJ);
    }
}
