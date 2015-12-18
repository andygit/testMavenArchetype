<%@ page contentType="text/html; charset=gb2312" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>
<html>
<head>
    <title>登录界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/font-awesome/css/font-awesome.min.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

    <s:head theme="xhtml"/>
    <sx:head parseContent="true"/>

	<style>
	body{
		font-family: 'microsoft yahei',Arial,sans-serif;
		background-color: #222;
	}

	.redborder {
		border:2px solid #f96145;
		border-radius:2px;
	}

	.row {
		padding: 20px 0px;
	}

	.bigicon {
		font-size: 97px;
		color: #f08000;
	}

	.loginpanel {
		text-align: center;
		width: 300px;
		border-radius: 0.5rem;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
		margin: 10px auto;
		background-color: #555;
		padding: 20px;
	}

	input {
		width: 100%;
		margin-bottom: 17px;
		padding: 15px;
		background-color: #ECF4F4;
		border-radius: 2px;
		border: none;
	}

	h2 {
		margin-bottom: 20px;
		font-weight: normal;
		color: #EFEFEF;
	}

	.btn {
		border-radius: 2px;
		padding: 10px;
	}

	.btn span {
		font-size: 27px;
		color: white;
	}

	.buttonwrapper{
		position:relative;
		overflow:hidden;
		height:50px;
	}

	.lockbutton {
		font-size: 27px;
		color: #f96145;
		padding: 10px;
		width:100%;
		position:absolute;
		top:0;
		left:0;
	}

	.loginbutton {
		background-color: #f08000;
		width: 100%;
		-webkit-border-top-right-radius: 0;
		-webkit-border-bottom-right-radius: 0;
		-moz-border-radius-topright: 0;
		-moz-border-radius-bottomright: 0;
		border-top-right-radius: 0;
		border-bottom-right-radius: 0;
		left: -260px;
		position:absolute;
		top:0;
	}
	</style>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#loginbtn").click(function(){
                $('#loading').removeClass('hidden');
                //这里书写登录相关后台处理，例如: Ajax请求用户名和密码验证
                $.ajax({
                    url:"jsonLogin.action",
                    type:"post",
                    dataType:"json",
                    data:$("input").serialize(),
                    success:onLoginSuccess,
                    error:onLoginError
                });
            });
        });

		function onLoginSuccess(result){
			var json = eval("("+result+")");
			if(json.code=="1"){
				$("#loginForm").attr("action","index1.action");
				$("#loginForm").submit();
			}else{
				$("#loginErrorHint").html("用户名或密码错误");
			}
		}
		function onLoginError(xmlHttpRequest, textStatus, errorThrown){
            alert("error:"+textStatus);
		}

        function check_values() {
//        if ($("input[name='username']").val().length != 0 && $("input[name='password']").val().length != 0) {
            if ($("#username").val().length != 0 && $("#password").val().length != 0) {
                $("#loginbtn").animate({ left: '0' , duration: 'slow'});
                $("#lockbtn").animate({ left: '260px' , duration: 'slow'});
            }else{
                $("#loginbtn").animate({ left: '260px' , duration: 'slow'});
                $("#lockbtn").animate({ left: '0' , duration: 'slow'});
            }
        }

    </script>
</head>
<body>

<!-- Interactive Login - START -->

<div class="container-fluid">
    <div class="row">
        <div class="loginpanel">
            <i id="loading" class="hidden fa fa-spinner fa-spin bigicon"></i>
            <h2>
                <%--<span class="fa fa-quote-left "></span> --%>
                登录
                <%--<span class="fa fa-quote-right "></span>--%>
            </h2>
            <div>
                <s:form id="loginForm" method="post">
                <input id="username" name="person.username" type="text" placeholder="登录账号" onchange="check_values();">
                <input id="password" name="person.password" type="password" placeholder="输入密码" onchange="check_values();">
                </s:form>
                <div class="buttonwrapper">
                    <button id="loginbtn" class="btn btn-warning loginbutton">
                        <span class="fa fa-check"></span>
                    </button>
                    <span id="lockbtn" class="fa fa-lock lockbutton redborder"></span>
                </div>
                <h2 id="loginErrorHint"/>
            </div>
        </div>
    </div>
</div>


<!-- Interactive Login - END -->

<div class="container-fluid">
	<div class="row footerbox">
		<div class="col-md-1"></div>
		<div class="col-md-10">
		<footer class="text-center">
			<a href="1.htm"><i class="fa fa-external-link"></i> 提示</a>
		</footer>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>
</body>
</html>