package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem responsible for the climbing mechanism
 */
public class ClimberSubsystem extends Subsystem {

	private CANTalon climber = new CANTalon(RobotMap.CLIMBER_MOTOR);

	@Override
	public void initDefaultCommand() {
	}

	public void climb(double speed) {
		climber.set(speed);
	}

	public void climbMax() {
		climb(1);
	}

	public void wind(double speed) {
		climb(speed);
	}

	public void stop() {
		climb(0);
	}
}