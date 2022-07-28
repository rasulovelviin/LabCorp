package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FunctionLibrary {
	
public static Properties property;
	

	// this block is for read properties file
	static{
					
			try {
				property=new Properties();
				String path="src/test/resources/apiConfig.properties";
				File file=new File(path);
				FileInputStream fis=new FileInputStream(file);
				property.load(fis);
			
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
	
	}
	
	
	// this method convert object to String
	public String convertObjectToString(Object obj) {
		String strReqData=null;
		 try {
			ObjectMapper objMapper=new ObjectMapper();
			strReqData=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		 
		return  strReqData;
	}

}
