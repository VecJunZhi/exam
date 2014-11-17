package cn.gov.scciq.basicSettings.storageCondition;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.gov.scciq.dbpool.DBPool;

public class StorageConditionService implements IStorageConditionService{
	 private static Log log=LogFactory.getLog(StorageConditionService.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<StorageConditionBean> list = new ArrayList<StorageConditionBean>();
	
	@Override
	public String SaveStorageCondition(StorageConditionBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveStorageCondition(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getStorageConditionID());
			proc.setString(2, bean.getConditionCode());
			proc.setString(3, bean.getConditionName());
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(4);
			returnCode=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveStorageCondition--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveStorageCondition--"+e);
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
	public String DelStorageCondition(StorageConditionBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelStorageCondition(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getStorageConditionID());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="Pro_DelStorageCondition";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelStorageCondition--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelStorageCondition--"+e);
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
