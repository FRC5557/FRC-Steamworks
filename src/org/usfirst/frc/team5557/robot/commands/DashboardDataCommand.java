package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
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
		SmartDashboard.putData("Compass", Robot.sensors.getCompass());
		SmartDashboard.putNumber("Accel_Y", Robot.sensors.getAy());
		SmartDashboard.putNumber("Accel_X", Robot.sensors.getAx());
		SmartDashboard.putNumber("Gyro_X", Robot.sensors.getGx());
		SmartDashboard.putNumber("Gyro_Y", Robot.sensors.getGy());
		SmartDashboard.putNumber("Barometer", Robot.sensors.getCompass().getBarometricPressure());
		SmartDashboard.putNumber("Encoder FL", Robot.sensors.getDis(MotorType.kFrontLeft));
		SmartDashboard.putNumber("Encoder FR", Robot.sensors.getDis(MotorType.kFrontRight));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
