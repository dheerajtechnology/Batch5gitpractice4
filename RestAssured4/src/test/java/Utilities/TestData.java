package Utilities;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestData {
	public static Map payLoadData()
	{
		Map<String,Object>mp=new LinkedHashMap<String, Object>();
		
		mp.put("name", "Ravi");
		mp.put("gender", "male");
		mp.put("email", ReusableMethods.generateRandomEmail());
		mp.put("status", "active");
		return mp;
	}

}
