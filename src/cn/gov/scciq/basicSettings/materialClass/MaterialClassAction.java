package cn.gov.scciq.basicSettings.materialClass;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gov.scciq.basicSettings.processingWay.ProcessingWayAction;

public class MaterialClassAction  {
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
		
		private static Log log=LogFactory.getLog(ProcessingWayAction.class);
		MaterialClassService materialClassService = new MaterialClassService();
		
		public String SaveMaterialClass() throws Exception{
			  
		     JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     MaterialClassBean materialClassBean=(MaterialClassBean)JSONObject.toBean(object,MaterialClassBean.class);
			 result=materialClassService.SaveMaterialClass(materialClassBean);
			 return "success"; 
		}
	
		
		public String SaveMaterialSubclass() throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     MaterialClassBean materialClassBean=(MaterialClassBean)JSONObject.toBean(object,MaterialClassBean.class);
			 result=materialClassService.SaveMaterialSubclass(materialClassBean);
			 return "success"; 
		}
		
		public String SaveMaterialSubsubclass() throws Exception {
			JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     MaterialClassBean materialClassBean=(MaterialClassBean)JSONObject.toBean(object,MaterialClassBean.class);
			 result=materialClassService.SaveMaterialSubsubclass(materialClassBean);
			 return "success"; 
		}
		
		public String SaveMaterialSubsubclassSub() throws Exception {
			JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     MaterialClassBean materialClassBean=(MaterialClassBean)JSONObject.toBean(object,MaterialClassBean.class);
			 result=materialClassService.SaveMaterialSubsubclassSub(materialClassBean);
			 return "success"; 
		}
		
		public String DelMaterialClass() throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     MaterialClassBean materialClassBean=(MaterialClassBean)JSONObject.toBean(object,MaterialClassBean.class);
			 result=materialClassService.DelMaterialClass(materialClassBean);
			 return "success"; 
		}
		
		public String DelMaterialSubclass() throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     MaterialClassBean materialClassBean=(MaterialClassBean)JSONObject.toBean(object,MaterialClassBean.class);
			 result=materialClassService.DelMaterialSubclass(materialClassBean);
			 return "success"; 
		}
		
		public String DelMaterialSubsubclass()  throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     MaterialClassBean materialClassBean=(MaterialClassBean)JSONObject.toBean(object,MaterialClassBean.class);
			 result=materialClassService.DelMaterialSubsubclass(materialClassBean);
			 return "success"; 
		}
}
