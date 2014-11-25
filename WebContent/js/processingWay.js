$(document).ready(function(){
	var curRow=null;
//页面刷新进入
	var columnproClass = [
		                  { "data": "methodCode" },
		                  { "data": "methodName" },
		      	          { "data": "ifSet" },
		                 ];
	var table = $('#processingWayTb').DataTable( {
		  "scrollX": true,
	      "deferRender": true,
		  "processing": true,
		  "serverSide": true,
		  "ajax":{
			  url : "SearchSelectAction_getProcessingMethod",
			  type : "GET",
			  data : {"methodName" : ""}    
		  },
	      "columns": columnproClass,
	  } );
	
	//点击新增，弹出对话框
	$("#addprocessingWay").click(function(){
		 $(".overlay").show();
		 $("#addprocessingWayDialog").show();   
	  });
	//点击取消，隐藏对话框
	 $("#closeaddprocessingWayDialogBtn").click(function(){
		  $(".overlay").hide();
	      $("#addprocessingWayDialog").hide(); 
	  });  
	 
	 
	//点击新增，置空，并填充表的左边(获取加工方式非集合数据)
	 $("#addprocessingWay").click(function() { 
			
			/*var id = $("#productClassid").val();
			var code = $("#classcode").val();
			var name = $("#classname").val();*/
		/*	var user = {
					
					methodName : ""
			};
			var jsonstr = JSON.stringify(user);
			alert(jsonstr);*/
			$.post("ProcessingWayAction_getProcessingMethod", 
					  {"methodName" : ""}, 
			    function(rdataobj) {  
				var rdataobj = eval("("+rdataobj+")");  
				showsetslist(rdataobj);
		}, 'json');
});
	
		
	//集合左边
	function showsetslist(rdataobj){
		$showlist=$($("#setsleftlistall")); 
		var ctbody=$("<tbody></tbody>").appendTo($showlist);
		for(i=0;i<rdataobj.data.length;i++){
		    var ctr=$("<tr></tr>").appendTo($(ctbody));
		    var ctd=$('<td width="20%"><input type="checkbox" name="checkbox_leftsets"></input></td>').appendTo($(ctr));
		    var ctd=$('<td width="25%">'+rdataobj.data[i].methodCode+'</td>').appendTo($(ctr));
		    var ctd=$('<td width="55%">'+rdataobj.data[i].methodName+'</td>').appendTo($(ctr));
			$(ctr).mouseover(function(){
				$(this).toggleClass('oddrow');
			});
			$(ctr).mouseout(function(){
				$(this).toggleClass("oddrow");     
			});
		}
	}
	//添加>>  集合左边到右边
	$("#addset").bind('click', function(){
		var count=0;
		setsarray = new Array();
		$("input[name='checkbox_leftsets']").each(function(index){
			    
		if($(this).prop("checked")){   //jquery1.6改进了$(this).attr("checked")
			    var temp=$(this).parents().next().html();
				temp=temp+" "+$(this).parents().next().next().html();
				setsarray[count]=temp;
				count++;
			}
		});
//
		 count=0;
 		 setscontent = new Array();
 		 $("#setsrightlistall tbody tr").each(function(index){
				var temp=$(this).children().eq(1).html();
				setscontent[count]=temp;
				count++;
		  });
 		 
		$showlist=$("#setsrightlistall");
		var ctbody=$("<tbody></tbody>").appendTo($showlist);
		for(i=0;i<setsarray.length;i++){
			var tempstring=setsarray[i].split(" ");
			var ifExist=false;
			for(j=0;j<setscontent.length;j++){
				if(tempstring[0]==setscontent[j]){ifExist=true;}
			}
			if(ifExist==false){
		    var ctr=$("<tr></tr>").appendTo($(ctbody));
		    var ctd=$('<td width="20%"><input type="checkbox" name="checkbox_rightsets"></input></td>').appendTo($(ctr));
		    var ctd=$('<td width="25%">'+tempstring[0]+'</td>').appendTo($(ctr));
		    var ctd=$('<td width="25%">'+tempstring[1]+'</td>').appendTo($(ctr));
			$(ctr).mouseover(function(){
				$(this).toggleClass("oddrow");
			});
			$(ctr).mouseout(function(){
				$(this).toggleClass("oddrow");
			});
			}				
		}
    });
	//移除<<  右边选择删除
	$("#delset").bind('click', function(){
		var count=0;
		setsarray = new Array();
		$("input[name='checkbox_rightsets']").each(function(index){
			if($(this).prop("checked")==false){
				var temp=$(this).parents().next().html();
				temp=temp+" "+$(this).parents().next().next().html();
				setsarray[count]=temp;
				count++;
			}
		});
		$("#setsrightlistall tbody").empty();   
		$showlist=$("#setsrightlistall");
		var ctbody=$("<tbody></tbody>").appendTo($showlist);
		for(i=0;i<setsarray.length;i++){
			var tempstring=setsarray[i].split(" ");
		    var ctr=$("<tr></tr>").appendTo($(ctbody));
		    var ctd=$('<td width="20%"><input type="checkbox" name="checkbox_rightsets"></input></td>').appendTo($(ctr));
		    var ctd=$('<td width="25%">'+tempstring[0]+'</td>').appendTo($(ctr));
		    var ctd=$('<td width="25%">'+tempstring[1]+'</td>').appendTo($(ctr));
		}
    });
	//保存时输入信息验证
	function ifvalidate(){
		var validate=true;
		if($("#processingWayCode").val()==''||$("#processingWayName").val()==''){validate=false;}
		return validate;
	}
	//保存
	$("#saveprocessingWayBtn").bind('click', function(){ 
		
		  if(ifvalidate()==true){ 
           if($($("input[name='ifsetsets']")).prop("checked")){
        	
          	 var ifsets="1";
          	 var setsdata={
          			processingMethodID:'0',  
          			methodName:$("#processingWayName").val(),
          			methodCode:$("#processingWayCode").val(),
          			ifSet:ifsets
          	 };
          	 var setsnamedata =JSON.stringify(setsdata);alert("ent");// $.toJSON(setsdata);alert("enfsfst");
       		 var processingWayCode = $("#processingWayCode").val();  
       		 var count=0;  
       		 setscontent = new Array();
       		 $("#setsrightlistall tbody tr").each(function(index){
      				var temp=$(this).children().eq(1).html();
      				alert("temp"+temp);
      				setscontent[count]=temp;
      				count++;
      		  });
       		 alert("ksf"+setscontent+setscontent.length);    
      		 $.post( 
      				"ProcessingWayAction_SaveProcessingMethodSub",
         				{processingMethodID:0,processingWayCode:processingWayCode,data:setsnamedata,setscontent:setscontent.toString()},
         				function(rdata) {
         					alert("kkk");
         					alert(rdata);
         					if(rdata=="true"){
         						SendShowTableRequest(pageSize,pageIndex);
         	  					$("#fuzzy").toggle();
         	  					clrAdd();
         					}
         				}, 
         				'json');
          	 }
           else{
          	 var ifsets="0";
          	 savesetsbasicdata(ifsets);
          	 $("#fuzzy").toggle();
          	 }           
		  }
		  else{alert("名称和代码不能为空！");}
  });
	//保存非集合数据
	function savesetsbasicdata(ifsets){
		 var setsdata={
				processingMethodID:0,
       			methodName:$("#processingWayName").val(),
       			methodCode:$("#processingWayCode").val(),
       			ifSet:ifsets
		 };
		 var setsnamedata = JSON.stringify(setsdata);
			 $.post( 
					 "ProcessingWayAction_SaveProcessingMethod?&ts="+new Date().getTime(),
				{processingMethodID:0,data:setsnamedata},
				function(rdata) {
					alert("ok");
					/*if(rdata=="true"){	
						SendShowTableRequest(pageSize,pageIndex);
				    clrAdd();
			        }*/
				}, 
				'json');
	}
	$('#processingWayTb tbody').on("click", "tr", clickRow );
	  //选中行变色
	  function clickRow(){
		  var row = this;
		  if ( $(row).hasClass('active') ) {  
			    curRow = null;
	            $(row).removeClass('active');
	        }
	        else {
	        	curRow = row;
	            table.$('tr.active').removeClass('active');
	            $(row).addClass('active');
	        }
	  }
	
	 //删除选中行
	  $('#deleteprocessingWay').click(delConvCtrlRule);  
	  function delConvCtrlRule(){
		  if(curRow == null){
			  alert("请先选择一条要删除的记录！");
			  return;
		  }
		  if(confirm("确定删除吗?")){  
			  var methodCode = table.row(curRow).data().methodCode;
			  alert(methodCode);
			  $.post("ProcessingWayAction_DelProcessingMethod?&ts="
						+ new Date().getTime(), {
							data:JSON.stringify({methodCode : methodCode})  
				}, function(rdata) {
					alert("del ok");
					table.row(curRow).remove().draw(false);
					/*if(rdata.data == "true"){
						alert("删除成功！");
						table.row(curRow).remove().draw(false);
					}*/
				}, 'json');
		  }

	  }
	//是否为集合动态加载
	/*$("#ifsetsets").bind('click', function(){
	    if($($("input[name='ifsetsets']")).attr("checked")){
	       SendListRquest();
	    }
	    else{
		    $("#setsleftlistall tbody").empty();
		    $("#setsrightlistall tbody").empty();
	    }
    });*/
	//获取集合数据
	function SendListRquest(){
	       $.post( 
				     "SetProcessingMethod!initial.action?&ts="+new Date().getTime(),
				     {nosense:"nosense"},
				     function(rdata) {
					                 var rdataobj = eval("("+rdata+")"); 
					                 showsetslist(rdataobj);
				                    }, 
				     'json');
	    }
	
});