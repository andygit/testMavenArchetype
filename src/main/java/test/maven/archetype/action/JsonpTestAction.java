package test.maven.archetype.action;

/**
 * Created by andy on 2015/12/9.
 */

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import test.maven.archetype.bo.Person;

import javax.servlet.http.HttpServletRequest;


public class JsonpTestAction extends ActionSupport{
    private String jsoncallback;
    private Person person;
    // 返回结果给客户端
    private String result;

    /**
     * 注意：jsonp这个action的返回不能配置为json类型的返回，而要配置成jsp页面返回
     * 因为如果用json类型的返回，返回给ajax的text会在左右两边加上“，导致ajax解析失败
     * 返回jsp，在jsp里显示result则不会有”
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        //将要返回的实体对象进行json处理
        JSONObject json=JSONObject.fromObject(person);
        //输出格式如：{"id":1, "username":"zhangsan", "pwd":"123"}
        System.out.println(json);
        HttpServletRequest request = ServletActionContext.getRequest();
        String callback = request.getParameter("jsoncallback");
        System.out.println("callback:"+callback);
        result=getJsoncallback()+"("+json.toString()+")";
        System.out.println(result);
        return SUCCESS;
    }

    public String getJsoncallback() {
        return jsoncallback;
    }

    public void setJsoncallback(String jsoncallback) {
        this.jsoncallback = jsoncallback;
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
