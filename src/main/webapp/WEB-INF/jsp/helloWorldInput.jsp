<%@ page contentType="text/html; charset=gb2312" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>ÄãºÃ£¬Hello World Input</title>
	<s:head />
</head>
<body>
	<s:form action="helloWorld">
		<s:textfield label="What is your name?" name="name" />
		<s:textfield label="What is the date?" name="dateNow" />
		<s:submit />
	</s:form>
</body>
</html>
	