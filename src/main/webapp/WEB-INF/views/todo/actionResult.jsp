<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/header.jsp" %>


<!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Action Result!
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
                        
                        	<div class="box box-success">
                                <div class="box-header">
                                    <h3 class="box-title">${param.result }</h3>
                                    <div class="box-tools pull-right">
                                        <div class="btn-group" data-toggle="btn-toggle">
                                            <button type="button" class="btn btn-success btn-xs active" data-toggle="on">Left</button>                                            
                                            <button type="button" class="btn btn-success btn-xs" data-toggle="off">Right</button>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="box-body">
                                	
                                	${cri.pageno }
                                	
                                    Box class: <code>.box.box-success</code>
                                    <p>
                                        amber, microbrewery abbey hydrometer, brewpub ale lauter tun saccharification oxidized barrel.
                                        berliner weisse wort chiller adjunct hydrometer alcohol aau!
                                        sour/acidic sour/acidic chocolate malt ipa ipa hydrometer.
                                        
                                        <form id="form1" action="${param.nextPage}" method="get">
                                            <c:if test="${not empty cri}">
                                        	<input type='hidden' name='pageno' value='${cri.pageno }'/>
                                        	</c:if>
                                        	<button class="btn btn-primary" id='moveBtn' type='submit'>Move Page</button>
                                        </form>
                                        
                                        
                                    </p>
                                </div><!-- /.box-body -->
                            </div>


                        </div><!--/.col (left) -->

                    </div>   <!-- /.row -->
                </section><!-- /.content -->
                
            </aside><!-- /.right-side -->
		
<%@include file="../include/scripts.jsp" %>

<script>

$(function(){

});

</script> 
  
<%@include file="../include/footer.jsp" %>

    