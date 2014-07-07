$(function(){
	
	if(result === 'success'){
		$('#resultMsg').html("게시물이 정상적으로 등록되었습니다.");
		$("#myModal").modal('show');
		
		console.log(document.referrer);
		self.location = nextPage;
	}
	
	$('#saveBtn').click(function(event){
		
		event.preventDefault();
		$('.form-horizontal').submit();
		
	});
});