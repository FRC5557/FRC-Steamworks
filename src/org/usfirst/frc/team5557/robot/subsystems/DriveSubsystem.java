package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.OI;
import org.usfirst.frc.team5557.robot.Robot;
import org.usfirst.frc.team5557.robot.RobotMap;
import org.usfirst.frc.team5557.robot.commands.ManualDriveCommand;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem which is simply the drive train of the robot
 */
public class DriveSubsystem extends Subsystem {

	private CANTalon leftFront = new CANTalon(RobotMap.LEFT_FRONT_MOTOR);
	private CANTalon leftRear = new CANTalon(RobotMap.LEFT_REAR_MOTOR);
	private CANTalon rightFront = new CANTalon(RobotMap.RIGHT_FRONT_MOTOR);
	private CANTalon rightRear = new CANTalon(RobotMap.RIGHT_REAR_MOTOR);
	private RobotDrive robotDrive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);

	public DriveSubsystem() {
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, false);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, false);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		// Set up Talon SRX controllers

		for (MotorType m : MotorType.values()) {
			getTalon(m).configNominalOutputVoltage(+RobotMap.NOMINAL_OUTPUT_VOLTAGE, -RobotMap.NOMINAL_OUTPUT_VOLTAGE);
			getTalon(m).configPeakOutputVoltage(+RobotMap.PEAK_OUTPUT_VOLTAGE, -RobotMap.PEAK_OUTPUT_VOLTAGE);
		}

		// This suppresses the "Output not frequent enough" message
		robotDrive.setSafetyEnabled(false);
	}

	/**
	 * Getter method for Talon SRX controllers. Used for encoders in
	 * SensorSubsystem
	 */
	public CANTalon getTalon(MotorType motor) {
		switch (motor) {
		case kFrontLeft:
			return leftFront;
		case kRearLeft:
			return leftRear;
		case kFrontRight:
			return rightFront;
		case kRearRight:
			return rightRear;
		default:
			return leftFront;
		}
	}
	public void switchMode(TalonControlMode mode) {
		for (MotorType m : MotorType.values()) {
			getTalon(m).changeControlMode(mode);
		}
	}

	public void setDriveTarget(double target) {
		for (MotorType m : MotorType.values()) {
			getTalon(m).set(target);
		}
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ManualDriveCommand());
	}

	/**
	 * Set curve < 0 for left turn or curve > 0 for right turn. Set curve =
	 * e^(-r/w) to get a turn radius r for wheelbase w of your robot.
	 * Conversely, turn radius r = -ln(curve)*w for a given value of curve and
	 * wheelbase w.
	 **/
	public void manualDrive(double magnitude, double turn) {
		/*double abs_radius = Math.abs(radius);
		double curvature;

		if (radius == 0) {
			curvature = 0;
		} else {
			curvature = (radius / abs_radius) * Math.exp(-abs_radius / RobotMap.BASE_CURVATURE_CONSTANT);
		}*/
		
		robotDrive.arcadeDrive(turn,magnitude);
	}

	public void stop() {
		manualDrive(0, 0);
	}

	public void drive() {
		double X = -OI.driveStick.getX();
		double Y = -OI.driveStick.getY();
		double rotation = OI.driveStick.getTwist();

		robotDrive.arcadeDrive(rotation,Y);
	}
}
