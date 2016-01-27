package org.jeecgframework.web.system.controller.core;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.model.json.ImportFile;
import org.jeecgframework.core.tag.vo.easyui.Autocomplete;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.platform.common.tag.easyui.TagUtil;
import org.jeecgframework.platform.constant.Globals;
import org.jeecgframework.platform.util.FileUtils;
import org.jeecgframework.platform.util.ReflectHelper;
import org.jeecgframework.web.system.controller.BaseController;
import org.jeecgframework.web.system.entity.base.TSAttachment;
import org.jeecgframework.web.system.service.ResourceService;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.utils.JSONHelper;
import org.jeecgframework.web.utils.MyClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * 通用业务处理
 * 
 * @author 张代浩
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/commonController")
public class CommonController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CommonController.class);
	private SystemService systemService;
	private String message;
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	/**
	 * 通用列表页面跳转
	 */
	@RequestMapping(params = "listTurn")
	public ModelAndView listTurn(HttpServletRequest request) {
		String turn = request.getParameter("turn");// 跳转的目标页面
		return new ModelAndView(turn);
	}

	/**
	 * 附件预览页面打开链接
	 * 
	 * @return
	 */
	@RequestMapping(params = "openViewFile")
	public ModelAndView openViewFile(HttpServletRequest request) {
		String fileid = request.getParameter("fileid");
		String subclassname = oConvertUtils.getString(request.getParameter("subclassname"), "org.jeecgframework.web.system.pojo.base.TSAttachment");
		String contentfield = oConvertUtils.getString(request.getParameter("contentfield"));
		Class fileClass = MyClassLoader.getClassByScn(subclassname);// 附件的实际类
		Object fileobj = systemService.findEntity(fileClass, fileid);
		ReflectHelper reflectHelper = new ReflectHelper(fileobj);
		String extend = oConvertUtils.getString(reflectHelper.getMethodValue("extend"));
		if ("dwg".equals(extend)) {
			String realpath = oConvertUtils.getString(reflectHelper.getMethodValue("realpath"));
			request.setAttribute("realpath", realpath);
			return new ModelAndView("common/upload/dwgView");
		} else if (FileUtils.isPicture(extend)) {
			String realpath = oConvertUtils.getString(reflectHelper.getMethodValue("realpath"));
			request.setAttribute("realpath", realpath);
			request.setAttribute("fileid", fileid);
			request.setAttribute("subclassname", subclassname);
			request.setAttribute("contentfield", contentfield);
			return new ModelAndView("common/upload/imageView");
		} else {
			String swfpath = oConvertUtils.getString(reflectHelper.getMethodValue("swfpath"));
			request.setAttribute("swfpath", swfpath);
			return new ModelAndView("common/upload/swfView");
		}

	}

	/**
	 * 附件预览读取
	 * 
	 * @return
	 */
	@RequestMapping(params = "viewFile")
	public void viewFile(HttpServletRequest request, HttpServletResponse response) {
		String fileid =oConvertUtils.getString(request.getParameter("fileid"));
		String subclassname = oConvertUtils.getString(request.getParameter("subclassname"), "com.jeecg.base.pojo.TSAttachment");
		Class fileClass = MyClassLoader.getClassByScn(subclassname);// 附件的实际类
		Object fileobj = systemService.findEntity(fileClass, fileid);
		ReflectHelper reflectHelper = new ReflectHelper(fileobj);
		UploadFile uploadFile = new UploadFile(request, response);
		String contentfield = oConvertUtils.getString(request.getParameter("contentfield"), uploadFile.getByteField());
		byte[] content = (byte[]) reflectHelper.getMethodValue(contentfield);
		String path = oConvertUtils.getString(reflectHelper.getMethodValue("realpath"));
		String extend = oConvertUtils.getString(reflectHelper.getMethodValue("extend"));
		String attachmenttitle = oConvertUtils.getString(reflectHelper.getMethodValue("attachmenttitle"));
		uploadFile.setExtend(extend);
		uploadFile.setTitleField(attachmenttitle);
		uploadFile.setRealPath(path);
		uploadFile.setContent(content);
		//uploadFile.setView(true);
		resourceService.viewOrDownloadFile(uploadFile);
	}

	@RequestMapping(params = "importdata")
	public ModelAndView importdata() {
		return new ModelAndView("system/upload");
	}

	/**
	 * 生成XML文件
	 * 
	 * @return
	 */
	@RequestMapping(params = "createxml")
	public void createxml(HttpServletRequest request, HttpServletResponse response) {
		String field = request.getParameter("field");
		String entityname = request.getParameter("entityname");
		ImportFile importFile = new ImportFile(request, response);
		importFile.setField(field);
		importFile.setEntityName(entityname);
		importFile.setFileName(entityname + ".bak");
		importFile.setEntityClass(MyClassLoader.getClassByScn(entityname));
		resourceService.createXml(importFile);
	}

	/**
	 * 生成XML文件parserXml
	 * 
	 * @return
	 */
	@RequestMapping(params = "parserXml")
	@ResponseBody
	public AjaxJson parserXml(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson json = new AjaxJson();
		String fileName = null;
		UploadFile uploadFile = new UploadFile(request);
		String ctxPath = request.getSession().getServletContext().getRealPath("");
		File file = new File(ctxPath);
		if (!file.exists()) {
			file.mkdir();// 创建文件根目录
		}
		MultipartHttpServletRequest multipartRequest = uploadFile.getMultipartRequest();
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile mf = entity.getValue();// 获取上传文件对象
			fileName = mf.getOriginalFilename();// 获取文件名
			String savePath = file.getPath() + "/" + fileName;
			File savefile = new File(savePath);
			try {
				FileCopyUtils.copy(mf.getBytes(), savefile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		resourceService.parserXml(ctxPath + "/" + fileName);
		json.setSuccess(true);
		return json;
	}

	/**
	 * 自动完成请求返回数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "getAutoList")
	public void getAutoList(HttpServletRequest request, HttpServletResponse response, Autocomplete autocomplete) {
		String jsonp = request.getParameter("jsonpcallback");
		String trem = StringUtil.getEncodePra(request.getParameter("trem"));// 重新解析参数
		autocomplete.setTrem(trem);
		List autoList = systemService.findAutoList(autocomplete);
		String labelFields = autocomplete.getLabelField();
		String[] fieldArr = labelFields.split(",");
		String valueField = autocomplete.getValueField();
		String[] allFieldArr = null;
		if (StringUtil.isNotEmpty(valueField)) {
			allFieldArr = new String[fieldArr.length+1];
			for (int i=0; i<fieldArr.length; i++) {
				allFieldArr[i] = fieldArr[i];
			}
			allFieldArr[fieldArr.length] = valueField;
		}
		
		try {
			String str = TagUtil.getAutoList(autocomplete, autoList);
			str = "(" + str + ")";
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(JSONHelper.listtojson(allFieldArr,allFieldArr.length,autoList));
            response.getWriter().flush();
            response.getWriter().close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * 删除继承于TSAttachment附件的公共方法
	 * 	
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "delObjFile")
	@ResponseBody
	public AjaxJson delObjFile(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		TSAttachment attachment = systemService.findEntity(TSAttachment.class,fileKey);
		String subclassname = attachment.getSubclassname(); // 子类类名
		Object objfile = systemService.findEntity(MyClassLoader.getClassByScn(subclassname), attachment.getId());// 子类对象
		message = "" + attachment.getAttachmenttitle() + "删除成功";
		systemService.delete(objfile);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}

	/**
	 * 继承于TSAttachment附件公共列表跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "objfileList")
	public ModelAndView objfileList(HttpServletRequest request) {
		Object object = null;// 业务实体对象
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		TSAttachment attachment = systemService.findEntity(TSAttachment.class,fileKey);
		String businessKey = oConvertUtils.getString(request.getParameter("businessKey"));// 业务主键
		String busentityName = oConvertUtils.getString(request.getParameter("busentityName"));// 业务主键
		String typename = oConvertUtils.getString(request.getParameter("typename"));// 类型
		String typecode = oConvertUtils.getString(request.getParameter("typecode"));// 类型typecode
		if (StringUtil.isNotEmpty(busentityName) && StringUtil.isNotEmpty(businessKey)) {
			object = systemService.find(MyClassLoader.getClassByScn(busentityName), businessKey);
			request.setAttribute("object", object);
			request.setAttribute("businessKey", businessKey);
		}
		if(attachment!=null)
		{
			request.setAttribute("subclassname",attachment.getSubclassname());
		}
		request.setAttribute("fileKey", fileKey);
		request.setAttribute("typecode", typecode);
		request.setAttribute("typename", typename);
		request.setAttribute("typecode", typecode);
		return new ModelAndView("common/objfile/objfileList");
	}

	/**
	 * 继承于TSAttachment附件公共列表数据
	 */
	@RequestMapping(params = "objfileGrid")
	public void objfileGrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String businessKey = oConvertUtils.getString(request.getParameter("businessKey"));
		String subclassname = oConvertUtils.getString(request.getParameter("subclassname"));// 子类类名
		String type = oConvertUtils.getString(request.getParameter("typename"));
		String code = oConvertUtils.getString(request.getParameter("typecode"));
		String filekey = oConvertUtils.getString(request.getParameter("filekey"));
		CriteriaQuery cq = new CriteriaQuery(MyClassLoader.getClassByScn(subclassname), dataGrid);
		cq.eq("businessKey", businessKey);
		if (StringUtil.isNotEmpty(type)) {
			cq.createAlias("TBInfotype", "TBInfotype");
			cq.eq("TBInfotype.typename", type);
		}
		if (StringUtil.isNotEmpty(filekey)) {
			cq.eq("id", filekey);
		}
		if (StringUtil.isNotEmpty(code)) {
			cq.createAlias("TBInfotype", "TBInfotype");
			cq.eq("TBInfotype.typecode", code);
		}
		cq.add();
		this.systemService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
}
