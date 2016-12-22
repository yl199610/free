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
import com.yc.mybatis.entity.Money;
import com.yc.mybatis.entity.Person;
import com.yc.mybatis.service.DpService;
import com.yc.mybatis.service.MoneyService;
import com.yc.mybatis.service.impl.DpServiceImpl;
import com.yc.mybatis.service.impl.MoneyServiceImpl;

@WebServlet("/money/*")
public class MoneyServlet extends BaseServlet {
	private static final long serialVersionUID = 513537102242703475L;
	private MoneyService moneyService;

	public MoneyServlet() {
		moneyService = new MoneyServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUriStr = req.getRequestURI();
		if (reqUriStr.endsWith("list")) {
			doList(req, resp);
		}else if(reqUriStr.endsWith("add")) {
			doAdd(req, resp);
		}else if(reqUriStr.endsWith("getMsg")) {
			doGetMsg(req, resp);
		}else if(reqUriStr.endsWith("getBy")) {
			dogetBy(req, resp);
		}else if(reqUriStr.endsWith("modify")) {
			doModify(req, resp);
		}else if(reqUriStr.endsWith("arch")) {
			doArch(req, resp);
		}else if (reqUriStr.endsWith("getOnePerson")) {
			doGetOne(req, resp);
		}
	}

	private void doGetOne(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pid=req.getParameter("pid");
		List<Money> money=moneyService.getAllMoneyByid(Integer.parseInt(pid));
		System.out.println(money);
		respOutStr(resp, toJsonStr(money));
	}


	private void doArch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String paid = req.getParameter("cnid");
		boolean isSuccess = moneyService.ArchiveMoney(Integer.parseInt(paid));
		respOutStr(resp,isSuccess+"");
	}

	private void doModify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SmartUpload su = getSmartUpload(req, resp);
		Request req1 = su.getRequest();
		Money dp=getReqParam2Obj(req1, Money.class);
		dp.setPaid(Integer.parseInt(req.getParameter("cnid")));
		boolean flag=moneyService.modifyMoney(dp);
		respOutStr(resp,flag+"");
	}

	private void dogetBy(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String paid=req.getParameter("personid");
		Person person=moneyService.getById(Integer.parseInt(paid));
		respOutStr(resp, toJsonStr(person));
	}

	private void doGetMsg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String paid=req.getParameter("cnid");
		Money money=moneyService.getMsgById(Integer.parseInt(paid));
		respOutStr(resp, toJsonStr(money));
	}

	private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SmartUpload su = getSmartUpload(req, resp);
		Request req1 = su.getRequest();
		Money money=getReqParam2Obj(req1, Money.class);
		respOutStr(resp,moneyService.addMoney(money)+"");
	}

	private void doList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Money> money=moneyService.getAllMoney();
		respOutStr(resp, toJsonStr(money));
	}

}
