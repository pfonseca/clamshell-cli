package org.clamshellcli.impl.commands;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

public class IfConfigCmd implements Command{

    private static final String NAMESPACE = "syscmd";
    private static final String CMD_NAME = "ifconfig";
	
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
               return "Return all ip address";
            }

            @Override
            public String getUsage() {
                return "Type 'ifconfig'";
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
		
		try{
			Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
			 
		      while (en.hasMoreElements()) {
		         NetworkInterface ni = en.nextElement();
		 
		         ioConsole.println("Interface Name:  " + ni.getName());
		         ioConsole.println("  Display Name = " + ni.getDisplayName());
		         ioConsole.println("  Is up = " + ni.isUp());
		         ioConsole.println("  Support multicast = " + ni.supportsMulticast());
		         ioConsole.println("  Is loopback = " + ni.isLoopback());
		         ioConsole.println("  Is virtual = " + ni.isVirtual());
		         ioConsole.println("  Is point to point = " + ni.isPointToPoint());
		         ioConsole.println("  Hardware address = " + getMacAddress(ni.getHardwareAddress()));
		         ioConsole.println("  MTU = " + ni.getMTU());
		 
		         ioConsole.println("  List of Interface Addresses:");
		         List<InterfaceAddress> list = ni.getInterfaceAddresses();
		         Iterator<InterfaceAddress> it = list.iterator();
		 
		         while (it.hasNext()) {
		            InterfaceAddress ia = it.next();
		            ioConsole.println("    Address = " + ia.getAddress());
		            ioConsole.println("    Broadcast = " + ia.getBroadcast());
		            ioConsole.println("    Network prefix length = " + ia.getNetworkPrefixLength());
		            ioConsole.println("");
		         }
		      }
		      
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return null;
	}

	private String getMacAddress(byte[] mac) {
		
		StringBuilder sb = new StringBuilder();
		
		if(mac != null){
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i],
						(i < mac.length - 1) ? "-" : ""));
			}
		}
		
		return sb.toString();
	}

}
