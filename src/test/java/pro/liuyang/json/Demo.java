package pro.liuyang.json;

import org.junit.Test;
import pro.liuyang.json.bean.UserInfo;

public class Demo {

    @Test
    public void demo() throws Exception {
        Object userInfo = new UserInfo();
        Object[] arr = new Object[]{userInfo, null, new Object(), new Exception()};
        System.out.println(ParamParse.toJson(arr));
    }

}
