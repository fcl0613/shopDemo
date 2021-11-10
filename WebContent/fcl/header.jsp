<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            <c:if test="${isLogin ne '1' }">
            	<a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            </c:if>
            <c:if test="${isLogin eq '1' }">
            	你好 ${user.username }
            </c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a><a href="cart.html"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
            <c:forEach var="f" items="${flist }">
            	<li><a href="selectproductlist?fid=${f.cateid }">${f.catename }</a>
                	<div class="sList2">
                   		<div class="clearfix">
                    		<c:forEach var="c" items="${clist }">
                    			<c:if test="${f.cateid == c.parentid }">
                    				<a href="selectproductlist?cid=${c.cateid }">${c.catename }</a>
                    			</c:if>
                    		</c:forEach>
                    	</div>
                	</div>
            	</li>
            </c:forEach>
        </ul>
    </div>
</div>