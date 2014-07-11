<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/header.jsp" %>

<!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                       To-do List 
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

							<form id="form1" name="form1" action=""> 
							
							<input type='hidden' id='pageno' name='pageno' value = '${cri.pageno }'/>
							<input type='hidden' id='bno' name='bno' />
							                           
                            <!-- TO DO List -->
                            <div class="box box-primary">
                                <div class="box-header">
                                    <i class="ion ion-clipboard"></i>
                                    <h3 class="box-title">To Do List</h3>
                                    <div class="box-tools pull-right">
                                        <ul id='pageUl' class="pagination pagination-sm inline">
                                        </ul>
                                    </div>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                    <ul class="todo-list">
                                    
                                    <c:forEach var="item" items="${list}" varStatus="status"> 
                                    
                                        <li>
                                            <!-- drag handle -->
                                            <span class="handle">
                                                <i class="fa fa-ellipsis-v"></i>
                                                <i class="fa fa-ellipsis-v"></i>
                                            </span>  
                                            <!-- checkbox -->
                                            <input type="checkbox" value="" name=""/>     
                                            <!-- todo text -->
                                            <span class="text eachItem" id="${item.bno}" >${item.title }</span>
                                            <!-- Emphasis label -->
                                            <small class="label label-danger"><i class="fa fa-clock-o"></i> 2 mins</small>
                                            <!-- General tools such as edit or delete-->
                                            <div class="tools">
                                                <i class="fa fa-edit"></i>
                                                <i class="fa fa-trash-o"></i>
                                            </div>
                                        </li>
                                        
                                   </c:forEach>     
         
                                    </ul>
                                </div><!-- /.box-body -->
                                <div class="box-footer clearfix no-border">
                                    <button class="btn btn-default pull-right"><i class="fa fa-plus"></i> Add item</button>
                                </div>
                            </div><!-- /.box -->
                            </form>
                            
                        </div><!--/.col (left) -->
						
                    </div>   <!-- /.row -->
                </section><!-- /.content -->
                
            </aside><!-- /.right-side -->
		
<%@include file="../include/scripts.jsp" %>

<script src="/resources/js/pageMaker.js"></script>
<script>

$(function(){
	
	var pageMaker = new PageMaker({totalCount:'${cri.totalCount}', pageno:'${cri.pageno}'});
	
	pageMaker.makePage("pageUl");
	
	$("#pageUl li a").click(function(event){
		
		event.preventDefault();
		
		console.log(event.target.innerHTML);
		
		$("#pageno").attr("value", event.target.innerHTML);
		
		$("#form1").submit();
		
	});
	
	$(".eachItem").click(function(event){
		console.log(event.target);
		
		var id = $(event.target).attr("id");
		
		console.log(id);
		
		var $form = $("#form1"); 
		$form.attr("action", "/todo/detail");
		$("#bno").attr("value", id);
		$form.submit();
		
	});
	
});

</script> 
  
<%@include file="../include/footer.jsp" %>

    