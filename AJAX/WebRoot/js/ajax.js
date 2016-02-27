
	//注意：js文件要设为utf-8编码，否则可能出现乱码情况，即与jsp的编码一致	

	function createXmlReq(){
		var xmlHttp = null;
		try{//Firefox、Opera 8.0+、Safari
			xmlHttp = new XMLHttpRequest();
		}
		catch(e){
			try{//IE 
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch(e){
				try{
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch(e){
				}
			}
		}
		return xmlHttp;
	}	
		
		
	function Ajax(){
		var xmlReq = createXmlReq();
		
		// 创建Ajax的send方法，用于处理不同类型的请求， 得到的数据交由onData方法处理
		this.send = function(url, type, onData){
			
			xmlReq.onreadystatechange = function(){
				
				if(xmlReq.readyState == 4){
					
					if(xmlReq.status == 200 || this.xmlReq.status == 304){
						
						if("text" == type){//对“text”的类别进行处理
							onData(xmlReq.responseText);
						}else if("xml" == type){//对“xml”的类别进行处理
							onData(xmlReq.responseXML);
						}else if ("json" == type){//对“json”的类别进行处理
							var data = xmlReq.responseText;
							var dataObj = eval("("+data+")");
							onData(dataObj);
						}
					}
				}
			};
			
			xmlReq.open("post",url, true);
			
			
			xmlReq.setRequestHeader("Content-Type" , "application/x-www-form-urlencoded");
			xmlReq.send(null);
		};
		
	}
	
	
	
	
	
	