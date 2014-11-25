package cn.gov.scciq.basicSettings.packageType;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import cn.gov.scciq.dbpool.DBPool;

public class PackageTypeService implements IPackageTypeService {
	 private static Log log=LogFactory.getLog(PackageTypeService.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<PackageTypeBean> list = new ArrayList<PackageTypeBean>();

	@Override
	public String SavePackageType(PackageTypeBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SavePackageType(?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getPackageTypeID());
			proc.setString(2, bean.getTypeCode	());
			proc.setString(3, bean.getTypeName());
			proc.setString(4, bean.getIfSet());
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.registerOutParameter(6, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(5);
			returnCode=proc.getString(6);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SavePackageType--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SavePackageType--"+e);
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
	public String SavePackageTypeSub(PackageTypeBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SavePackageTypeSub(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getPackageTypeSubID());
			proc.setString(2, bean.getTypeCode());
			proc.setString(3, bean.getTypeCodeSub());
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(4);
			returnCode=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SavePackageTypeSub--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SavePackageTypeSub--"+e);
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
	public String DelPackageType(PackageTypeBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelPackageType(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getTypeCode());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelPackageType";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelPackageType--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelPackageType--"+e);
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
