package cn.gov.scciq.basicSettings.additivePurposeSet;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class AdditivePurposeAction{
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
		
		private static Log log=LogFactory.getLog(AdditivePurposeAction.class);
        AdditivePurposeService additivePurposeService = new AdditivePurposeService();
	
		public String SaveAdditivePurpose( )
				throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     AdditivePurposeBean additivePurposeBean=(AdditivePurposeBean)JSONObject.toBean(object,AdditivePurposeBean.class);
			 result=additivePurposeService.SaveAdditivePurpose(additivePurposeBean);
			 return "success"; 
		}
	
		public String DelAdditivePurpose( )
				throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     AdditivePurposeBean additivePurposeBean=(AdditivePurposeBean)JSONObject.toBean(object,AdditivePurposeBean.class);
			 result=additivePurposeService.DelAdditivePurpose(additivePurposeBean);
			 return "success";  
		}

}
