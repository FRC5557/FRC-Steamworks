package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem is responsible for the shooter system, including the ball
 * feeder
 */
public class ShooterSubsystem extends Subsystem {

	private CANTalon shooter = new CANTalon(RobotMap.SHOOTER_MOTOR);
	private CANTalon collector = new CANTalon(RobotMap.COLLECTOR_MOTOR);

	@Override
	public void initDefaultCommand() {
	}

	public void shoot(double speed) {
		shooter.set(Math.abs(speed));
	}

	public void shootMax() {
		shoot(1);
	}

	public void stop() {
		shoot(0);
	}
	
	public void agitate(double speed) {
		collector.set(Math.abs(speed));
	}
	
	public void stopCollector() {
		agitate(0);
	}
}
