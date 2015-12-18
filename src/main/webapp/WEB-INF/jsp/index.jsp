<%@ page contentType="text/html; charset=gb2312" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Index</title>
	<s:head />
</head>
<body>
	<s:form action="sitemesh/helloWorld">
		<s:textfield label="hello" name="name" value="%{username}"/>
		<s:textfield label="hello2" name="name2" value="%{#parameters.username}"/>
		<s:textfield label="What is the date?" name="dateNow" />
		<s:submit />
	</s:form>
</body>
</html>
	