<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>product-left</title>
<link href="/res/zhou/css/admin.css" rel="stylesheet" type="text/css" />
<link href="/res/common/css/theme.css" rel="stylesheet" type="text/css" />
<link href="/res/common/css/jquery.validate.css" rel="stylesheet"
	type="text/css" />
<link href="/res/common/css/jquery.treeview.css" rel="stylesheet"
	type="text/css" />
<link href="/res/common/css/jquery.ui.css" rel="stylesheet"
	type="text/css" />

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="/res/fckeditor/fckeditor.js"></script>
<script src="/res/common/js/jquery.js" type="text/javascript"></script>
<script src="/res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="/res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="/res/common/js/zhou.js" type="text/javascript"></script>
<script src="/res/zhou/js/admin.js" type="text/javascript"></script>
</head>
<body class="lbody">
	<div class="left">
		<%@ include file="/WEB-INF/back_page/head.jsp"%>
		<ul class="w-lful">
			<li>
				<a href="../product/list.do" target="rightFrame">商品管理</a>
			</li>
			<li>
				<a href="../brand/list.do" target="rightFrame">品牌管理</a>
			</li>
			<li>
				<a href="../type/list.do" target="rightFrame">类型管理</a>
			</li>
		</ul>
	</div>
</body>
</html>