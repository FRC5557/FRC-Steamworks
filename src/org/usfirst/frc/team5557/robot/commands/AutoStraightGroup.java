package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous path in which robot starts aligned with peg
 */
public class AutoStraightGroup extends CommandGroup {
	public AutoStraightGroup() {
		addSequential(new UltraDriveCommand(1000));// Drive towards peg up until
												// certain distance
		//addSequential(new WaitCommand(100));// Extra time for gear to get on peg
		//addSequential(new AutoLinearDriveCommand(-1));// Reverse out of airship
														// spot
		//addSequential(new AutoTurnCommand(1));// Turn towards boiler
		/**
		 * Vision bit
		 */

	}
}
