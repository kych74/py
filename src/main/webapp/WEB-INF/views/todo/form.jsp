<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@include file="../include/header.jsp" %>


<!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Regist New To-do 
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
                                    <h3 class="box-title">Your New Todo</h3>
                                    <sf:errors path="*" cssClass="error" />
                                </div><!-- /.box-header -->
                                <!-- form start -->
                                
                                
                                
                                <sf:form action="registAction" method="post" commandName="todo">
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
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                </sf:form>
                            </div><!-- /.box -->
                        </div><!--/.col (left) -->

                    </div>   <!-- /.row -->
                </section><!-- /.content -->
                
            </aside><!-- /.right-side -->
		
<%@include file="../include/scripts.jsp" %>

<script>

$(function(){
	var result = '${param.result}';
	var nextPage = '${param.nextPage}';
	
	var requestMethod = '${pageContext.request.method}';
	
	if(result ==='success'){
		if(confirm("등록에 성공하셨습니다.\n 리스트에서 확인 하시겠습니까?")){
		
			self.location = nextPage;
		}
		
	}
	
});

</script> 
  
<%@include file="../include/footer.jsp" %>

    