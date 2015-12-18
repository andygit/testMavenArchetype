package test.maven.archetype.action;

/**
 * Created by andy on 2015/12/9.
 */

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import test.maven.archetype.bo.Person;


public class JsonLoginAction extends ActionSupport{
    private Person person;
    // 返回结果给客户端
    private String result;

    @Override
    public String execute() throws Exception {
        JSONObject json=new JSONObject();
        if("yzwang".equals(person.getUsername()) && "yzwang".equals(person.getPassword())) {
            json.put("code","1");
            json.put("result","成功");
        }else{
            json.put("code","0");
            json.put("result","失败");
        }
        System.out.println(json);
        result=json.toString();
        return SUCCESS;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
