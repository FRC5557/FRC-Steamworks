package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Basic Linear Movement in Autonomous
 */
public class AutoLinearDriveCommand extends Command {
	private double dis;

	public AutoLinearDriveCommand(double my_dis) {
		dis = my_dis;
		requires(Robot.drive);
		requires(Robot.sensors);
	}

	@Override
	protected void initialize() {
		Robot.sensors.resetEncoders();
	}

	@Override
	protected void execute() {
		Robot.drive.manualDrive(.5, 0);
	}

	@Override
	protected boolean isFinished() {
		if (Robot.sensors.getDis(MotorType.kFrontLeft) < this.dis) {
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
