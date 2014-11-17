package cn.gov.scciq.basicSettings.item;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gov.scciq.dbpool.DBPool;

public class ItemService implements IItemService{
	 private static Log log=LogFactory.getLog(ItemService.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<ItemBean> list = new ArrayList<ItemBean>();
	@Override
	public String SaveItem(ItemBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveItem(?,?,?,?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getItemID());
			proc.setString(2, bean.getItemCode());
			proc.setString(3, bean.getItemName());
			proc.setString(4, bean.getRiskClassCode());
			proc.setString(5, bean.getItemType());
			proc.setString(6, bean.getLabFlg());
			proc.setString(7, bean.getIfSet());
			proc.registerOutParameter(8, java.sql.Types.VARCHAR);
			proc.registerOutParameter(9, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(8);
			returnCode=proc.getString(9);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveItem--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveItem--"+e);
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
	public String SaveItemSub(ItemBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveItemSub(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getItemSubID());
			proc.setString(2, bean.getItemCode());
			proc.setString(3, bean.getItemCodeSub());
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(4);
			returnCode=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveItemSub--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveItemSub--"+e);
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
	public String DelItem(ItemBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelItem(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getItemCode());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelItemOK";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelItem--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelItem--"+e);
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
	public String GetItem(ItemBean bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String GetItemSub(ItemBean bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	 

}
