package cn.gov.scciq.basicSettings.processingDegree;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.gov.scciq.dbpool.DBPool;

public class ProcessingDegreeService implements IProcessingDegreeService{
	 private static Log log=LogFactory.getLog(ProcessingDegreeService.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<ProcessingDegreeBean> list = new ArrayList<ProcessingDegreeBean>();
	@Override
	public String SaveProcessingDegree(ProcessingDegreeBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveProcessingDegree(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getProcessingDegreeID());
			proc.setString(2, bean.getDegreeCode());
			proc.setString(3, bean.getDegreeName());
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(4);
			returnCode=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveProcessingDegree--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveProcessingDegree--"+e);
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
	public String DelProcessingDegree(ProcessingDegreeBean bean)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelProcessingDegree(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getProcessingDegreeID());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelProcessingDegreeOK";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelProcessingDegree--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelProcessingDegree--"+e);
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
