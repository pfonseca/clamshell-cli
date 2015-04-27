package org.clamshellcli.impl.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class TouchCmd implements Command {

	private static final String NAMESPACE = "syscmd";
	private static final String CMD_NAME = "touch";

	private class TouchParams {

		@Parameter(required = true)
		public List<String> folder = new ArrayList<String>();
	}

	@Override
	public void plug(Context arg0) {

	}

	@Override
	public void unplug(Context arg0) {

	}

	@Override
	public Object execute(Context ctx) {

		IOConsole ioConsole = ctx.getIoConsole();

		String[] args = (String[]) ctx.getValue(Context.KEY_COMMAND_LINE_ARGS);

		if (args == null)
			args = new String[0];

		TouchParams object = new TouchParams();
		JCommander jCommander = new JCommander(object, args);

		List<String> params = object.folder;
		
		ioConsole.println(object.toString());

		return null;
	}

	@Override
	public Descriptor getDescriptor() {
		return new Command.Descriptor() {
			@Override
			public String getNamespace() {
				return NAMESPACE;
			}

			@Override
			public String getName() {
				return CMD_NAME;
			}

			@Override
			public String getDescription() {
				return "Create or update file's modified date";
			}

			@Override
			public String getUsage() {
				return "Type 'touch'";
			}

			@Override
			public Map<String, String> getArguments() {
				return Collections.emptyMap();
			}
		};
	}

}
