package cn.gov.scciq.basicSettings.processingWay;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import cn.gov.scciq.basicSettings.productClass.ProductClassServiceImpl;
import cn.gov.scciq.dbpool.DBPool;

public class ProcessingWayService implements IProcessingWayService {
	 private static Log log=LogFactory.getLog(ProductClassServiceImpl.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 private String[] setscontent;
	 
	 List<ProcessingWayBean> list = new ArrayList<ProcessingWayBean>();
	@Override
	public String SaveProcessingMethod(ProcessingWayBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveProcessingMethod(?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getProcessingMethodID());
			proc.setString(2, bean.getMethodCode());
			proc.setString(3, bean.getMethodName());
			proc.setString(4, bean.getIfSet());
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.registerOutParameter(6, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(5);
			returnCode=proc.getString(6);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveProcessingMethod--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveProcessingMethod--"+e);
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
	public String SaveProcessingMethodSub(ProcessingWayBean bean,String[] arr)
			throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		
		try {
			String returnStr =null;
			String returnCode =null;
			String wCall = null;
			wCall = "{call Pro_SaveProcessingMethod(?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getProcessingMethodID());
			proc.setString(2, bean.getMethodCode());
			proc.setString(3, bean.getMethodName());
			proc.setString(4, bean.getIfSet());
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.registerOutParameter(6, java.sql.Types.VARCHAR);
			proc.execute();
			proc.close();
			int i=0;
			System.out.println("sets is");
			System.out.println("setscuntent is ;"+arr.toString()+";"+arr.length);
			while(i<arr.length)
			{
			 wCall = "{call Pro_SaveProcessingMethodSub(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, "0");
			proc.setString(2, bean.getMethodCode());
			proc.setString(3, arr[i]);
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
			proc.close();
			i++;
		//	rs = proc.getResultSet();
			//returnStr=proc.getString(4);
			//returnCode=proc.getString(5);
			}
			returnStr="savePWayBaseOK";
			returnCode="savePWaySubOK";
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveProcessingMethodSub--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveProcessingMethodSub--"+e);
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
	public String DelProcessingMethod(ProcessingWayBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelProcessingMethod(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getMethodCode());
			
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelProcessingMethodOk";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelProcessingMethod--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelProcessingMethod--"+e);
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

	public String[] getSetscontent() {
		return setscontent;
	}

	public void setSetscontent(String[] setscontent) {
		this.setscontent = setscontent;
	}

}
