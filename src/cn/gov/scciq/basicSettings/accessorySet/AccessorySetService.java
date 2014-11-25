package cn.gov.scciq.basicSettings.accessorySet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gov.scciq.basicSettings.packageType.PackageTypeService;
import cn.gov.scciq.dbpool.DBPool;

public class AccessorySetService implements IAccessorySetService {
	 private static Log log=LogFactory.getLog(AccessorySetService.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<AccessorySetBean> list = new ArrayList<AccessorySetBean>();


	@Override
	public String SaveAccessory(AccessorySetBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveAccessory(?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getAccessoryID());
			proc.setString(2, bean.getAccessoryName());
			proc.registerOutParameter(3, java.sql.Types.VARCHAR);
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(3);
			returnCode=proc.getString(4);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveAccessory--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveAccessory--"+e);
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
	public String DelAccessory(AccessorySetBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelAccessory(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getAccessoryID());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelAccessoryOK";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelAccessory--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelAccessory--"+e);
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
