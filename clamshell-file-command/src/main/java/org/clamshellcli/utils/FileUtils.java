package org.clamshellcli.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

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
	
	
	public static String printFile(File file){
		StringBuilder sb = new StringBuilder();
		
		sb.append(file.isDirectory()?"d":"-");
		
		try {
			Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(Paths.get(file.getAbsolutePath()));
			sb.append(PosixFilePermissions.toString(posixFilePermissions));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		sb.append(" ");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sb.append(sdf.format(new Date(file.lastModified())));
		
		sb.append(" ");
		sb.append(file.getName());
		
		
		return sb.toString();
	}
	
}
