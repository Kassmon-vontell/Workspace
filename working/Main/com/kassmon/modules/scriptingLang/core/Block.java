
package com.kassmon.modules.scriptingLang.core;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

/**
 * Represents a block of commands that can be executed sequentially. Implements
 * the Command interface to allow chaining of commands.
 */
public class Block extends Command {

	/**
	 * Executes the current block and, if a next command exists, executes it as
	 * well.
	 *
	 * @param memory the runtime memory environment used during execution
	 */
	@Override
	public void run(Memory memory) {
		if (super.hasNextCommand()) super.getNextCommand().run(memory);
	}

}
