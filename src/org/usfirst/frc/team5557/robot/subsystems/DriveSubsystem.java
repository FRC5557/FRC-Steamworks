package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.OI;
import org.usfirst.frc.team5557.robot.Robot;
import org.usfirst.frc.team5557.robot.RobotMap;
import org.usfirst.frc.team5557.robot.commands.ManualDriveCommand;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
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
	}

	/**
	 * Getter method for Talon Motor controllers. Used for encoders in
	 * SensorSubsystem
	 */
	public CANTalon getTalon(String motor) {
		switch (motor) {
		case "UL":
			return this.leftFront;
		case "BL":
			return this.leftRear;
		case "UR":
			return this.rightFront;
		case "BR":
			return this.rightRear;
		default:
			return this.leftFront;
		}
	}

	public void switchMode(String mode) {
		switch (mode) {
		case "Position":
			this.leftFront.changeControlMode(TalonControlMode.Position);
			this.leftRear.changeControlMode(TalonControlMode.Position);
			this.rightFront.changeControlMode(TalonControlMode.Position);
			this.rightRear.changeControlMode(TalonControlMode.Position);
		case "Speed":
			this.leftFront.changeControlMode(TalonControlMode.Speed);
			this.leftRear.changeControlMode(TalonControlMode.Speed);
			this.rightFront.changeControlMode(TalonControlMode.Speed);
			this.rightRear.changeControlMode(TalonControlMode.Speed);
		case "Percent":
			this.leftFront.changeControlMode(TalonControlMode.PercentVbus);
			this.leftRear.changeControlMode(TalonControlMode.PercentVbus);
			this.rightFront.changeControlMode(TalonControlMode.PercentVbus);
			this.rightRear.changeControlMode(TalonControlMode.PercentVbus);
		default:
			this.leftFront.changeControlMode(TalonControlMode.PercentVbus);
			this.leftRear.changeControlMode(TalonControlMode.PercentVbus);
			this.rightFront.changeControlMode(TalonControlMode.PercentVbus);
			this.rightRear.changeControlMode(TalonControlMode.PercentVbus);
		}
	}

	public void setTargetDrive(double target) {
		this.leftFront.set(target);
		this.leftRear.set(target);
		this.rightFront.set(target);
		this.rightRear.set(target);
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
	public void manualDrive(double magnitude, double radius) {
		double abs_radius = Math.abs(radius);
		double curvature;

		if (radius == 0) {
			curvature = 0;
		} else {
			curvature = (radius / abs_radius) * Math.exp(-abs_radius / RobotMap.BASE_CURVATURE_CONSTANT);
		}

		robotDrive.drive(magnitude, curvature);
	}

	public void drive() {
		double X = OI.driveStick.getX();
		double Y = OI.driveStick.getY();
		double rotation = OI.driveStick.getZ();
		SmartDashboard.putString("Sensor", this.getTalon("BR").isSensorPresent(FeedbackDevice.QuadEncoder).toString());
		SmartDashboard.putNumber("Test", Robot.sensors.getDis());
		//robotDrive.mecanumDrive_Cartesian(X, Y, rotation, 0);
		robotDrive.arcadeDrive(rotation,Y/2.0);
	}
}
