<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var ="NewURL" value="/chinh-sua"/>
<c:url var ="AddURL" value="/them-truyen"/>
<c:url var ="ThisURL" value="/ke-sach"/>
<c:url var ="DelURL" value="/xoa-truyen"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty message.message}">
		<div class="alert alert-${message.alert}">
  			${message.message}
		</div>
	</c:if>
	<table class="table">
			<thead>
				<tr>
					<th scope="col">${story.nameStory}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${colectionStoryList.listResult}">
					<tr>
						<th onclick="CollectionStory(${item.idCollectionStory})"
							scope="col">${item.nameCollectionStory}</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<script>
		
	</script>
</body>
</html>