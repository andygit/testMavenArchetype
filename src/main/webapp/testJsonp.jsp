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

  <title>Jsonp测试</title>
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
          async:true,
          url: "http://localhost:8080/testMavenArchetype/jsonp.action",
          // 数据发送方式
          type: "post",
          // 接受数据格式
          dataType : "jsonp",
          // 要传递的数据
          data : params,
          jsonp:"jsoncallback",
          timeout:50000,
          // 回调函数，接受服务器端返回给客户端的值，即result值
          success : show,
            error : onError
        });
      });
    });

    function show(json){
      var obj = "编号: "+json.id+"  用户名: "+json.username+"  密码: "+json.password;
      $("#result").html(obj);
    }
      function onError(xmlHttpRequest, textStatus, errorThrown){
          alert("error:"+textStatus);
      }
  </script>
  <s:head theme="xhtml"/>
  <sx:head parseContent="true"/>
</head>

<body>
<!-- 显示User实体对象 -->
<div id="result"></div>
<s:form name="userForm">
  编号：<input name="person.id"/><br/>
  用户名：<input name="person.username"/><br/>
  密码：<input name="person.password"/><br/><br/>
  <input id="btn" type="button" value=" 提 交 "/>
</s:form>

</body>
</html>