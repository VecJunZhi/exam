package cn.gov.scciq.basicSettings.packageType;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gov.scciq.basicSettings.materialSource.MaterialSourceAction;
import cn.gov.scciq.basicSettings.materialSource.MaterialSourceBean;

public class PackageTypeAction  {
	private String data;
	private String result;

    public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	private static Log log=LogFactory.getLog(PackageTypeAction.class);
	PackageTypeService packageTypeService = new PackageTypeService();

	
	public String SavePackageType() throws Exception {
		 JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     PackageTypeBean packageTypeBean=(PackageTypeBean)JSONObject.toBean(object,PackageTypeBean.class);
		 result=packageTypeService.SavePackageType(packageTypeBean);
		 return "success"; 
	}
	
	public String SavePackageTypeSub() throws Exception {
		 JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     PackageTypeBean packageTypeBean=(PackageTypeBean)JSONObject.toBean(object,PackageTypeBean.class);
		 result=packageTypeService.SavePackageTypeSub(packageTypeBean);
		 return "success"; 
	}

	public String DelPackageType() throws Exception {
		 JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     PackageTypeBean packageTypeBean=(PackageTypeBean)JSONObject.toBean(object,PackageTypeBean.class);
		 result=packageTypeService.DelPackageType(packageTypeBean);
		 return "success"; 
	}
	

}
