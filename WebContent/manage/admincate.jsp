<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminmenu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/shop/manage/adminindex.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        <div class="result-wrap">
            <form action="" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admintocateadd"><i class="icon-font"></i>新增分类</a>
                        <a id="updateOrd" href="adminselectcategory"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>ID</th>
                            <th>分类名</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="cate" items="${catelist}">
                        	<c:if test="${cate.parentid == 0 }">
                        		<tr>
                        			<td>${cate.cateid }</td>
                        			<td>${cate.catename }</td>
                        			<td>
                        				<a class="link-update" href="admintocateupdate?id=${cate.cateid }">修改</a>
	                                	<a class="link-del" href="javascript:catedel(${ cate.cateid})">删除</a>
                        			</td>
                        		</tr>
                       			<c:forEach var="ccate" items="${catelist}">
                        			<c:if test="${ccate.parentid == cate.cateid }">
                        				<tr>
                        					<td>${ccate.cateid }</td>
                        					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ccate.catename }</td>
                        					<td>
                        						<a class="link-update" href="admintocateupdate?id=${ccate.cateid }">修改</a>
	                                			<a class="link-del" href="javascript:catedel(${ ccate.cateid})">删除</a>
	                                		</td>
                        				</tr>
                        			</c:if>
                        		</c:forEach>
                        	</c:if>
                        </c:forEach>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>

<!-- 设置搜索关键字为空 查找全部 -->
<script>
	function editinput(){
		document.getElementById("tt").value=("");
	}
	
	function catedel(id){
		if (confirm("你确定要删除该分类吗？")) {
			location.href="admindocatedel?id="+id;
		}
	}
</script>
</body>
</html>