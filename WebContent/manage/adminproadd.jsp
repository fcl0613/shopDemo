<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminmenu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/shop/manage/adminindex.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/shop/manage/adminselectproduct">产品管理</a><span class="crumb-step">&gt;</span><span>新增产品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="admindoproadd" method="post" enctype="multipart/form-data" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                                <th><i class="require-red">*</i>产品名称</th>
                                <td>
                                    <input class="common-text required" id="title" name="proname" size="50" value="" type="text">
                                </td>
                            </tr>
                        	<tr>
                            	<th width="120"><i class="require-red">*</i>图书分类</th>
                            	<td width="80">父分类</td>
                            	<td> 
                              		<select id="par" calss="common-text required" name="parentid" onchange="getchild()">
                              			<option value="-1" selected="selected">请选择</option>
                              				<c:forEach var="f" items="${fcate }">
                              					<option value="${f.cateid }">${f.catename }</option>
                              				</c:forEach>
                              		</select>
                            	</td>
                            	<td>子分类</td>
                            	<td> 
                              		<select id ="ch" calss="common-text required" name="childid" >
                              			<option value="0" selected="selected">请选择</option>
                              		</select>
                            	</td>
                        	</tr>
                            <tr>
                                <th><i class="require-red">*</i>产品描述</th>
                                <td>
                                    <input class="common-text required" id="title" name="prodes" size="50" value="" type="text">
                               	</td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>产品价格</th>
                                <td>
                                    <input class="common-text required" id="title" name="proprice" size="50" value="" type="text">
                               	</td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>产品剩余</th>
                                <td>
                                    <input class="common-text required" id="title" name="prostock" size="50" value="" type="text">
                               	</td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>产品图片</th>
                                <td>
                                    <input class="common-text required" id="title" name="proimg" size="50" value="" type="file">
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

<script>
	function getchild(){
		var fid = document.getElementById("par").value;
		var sel = document.getElementById("ch");
		document.getElementById("ch").options.length = 0;
		var opt1 = document.createElement("option");
		opt1.value = "0";
		opt1.innerHTML = "请选择";
		opt1.selected = true;
		sel.append(opt1);
		<c:forEach var="c" items="${ccate }">
			var f = "${c.parentid }";
			if (f == fid) {
				var opt = document.createElement("option");
				opt.value = "${c.cateid }";
				opt.innerHTML = "${c.catename }";
				sel.append(opt);
			}
		</c:forEach>
	}
</script>

</body>
</html>