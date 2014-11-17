package cn.gov.scciq.basicSettings.storageCondition;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class StorageConditionAction {
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
		
		private static Log log=LogFactory.getLog(StorageConditionAction.class);
      StorageConditionService storageConditionService = new StorageConditionService();
		
		public String DelStorageCondition()
				throws Exception {
			JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     StorageConditionBean storageConditionBean=(StorageConditionBean)JSONObject.toBean(object,StorageConditionBean.class);
			 result=storageConditionService.DelStorageCondition(storageConditionBean);
			 return "success"; 
		}
		
		public String SaveStorageCondition()
				throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     StorageConditionBean storageConditionBean=(StorageConditionBean)JSONObject.toBean(object,StorageConditionBean.class);
			 result=storageConditionService.SaveStorageCondition(storageConditionBean);
			 return "success"; 
		}

}
