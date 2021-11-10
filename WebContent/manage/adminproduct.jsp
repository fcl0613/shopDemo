<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminmenu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/shop/manage/adminindex.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">产品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="adminselectproduct" method="get"><!-- 搜索用get -->
                    <table class="search-tab">
                        <tr>
                            <!--th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td-->
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords }" id="tt" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                            <td><button onclick="editinput()" class="btn btn-primary btn2">刷新</button></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admintoproductadd"><i class="icon-font"></i>新增产品</a>
                        <a id="updateOrd" href="adminselectcategory"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>ID</th>
                            <th>产品名</th>
                            <th>产品描述</th>
                            <th>产品价格</th>
                            <th>产品剩余</th>
                            <th>产品父分类</th>
                            <th>产品子分类</th>
                            <th>产品图片</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="p" items="${plist}">
                        	<tr>
                        		<td>${p.proid }</td>
                        		<td>${p.proname }</td>
                        		<td>${p.prodes }</td>
                        		<td>${p.propice }</td>
                        		<td>${p.prostock }</td>
                        		<td>${p.profcateid }</td>
                        		<td>${p.proccateid }</td>
                        		<td><img src="../images/product/${p.propicname } "width="80" height="80"></td>
                        		<td>
                        			<a class="link-update" href="">修改</a>
	                                <a class="link-del" href="">删除</a>
                        		</td>
                        	</tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
                    	共${tsum }条记录,当前第${cpage }/${tpage }页
                    	<a href="adminselectproduct?cp=1${searchParams }">首页</a>
                    	<a href="adminselectproduct?cp=${cpage-1 < 1 ? 1:cpage-1}${searchParams }">上一页</a>
                    	<a href="adminselectproduct?cp=${cpage+1 > tpage ? tpage:cpage+1}${searchParams }">下一页</a>
                    	<a href="adminselectproduct?cp=${tpage }${searchParams }">尾页</a>
                    </div>
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