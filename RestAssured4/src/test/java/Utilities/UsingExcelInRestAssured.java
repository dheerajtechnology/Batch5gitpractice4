package Utilities;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import Constants.ConstantsVariable;
import io.restassured.RestAssured;

public class UsingExcelInRestAssured {
	@Test
	public void user() throws IOException
	{
		
	
	 //String path="C:\\Users\\bhara\\OneDrive\\Documents\\TestData14thJan.xlsx";
	 //String sheetname="sheet1";
	 FetchDataFromExcel obj=new FetchDataFromExcel(ConstantsVariable.Excel_Path,ConstantsVariable.Excel_Path);
	 
	 RestAssured.baseURI="https://httpbin.org";
	 
	 Map<Object,Object> mp=new LinkedHashMap<Object,Object>();
	 
	 mp.put("gender",obj.getTestData(2, 2));
	 mp.put("name", obj.getTestData(1,0));
	 mp.put("status",obj.getTestData(2,3));
	 
	 String Response=given().log().all().body(mp).when().post("post").then().extract().response().asString();
	 System.out.println(Response);
}

}
