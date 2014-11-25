package cn.gov.scciq.basicSettings.productClass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gov.scciq.dbpool.*;
import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductClassServiceImpl implements IproductClassService{
	 private static Log log=LogFactory.getLog(ProductClassServiceImpl.class);
	 private String json = null;
	
	List<ProductClassBean> list = new ArrayList<ProductClassBean>();
	@Override
	public String saveProductClass(ProductClassBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr ="ok";
			String returnCode =null;
		
			String wCall = "{call Pro_SaveProductClass(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getProductClassID());
			proc.setString(2, bean.getClassCode());
			proc.setString(3, bean.getClassName());
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
			
		//	rs = proc.getResultSet();
			returnStr=proc.getString(4);
			returnCode=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveProductClass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveProductClass--"+e);
		}finally{
		    try{
			if(conn!=null)
			   conn.close();
			if(proc!=null)
				proc.close();
			if(rs!=null)
				rs.close();
		      }
			catch(Exception e){
				e.printStackTrace();	
			}
		}
		return json;
	}
	@Override
	public String deleteProductClass(ProductClassBean bean)throws Exception {
		
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelProductClass(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getProductClassID());
			
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="delOk";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelProductClass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelProductClass--"+e);
		}finally{
		    try{
			if(conn!=null)
			   conn.close();
			if(proc!=null)
				proc.close();
			if(rs!=null)
				rs.close();
		      }
			catch(Exception e){
				e.printStackTrace();	
			}
		}
		return json;
	}
	@Override
	public String getProductClass(ProductClassBean bean) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCount =null;
		
			String wCall = "{call Pro_GetProductClass(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getRowIndex()); //记录索引号
			proc.setString(2, bean.getPageSize()); //每页最大记录数
			proc.setString(3, "ProductClassID");
			proc.setString(4, "asc");
			proc.registerOutParameter(5, java.sql.Types.INTEGER);
			proc.execute();
		    rs = proc.getResultSet();
		    while(rs.next()){
		    	ProductClassBean proBean = new ProductClassBean();
		    	proBean.setProductClassID(rs.getString("ProductClassID"));
		    	proBean.setClassCode(rs.getString("ClassCode"));
		    	proBean.setClassName(rs.getString("ClassName"));
		    	proBean.setSerialRank(rs.getString("SerialRank"));
		    	list.add(proBean);
		    }
			returnStr=JSONArray.fromObject(list).toString();
			returnCount=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCount\":\""+returnCount+"\"}";
			log.info("Pro_GetProductClass--"+json);
		} catch (Exception e) {
			
			log.error("Pro_GetProductClass--"+e);
		}finally{
		    try{
			if(conn!=null)
			   conn.close();
			if(proc!=null)
				proc.close();
			if(rs!=null)
				rs.close();
		      }
			catch(Exception e){
				e.printStackTrace();	
			}
		}
		return json;
	}
	@Override
	public String saveSubProductClass(ProductClassBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
			String wCall = "{call Pro_SaveProductSubclass(?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getProductSubclassID());
			proc.setString(2, bean.getClassCode());
			proc.setString(3, bean.getSubclassCode());
			proc.setString(4, bean.getSubclassName());
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.registerOutParameter(6, java.sql.Types.INTEGER);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(5);
			returnCode=proc.getString(6);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveProductSubclass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveProductSubclass--"+e);
		}finally{
		    try{
			if(conn!=null)
			   conn.close();
			if(proc!=null)
				proc.close();
			if(rs!=null)
				rs.close();
		      }
			catch(Exception e){
				e.printStackTrace();	
			}
		}
		return json;
	}
	@Override
	public String deleteSubProductClass(ProductClassBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelProductSubClass(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getProductSubclassID());
			
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="delprosubclassOk";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelProductSubClass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelProductSubClass--"+e);
		}finally{
		    try{
			if(conn!=null)
			   conn.close();
			if(proc!=null)
				proc.close();
			if(rs!=null)
				rs.close();
		      }
			catch(Exception e){
				e.printStackTrace();	
			}
		}
		return json;
	}
	@Override
	public String getSubProductClass(ProductClassBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCount =null;
		
			String wCall = "{call Pro_GetProductSubclass(?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getClassCode()); 
			proc.setString(2, bean.getRowIndex()); //记录索引号
			proc.setString(3, bean.getPageSize());  //每页最大记录数
			proc.setString(4, "ProductSubclassID");
			proc.setString(5, "asc");
			proc.registerOutParameter(6, java.sql.Types.INTEGER);
			proc.execute();
		    rs = proc.getResultSet();
		    while(rs.next()){
		    	ProductClassBean proBean = new ProductClassBean();
		    	proBean.setProductSubclassID(rs.getString("ProductSubclassID"));
		    	proBean.setClassCode(rs.getString("ClassCode"));
		    	proBean.setSubclassCode(rs.getString("SubclassCode"));
		    	proBean.setSubclassName(rs.getString("SubclassName"));
		    	proBean.setSerialRank(rs.getString("SerialRank"));
		    	list.add(proBean);
		    }
			returnStr=JSONArray.fromObject(list).toString();
			returnCount=proc.getString(6);
			json="{\"returnStr\":"+returnStr+",\"returnCount\":\""+returnCount+"\"}";
			log.info("Pro_GetProductSubclass--"+json);
		} catch (Exception e) {
			
			log.error("Pro_GetProductSubclass--"+e);
		}finally{
		    try{
			if(conn!=null)
			   conn.close();
			if(proc!=null)
				proc.close();
			if(rs!=null)
				rs.close();
		      }
			catch(Exception e){
				e.printStackTrace();	
			}
		}
		return json;
	}

}
