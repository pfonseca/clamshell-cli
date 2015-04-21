package org.clamshellcli.impl.commands;

import java.util.Collections;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

public class ClearCmd implements Command{

    private static final String NAMESPACE = "syscmd";
    private static final String CMD_NAME = "clear";
	
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
               return "Clear screen";
            }

            @Override
            public String getUsage() {
                return "Type 'clear'";
            }

            @Override
            public Map<String, String> getArguments() {
                return Collections.emptyMap();
            }
        };
        
	}

	@Override
	public Object execute(Context ctx) {
		IOConsole c = ctx.getIoConsole();
		c.clearScreen();
		return null;
	}

}
