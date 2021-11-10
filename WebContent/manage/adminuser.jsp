<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminmenu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/shop/manage/adminindex.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="admindouserselect" method="get"><!-- 搜索用get -->
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
            <form action="admindouserdelete?cpage=${cpage}&keyword=${param.keywords }" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="adminuseradd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:deleteMore('确定删除这些用户名吗?','myform')"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="admindouserselect"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectAll(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>性别</th>
                            <th>电话</th>
                            <th>地址</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="u" items="${userlist}">
                        	<tr>
                            	<td class="tc"><input name="id[]" value="${u.userid }" type="checkbox"></td>
                            	<td>${u.userid }</td>
                            	<td>${u.username }</td>
	                            <td>${u.password }</td>
	                            <td>
	                            	<c:if test = "${u.usersex == 0}">
	                            		男
	                            	</c:if>
	                            	<c:if test = "${u.usersex == 1}">
	                            		女
	                            	</c:if>
	                            	<c:if test = "${u.usersex == 2}">
	                            		保密
	                            	</c:if>
	                            </td>
	                            <td>${u.phone }</td>
	                            <td>${u.address }</td>
	                            <td>
	                                <a class="link-update" href="admintouserupdate?id=${u.userid }&cpage=${cpage}&keyword=${param.keywords }">修改</a>
	                                <a class="link-del" href="javascript:del('你确定要删除该用户吗？','admindouserdelete?id=${u.userid }&cpage=${cpage}&keyword=${param.keywords }')">删除</a>
	                            </td>
                        	</tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
                    	共${tsum }条记录,当前第${cpage }/${tpage }页
                    	<a href="admindouserselect?cp=1${searchParams }">首页</a>
                    	<a href="admindouserselect?cp=${cpage-1 < 1 ? 1:cpage-1}${searchParams }">上一页</a>
                    	<a href="admindouserselect?cp=${cpage+1 > tpage ? tpage:cpage+1}${searchParams }">下一页</a>
                    	<a href="admindouserselect?cp=${tpage }${searchParams }">尾页</a>
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
	
	function judgeSex(sex){
		if(sex==0){
			//document.getElementById("sex").innerHTML = "男";
			return "男";
		}else if(sex == 1){
			//document.getElementById("sex").innerHTML = "女";
			return "女";
		}else{
			//document.getElementById("sex").innerHTML = "保密";
			return "保密";
		}
	}
	//document.getElementById("sex").innerText = judgeSex(${u.usersex });
	
	function del(mess, url){
		if(confirm(mess)){
			location.href=url;
		}	
	}
	
	
	function selectAll(o){
		var a = document.getElementsByName("id[]");
		for(var i=0;i<a.length;i++){
			a[i].checked = o.checked;
		}
	}
	
	function deleteMore(mess, formname){
		if(confirm(mess)){
			var form = document.getElementById(formname);
			form.submit();
		}	
	}
</script>
</body>
</html>