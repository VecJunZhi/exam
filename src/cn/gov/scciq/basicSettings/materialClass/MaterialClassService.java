package cn.gov.scciq.basicSettings.materialClass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import cn.gov.scciq.basicSettings.productClass.ProductClassServiceImpl;
import cn.gov.scciq.dbpool.DBPool;

public class MaterialClassService implements IMaterialClassService {
	 private static Log log=LogFactory.getLog(ProductClassServiceImpl.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<MaterialClassBean> list = new ArrayList<MaterialClassBean>();

	@Override
	public String SaveMaterialClass(MaterialClassBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveMaterialClass(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getMaterialClassID());
			proc.setString(2, bean.getClassCode());
			proc.setString(3, bean.getClassName());
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(4);
			returnCode=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveMaterialClass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveMaterialClass--"+e);
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
	public String SaveMaterialSubclass(MaterialClassBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveMaterialSubclass(?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getMaterialSubclassID());
			proc.setString(2, bean.getClassCode	());
			proc.setString(3, bean.getSubclassCode());
			proc.setString(4, bean.getSubclassName());
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.registerOutParameter(6, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(5);
			returnCode=proc.getString(6);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveMaterialSubclass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveMaterialSubclass--"+e);
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
	public String SaveMaterialSubsubclass(MaterialClassBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveMaterialSubsubclass(?,?,?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getMaterialID());
			proc.setString(2, bean.getClassCode	());
			proc.setString(3, bean.getSubclassCode());
			proc.setString(4, bean.getMaterialCode());
			proc.setString(5, bean.getMaterialName());
			proc.setString(6, bean.getIfSet());
			proc.registerOutParameter(7, java.sql.Types.VARCHAR);
			proc.registerOutParameter(8, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(7);
			returnCode=proc.getString(8);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveMaterialSubsubclass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveMaterialSubsubclass--"+e);
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
	public String SaveMaterialSubsubclassSub(MaterialClassBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveMaterialSubsubclassSub(?,?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getMaterialSubID());
			proc.setString(2, bean.getClassCode	());
			proc.setString(3, bean.getSubclassCode());
			proc.setString(4, bean.getMaterialCode());
			proc.setString(5, bean.getMaterialCodeSub());
			proc.registerOutParameter(6, java.sql.Types.VARCHAR);
			proc.registerOutParameter(7, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(6);
			returnCode=proc.getString(7);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveMaterialSubsubclassSub--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveMaterialSubsubclassSub--"+e);
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
	public String DelMaterialClass(MaterialClassBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelMaterialClass(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getClassCode());
			
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelMaterialClassOk";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelMaterialClass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelMaterialClass--"+e);
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
	public String DelMaterialSubclass(MaterialClassBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelMaterialSubclass(?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getClassCode());
			proc.setString(2, bean.getSubclassCode());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelMaterialSubclass";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelMaterialSubclass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelMaterialSubclass--"+e);
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
	public String DelMaterialSubsubclass(MaterialClassBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelMaterialSubsubclass(?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getClassCode());
			proc.setString(2, bean.getSubclassCode());
			proc.setString(3, bean.getMaterialCode());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelMaterialSubsubclass";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelMaterialSubsubclass--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelMaterialSubsubclass--"+e);
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
