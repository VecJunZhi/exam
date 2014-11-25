package cn.gov.scciq.basicSettings.countryArea;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class CountryAreaAction {
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
		
		private static Log log=LogFactory.getLog(CountryAreaAction.class);
		CountryAreaService countryAreaService = new CountryAreaService();
		
		public String SaveCountry( ) throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     CountryAreaBean countryAreaBean=(CountryAreaBean)JSONObject.toBean(object,CountryAreaBean.class);
			 result=countryAreaService.SaveCountry(countryAreaBean);
			 return "success"; 
		}
	
		public String SaveCountrySub( ) throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     CountryAreaBean countryAreaBean=(CountryAreaBean)JSONObject.toBean(object,CountryAreaBean.class);
			 result=countryAreaService.SaveCountrySub(countryAreaBean);
			 return "success";
		}
	
		public String DelCountry() throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     CountryAreaBean countryAreaBean=(CountryAreaBean)JSONObject.toBean(object,CountryAreaBean.class);
			 result=countryAreaService.DelCountry(countryAreaBean);
			 return "success";
		}

}
