package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Driving autonomously in a straight line up until certain distance using
 * MaxBotix Ultrasonic
 */
public class UltraDriveCommand extends Command {
	private double dis;

	public UltraDriveCommand(double my_dis) {
		dis = my_dis;
		requires(Robot.sensors);
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.drive.manualDrive(.5, 0);
	}

	@Override
	protected boolean isFinished() {
		if (Robot.sensors.getUltra() >= this.dis) {
			Robot.drive.manualDrive(0, 0);
			return true;
		}
		return false;
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected void end() {
	}
}