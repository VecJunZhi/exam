package cn.gov.scciq.basicSettings.materialSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gov.scciq.basicSettings.productClass.ProductClassServiceImpl;
import cn.gov.scciq.dbpool.DBPool;



public class MaterialSourceService implements IMaterialSourceService {
	 private static Log log=LogFactory.getLog(ProductClassServiceImpl.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<MaterialSourceBean> list = new ArrayList<MaterialSourceBean>();

	@Override
	public String SaveMaterialSource(MaterialSourceBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveMaterialSource(?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getMaterialSourceID());
			proc.setString(2, bean.getSourceCode());
			proc.setString(3, bean.getSourceName());
			proc.setString(4, bean.getIfSet());
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.registerOutParameter(6, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(5);
			returnCode=proc.getString(6);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveMaterialSource--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveMaterialSource--"+e);
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
	public String SaveMaterialSourceSub(MaterialSourceBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveMaterialSourceSub(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getMaterialSourceSubID());
			proc.setString(2, bean.getSourceCode());
			proc.setString(3, bean.getSourceCodeSub());
			
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(4);
			returnCode=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveMaterialSourceSub--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveMaterialSourceSub--"+e);
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
	public String DelMaterialSource(MaterialSourceBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelMaterialSource(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getSourceCode());
			
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelMaterialSource";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelMaterialSource--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelMaterialSource--"+e);
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
