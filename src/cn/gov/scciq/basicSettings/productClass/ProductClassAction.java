package cn.gov.scciq.basicSettings.productClass;


import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class ProductClassAction extends ActionSupport {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Log log=LogFactory.getLog(ProductClassAction.class);
	ProductClassServiceImpl iproductClassService = new ProductClassServiceImpl();
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
	 
	  public String saveProClass() throws Exception{
		  
	     JSONObject object = JSONObject.fromObject(data);
		 ProductClassBean proBean=(ProductClassBean)JSONObject.toBean(object,ProductClassBean.class);
		 result=iproductClassService.saveProductClass(proBean);
		 return "success"; 
	}
	  public String saveSubProductClass() throws Exception{
		  
		     JSONObject object = JSONObject.fromObject(data);
			 ProductClassBean proBean=(ProductClassBean)JSONObject.toBean(object,ProductClassBean.class);
			 result=iproductClassService.saveSubProductClass(proBean);
			 return "success"; 
		}
	  public String deleteProductClass() throws Exception{
		  
		     JSONObject object = JSONObject.fromObject(data);
			 ProductClassBean proBean=(ProductClassBean)JSONObject.toBean(object,ProductClassBean.class);
			 result=iproductClassService.deleteProductClass(proBean);
		     return "success"; 
		}
	  public String deleteSubProductClass() throws Exception{
		  
		     JSONObject object = JSONObject.fromObject(data);
			 ProductClassBean proBean=(ProductClassBean)JSONObject.toBean(object,ProductClassBean.class);
			 result=iproductClassService.deleteSubProductClass(proBean);
			 return "success"; 
		}
	  public String getProductClass() throws Exception{
		  
		     JSONObject object = JSONObject.fromObject(data);
		     ProductClassBean proBean=(ProductClassBean)JSONObject.toBean(object,ProductClassBean.class);
			 result=iproductClassService.getProductClass(proBean);
			 return "success"; 
		}
	  public String getSubProductClass() throws Exception{
		  
		     JSONObject object = JSONObject.fromObject(data);
			 ProductClassBean proBean=(ProductClassBean)JSONObject.toBean(object,ProductClassBean.class);
			 result=iproductClassService.getSubProductClass(proBean);
			 return "success"; 
		}
	
	
	

}
