package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DashboardDataCommand extends Command {

	// This command should require all subsystems from which it is getting data
	public DashboardDataCommand() {
		requires(Robot.drive);
		requires(Robot.sensors);

	}

	// This should have all necessary outputs to the SmartDashboard
	@Override
	protected void execute() {
		SmartDashboard.putNumber("MaxBotix Ultrasonic", Robot.sensors.getUltra());
		SmartDashboard.putData("Compass",Robot.sensors.getCompass());
		SmartDashboard.putNumber("Ax",Robot.sensors.getAx());
		SmartDashboard.putNumber("Ay",Robot.sensors.getAy());
		SmartDashboard.putNumber("GyroX",Robot.sensors.getGx());
		SmartDashboard.putNumber("GyroY",Robot.sensors.getGy());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
