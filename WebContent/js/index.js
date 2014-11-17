$(document).ready(function(){
	initContentDivHeight();//初始化页面
	
	$("#risk-nav ul li").each(function(i){
		switch(i){
		case 0 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/ConventionCtrl.html?ts="+new Date().getTime());
			});
		
			break;
		case 1 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/ConventionCtrl.html");
			});
		
			break;
		}
	});    
	/*下面这部分为basic-setting 中的模块*/
	$("#basic-setting-nav ul li").each(function(i){
		switch(i){
		case 0 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/productClass.html?ts="+new Date().getTime());
			});
			break;
		case 1 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/processingWay.html?ts="+new Date().getTime());
			});
			break;
		case 2 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/materialClass.html?ts="+new Date().getTime());
			});
			break;  
		case 3 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/materialSource.html");
			});
			break;
		case 4 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/packageType.html?ts="+new Date().getTime());
			});
			break;
		case 5 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/intendedUse.html");
			});
			break;
		case 6 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/processingDegree.html?ts="+new Date().getTime());
			});
			break;
		case 7 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/storageCondition.html");
			});
			break;
		case 8 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/countryArea.html?ts="+new Date().getTime());
			});
			break;
		case 9 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/examineItem.html");
			});
			break;
		case 10 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/accessorySet.html?ts="+new Date().getTime());
			});
			break;
		case 11 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/additiveSet.html");
			});
			break;
		case 12 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/additivePurposeSet.html?ts="+new Date().getTime());
			});
			break;
		case 13 :
			$(this).click(function(){
				$("#right-content").empty().load("./html/processingWay.html");
			});
			break;
		}
	});
	
	
	
});