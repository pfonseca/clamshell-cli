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


public class CdCmd implements Command{

    private static final String NAMESPACE = "syscmd";
    private static final String CMD_NAME = "cd";
	
    
    private class CdParams {
    	
        @Parameter(required=true, description="Next folder", arity=1)
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
               return "Change current folder";
            }

            @Override
            public String getUsage() {
                return "Type 'cd'";
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
    		
    		File f=FileUtils.getSystemFile(ctx.getValue(Context.KEY_PWD).toString(), object.folder.get(0));
    		if(!f.exists()){
    			ioConsole.println("Folder not found");
    			throw new FolderNotFound();
    		}
    		
    		ctx.putValue(Context.KEY_PWD, f.getAbsolutePath());
    		
    		ioConsole.println("Folder: "+object.folder);
        }catch(RuntimeException ex){
        	ioConsole.printf("%nUnable execute command: %s%n%n", ex.getMessage());
        }

		return null;
	}

}
