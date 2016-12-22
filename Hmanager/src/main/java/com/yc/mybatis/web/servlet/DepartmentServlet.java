package com.yc.mybatis.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.yc.mybatis.entity.Department;
import com.yc.mybatis.service.DpService;
import com.yc.mybatis.service.impl.DpServiceImpl;

@WebServlet("/dp/*")
public class DepartmentServlet extends BaseServlet {
	private static final long serialVersionUID = 513537102242703475L;
	private DpService dpServcie;

	public DepartmentServlet() {
		dpServcie = new DpServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUriStr = req.getRequestURI();
		if (reqUriStr.endsWith("list")) {
			doList(req, resp);
		}else if(reqUriStr.endsWith("add")) {
			doAdd(req, resp);
		}else if(reqUriStr.endsWith("getMsg")) {
			doGetById(req, resp);
		}else if(reqUriStr.endsWith("modify")) {
			doModify(req, resp);
		}else if(reqUriStr.endsWith("archive")) {
			doArch(req, resp);
		}
	}

	private void doArch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pid = req.getParameter("cnid");
		boolean isSuccess = dpServcie.ArchiveDp(Integer.parseInt(pid));
		respOutStr(resp,isSuccess+"");
	}

	private void doModify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SmartUpload su = getSmartUpload(req, resp);
		Request req1 = su.getRequest();
		Department dp=getReqParam2Obj(req1, Department.class);
		boolean flag=dpServcie.modifyDp(dp);
		respOutStr(resp,flag+"");
	}

	private void doGetById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String dpid=req.getParameter("cnid");
		Department dp=dpServcie.getMsgById(Integer.parseInt(dpid));
		respOutStr(resp, toJsonStr(dp));
	}

	private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SmartUpload su = getSmartUpload(req, resp);
		Request req1 = su.getRequest();
		Department dp=getReqParam2Obj(req1, Department.class);
		boolean flag=dpServcie.addDp(dp);
		System.out.println("--------------"+flag);
		respOutStr(resp,flag+"");
	}

	private void doList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Department> department=dpServcie.getAllDp();
		System.out.println("=========="+department);
		respOutStr(resp, toJsonStr(department));
	}

}
