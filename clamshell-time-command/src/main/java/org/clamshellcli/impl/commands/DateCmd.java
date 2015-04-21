package org.clamshellcli.impl.commands;

import java.util.Collections;
import java.util.Map;

import org.clamshellcli.api.Command;


public class DateCmd extends TimeCmd{
	
    private static final String NAMESPACE = "syscmd";
    private static final String ACTION_NAME = "date";
	
	
    @Override
    public Command.Descriptor getDescriptor(){
        return new Command.Descriptor() {
            @Override public String getNamespace() {return NAMESPACE;}
            
            @Override
            public String getName() {
                return ACTION_NAME;
            }

            @Override
            public String getDescription() {
               return "Prints current date/time";
            }

            @Override
            public String getUsage() {
                return "Type 'date'";
            }

            @Override
            public Map<String, String> getArguments() {
                return Collections.emptyMap();
            }
        };
    }
    
    
}
