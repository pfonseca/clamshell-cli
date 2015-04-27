package org.clamshellcli.impl.commands;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

import com.github.axet.wget.WGet;

public class WGetCmd implements Command{

    private static final String NAMESPACE = "syscmd";
    private static final String CMD_NAME = "wget";
	
	
	@Override
	public void plug(Context arg0) {
		
	}
	
	@Override
	public void unplug(Context arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object execute(Context ctx) {
		IOConsole ioConsole = ctx.getIoConsole();
		
		ioConsole.println("antes wget");
		
		try {
            // choise internet url (ftp, http)
            URL url = new URL("http://download.virtualbox.org/virtualbox/4.2.4/VirtualBox-4.2.4-81684-OSX.dmg");
            // choise target folder or filename "/Users/axet/Downloads/ap61.ram"
            File target = new File("/Users/axet/Downloads/");
            // initialize wget object
            WGet w = new WGet(url, target);
            // single thread download. will return here only when file download
            // is complete (or error raised).
            w.download();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RuntimeException allDownloadExceptions) {
            allDownloadExceptions.printStackTrace();
        }
		
		return null;
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
               return "Download files";
            }

            @Override
            public String getUsage() {
                return "Type 'wget'";
            }

            @Override
            public Map<String, String> getArguments() {
                return Collections.emptyMap();
            }
        };
	}

}
