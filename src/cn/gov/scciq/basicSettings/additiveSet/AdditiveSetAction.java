package cn.gov.scciq.basicSettings.additiveSet;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AdditiveSetAction {
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
		
		private static Log log=LogFactory.getLog(AdditiveSetAction.class);
		AdditiveSetService additiveSetService = new AdditiveSetService();
		
		public String SaveAdditive( ) throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     AdditiveSetBean additiveSetBean=(AdditiveSetBean)JSONObject.toBean(object,AdditiveSetBean.class);
			 result=additiveSetService.SaveAdditive(additiveSetBean);
			 return "success"; 
		}
		
		public String DelAdditive( ) throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     AdditiveSetBean additiveSetBean=(AdditiveSetBean)JSONObject.toBean(object,AdditiveSetBean.class);
			 result=additiveSetService.DelAdditive(additiveSetBean);
			 return "success"; 
		}

}
