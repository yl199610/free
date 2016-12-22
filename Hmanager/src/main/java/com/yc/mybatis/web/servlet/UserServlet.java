package com.yc.mybatis.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.CloseableThreadContext.Instance;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yc.mybatis.entity.Department;
import com.yc.mybatis.entity.Manager;
import com.yc.mybatis.entity.Money;
import com.yc.mybatis.entity.PaginationBean;
import com.yc.mybatis.entity.Person;
import com.yc.mybatis.service.UserService;
import com.yc.mybatis.service.impl.UserServiceImpl;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 513537102242703475L;
	private UserService userService;
	private String mid;
	public UserServlet() {
		userService = new UserServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUriStr = req.getRequestURI();
		if (reqUriStr.endsWith("login")) {
			doLogin(req, resp);
		}else if (reqUriStr.endsWith("add")) {
			doAdd(req, resp);
		}else if (reqUriStr.endsWith("getPerson")) {
			doGetPerson(req, resp);
		}else if (reqUriStr.endsWith("list")) {
			doList(req, resp);
		}else if (reqUriStr.endsWith("modify")) {
			doModify(req, resp);
		}else if (reqUriStr.endsWith("archive")) {
			doArch(req, resp);
		}else if (reqUriStr.endsWith("getAllPerson")) {
			doGetAll(req, resp);
		}
	}

	private void doGetAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Person> person=userService.getAllPersson();
		respOutStr(resp, toJsonStr(person));
	}

	private void doArch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pid = req.getParameter("cnid");
		boolean isSuccess = userService.ArchivePerson(Integer.parseInt(pid));
		respOutStr(resp,isSuccess+"");
	}

	private void doModify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SmartUpload su = getSmartUpload(req, resp);
		Request req1 = su.getRequest();// jspsmart的request
		File f = su.getFiles().getFile(0);
		if (!f.isMissing()) {
			String path = new java.io.File(getServletContext().getRealPath("/")).getParent() + "\\upload\\"
					+ f.getFileName();
			System.out.println("文件的位置" + path);
			try {
				f.saveAs(path, SmartUpload.SAVE_PHYSICAL);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
		}
		Person person = getReqParam2Obj(req1, Person.class);
		person.setPhoto("image/" + f.getFileName());
		respOutStr(resp, toJsonStr(userService.modifyUser(person)));
	}

	private void doGetPerson(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pid=req.getParameter("cnid");
		respOutStr(resp, toJsonStr(userService.getPersonById(Integer.parseInt(pid))));
	}

	private void doList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		Person person=new Person();
//		Department department=new Department();
//		List<Department> dp=new ArrayList<Department>();
		String currPage = req.getParameter("page");
		String pageSize = req.getParameter("rows");
		PaginationBean<Person> userBean = userService.listPartUsers(currPage, pageSize);
//		List<Person> p=userBean.getRows();
//		for (int i = 0; i < p.size(); i++) {
//			int personid=p.get(i).getPid();
//			System.out.println(personid);
//			person=userService.getDpNameById(personid);
//			department=person.getDepartment();
//			dp.add(department);
//		}
		System.out.println(userBean);
		respOutStr(resp, toJsonStr(userBean));
	}

	private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Person n=new Person();
		String pid=req.getParameter("pid");
		SmartUpload su=new SmartUpload();
		su.setCharset("utf-8");
		su.initialize(getServletConfig(), req, resp);
		boolean isSuccess=false;
		try {
			su.upload();
			Request request=su.getRequest();
			Files fs=su.getFiles();//取得所有的上传文件对象
			File f=fs.getFile(0);
			String file=f.getFileName();
			String InsertPath=null;
			if(file.equals("")){
				InsertPath="image/not_pic.jpg";
			}else{
				InsertPath="image"+"/"+file;//虚拟路径
			}
			f.saveAs(InsertPath,SmartUpload.SAVE_VIRTUAL);//上传到哪个目录
			n=getReqParam2Obj(request, Person.class);
			n.setPersonid(Integer.parseInt(pid));
			if(req.getParameter("ppower").equals("1")){
				n.setPpower("普通用户");
			}else{
				n.setPpower("管理员");
			}
			n.setPhoto(InsertPath);
			isSuccess=userService.addPerson(n);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}finally{
			respOutStr(resp,isSuccess+"");  //把对象转换成json字符串,做为响应数据
		}
	}


	// 登陆处理
	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Manager manager = getReqParam2Obj(req, Manager.class);
		if(manager.getUpower().equals("管理员")){
			respOutStr(resp, userService.login(manager) + "");
		}else{
			mid=req.getParameter("mid");
			String pwd=req.getParameter("pwd");
			String ppower=req.getParameter("upower");
			req.getSession().setAttribute("login",mid);
			Person p=new Person();
			p.setPid(Integer.parseInt(mid));
			p.setPersonid(Integer.parseInt(pwd));
			p.setPpower(ppower);
			respOutStr(resp, userService.selectPerson(p)+"1");
		}
	}
}
