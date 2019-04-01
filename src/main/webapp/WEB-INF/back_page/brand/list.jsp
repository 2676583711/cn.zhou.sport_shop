<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>babasport-list</title>
</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 品牌管理 - 列表</div>
		<form class="ropt">
			<input class="add" type="button" value="添加"
				onclick="javascript:window.location.href='add.do'" />
		</form>
		<div class="clear"></div>
	</div>
	<div class="body-box">

		<form action="/admin/brand/list.do" method="post"
			style="padding-top: 5px;">
			品牌名称:
			<input type="text" name="name" value="${name}" />
			<select name="isDisplay" id="isDisplay">
				<option value="${isDisplay }"
					<c:if test="${isDisplay==1}">select="selected"</c:if>>是</option>
				<option value="${isDisplay }"<c:if test="${isDisplay==0 }">select="selected"</c:if>->不是</option>
			</select>
			<input type="submit" class="query" value="查询" />
		</form>

		<table cellspacing="1" cellpadding="0" border="0" width="100%"
			class="pn-ltable">
			<thead class="pn-lthead">
				<tr>
					<th width="20">
						<input type="checkbox" onclick="checkBox('ids',this.checked)" />
					</th>
					<th>品牌ID</th>
					<th>品牌名称</th>
					<th>品牌图片</th>
					<th>品牌描述</th>
					<th>排序</th>
					<th>是否可用</th>
					<th>操作选项</th>
				</tr>
			</thead>
			<tbody class="pn-ltbody">

				<!--  遍历品牌数据，然后逐一展示-->
				<c:forEach items="${brandBean}" var="brandBean">
					<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'"
						onmouseover="this.bgColor='#eeeeee'">

						<td>
							<input type="checkbox" value="8" name="ids" />
						</td>
						<td align="center">${brandBean.id }</td>
						<td align="center">${brandBean.name }</td>
						<td align="center">
							<!--/res/img/pic/ppp0.jpg  -->
							<img width="40" height="40"
								src="${serverUrl.concat(brandBean.imageUrl) }" />
						</td>
						<td align="center"></td>
						<td align="center">${brandBean.sort }</td>
						<td align="center">
							<c:if test="${isDisplay==1}">是</c:if>
							<c:if test="${isDisplay==0}">不是</c:if>
						</td>

						<td align="center">
							<!--&name=name&imageUrl=imageUrl&description=description&sort=sort&isDisplay=isDisplay  -->
							<a class="pn-opt" href="/admin/brand/edit.do?id=${brandBean.id}">修改</a>
							<a class="pn-opt"
								onclick="if(!confirm('您确定删除吗？')) {return false;}"
								href="/admin/brand/delete.do?id=${brandBean.id}&
								name=${brandBean.name}&isDisplay=${brandBean.isDisplay}">删除</a>
						</td>
					</tr>
				</c:forEach>


				<!-- <tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'"
					onmouseover="this.bgColor='#eeeeee'">
					<td><input type="checkbox" value="8" name="ids" /></td>
					<td align="center">8</td>
					<td align="center">金乐乐</td>
					<td align="center"><img width="40" height="40"
						src="/res/img/pic/ppp0.jpg" /></td>
					<td align="center"></td>
					<td align="center">99</td>
					<td align="center">是</td>
					<td align="center"><a class="pn-opt" href="#">修改</a> | <a
						class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}"
						href="#">删除</a></td>
				</tr> -->

				<!-- <tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="7" name="ids"/></td>
			<td align="center">7</td>
			<td align="center">喜悦瑜伽</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="6" name="ids"/></td>
			<td align="center">6</td>
			<td align="center">丹璐斯</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="5" name="ids"/></td>
			<td align="center">5</td>
			<td align="center">菩媞</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="4" name="ids"/></td>
			<td align="center">4</td>
			<td align="center">伊朵莲</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="3" name="ids"/></td>
			<td align="center">3</td>
			<td align="center">梵歌纳（vangona）</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="2" name="ids"/></td>
			<td align="center">2</td>
			<td align="center">凯速（KANSOON）</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="1" name="ids"/></td>
			<td align="center">1</td>
			<td align="center">依琦莲</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr> -->

			</tbody>
		</table>

		<!--& amp; 表示符号 &、
			& nbsp;表示空格
			一般常见的还有
			& lt; 表示小于号 <
			& gt; 表示大于号 >
			& copy ;表示 @   -->


		<!--分页显示  -->
		<div class="page pb15">
			<span class="r inb_a page_b">


				<font size="2">
					<a
						href="/admin/brand/divide.do?&amp;isDisplay=${isDisplay }&amp;pageNo=1">首页</a>
				</font>
				<a
					href="/admin/brand/divide.do?&amp;isDisplay=${isDisplay }&amp;pageNo=${previousPage}">
					<font size="2"> 上一页 </font>
				</a>

				<strong>
					<c:if test="${pageNo==1 }">1</c:if>
					<c:if test="${pageNo!=1 }">
						<a
							href="/admin/brand/list.do?&amp;isDisplay=${isDisplay }&amp;pageNo=1">1</a>
					</c:if>
				</strong>
				<a
					href="/admin/brand/divide.do?&amp;isDisplay=${isDisplay}&amp;pageNo=2">2</a>
				<a
					href="/admin/brand/divide.do?&amp;isDisplay=${isDisplay}&amp;pageNo=3">3</a>
				<a
					href="/admin/brand/divide.do?&amp;isDisplay=${isDisplay}&amp;pageNo=4">4</a>
				<a
					href="/admin/brand/divide.do?&amp;isDisplay=${isDisplay}&amp;pageNo=5">5</a>
				<c:if test="${pageNo!=totalPages }">
					<a
						href="/admin/brand/divide.do?&amp;isDisplay=${isDisplay}&amp;pageNo=${nextPage}">${pageNo }</a>
				</c:if>

				<a
					href="/admin/brand/divide.do?&amp;isDisplay=${isDisplay}&amp;pageNo=${nextPage}">
					<font size="2">下一页</font>
				</a>
				<a
					href="/admin/brand/divide.do?&amp;isDisplay=${isDisplay}&amp;pageNo=${totalPages}">
					<font size="2">尾页</font>
				</a>
				共
				<var>${totalPages}</var>
				页 到第
				<input type="text" size="3" id="PAGENO" name="pageNo"
					value="${pageNo}" />
				页
				<input type="button"
					onclick="javascript:window.location.href ='/admin/brand/divide.do?&amp;isDisplay=0&amp;pageNo=' + $('#PAGENO').val() "
					value="确定" class="hand btn60x20" id="skip" />

			</span>
		</div>


		<div style="margin-top: 15px;float=left">
			<input class="del-button" type="button" value="删除110"
				onclick="optDelete();" />
		</div>
</body>
</html>