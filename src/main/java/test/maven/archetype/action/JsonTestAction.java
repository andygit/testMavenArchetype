package test.maven.archetype.action;

/**
 * Created by andy on 2015/12/9.
 */

        import net.sf.json.JSONObject;
        import com.opensymphony.xwork2.ActionSupport;
        import test.maven.archetype.bo.Person;


public class JsonTestAction extends ActionSupport{
    private Person person;
    // 返回结果给客户端
    private String result;

    @Override
    public String execute() throws Exception {
        //将要返回的实体对象进行json处理
        JSONObject json=JSONObject.fromObject(person);
        //输出格式如：{"id":1, "username":"zhangsan", "pwd":"123"}
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
