package cn.gov.scciq.basicSettings.processingWay;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gov.scciq.bussiness.searchSelect.SearchSelectService;

import com.opensymphony.xwork2.Action;



public class ProcessingWayAction {
	    private String data;
		private String result;
        private String methodName;
        private JSONObject json;
        private String setscontent;
       
        private String processingWayCode;
	    public JSONObject getJson() {
			return json;
		}
		public void setJson(JSONObject json) {
			this.json = json;
		}
		public String getMethodName() {
			return methodName;
		}
		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}
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
		ProcessingWayService processingWayService = new ProcessingWayService();
		
		public String SaveProcessingMethod() throws Exception{
			  
		     JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     ProcessingWayBean processingWayBean=(ProcessingWayBean)JSONObject.toBean(object,ProcessingWayBean.class);
			 result=processingWayService.SaveProcessingMethod(processingWayBean);
			 return "success"; 
		}
		
		public String SaveProcessingMethodSub() throws Exception{
			  System.out.println("entery");
		     JSONObject object = JSONObject.fromObject(data);
		     log.info("basedata is"+object);
		     log.info(processingWayCode);
		     String[]setarr= setscontent.split(",");
		     ProcessingWayBean processingWayBean=(ProcessingWayBean)JSONObject.toBean(object,ProcessingWayBean.class);
			 result=processingWayService.SaveProcessingMethodSub(processingWayBean,setarr);
			 return "success"; 
		}
		public String DelProcessingMethod() throws Exception{
			  
		     JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     ProcessingWayBean processingWayBean=(ProcessingWayBean)JSONObject.toBean(object,ProcessingWayBean.class);
			 result=processingWayService.DelProcessingMethod(processingWayBean);
			 return "success"; 
		}
		//获得非集合数据
		 public String getProcessingMethod(){
		        int startIndex = 0;
		        int pageSize = 0;
		        int showFlg = 1;
		        String orderWord = "MethodCode";
		        String orderDirection = "DESC";
		        json = SearchSelectService.getProcessingMethod(methodName, showFlg, startIndex, pageSize, orderWord, orderDirection);
		        result= json.toString();
		        System.out.println("processingwayJson:"+result);
		        return Action.SUCCESS;
		    }
		public String getSetscontent() {
			return setscontent;
		}
		public void setSetscontent(String setscontent) {
			this.setscontent = setscontent;
		}
		public String getProcessingWayCode() {
			return processingWayCode;
		}
		public void setProcessingWayCode(String processingWayCode) {
			this.processingWayCode = processingWayCode;
		}

}
