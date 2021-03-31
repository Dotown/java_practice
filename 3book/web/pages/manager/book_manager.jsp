<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%--静态包含页头内容--%>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function (){
			$("a.sub").click(function (){
				return confirm("确定要删除《"+ $(this).parent().parent().find("td:first").text() +"》这本记录吗");
			})
		})

	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
	<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.item}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
				<td><a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a></td>
				<td><a class="sub" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
			</tr>
			</c:forEach>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>

		<div id="page_nav">
			<a href="manager/bookServlet?action=page&pageNo=1">首页</a>
			<c:if test="${requestScope.page.pageNo>1}">
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>
			<a href="#">3</a>
			【4】
			<a href="#">5</a>
			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
			</c:if>

			<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input class="pageNumber" value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
			<input class="pageBtn" type="button" value="确定">
			<script type="text/javascript">
				$(function (){
					$(".pageBtn").click(function (){
						var pageNo = $(".pageNumber").val();
						location.href="${base}manager/bookServlet?action=page&pageNo="+pageNo;
					})
				})
			</script>
		</div>
	</div>
	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>