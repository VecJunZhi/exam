package cn.gov.scciq.basicSettings.countryArea;

public interface ICountryAreaService {
	public String SaveCountry(CountryAreaBean bean)throws Exception;
	public String SaveCountrySub(CountryAreaBean bean)throws Exception;
	public String DelCountry(CountryAreaBean bean)throws Exception;
	//public String GetCountry(CountryAreaBean bean)throws Exception;
	//public String GetCountrySub(CountryAreaBean bean)throws Exception;
	

}
