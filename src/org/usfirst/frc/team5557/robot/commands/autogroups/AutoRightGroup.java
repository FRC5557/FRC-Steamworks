package org.usfirst.frc.team5557.robot.commands.autogroups;

import org.usfirst.frc.team5557.robot.commands.DriveForDistanceCommand;
import org.usfirst.frc.team5557.robot.commands.TurnForAngleCommand;
import org.usfirst.frc.team5557.robot.commands.UltraDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous path for robot starting on right alliance spot headed for
 * rightmost peg
 */
public class AutoRightGroup extends CommandGroup {
	public AutoRightGroup(boolean shoot) {
		addSequential(new DriveForDistanceCommand(100));// Drive forward
		addSequential(new TurnForAngleCommand(1));// Turn towards peg
		addSequential(new UltraDriveCommand(1));// Drive towards peg until
												// certain distance
		addSequential(new WaitCommand(100));// Extra time to make sure gear gets
											// on peg
		addSequential(new DriveForDistanceCommand(-1));// reverse out of airship
														// slot
		addSequential(new TurnForAngleCommand(1));// turn towards boiler

		if (shoot) {
			// TODO vision processing
		}
	}
}
