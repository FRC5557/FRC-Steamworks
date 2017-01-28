package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5557.robot.commands.AutoLinearDriveCommand;
import org.usfirst.frc.team5557.robot.commands.AutoTurnCommand;

public class AutoGroup extends CommandGroup {
	public AutoGroup() {
		addSequential(new AutoLinearDriveCommand(200));// Parameter is for the
														// distance
														// threshold.When
														// encoders returns
														// value above para,
														// robot stops
		addSequential(new AutoTurnCommand(50));
	}
}
