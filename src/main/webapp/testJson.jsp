<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>Json测试</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
      //点击提交按钮时，从服务端获取数据，然后在客户端显示
      $("#btn").click(function(){
        // 序列化表单的值
        var params=$("input").serialize();
        $.ajax({
          url: "json1.action",
          // 数据发送方式
          type: "post",
          // 接受数据格式
          dataType : "json",
          // 要传递的数据
          data : params,
          // 回调函数，接受服务器端返回给客户端的值，即result值
          success : show
        });
      });
    });

    function show(result){
      //测试result是否从服务器端返回给客户端
      //alert(result);
      //解析json对象
      var json = eval("("+result+")");
      var obj = "编号: "+json.id+"  用户名: "+json.username+"  密码: "+json.password;
      $("#result").html(obj);
    }
  </script>
  <!-- s:head theme="ajax" />这句话好像没影响哦    -->
  <!--在jsp页面上加入 s:head theme="ajax" />会报如下异常：java.io.FileNotFoundException:
            Template /template/ajax/head.ftl not found.     
              解决办法：在struts2-core-2.1.8.jar/template目录下加入ajax文件夹，ajax文件夹所在目录为
            struts2-core-2.1.8.jar/template/archive。
              注意：ajax文件夹下要包含head.ftl，否则还是会抛异常。head.ftl请在template目录搜索然后放到ajax文件夹里
         -->
  <s:head theme="xhtml"/>
  <sx:head parseContent="true"/>
</head>

<body>
<!-- 显示User实体对象 -->
<div id="result"></div>
<s:form name="userForm" action="json1" method="post">
  编号：<input name="person.id"/><br/>
  用户名：<input name="person.username"/><br/>
  密码：<input name="person.password"/><br/><br/>
  <input id="btn" type="button" value=" 提 交 "/>
</s:form>

</body>
</html>