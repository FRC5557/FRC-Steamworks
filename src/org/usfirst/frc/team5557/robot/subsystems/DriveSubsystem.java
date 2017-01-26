package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.RobotMap;
import org.usfirst.frc.team5557.robot.commands.JoystickDriveCommand;
import org.usfirst.frc.team5557.robot.OI;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
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
	public DriveSubsystem(){
		
	}
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDriveCommand());
	}

	public void drive() {
		double X = OI.driveStick.getX();
		double Y = OI.driveStick.getY();
		double magnitude = OI.driveStick.getMagnitude();
		double direction = OI.driveStick.getDirectionDegrees();
		double rotation = OI.driveStick.getZ();
		//robotDrive.arcadeDrive(5*Y,rotation);
		robotDrive.mecanumDrive_Polar(magnitude, direction, rotation);
		//robotDrive.mecanumDrive_Cartesian(X,Y, rotation, 0);
	}
}
