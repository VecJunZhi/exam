package cn.gov.scciq.basicSettings.accessorySet;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class AccessorySetAction  {
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
		
		private static Log log=LogFactory.getLog(AccessorySetAction.class);
		AccessorySetService accessorySetService = new AccessorySetService();

		
		public String SaveAccessory() throws Exception {
			     JSONObject object = JSONObject.fromObject(data);
			     log.info(object);
			     AccessorySetBean accessorySetBean=(AccessorySetBean)JSONObject.toBean(object,AccessorySetBean.class);
				 result=accessorySetService.SaveAccessory(accessorySetBean);
				 return "success"; 
		}
	
		public String DelAccessory() throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     AccessorySetBean accessorySetBean=(AccessorySetBean)JSONObject.toBean(object,AccessorySetBean.class);
			 result=accessorySetService.DelAccessory(accessorySetBean);
			 return "success"; 
		}

}
