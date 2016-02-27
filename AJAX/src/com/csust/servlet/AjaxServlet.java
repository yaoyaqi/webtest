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
		
		//����action���صĲ�ֵͬ�����в�ͬ�Ĳ���
		if("text".equals(action)){
			this.doText(request, response);
		}else if("xml".equals(action)){
			this.doXml(request,response);
		}else if("json".equals(action)){
			this.doJson(request, response);
		}
		
		
	}
	
	/**
	 * ����Ҫ����json��ʽ������ʱ�����иò���
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void doJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<Province> list = new ArrayList<Province>();
		Province p1 = new Province(1, "����ʡ");
		Province p2 = new Province(2, "����ʡ");
		Province p3 = new Province(3, "ɽ��ʡ");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		//�����γ�json�ַ��������ã����������䲻����list�е�ĳ������,�˴����˵���pid
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"pid"});
		
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig );
		out.print(jsonArray.toString());
	}

	
	/**
	 * ����Ҫ���ص�xml�ı�ʱ�����иò���
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void doXml(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<china>");
		out.println("<province name='����ʡ'>");
		out.println("</province>");
		
		out.println("<province name='����ʡ'>");
		out.println("</province>");
		
		out.println("<province name='ɽ��ʡ'>");
		out.println("</province>");
		out.println("</china>");
	}

	/**
	 * ����Ҫ���ص���text�ı�ʱ�����иò���
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
