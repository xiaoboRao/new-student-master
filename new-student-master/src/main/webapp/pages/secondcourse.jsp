<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>第二课堂</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">

</head>


<body>
<div id="home">
<div class="container">

	<div class="header">
		<h5 class="logo">江西理工大学</h5>
		<h1 class="text-center main-title">共青团第二课堂成绩单</h1>
		<form class="form-inline text-center">
			<div class="row">
				<div class="form-group col-md-3 col-sm-6">
				    <label >姓&nbsp;名:${principal.username }</label>

			  	</div>
			  	<div class="form-group col-md-3 col-sm-6">
				    <label>学&nbsp;院:${principal.college }</label>

			  	</div>
			  	<div class="form-group col-md-3 col-sm-6">
				    <label>班&nbsp;级:${principal.classes}</label>

			  	</div>
			  	<div class="form-group col-md-3 col-sm-6">
				    <label >学&nbsp;号:${principal.idnumber }</label>
			  	</div>
		  	</div>
		</form>
	</div>
	<form action="" method="post" name="form1" enctype="multipart/form-data">
	<div class="row">
		<div class="left-column col-md-6">
			<div class="left-column1 col-md-12">
				<h4 class="text-center">团学工作履历</h4>
				<textarea class="tuan" name="mygroup" id="" cols="" rows="">${principal.item.mygroup}</textarea>
					<div id="putmaterial">
						<h6>上传材料</h6>
						<div>
							<c:forEach items="${principal.mygrouppic}" var="entry">
									<c:if test="${entry !=null}">
										<span class="col-md-2">
									<img src="/pic/${entry}" width=50 height=50 />
									<p><input type="button" value="删除"  onclick="window.location.href='${pageContext.request.contextPath}/deletepic.action?mygrouppic=${entry}&username=${principal.username }'"/></p>
										</span>
									</c:if>
							</c:forEach>
						</div>
						<br>
						<div>
						<input type="file"  name="items_pic"/>
						<span><button class="btn btn-default" value="确定上传" onclick="putuppic()"/>确定上传</span>
						</div>
					</div>
			</div>
			<div class="left-column2 col-md-12">
				<h4 class="text-center">社会实践实习</h4>
				<textarea class="she" name="mysocial"  cols="" rows="">${principal.item.mysocial}</textarea>
				<div >
					<h6>上传材料</h6>
					<div style="height:89px;">
					<c:forEach items="${principal.mysocialpic}" var="socialpic">
									<c:if test="${socialpic !=null}">
										<span class="col-md-2">
										<img src="/pic/${socialpic}" width=50 height=50 />
										<p><input type="button" value="删除"  onclick="window.location.href='${pageContext.request.contextPath}/deletesocialpic.action?mysocialpic=${socialpic}&username=${principal.username }'"/></p>
									</span>
									</c:if>
					</c:forEach>
					</div>
					<input type="file"  name="social_pic"/>
					<span><button class="btn btn-default" value="确定上传" onclick="putsocialpic()"/>确定上传</span>
				</div>
			</div>
			<div class="left-column3 col-md-12">
				<h4 class="text-center">志愿服务活动</h4>
				<textarea class="zhi" name="myvolunteer"  cols="" rows="">${principal.item.myvolunteer}</textarea>
				<h6>上传材料</h6>
				<div style="height:89px;">
				<c:forEach items="${principal.myvolunteerpic}" var="myvolunteer">
								<c:if test="${myvolunteer !=null}">
										<span class="col-md-2">
										<img src="/pic/${myvolunteer}" width=50 height=50 />
										<p><input type="button" value="删除"  onclick="window.location.href='${pageContext.request.contextPath}/deletemyvolunteerpic.action?myvolunteerpic=${myvolunteer}&username=${principal.username }'"/></p>
									</span>
									</c:if>
				</c:forEach>
				</div>
				<input type="file"  name="volunteer_pic"/>
				<span><button class="btn btn-default" value="确定上传" onclick="putmyvolunteerpic()"/>确定上传</span>
			</div>
			<div class="left-column4 col-md-12">
				<h4 class="text-center">创新创业创优</h4>
				<textarea class="chuang" name="mycreative"  cols="" rows="">${principal.item.mycreative}</textarea>
				<h6>上传材料</h6>
				<div style="height:89px;">
				<c:forEach items="${principal.mycreativepic}" var="myvolunteer">
									<c:if test="${myvolunteer !=null}">
										<span class="col-md-2">
										<img src="${pageContext.request.contextPath}/pic/${myvolunteer}" width=50 height=50 />
										<p><input type="button" value="删除"  onclick="window.location.href='${pageContext.request.contextPath}/deletemycreativepic.action?mycreativepic=${myvolunteer}&username=${principal.username }'"/></p>
									</span>
									</c:if>
				</c:forEach>
				</div>
				<input type="file"  name="creativepic"/>
				<span><button class="btn btn-default" value="确定上传" onclick="putmycreativepic()"/>确定上传</span>
			</div>
		</div>
		<div class="right-column col-md-6">
			<div class="right-column1 col-md-12">
				<h4 class="text-center">重点活动参加情况</h4>
				<textarea class="zhong" name="myimportant"  cols="" rows="">${principal.item.myimportant}</textarea>
				<h6>上传材料</h6>
				<div style="height:89px;">
				<c:forEach items="${principal.myimportantpic}" var="myvolunteer">
									<c:if test="${myvolunteer !=null}">
										<span class="col-md-2">
										<img src="/pic/${myvolunteer}" width=50 height=50 />
										<p><input type="button" value="删除"  onclick="window.location.href='${pageContext.request.contextPath}/deletemyimportantpic.action?myimportantpic=${myvolunteer}&username=${principal.username }'"/></p>
										</span>
									</c:if>
				</c:forEach>
				</div>
				<input type="file"  name="importantpic"/>
				<span><button class="btn btn-default" value="确定上传" onclick="putmyimportantpic()"/>确定上传</span>
			</div>
			<div class="right-column21 col-md-1">
				<h4 class="text-center">素质发展项目</h4>
				<textarea class="su" name="quality"  cols="" rows="">${principal.item.myquality}</textarea>
			</div>
			<div class="right-column22 col-md-11">
				<textarea class="su" name="myquality"  cols="" rows=""></textarea>
				<h6>上传材料</h6>
				<div style="height:89px;">
					<c:forEach items="${principal.myqualitypic}" var="myvolunteer">
									<c:if test="${myvolunteer !=null}">
										<span class="col-md-2">
										<img src="/pic/${myvolunteer}" width=50 height=50 />
										<p><input type="button" value="删除"  onclick="window.location.href='${pageContext.request.contextPath}/deletemyqualitypic.action?myqualitypic=${myvolunteer}&username=${principal.username }'"/></p>
										</span>
									</c:if>
					</c:forEach>
				</div>
				<input type="file"  name="myqualitypic"/>
				<span><button class="btn btn-default" value="确定上传" onclick="putmyqualitypic()"/>确定上传</span>
			</div>
			<div class="right-column3 col-md-12">
				<h4>以上内容记录属实</h4>
			</div>
			<div class="right-column41 col-md-6">
				<span><h3 style="border: 1px dashed #f11" class="text-center">认定人签字</h3></span>
			</div>
			<div class="right-column42 col-md-6">
			  	<textarea name="" cols="" rows="" class="text-center signature">a</textarea>
			</div>
			<div class="right-column5 col-md-12">
				<h5>认定单位盖章</h5>
			</div>
			<button name="submit" onclick="putup()"  style="width:100px;height: 50px;color: #2f846d" >提交</button>
		</div>
	</div>
	</form>
</div>
</div>
<%--<script src="${pageContext.request.contextPath}/static/js/secondcourse.js"></script>--%>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap3.0.3.min.js"></script>

</body>
<script>

	function putup() {
        form1.action="${pageContext.request.contextPath}/putuptext.action?userid=${principal.userid}";
        form1.submit();
    }
	function putuppic() {
		form1.action="${pageContext.request.contextPath}/addpicture.action?userid=${principal.userid}";
        form1.submit();
    }
    function putsocialpic() {
        form1.action="${pageContext.request.contextPath}/addsocialpicture.action?userid=${principal.userid}";
        form1.submit();
    }
    function putmyvolunteerpic() {
        form1.action="${pageContext.request.contextPath}/addvolunteerpic.action?userid=${principal.userid}";
        form1.submit();
    }
    function putmyimportantpic() {
        form1.action="${pageContext.request.contextPath}/addimportantpic.action?userid=${principal.userid}";
        form1.submit();
    }
    function putmycreativepic() {
        form1.action="${pageContext.request.contextPath}/addmycreativepic.action?userid=${principal.userid}";
        form1.submit();
    }
    function putmyqualitypic() {
        form1.action="${pageContext.request.contextPath}/addmyqualitypic.action?userid=${principal.userid}";
        form1.submit();
    }
    <%--function deletepicture(pic) {--%>
<%--//        alert("i am clicked");--%>
        <%--var url = "${pageContext.request.contextPath}/deletepic.action";--%>
        <%--var param = {"mygrouppic":pic,"userid":${principal.userid }};--%>

        <%--$.post(url,param, function(data) {--%>
            <%----%>
        <%--});--%>
    <%--}--%>
</script>
</html>