package cn.gov.scciq.basicSettings.processingDegree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import net.sf.json.JSONObject;

public class ProcessingDegreeAction{
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
		
		private static Log log=LogFactory.getLog(ProcessingDegreeAction.class);
        ProcessingDegreeService processingDegreeService = new ProcessingDegreeService();
	
	public String SaveProcessingDegree()
			throws Exception {
	     JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     ProcessingDegreeBean processingDegreeBean=(ProcessingDegreeBean)JSONObject.toBean(object,ProcessingDegreeBean.class);
		 result=processingDegreeService.SaveProcessingDegree(processingDegreeBean);
		 return "success"; 
	}


	public String DelProcessingDegree()
			throws Exception {
		 JSONObject object = JSONObject.fromObject(data);
	     log.info(object);
	     ProcessingDegreeBean processingDegreeBean=(ProcessingDegreeBean)JSONObject.toBean(object,ProcessingDegreeBean.class);
		 result=processingDegreeService.DelProcessingDegree(processingDegreeBean);
		 return "success"; 
	}

}
