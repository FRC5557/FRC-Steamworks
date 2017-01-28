package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.RobotMap;
import org.usfirst.frc.team5557.robot.commands.ManualDriveCommand;
import org.usfirst.frc.team5557.robot.OI;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

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
	 * Accessor method for Talon Motor controllers. Used for encoders in
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
	public void manualDrive(double magnitude, double curvature) {
		robotDrive.drive(magnitude, curvature);
	}

	public void drive() {
		double X = OI.driveStick.getX();
		double Y = OI.driveStick.getY();
		double magnitude = OI.driveStick.getMagnitude();
		double direction = OI.driveStick.getDirectionDegrees();
		double rotation = OI.driveStick.getZ();
		// robotDrive.arcadeDrive(Y * .5, rotation);
		// robotDrive.mecanumDrive_Polar(magnitude, direction, rotation);
		robotDrive.mecanumDrive_Cartesian(X, Y, rotation, 0);
	}
}
