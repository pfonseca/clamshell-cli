package org.clamshellcli.impl.commands;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;
import org.clamshellcli.utils.FileUtils;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class LsCmd implements Command {

    private static final String NAMESPACE = "syscmd";
    private static final String CMD_NAME = "ls";
	
    
    private class CdParams {
    	
        @Parameter( )
        public List<String> folder=new ArrayList<String>();
    }
    
	@Override
	public void plug(Context plug) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unplug(Context plug) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Descriptor getDescriptor() {
		return new Command.Descriptor() {
            @Override public String getNamespace() {return NAMESPACE;}
            
            @Override
            public String getName() {
                return CMD_NAME;
            }

            @Override
            public String getDescription() {
               return "List files";
            }

            @Override
            public String getUsage() {
                return "Type 'ls'";
            }

            @Override
            public Map<String, String> getArguments() {
                return Collections.emptyMap();
            }
        };
	}

	@Override
	public Object execute(Context ctx) {
		IOConsole ioConsole = ctx.getIoConsole();
		
		
		String[] args = (String[]) ctx.getValue(Context.KEY_COMMAND_LINE_ARGS);
		
        try{
    		CdParams object = new CdParams();
    		JCommander jCommander = new JCommander(object, args);
    		
    		
    		List<String> params = object.folder;
    		
    		
    		
    		File f=null;
    		
    		if(params == null || params.size() == 0){
    			f = new File(ctx.getValue(Context.KEY_PWD).toString());
    		}else{
    			f = FileUtils.getSystemFile(ctx.getValue(Context.KEY_PWD).toString(), params.get(0));
    		}
    		
    		if(f.exists()){
    			for(File file:f.listFiles()){
    				if(file.isFile()){
    					ioConsole.println(file.getName());
    				}else{
    					ioConsole.println("["+file.getName()+"]");
    				}
    			}
    		}else{
    			ioConsole.println("Folder not found");
    			throw new FolderNotFound();
    		}
    		
        }catch(RuntimeException ex){
        	ioConsole.printf("%nUnable execute command: %s%n%n", ex.getMessage());
        }

		return null;
	}

}
