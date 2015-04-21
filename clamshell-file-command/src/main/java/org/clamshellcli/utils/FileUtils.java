package org.clamshellcli.utils;

import java.io.File;

public class FileUtils {
	
	public static File getSystemFile(String actualFolder, String file){
		
		
		if(file.equals("..")){
			file = new File(actualFolder).getParentFile().getAbsolutePath();
		}
		
		if(file.equals("~")){
			file = new File(System.getProperty( "user.home" )).getAbsolutePath();
		}
		
		File f=new File(file);
		if(!f.exists()){
			f = new File(actualFolder, file);
		}
		
		return f;
	}
	
}
