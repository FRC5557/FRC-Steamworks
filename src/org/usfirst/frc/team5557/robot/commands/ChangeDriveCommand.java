package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Button activated command that changes the drive control on motor controllers
 */
public class ChangeDriveCommand extends Command {
	private String type;

	public ChangeDriveCommand(String my_type) {
		type = new String(my_type);
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.drive.switchMode(this.type);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected void end() {
	}
}
