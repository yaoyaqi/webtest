package com.csust.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.csust.bean.Province;

public class AjaxServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String action = request.getParameter("action");
		
		//根据action返回的不同值，进行不同的测试
		if("text".equals(action)){
			this.doText(request, response);
		}else if("xml".equals(action)){
			this.doXml(request,response);
		}else if("json".equals(action)){
			this.doJson(request, response);
		}
		
		
	}
	
	/**
	 * 当需要返回json格式的数据时，进行该测试
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void doJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<Province> list = new ArrayList<Province>();
		Province p1 = new Province(1, "吉林省");
		Province p2 = new Province(2, "辽宁省");
		Province p3 = new Province(3, "山东省");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		//用于形成json字符串的配置，可以配置其不包括list中的某个属性,此处过滤掉了pid
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"pid"});
		
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig );
		out.print(jsonArray.toString());
	}

	
	/**
	 * 但需要返回的xml文本时，进行该测试
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void doXml(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<china>");
		out.println("<province name='吉林省'>");
		out.println("</province>");
		
		out.println("<province name='辽宁省'>");
		out.println("</province>");
		
		out.println("<province name='山东省'>");
		out.println("</province>");
		out.println("</china>");
	}

	/**
	 * 当需要返回的是text文本时，进行该测试
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doText(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		System.out.println("yaoqiya");
		out.print("yaoqiya");
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
