<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<c:if test="${not empty message.message}">
							<div class="alert alert-${message.alert}">${message.message}</div>
						</c:if>
						<h5 class="card-title text-center">Đăng nhập</h5>
						<form action="<c:url value='/dang-nhap'/>" id="formSubmit"
							method="post">
							<input type="hidden" value="login" id="idstory" name="action" />
							<div class="form-label-group">
								<input type="text" value="" name="username"
									id="inputEmail" class="form-control"
									placeholder="Tên tài khoảng" required autofocus> <label
									for="inputEmail">Tên tài khoảng</label>
							</div>

							<div class="form-label-group">
								<input type="password" value="" name="password"
									id="inputPassword" class="form-control" placeholder="Mật khẩu"
									required> <label for="inputPassword">Mật khẩu</label>
							</div>

							<div class="custom-control custom-checkbox mb-3">
								<a href="<c:url value="/dang-ky-tai-khoang"/>">Đăng ký tài khoảng</a>
							</div>
							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Đăng nhập</button>
							<hr class="my-4">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>