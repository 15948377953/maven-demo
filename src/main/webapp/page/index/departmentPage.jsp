<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>部门管理页面</title>
</head>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="../commom/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="../commom/leftsidebar.jsp"%>

        <!-- 部门表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="#">部门管理</a></li>
                        <li class="active">部门信息</li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="dept_table">
                    <thead>
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>部门老大</th>
                        <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${pageBean.lists}" var="dept">
                            <tr>
                                <td>${dept.deptId}</td>
                                <td>${dept.deptName}</td>
                                <td>${dept.deptLeader}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary dept_edit_btn" data-toggle="modal" data-target=".dept-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger dept_delete_btn">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="panel-body">
                    <div class="table_items">
                        当前第<span>${pageBean.currPage}</span>页，共有<span>${pageBean.totalPage}</span>页，总记录数<span>${pageBean.totalCount}</span>条。
                        <span>
                           <c:if test="${pageBean.currPage != 1}">
                               <a href="${pageContext.request.contextPath }/dept/getDeptList?currentPage=1">[首页]</a>
                               <a href="${pageContext.request.contextPath }/dept/getDeptList?currentPage=${pageBean.currPage-1}">[上一页]</a>
                           </c:if>
                           <c:if test="${pageBean.currPage != pageBean.totalPage}">
                               <a href="${pageContext.request.contextPath }/dept/getDeptList?currentPage=${pageBean.currPage+1}">[下一页]</a>
                               <a href="${pageContext.request.contextPath }/dept/getDeptList?currentPage=${pageBean.totalPage}">[尾页]</a>
                           </c:if>
                       </span>
                    </div>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.dept_info -->
    </div><!-- /.hrms_dept_body -->

    <%@ include file="departmentAdd.jsp"%>
    <%@ include file="departmentUpdate.jsp"%>

    <!-- 尾部-->
    <%@ include file="../commom/foot.jsp"%>

</div><!-- /.hrms_dept_container -->

<script type="text/javascript">
    var currPage = ${pageBean.currPage};
    var totalPage = ${pageBean.totalPage};

    <!-- ==========================部门删除操作=================================== -->
    $(".dept_delete_btn").click(function () {
        var deptId = $(this).parent().parent().find("td:eq(0)").text();
        var deptName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认删除【"+ deptName +"】的信息吗？")){
            $.ajax({
                url:'/dept/delDept',
                type:"POST",
                data:{
                    dept:deptId
                },
                dataType:'json',
                success:function (data) {
                    console.info(data.result);
                    if ("success" == data.result){
                        confirm("删除成功！");
                        window.location.reload();
                    }else {
                        alert(result.extendInfo.del_dept_error);
                    }
                }
            });
        }
    });
</script>
</body>
</html>
