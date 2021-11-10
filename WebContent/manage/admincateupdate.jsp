<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminmenu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/shop/manage/adminindex.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/shop/manage/adminselectcategory">分类管理</a><span class="crumb-step">&gt;</span><span>分类修改</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="admindocateupdate" method="post" id="myform" name="myform">
                	<input type="hidden" name="id" value="${cate.cateid}">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120"><i class="require-red">*</i>父级分类</th>
                            <td> 
                              	<select calss="common-text required" name="parentid" >
                              		<c:if test="${cate.parentid == 0 }">
                              			<option value="0" selected="selected">根分类</option>
                              		</c:if>
                              		<c:forEach var="cate1" items="${catelist }">
                              			<c:if test="${cate1.parentid == 0 }">
                              				<c:if test="${cate.parentid == cate1.cateid }">
                              					<option value="${cate1.cateid }" selected="selected">${cate1.catename }</option>
                              				</c:if>
                              				<c:if test="${cate.parentid != cate1.cateid }">
                              					<option value="${cate1.cateid }">${cate1.catename }</option>
                              				</c:if>
                              			</c:if> 
                              		</c:forEach>
                              	</select>
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>分类名称</th>
                                <td>
                                    <input class="common-text required" id="title" name="catename" size="50" value="${cate.catename }" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>