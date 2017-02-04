package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Basic autonomous turning using Encoders
 */
public class AutoTurnCommand extends Command {
	private double angle;

	public AutoTurnCommand(double my_angle) {
		angle = my_angle;
		requires(Robot.drive);
		requires(Robot.sensors);
	}

	@Override
	protected void initialize() {
		Robot.sensors.resetEncoders();
	}

	/**
	 * Positive angles will make the robot turn to the right. Negative angles
	 * will do the opposite
	 */
	@Override
	protected void execute() {
		Robot.drive.manualDrive(.5, angle);
	}

	/**
	 * Needs to be updated Checks if distance is greater than wheel
	 * circumference times fraction of full revolution Circumference of Mecanum
	 * wheels on robot is 8pi
	 */
	@Override
	protected boolean isFinished() {
		if (Robot.sensors.getDis(MotorType.kFrontLeft) >= (angle / 360) * (8 * Math.PI)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected void end() {
	}
}
