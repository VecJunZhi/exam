package cn.gov.scciq.basicSettings.item;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ItemAction  {
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
		
		private static Log log=LogFactory.getLog(ItemAction.class);
        ItemService itemService = new ItemService();
		
		public String SaveItem() throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     ItemBean itemBean=(ItemBean)JSONObject.toBean(object,ItemBean.class);
			 result=itemService.SaveItem(itemBean);
			 return "success"; 
		}
		
		public String SaveItemSub() throws Exception {
			JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     ItemBean itemBean=(ItemBean)JSONObject.toBean(object,ItemBean.class);
			 result=itemService.SaveItemSub(itemBean);
			 return "success";
		}
	
		public String DelItem() throws Exception {
			 JSONObject object = JSONObject.fromObject(data);
		     log.info(object);
		     ItemBean itemBean=(ItemBean)JSONObject.toBean(object,ItemBean.class);
			 result=itemService.DelItem(itemBean);
			 return "success";
		}
		
		public String GetItem() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
		public String GetItemSub() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

}
