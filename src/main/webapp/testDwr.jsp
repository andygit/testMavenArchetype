<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Dwr test</title>
  <script type='text/javascript' src='/testMavenArchetype/dwr/interface/helloWorld.js'></script>
  <script type='text/javascript' src='/testMavenArchetype/dwr/engine.js'></script>
  <script type='text/javascript' src='/testMavenArchetype/dwr/util.js'></script>


  <script type="text/javascript">
    function firstDwr(){
      helloWorld.sayHello("zhangsan",callBackSayHello) ;
    }

    function callBackSayHello(data){
      alert(data);
    }
  </script>
</head>
<body>
<input  type="button"  name="button"  value="测试DWR"  onclick="firstDwr()">
</body>
</html> 