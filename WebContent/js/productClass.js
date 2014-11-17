$(document).ready(
		function(){
			var curRow = null; //局部变量
			 var productClassCode=null;
			 var tables=null;
			
			  
	//页面进入加载产品大类
			var columnproClass = [
			                  { "data": null },
			                  { "data": "classCode" },
			      	          { "data": "className" },
			                 ];
			var table = $('#productClassTb').DataTable( {
				  "scrollX": true,
			      "deferRender": true,
				  "processing": true,
				  "serverSide": true,
				  "ajax":{
					  url : "SelectDataAction_getProductClass",
					  type : "GET",
					  data : function(d){
						  d.data = getRequestParam();
						 
					  }
				  },
			      "columns": columnproClass,
			      "columnDefs": [
			                     {
			                         "targets": [ 0 ],
			                         "visible": false,
			                     }
			                 ]
			  } );
			//点击选中某一行
			$('#productClassTb tbody').on("click", "tr", clickRow );
			$('#productClassTb tbody').on("click", "tr", puoSubclassDraw);
			
			//选中某一行
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
			  
			
			//table.row('tr:first').css('active');  
			   //    productClassCode = table.row('tr:first').data().classCode; 
				//		  alert(productClassCode);
			// getprosubclass();
			function puoSubclassDraw(){  
					 
					// productClassCode =	table.row(curRow).data().classCode;
					// getprosubclass(productClassCode);
				//tables.destroy(false);
			//	tables.clear(true); alert("kk");
				    getprosubclass();
					
					//return productClassCode; 
					
				}		
			var delayInterval = 400;
		    window.setTimeout(getprosubclass, delayInterval);
			function getprosubclass(){   
					//	alert("dfd");  
			//	var delayInterval = 1000;
			  //  window.setTimeout(getprosubclass, delayInterval);
				         if(tables == null){curRow="tr:first";}else{tables.destroy(false);}
						  var columnproSubClass = [
									                  { "data": "classCode" },
									      	          { "data": "subclassCode" },
					   				      	          { "data": "subclassName" },
									                 ]; 
					
							 tables = $('#productSubClassTb').DataTable( {
								  "scrollX": true,
							      "deferRender": true,
		  						  "processing": true,
								  "serverSide": true,
								   "retrieve": true,
								  /* "destroy": true, */
								  "ajax":{
									  url : "SelectDataAction_getProductSubclass",
									  type : "GET",
									  data :  /*function(d){
										      d.data = getRequestParam2();
										      alert("d.data"+d.data);*/
										    {"productClassCode" :  table.row(curRow).data().classCode+""}
							
									 // }
			  							 
									  
								  },
							      "columns": columnproSubClass,
							     /* "columnDefs": [
							                     {
							                         "targets": [ 0 ],
							                         "visible": false,
							                     }
							                 ]*/
								  });  
							
						  }
							
				 
			
			
			//获取请求参数
			  function getRequestParam(){
				  var data = {
						    productClassCode : getSelectValue("productClassCode"),
						    productClassName : getSelectValue("productClassName"),
						     };
				  var jsonstr = JSON.stringify(data);
				  
				  return jsonstr;
			  }
			  //
			  function getRequestParam2(){
				  if(productClassCode == null){productClassCode = table.row('tr:first').data().classCode;}
				  else { productClassCode = table.row(curRow).data().classCode;}
				  alert("code"+productClassCode);
				  var data = {
						    productClassCode : productClassCode
						   
						     };
				  var jsonstr = JSON.stringify(data);
				  
				  return jsonstr;
			  }
		
			
			//add productClass dialog show and hide
			 $("#addproductClass").click(function(){
				 $(".overlay").show();
				 $("#addproductClassDialog").show();   
			  });
			 $("#closeaddproductClassDialogBtn").click(function(){
				  $(".overlay").hide();
			      $("#addproductClassDialog").hide(); 
			  });
			 // update productClass dialog show and hide
			 $("#editproductClass").click(function(){
				 $(".overlay").show();
				 $("#updateproductClassDialog").show();   
			  });
			 $("#closeupdateproductClassDialogBtn").click(function(){
				  $(".overlay").hide();
			      $("#updateproductClassDialog").hide();   
			  });
			//add productSubClass dialog show and hide
			 $("#addproductSubClass").click(function(){
				 $(".overlay").show();
				 $("#addproductSubClassDialog").show();   
			  });
			 $("#closeaddproductSubClassDialogBtn").click(function(){
				  $(".overlay").hide();
			      $("#addproductSubClassDialog").hide(); 
			  });
			 // update productSubClass dialog show and hide
			 $("#editproductSubClass").click(function(){
				 $(".overlay").show();
				 $("#updateproductSubClassDialog").show();   
			  });
			 $("#closeupdateproductSubClassDialogBtn").click(function(){
				  $(".overlay").hide();
			      $("#updateproductSubClassDialog").hide();   
			  });
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
/*			 
			  var pageSize = 10;
			  var pageIndex = 1;   
			  var rowIndex = 0;
			  var totalPage = 1;
//产品大类--分页显示
	     function ShowProductClassTable(wpageSize,wpageIndex,wdivdisplaytable){           
				  rowIndex=parseInt(wpageSize)*(parseInt(wpageIndex)-1);  
				  var user = {
						  pageSize:wpageSize,
						  rowIndex:rowIndex
					};
					var jsonstr = JSON.stringify(user);
					alert(jsonstr);
					$.post(                                     
							"ProductClassAction_getProductClass",{
							data:jsonstr},                        
							function(rdata){
								alert("rdata follow");
								alert(rdata);
								var rdataobj=eval("("+rdata+")");  
								alert(rdataobj);
								//totalPage=Math.ceil(rdataobj.totalCount/wpageSize);   	
								totalPage=parseInt(parseInt(rdataobj.totalCount-1)/wpageSize)+1;
								ShowTable(rdataobj,$(wdivdisplaytable));						
								$("#pageIndex").html(wpageIndex);	                       
								$("#totalPage").html(totalPage);                           
							},
							"json");
				}
	  //   ShowProductClassTable(pageSize,pageIndex, $("div"));
//产品小类--分页显示
	     function ShowSubProductClassTable(wpageSize,wpageIndex,wdivdisplaytable){           
				  rowIndex=parseInt(wpageSize)*(parseInt(wpageIndex)-1);  
				  var code = $("#classcode").val();
				  var user = {
						  classCode:code,
						  pageSize:wpageSize,
						  rowIndex:rowIndex
					};
					var jsonstr = JSON.stringify(user);
					alert(jsonstr);
					$.post(                                     
							"ProductClassAction_getSubProductClass",{
							data:jsonstr},                        
							function(rdata){
								alert("rdata follow");
								alert(rdata);
								var rdataobj=eval("("+rdata+")");  
								alert(rdataobj);
								//totalPage=Math.ceil(rdataobj.totalCount/wpageSize);   	
								totalPage=parseInt(parseInt(rdataobj.totalCount-1)/wpageSize)+1;
								ShowTable(rdataobj,$(wdivdisplaytable));						
								$("#pageIndex").html(wpageIndex);	                       
								$("#totalPage").html(totalPage);                           
							},
							"json");
				}
	  ShowSubProductClassTable(pageSize,pageIndex, $("div"));	     
//saveproClass			
$("#saveproClass").click(function() {普通方式post
			
				var id = $("#productClassid").val();
				var code = $("#classcode").val();
				var name = $("#classname").val();
				var user = {
						productClassID : id,
						classCode:code,
						className : name
				};
				var jsonstr = JSON.stringify(user);
				alert(jsonstr);
				$.post("ProductClassAction_saveProClass", {
						  data:jsonstr }, 
				    function(rdata) {  
					alert("rdata follow");
					alert(rdata);
					$("#result tbody").empty();
					alert("normal POST success");
					var $ctr = $("<tr></tr>").appendTo($("#result"));
					$("<td>" + rdata.id + "</td>").appendTo($ctr);
					$("<td>" + rdata.name + "</td>").appendTo($ctr);
				}, 'json');
});
			
//saveSubProClass
$("#saveSubproClass").click(function() {普通方式post
				
				var id = $("#prosubclassid").val();
				var code = $("#procode").val();
				var subcode = $("#subclasscode").val();
				var subname = $("#subclassname").val();
				var user = {
						productSubclassID : id,
						classCode:code,
						subclassCode : subcode,  
						subclassName : subname
				};
				var jsonstr = JSON.stringify(user); 
				alert(jsonstr);
				$.post("ProductClassAction_saveSubProductClass", {
						  data:jsonstr }, 
				    function(rdata) {  
					alert("rdata follow");
					alert(rdata);
					$("#result tbody").empty();
					alert("normal POST success");
					var $ctr = $("<tr></tr>").appendTo($("#result"));
					$("<td>" + rdata.id + "</td>").appendTo($ctr);
					$("<td>" + rdata.name + "</td>").appendTo($ctr);
				}, 'json');
			});
	
//deleteProductClass
$("#deleteSubproClass").click(function() {普通方式post
	
				var id = $("#productClassid").val();
				var user = {
						productClassID : id,
				};
				var jsonstr = JSON.stringify(user); 
				alert(jsonstr);
				$.post("ProductClassAction_deleteProductClass", {
						  data:jsonstr }, 
				    function(rdata) {  
					alert("rdata follow");
					alert(rdata);
					$("#result tbody").empty();
					alert("normal POST success");
					var $ctr = $("<tr></tr>").appendTo($("#result"));
					$("<td>" + rdata.id + "</td>").appendTo($ctr);
					$("<td>" + rdata.name + "</td>").appendTo($ctr);
				}, 'json');
});	
	
//deleteSubProductClass	
$("#deleteSubProductClass").click(function() {普通方式post
	
				var id = $("#prosubclassid").val();
				var user = {
						productSubclassID : id,
				};
				var jsonstr = JSON.stringify(user); 
				alert(jsonstr);
				$.post("ProductClassAction_deleteSubProductClass", {
						  data:jsonstr }, 
				    function(rdata) {  
					alert("rdata follow");
					alert(rdata);
					$("#result tbody").empty();
					alert("normal POST success");
					var $ctr = $("<tr></tr>").appendTo($("#result"));
					$("<td>" + rdata.id + "</td>").appendTo($ctr);
					$("<td>" + rdata.name + "</td>").appendTo($ctr);
				}, 'json');
});	*/
	
	
	
	




	
	
	
	
	
});