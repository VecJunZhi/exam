package cn.gov.scciq.basicSettings.additiveSet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.gov.scciq.basicSettings.packageType.PackageTypeService;
import cn.gov.scciq.dbpool.DBPool;

public class AdditiveSetService implements IAdditiveSetService{
	 private static Log log=LogFactory.getLog(PackageTypeService.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<AdditiveSetBean> list = new ArrayList<AdditiveSetBean>();
	@Override
	public String SaveAdditive(AdditiveSetBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveAdditive(?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getAdditiveID());
			proc.setString(2, bean.getAdditiveName());
			proc.registerOutParameter(3, java.sql.Types.VARCHAR);
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(3);
			returnCode=proc.getString(4);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveAdditive--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveAdditive--"+e);
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
	public String DelAdditive(AdditiveSetBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelAdditive(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getAdditiveID());
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
