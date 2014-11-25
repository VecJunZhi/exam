$(document).ready(function(){
	
	
	
	
//	saveIntendedUse
$("#saveIntendedUse").click(function() {/*普通方式post*/
		
		var intendedUseID = $("#intendedUseID").val();
		var useCode = $("#useCode").val();
		var useName = $("#useName").val();
		var ifSet = 1;
		var user = {
				intendedUseID : intendedUseID,
				useCode:useCode,
				useName : useName,
				ifSet :ifSet
		};
		var jsonstr = JSON.stringify(user);
		alert(jsonstr);
		$.post("IntendedUseAction_SaveIntendedUse", {
				  data:jsonstr }, 
		    function(rdata) {  
			alert("rdata follow");
			alert(rdata);
			/*$("#result tbody").empty();
			alert("normal POST success");
			var $ctr = $("<tr></tr>").appendTo($("#result"));
			$("<td>" + rdata.id + "</td>").appendTo($ctr);
			$("<td>" + rdata.name + "</td>").appendTo($ctr);*/
		}, 'json');
});	
//SaveIntendedUseSub
$("#saveIntendedUseSub").click(function() {/*普通方式post*/
	
	var intendedUseSubID = $("#intendedUseSubID").val();
	var useCode = $("#useCode").val();
	var useCodeSub = $("#useCodeSub").val();
	
	var user = {
			intendedUseSubID : intendedUseSubID,
			useCode:useCode,
			useCodeSub : useCodeSub
			
	};
	var jsonstr = JSON.stringify(user);
	alert(jsonstr);
	$.post("IntendedUseAction_SaveIntendedUseSub", {
			  data:jsonstr }, 
	    function(rdata) {  
		alert("rdata follow");
		alert(rdata);
		/*$("#result tbody").empty();
		alert("normal POST success");
		var $ctr = $("<tr></tr>").appendTo($("#result"));
		$("<td>" + rdata.id + "</td>").appendTo($ctr);
		$("<td>" + rdata.name + "</td>").appendTo($ctr);*/
	}, 'json');
});	

//DelIntendedUse
$("#delIntendedUse").click(function() {/*普通方式post*/
	
	
	var useCode = $("#useCode").val();
	var user = {
			useCode:useCode
		};
	var jsonstr = JSON.stringify(user);
	alert(jsonstr);
	$.post("IntendedUseAction_DelIntendedUse", {
			  data:jsonstr }, 
	    function(rdata) {  
		alert("rdata follow");
		alert(rdata);
		/*$("#result tbody").empty();
		alert("normal POST success");
		var $ctr = $("<tr></tr>").appendTo($("#result"));
		$("<td>" + rdata.id + "</td>").appendTo($ctr);
		$("<td>" + rdata.name + "</td>").appendTo($ctr);*/
	}, 'json');
});
	
	
	
	
	
	
	
	
});