package cn.gov.scciq.basicSettings.intendedUse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONObject;


public class IntendedUseAction {
    	
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
		
		private static Log log=LogFactory.getLog(IntendedUseAction.class);
		IntendedUseService intendedUseService = new IntendedUseService();
	
	public String SaveIntendedUse() throws Exception{
		  
	     JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     IntendedUseBean intendBean=(IntendedUseBean)JSONObject.toBean(object,IntendedUseBean.class);
		 result=intendedUseService.SaveIntendedUse(intendBean);
		 return "success"; 
	}
	public String SaveIntendedUseSub() throws Exception{
		  
	     JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     IntendedUseBean intendBean=(IntendedUseBean)JSONObject.toBean(object,IntendedUseBean.class);
		 result=intendedUseService.SaveIntendedUseSub(intendBean);
		 return "success"; 
	}
	public String DelIntendedUse() throws Exception{
		  
	     JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     IntendedUseBean intendBean=(IntendedUseBean)JSONObject.toBean(object,IntendedUseBean.class);
		 result=intendedUseService.DelIntendedUse(intendBean);
		 return "success"; 
	}

}
