<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminmenu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/shop/manage/adminindex.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/shop/manage/admindouserselect">用户管理</a><span class="crumb-step">&gt;</span><span>修改用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="admindouserupdate" method="post" id="myform" name="myform">
                	<input type="hidden" name="userid" value="${user.userid }">
                	<input type="hidden" name="cpage" value="${cpage }">
                	<input type="hidden" name="keyword" value="${keyword }">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120"><i class="require-red">*</i>用户名：</th>
                            <td>
                                <input class="common-text required" id="title" name="username" size="50" value="${user.username }" type="text" readonly="readonly">
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="password" size="50" value="${user.password }" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>性别：</th>
                                <td>
                                	<input type="radio" name="sex" value="0" <c:if test = "${user.usersex==0}"> checked="checked" </c:if>>男
                                	<input type="radio" name="sex" value="1" <c:if test = "${user.usersex==1}"> checked="checked" </c:if>>女
                                	<input type="radio" name="sex" value="2" <c:if test = "${user.usersex==2}"> checked="checked" </c:if>>保密
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>电话：</th>
                                <td>
                                	<input class="common-text required" id="title" name="phone" size="50" value="${user.phone }" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>收货地址：</th>
                                <td>
                                	<input name="address" class="common-text required" id="title" size="50" value="${user.address }" type="text">
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