$(document).ready(function() {
	//点击左侧二级菜单的显示
	$(".submenu > a").click(function(e) {
		e.preventDefault(); /*取消事件的默认动作。*/
		var $li = $(this).parent("li");
		var $ul = $(this).next("ul");

		if ($li.hasClass("open")) {
			$ul.slideUp(350);
			$li.removeClass("open");
		} else {
			
			$(".nav > li > ul").slideUp(350);
			$(".nav > li").removeClass("open");
			$ul.slideDown(350);
			$li.addClass("open");
		}
	});

});

$.extend( $.fn.dataTable.defaults, { /* jQuery EasyUI 数据网格 - 扩展编辑器*/
    "searching": false,
    "ordering": false,
    "retrieve": true,
    "pagingType": "full_numbers",
    "dom" : 'rt<"bottom"lip><"clear">',
    "language": {
        "url": "vendors/datatables/chinese.lang.json"
    }
} );

/*自定义autocomplete
 * collection ： 绑定的数据集合
 * input_id : input id
 * btn_id : 下拉按钮 id
 * create_cb : 创建时的回调，可选
 * select_cb : 选中条目后的回调 
 * */
function cus_autocomplete(collection, input_id, btn_id, create_cb, select_cb){
	
	$("#"+input_id).autocomplete({
		source : collection,
		minLength : 0,		
		create : create_cb, /*Autocomplete创建时，可以在此事件中，对外观进行一些控制*/
		open : function(event, ui){ /*Autocomplete的结果列表弹出时*/
			var menuWidth = $(this).outerWidth() +  $("#"+btn_id).outerWidth();
	        $(this).autocomplete( "widget" ).width(menuWidth);/*$(this).autocomplete( "widget" )返回一个包含菜单元素的 jQuery 对象*/
		},
		select : select_cb,	/*Autocomplete的结果列表任意一项选中时，ui.item为选中的项*/	
	});
	if(btn_id != null){
		$("#"+btn_id).off("click");
		$("#"+btn_id).click(
			function() {	
				$("#"+input_id).autocomplete("search", "");/*	触发 search 事件，如果该事件未被取消则调用数据源。当被点击时，可被类似选择框按钮用来打开建议。当不带参数调用该方法时，则使用当前输入的值。可带一个空字符串和 minLength: 0 进行调用，来显示所有的条目*/
				$("#"+input_id).focus();
		});		
	}
 }

/**
 * 获取select中的编码，select中数据格式为：code+" "+name.
 * 获取请求数据
 * @param selectId
 * @returns
 */
function getSelectValue(selectId){
	var val = $("#"+selectId).val();
	var code =  val == null ? "" : val.split(" ")[0];
	//split是一个字符串截取的函数截取后用数组的形式存取 然后通过索引读取想要的那个字符串
	return code;
}

/**
 * 初始化各个内容块高度
 */
function initContentDivHeight() {
	var windowHeight = $(window).height();
	var headerHeight = $(".header").outerHeight();  /*函数用于设置或返回当前匹配元素的外高度*/
	var contentHeight = $(".page-content").outerHeight();
	var footerHeight = $("footer").outerHeight();
	var minContHeight = windowHeight - headerHeight - footerHeight - 30;
	if (minContHeight > contentHeight) {
		$(".page-content").height(minContHeight);  
		//alert("init content if："+windowHeight+"-header"+headerHeight+"-content"+contentHeight+"-foot"+footerHeight);
	}
	
}

	