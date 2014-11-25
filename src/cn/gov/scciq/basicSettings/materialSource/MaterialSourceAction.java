package cn.gov.scciq.basicSettings.materialSource;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class MaterialSourceAction  {
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
	
	private static Log log=LogFactory.getLog(MaterialSourceAction.class);
	MaterialSourceService materialSourceService = new MaterialSourceService();

	
	public String SaveMaterialSource() throws Exception {
		 JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     MaterialSourceBean materialSourceBean=(MaterialSourceBean)JSONObject.toBean(object,MaterialSourceBean.class);
		 result=materialSourceService.SaveMaterialSource(materialSourceBean);
		 return "success"; 
	}
	
	public String SaveMaterialSourceSub() throws Exception {
		JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     MaterialSourceBean materialSourceBean=(MaterialSourceBean)JSONObject.toBean(object,MaterialSourceBean.class);
		 result=materialSourceService.SaveMaterialSourceSub(materialSourceBean);
		 return "success"; 
	}
	
	public String DelMaterialSource() throws Exception {
		JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     MaterialSourceBean materialSourceBean=(MaterialSourceBean)JSONObject.toBean(object,MaterialSourceBean.class);
		 result=materialSourceService.DelMaterialSource(materialSourceBean);
		 return "success"; 
	}

}
