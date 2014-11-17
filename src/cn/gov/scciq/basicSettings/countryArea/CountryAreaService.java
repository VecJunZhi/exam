package cn.gov.scciq.basicSettings.countryArea;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gov.scciq.dbpool.DBPool;


public class CountryAreaService implements ICountryAreaService {
	 private static Log log=LogFactory.getLog(CountryAreaService.class);
	 String json = null;
	 String rowIndex ;
	 String pageSize;
	 List<CountryAreaBean> list = new ArrayList<CountryAreaBean>();
	@Override
	public String SaveCountry(CountryAreaBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveCountry(?,?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getCountryID());
			proc.setString(2, bean.getCountryCode());
			proc.setString(3, bean.getCountryName());
			proc.setString(4, bean.getIfSet());
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.registerOutParameter(6, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(5);
			returnCode=proc.getString(6);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveCountry--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveCountry--"+e);
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
	public String SaveCountrySub(CountryAreaBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			String returnCode =null;
		//	ResultSet rs = null;
			
			String wCall = "{call Pro_SaveCountrySub(?,?,?,?,?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getCountrySubID());
			proc.setString(2, bean.getCountryCode()); 	
			proc.setString(3, bean.getSubcountryCode());
			proc.registerOutParameter(4, java.sql.Types.VARCHAR);
			proc.registerOutParameter(5, java.sql.Types.VARCHAR);
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr=proc.getString(4);
			returnCode=proc.getString(5);
			json="{\"returnStr\":"+returnStr+",\"returnCode\":"+returnCode+"}";
			log.info("Pro_SaveCountrySub--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_SaveCountrySub--"+e);
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
	public String DelCountry(CountryAreaBean bean) throws Exception {
		Connection conn = DBPool.ds.getConnection();
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			
			String returnStr =null;
			
			
			String wCall = "{call Pro_DelCountry(?)}";
			proc = conn.prepareCall(wCall);
			proc.setString(1, bean.getCountryCode());
			proc.execute();
		//	rs = proc.getResultSet();
			returnStr="DelCountryOK";
			json="{\"returnStr\":"+returnStr+"}";
			log.info("Pro_DelCountry--"+json);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Pro_DelCountry--"+e);
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
