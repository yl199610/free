package com.yc.mybatis.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import com.google.gson.Gson;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	//response响应处理对象
	//outStr响应的数据
	protected void respOutStr(HttpServletResponse response,String outStr) throws IOException{
		PrintWriter out=response.getWriter();//响应流对象
		out.println(outStr);
		out.flush();
		out.close();
	}
	
	protected String toJsonStr(Object obj){
		Gson gson=new Gson();
		return gson.toJson(obj);
	}
	protected SmartUpload getSmartUpload(HttpServletRequest req, HttpServletResponse resp) {
		try {
			SmartUpload su=new SmartUpload();
			su.setCharset("utf-8");
			su.initialize(getServletConfig(), req, resp);
			su.upload();
			return su;
		} catch (ServletException | SmartUploadException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	Class为类   ， 接口的类型  类似int为整形的类型
//	UserServlet.class的类型是Class.  类似3的类型是int
//	Class为类的抽象
	protected<T> T getReqParam2Obj(HttpServletRequest request, Class<T> clazz) {
		//1 取到要转换成的对象的实例
		T t=null;
		try {
			t=clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			LogManager.getLogger().error("创建"+clazz.getName()+"实例化失败");
		}
		//2 取到所有的请求参数
		Enumeration<String> paramNames=request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String valName=paramNames.nextElement();
			String val=request.getParameter(valName);
			//3 根据请求参数名  通过反射取到对应的实体类中的方法对象
			String suff=String.format("et%c%s",Character.toUpperCase(valName.charAt(0)),valName.substring(1));
			try {
				Class<?> paramType=clazz.getMethod("g"+suff).getReturnType();//取到getXxx()方法的返回类型的类的类对象
				Method sm=clazz.getMethod("s"+suff,paramType);
				if(paramType.getName().intern()==int.class.getName().intern()||
						paramType.getName().intern()==Integer.class.getName().intern()){
					sm.invoke(t,Integer.parseInt(val));
				}else if(paramType.getName().intern()==double.class.getName().intern()||
						paramType.getName().intern()==Double.class.getName().intern()){
					sm.invoke(t,Double.parseDouble(val));
				}else{
					sm.invoke(t,val);
				}
			} catch (NumberFormatException | SecurityException e) {
				LogManager.getLogger().warn("在"+clazz.getName()+"中没有对应的"+e.getMessage()+"方法");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				LogManager.getLogger().warn(e.getMessage()+"转换的有参数格式不正确，转换数据类型失败");
			}catch (NoSuchMethodException e) {
				LogManager.getLogger().warn(e.getMessage()+"没有匹配的方法");
			}
		}
		return t;
	}
	
	protected <T> T getReqParam2Obj(Request request, Class<T> clazz) {
		// 1.取到要转换成的对象的实例
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			LogManager.getLogger().error("创建" + clazz.getName() + "实例对象失败!!!");
		}

		// 2.取到所有的请求参数名
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String valName = paramNames.nextElement();
			String val = request.getParameter(valName);
			// 3.根据请求参数名，通过反射取到对应的实体类中的方法对象
			String suff = String.format("et%c%s", Character.toUpperCase(valName.charAt(0)), valName.substring(1));

			try {
				Class<?> paramType = clazz.getMethod("g" + suff).getReturnType(); // 取到getXxx()方法的返回类型的类的类对象
				Method sm = clazz.getMethod("s" + suff, paramType); // 取到setXxx()方法对象

				if (paramType.getName().intern() == int.class.getName().intern() || 
						paramType.getName().intern() == Integer.class.getName().intern()) {
					sm.invoke(t, Integer.parseInt(val));
				} else if (paramType.getName().intern() == double.class.getName().intern() || 
						paramType.getName().intern() == Double.class.getName().intern()) {
					sm.invoke(t, Double.parseDouble(val));
				} else {
					sm.invoke(t, val);
				}
			} catch (NoSuchMethodException | SecurityException e) {
				LogManager.getLogger().warn("在" + clazz.getName() + "中没有对应" + e.getMessage() + "方法");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				LogManager.getLogger().warn(e.getMessage() + "转换入有参数格式不正确，转换数据类型失败");
			}
		}
		return t;
	}
}
