<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/header.jsp" %>


<!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">


<c:if test="${not empty param.result }">
<script>

alert('${param.result}');

</script>

</c:if>                        
                        
<c:if test="${not empty todo }">

                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Detail View To-do 
                        <small>Preview</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="#">Forms</a></li>
                        <li class="active">General Elements</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <!-- left column -->
                        <div class="col-md-9">
                        
                            <!-- general form elements -->
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">View Todo</h3>
                                    <sf:errors path="*" cssClass="error" />
                                </div><!-- /.box-header -->
                                <!-- form start -->
                                
                                
                                
                                
                                
                                <sf:form name="form1" id="form1" method="post" commandName="todo">
									
									<sf:hidden path="bno"/>
									<input type='hidden' name="pageno" value='${cri.pageno}'/>

                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="Title">Title</label>
                                            <sf:input path="title" class="form-control" id="title" placeholder="Title "/>
                                            <sf:errors path="title" cssClass="error" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="content">Content</label>
                                            <sf:input path="content" class="form-control" id="cotent" placeholder="Content "/>
                                            <sf:errors path="content" cssClass="error" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="dueDate">Due to</label>
                                            <sf:input path="dueDate"  type ="date" class="form-control" id="dueDate" placeholder="DueDate "/>
                                            <sf:errors path="dueDate" cssClass="error" />
                                        </div>
                                    </div><!-- /.box-body -->
									
									

                                    <div class="box-footer">
                                        <button class="btn btn-primary">Submit</button>
                                        
                                        <div class="btn-group pull-right">
                                        	<button  class="btn btn-primary " id="modBtn">Modify</button>
                                        	<button  class="btn btn-primary " id="delBtn">Delete</button>
                                        </div>
                                    </div>
                                </sf:form>
</c:if>                                
                                
                            </div><!-- /.box -->
                        </div><!--/.col (left) -->

                    </div>   <!-- /.row -->
                </section><!-- /.content -->
                
            </aside><!-- /.right-side -->
		
<%@include file="../include/scripts.jsp" %>

<script>

$(function(){
	
	var $form1 = $("#form1");
	
	$("#modBtn").click(function(event){
		
		$form1.attr("action" , "/todo/modify");
		
	});
	
	
	
	$("#delBtn").click(function(){
		$form1.attr("action" , "/todo/delete");
		//$form1.submit();
	});
	
	
});

</script> 
  
<%@include file="../include/footer.jsp" %>

    