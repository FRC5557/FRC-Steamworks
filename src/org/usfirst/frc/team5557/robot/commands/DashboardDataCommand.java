package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.OI;
import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DashboardDataCommand extends Command {

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("MaxBotix Ultrasonic", Robot.sensors.getUltra());
		SmartDashboard.putNumber("Accel_Y", Robot.sensors.getAy());
		SmartDashboard.putNumber("Accel_X", Robot.sensors.getAx());
		SmartDashboard.putNumber("Gyro_X", Robot.sensors.getGx());
		SmartDashboard.putNumber("Gyro_Y", Robot.sensors.getGy());
		
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

}
