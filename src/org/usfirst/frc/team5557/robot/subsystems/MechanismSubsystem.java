package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem which contains the main mechanisms including shooting, climbing,
 * and collecting
 */
public class MechanismSubsystem extends Subsystem {

	private CANTalon shooter = new CANTalon(RobotMap.SHOOTER_MOTOR);
	private CANTalon climber = new CANTalon(RobotMap.CLIMBER_MOTOR);
	

	public MechanismSubsystem() {
	}

	@Override
	public void initDefaultCommand() {
	}

	public void actMech(String mech, double speed) {
		switch (mech) {
		case "Shooter":
			shooter.set(speed);
		case "Climber":
			climber.set(speed);
		default:
		}
	}

}
