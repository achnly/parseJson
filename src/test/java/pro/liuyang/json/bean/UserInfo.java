package pro.liuyang.json.bean;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {

    private String username;

    private Integer age;

    private Map<String, Object> map;

    public UserInfo() {
        this.username = "刘洋";
        this.age = 122;
        Map<String, Object> map = new HashMap<>();
        map.put("a", username);
        map.put("asf", "鲁昆吉里");
        map.put("撒发顺丰", 1000);
        this.map = map;
    }

    public UserInfo(String username, Integer age, Map<String, Object> map) {
        this.username = username;
        this.age = age;
        this.map = map;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
