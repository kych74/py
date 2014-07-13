
function PageMaker(config){
	
	this.pageno = config.pageno;
	
	this.perPage = config.perPage? config.perPage:10; 
	
	this.perPageDisplay = config ? config.perPageDisplay:10;

	
	this.totalCount = config.totalCount;
	
	this.calculate();
	
}

PageMaker.prototype.calculate = function(){
	
	console.log("1-----------", this.pageno);
	
	this.firstPage = (Math.floor((this.pageno -1)/this.perPage) * this.perPage) +1;
	
	console.log("2-----------", this.firstPage);
	
	if(this.firstPage === 1){
		this.isFirst = true;
	}
	
	var tempLastPage = this.firstPage + this.perPage - 1;
	
	if( (tempLastPage * this.perPage) > this.totalCount ){
		
		this.lastPage = Math.ceil(this.totalCount/this.perPage);
		this.hasNext = false;
		
	}else if((tempLastPage * this.prePage) === this.totalCount ){
		
		this.lastPage = tempLastPage;
		this.hasNext = false;
		
	}else{
		
		this.lastPage = tempLastPage;
		this.hasNext = true;
	}
	
	console.log("tempLastPage", tempLastPage);
	console.log("firstPage",this.firstPage);
	console.log("totalCount", this.totalCount);
	console.log("lastPage" , this.lastPage);
	console.log("hasNext", this.hasNext);
	
	
};

PageMaker.prototype.makePage = function(targetId){
	

	
	var str = "";
	
	if(!this.isFirst){
		str += "<li><a href='#' data-page="+(this.firstPage -1)+">&laquo;</a></li>";
	}
	
	for(var i = this.firstPage;i <= this.lastPage ; i++){
		str += "<li><a href='#' data-page="+ i +">"+i+"</a></li>";
	}
	
	if(this.hasNext){
		str += "<li><a href='#' data-page="+(this.lastPage +1)+">&raquo;</a></li>";
	}
	
	document.getElementById(targetId).innerHTML = str;
	
};


