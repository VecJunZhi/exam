package cn.gov.scciq.basicSettings.additivePurposeSet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gov.scciq.basicSettings.accessorySet.AccessorySetBean;
import cn.gov.scciq.basicSettings.packageType.PackageTypeService;
import cn.gov.scciq.dbpool.DBPool;

public class AdditivePurposeService implements IAdditivePurposeService {
	 private static Log log=LogFactory.getLog(PackageTypeService.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<AccessorySetBean> list = new ArrayList<AccessorySetBean>();

	@Override
	public String SaveAdditivePurpose(AdditivePurposeBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveAdditivePurpose(?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getAdditivePurposeID());
			proc.setString(2, bean.getPurpose());
			proc.registerOutParameter(3, java.sql.Types.VARCHAR);
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(3);
			returnCode=proc.getString(4);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveAdditivePurpose--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveAdditivePurpose--"+e);
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
	public String DelAdditivePurpose(AdditivePurposeBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelAdditivePurpose(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getAdditivePurposeID());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelAdditivePurposeOK";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelAdditivePurpose--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelAdditivePurpose--"+e);
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
