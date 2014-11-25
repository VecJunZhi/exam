package cn.gov.scciq.basicSettings.intendedUse;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gov.scciq.basicSettings.packageType.PackageTypeBean;
import cn.gov.scciq.basicSettings.packageType.PackageTypeService;
import cn.gov.scciq.dbpool.DBPool;

public class IntendedUseService implements IIntendedUseService {
	 private static Log log=LogFactory.getLog(PackageTypeService.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<IntendedUseBean> list = new ArrayList<IntendedUseBean>();

	@Override
	public String SaveIntendedUse(IntendedUseBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveIntendedUse(?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getIntendedUseID());
			proc.setString(2, bean.getUseCode());
			proc.setString(3, bean.getUseName());
			proc.setString(4, bean.getIfSet());
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.registerOutParameter(6, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(5);
			returnCode=proc.getString(6);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveIntendedUse--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveIntendedUse--"+e);
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
	public String SaveIntendedUseSub(IntendedUseBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveIntendedUseSub(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getIntendedUseSubID());
			proc.setString(2, bean.getUseCode());
			proc.setString(3, bean.getUseCodeSub());
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(4);
			returnCode=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveIntendedUseSub--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveIntendedUseSub--"+e);
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
	public String DelIntendedUse(IntendedUseBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelIntendedUse(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getUseCode());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelIntendedUse";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelIntendedUse--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelIntendedUse--"+e);
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
