package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Basic Linear Movement in Autonomous
 */
public class AutoLinearDriveCommand extends Command {
	private double dis;

	public AutoLinearDriveCommand(double my_dis) {
		dis = my_dis;
		requires(Robot.drive);
		requires(Robot.sensor);
	}

	@Override
	protected void initialize() {
		Robot.sensor.resetEncoders();
	}

	@Override
	protected void execute() {
		Robot.drive.manualDrive(.5, 0);
	}

	@Override
	protected boolean isFinished() {
		if (Robot.sensor.getDis() < this.dis) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected void end() {
	}
}
