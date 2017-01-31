package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous path for robot starting on left alliance spot headed for leftmost
 * peg
 */
public class AutoLeftGroup extends CommandGroup {
	public AutoLeftGroup() {
		addSequential(new AutoLinearDriveCommand(100));// Drive forward
		addSequential(new AutoTurnCommand(1));// Turn towards peg
		addSequential(new UltraDriveCommand(1));// Drive towards peg until
												// certain distance
		addSequential(new WaitCommand(100));// Extra time to make sure gear gets
											// on peg
		addSequential(new AutoLinearDriveCommand(-1));// reverse out of airship
														// slot
		addSequential(new AutoTurnCommand(1));// turn towards boiler
		/**
		 * Vision bit
		 */
	}
}
