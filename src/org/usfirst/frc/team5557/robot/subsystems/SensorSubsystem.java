package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.Robot;
import org.usfirst.frc.team5557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Subsystem containing all sensors for the robot
 */
public class SensorSubsystem extends Subsystem {
	private PWM ultra = new PWM(RobotMap.PWM_CHANNEL);
	private Encoder UL = new Encoder(RobotMap.ENCODER_UL_1, RobotMap.ENCODER_UL_2);
	private Encoder BL = new Encoder(RobotMap.ENCODER_BL_1, RobotMap.ENCODER_BL_2);
	private Encoder UR = new Encoder(RobotMap.ENCODER_UR_1, RobotMap.ENCODER_UR_2);
	private Encoder BR = new Encoder(RobotMap.ENCODER_BR_1, RobotMap.ENCODER_BR_2);

	public SensorSubsystem() {

	}

	public void initDefaultCommand() {
	}

	public double getUltra() {
		return ultra.getRaw();
	}

	public void resetEncoders() {
		UL.reset();
		BL.reset();
		UR.reset();
		BR.reset();
	}

	public double getDis() {
		double avgDis = (UL.getDistance() + BL.getDistance() + UR.getDistance() + BR.getDistance()) / 4;
		return avgDis;
	}
}
