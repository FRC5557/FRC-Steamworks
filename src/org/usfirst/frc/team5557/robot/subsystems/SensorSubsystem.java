package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.Robot;
import org.usfirst.frc.team5557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import com.ctre.CANTalon.FeedbackDevice;

/**
 * Subsystem containing all sensors for the robot
 */
public class SensorSubsystem extends Subsystem {
	public AnalogInput ultra = new AnalogInput(RobotMap.ULTRA_ANALOG);
	private Ultrasonic ping_ultra = new Ultrasonic(RobotMap.ULTRA_CHANNEL_1, RobotMap.ULTRA_CHANNEL_2);

	public SensorSubsystem() {
		setEncoders();
		setPulse();
		ping_ultra.setAutomaticMode(true);
	}

	@Override
	public void initDefaultCommand() {
		ping_ultra.setAutomaticMode(true);
	}

	/**
	 * Sets the number of expected pulses per revolution coming from encoders
	 * Encoders rated to send 20 pulses per revolution*channel(2 channels total)
	 */
	public void setPulse() {
		Robot.drive.getTalon("UL").configEncoderCodesPerRev(40);
		Robot.drive.getTalon("BL").configEncoderCodesPerRev(40);
		Robot.drive.getTalon("UR").configEncoderCodesPerRev(40);
		Robot.drive.getTalon("BR").configEncoderCodesPerRev(40);
	}

	public void setEncoders() {
		Robot.drive.getTalon("UL").setFeedbackDevice(FeedbackDevice.QuadEncoder);
		Robot.drive.getTalon("UL").reverseSensor(false);
		Robot.drive.getTalon("UL").configNominalOutputVoltage(+0f, -0f);
		Robot.drive.getTalon("UL").configPeakOutputVoltage(+12f, -12f);
		Robot.drive.getTalon("UL").setProfile(0);
		Robot.drive.getTalon("UL").setF(0.0);
		Robot.drive.getTalon("UL").setPID(0.1, 0.0, 0.0);

		Robot.drive.getTalon("BL").setFeedbackDevice(FeedbackDevice.QuadEncoder);
		Robot.drive.getTalon("BL").reverseSensor(false);
		Robot.drive.getTalon("BL").configNominalOutputVoltage(+0f, -0f);
		Robot.drive.getTalon("BL").configPeakOutputVoltage(+12f, -12f);
		Robot.drive.getTalon("BL").setProfile(0);
		Robot.drive.getTalon("BL").setF(0.0);
		Robot.drive.getTalon("BL").setPID(0.1, 0.0, 0.0);

		Robot.drive.getTalon("UR").setFeedbackDevice(FeedbackDevice.QuadEncoder);
		Robot.drive.getTalon("UR").reverseSensor(false);
		Robot.drive.getTalon("UR").configNominalOutputVoltage(+0f, -0f);
		Robot.drive.getTalon("UR").configPeakOutputVoltage(+12f, -12f);
		Robot.drive.getTalon("UR").setProfile(0);
		Robot.drive.getTalon("UR").setF(0.0);
		Robot.drive.getTalon("UR").setPID(0.1, 0.0, 0.0);

		Robot.drive.getTalon("BR").setFeedbackDevice(FeedbackDevice.QuadEncoder);
		Robot.drive.getTalon("BR").reverseSensor(false);
		Robot.drive.getTalon("BR").configNominalOutputVoltage(+0f, -0f);
		Robot.drive.getTalon("BR").configPeakOutputVoltage(+12f, -12f);
		Robot.drive.getTalon("BR").setProfile(0);
		Robot.drive.getTalon("BR").setF(0.0);
		Robot.drive.getTalon("BR").setPID(0.1, 0.0, 0.0);
	}

	/**
	 * For MaxBotix Ultrasonic
	 */
	public double getUltra() {
		return ultra.getVoltage() * RobotMap.MAXBOTIX_VOLTAGE_CONSTANT_MM;
	}

	/**
	 * For Vex Ping Response Ultrasonic
	 */
	public double getPingUltra(String type) {
		switch (type) {
		case "MM":
			return ping_ultra.getRangeMM();
		case "Inches":
			return ping_ultra.getRangeInches();
		default:
			return ping_ultra.getRangeInches();
		}
	}

	public void resetEncoders() {
		Robot.drive.getTalon("UL").setPosition(0);
		Robot.drive.getTalon("BL").setPosition(0);
		Robot.drive.getTalon("UR").setPosition(0);
		Robot.drive.getTalon("BR").setPosition(0);
	}

	/**
	 * Gets the position values from each Talon Feedback Device and averages
	 * them
	 */
	public double getDis() {
		double UL = Robot.drive.getTalon("UL").getEncPosition();
		double BL = Robot.drive.getTalon("BL").getEncPosition();
		double UR = Robot.drive.getTalon("UR").getEncPosition();
		double BR = Robot.drive.getTalon("BR").getEncPosition();
		double avgDis = UR;
		return avgDis;
	}
}
