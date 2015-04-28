package org.clamshellcli.impl.commands;

import java.net.InetAddress;
import java.util.Collections;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

public class HostnameCmd implements Command{
	
    private static final String NAMESPACE = "syscmd";
    private static final String CMD_NAME = "hostname";
    

	@Override
	public void plug(Context plug) {
		
	}

	@Override
	public void unplug(Context plug) {
		
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
               return "Return hostname";
            }

            @Override
            public String getUsage() {
                return "Type 'hostname'";
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
		String hostname = "";

		try {
			InetAddress ia = InetAddress.getLocalHost();
			hostname = ia.getHostName();
			ioConsole.println(hostname);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hostname;
	}

}
