package pro.liuyang.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import pro.liuyang.json.bean.UserInfo;

import java.math.BigDecimal;

public class Demo {

    @Test
    public void demo() throws Exception {
        Object userInfo = new UserInfo();
        Object[] arr = new Object[]{userInfo, null, new Object(), new Exception()};
        System.out.println(ParamParse.toJson(arr));
        //System.out.println(JSON.toJSONString(arr));
    }

}
