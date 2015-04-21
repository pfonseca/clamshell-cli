package org.clamshellcli.impl.commands;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

public class EnvironmentCmd implements Command{

    private static final String NAMESPACE = "syscmd";
    private static final String CMD_NAME = "environment";
	
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
               return "Environment values";
            }

            @Override
            public String getUsage() {
                return "Type 'environment'";
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
		
		Properties properties = System.getProperties();
		
		Map<String, String> getenv = System.getenv();
		
		c.println("Properties ----------------------\n");
		for(Object key:properties.keySet()){
			c.println(key+" = "+properties.getProperty(key.toString()));
		}
		
		c.println("\n\nEnvironment ----------------------\n");
		for(Object key:getenv.keySet()){
			c.println(key+" = "+getenv.get(key.toString()));
		}
		
		return null;
	}

}
