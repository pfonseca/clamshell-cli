package org.clamshellcli.impl.commands;

import java.io.File;
import java.util.Collections;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

public class PwdCmd implements Command{

    private static final String NAMESPACE = "syscmd";
    private static final String CMD_NAME = "pwd";
	
	
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
               return "Return current folder";
            }

            @Override
            public String getUsage() {
                return "Type 'pwd'";
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
		
		String url = ctx.getValue(Context.KEY_PWD).toString();
		ioConsole.println(url+"\n");
		
		return new File(url);
	}

}
