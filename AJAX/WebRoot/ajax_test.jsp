<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'ajax_test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<script type="text/javascript" src="./js/ajax.js"></script>
	
	<script type="text/javascript">
		
	
		//? ajax.js中的脚本有问题，onreadystatechange方法不能回调
	
		// 测试通过封装的Ajax获取text
		// 获取text的回调函数，
		
		function onDataText(data){
			alert(data);
		}
		
		
		
		function testText(){
			var ajax = new Ajax();
			var url = "servlet/AjaxServlet?action=text&timeStamp="+new Date().getTime();
			ajax.send(url, "text", onDataText);
			
		}
			
		// 测试通过封装的Ajax获取xml
		
		function onDataXml(data){
			// 获取省的元素
			var provinceElements = data.getElementsByTagName("province");
			// 打印省的元素的集合
			alert(provinceElements.length);
			for(var i=0; i < provinceElements.length ; i++){
				alert(provinceElements[i].getAttribute("name"));
			}
		}
		
		
		function testXml(){
			var ajax = new Ajax();
			var url = "servlet/AjaxServlet?action=xml&timeStamp="+new Date().getTime();
			ajax.send(url, "xml", onDataXml);
		}
		
		// 测试通过封装的Ajax获取json数据		
		function onDataJson(data){
			for(var i=0; i<data.length; i++ ){
				alert(data[i].pid + "     " + data[i].pname);
			}
		}
		
		function testJson(){
			var ajax = new Ajax();
			var url = "servlet/AjaxServlet?action=json&timeStamp="+new Date().getTime();
			ajax.send(url, "json", onDataJson);
		}
		
			
	</script>
	
  </head>
  
  <body>
  
 	 <input type="button" value="测试通过Ajax获取text" onclick="testText()"  />&nbsp;&nbsp;
 	 <input type="button" value="测试通过Ajax获取xml" onclick="testXml()" />&nbsp;&nbsp;
 	 <input type="button" value="测试通过Ajax获取json" onclick="testJson()" />&nbsp;&nbsp;
 	 
  </body>
</html>
