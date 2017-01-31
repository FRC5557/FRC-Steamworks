package org.usfirst.frc.team5557.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team5557.robot.RobotMap;
import org.usfirst.frc.team5557.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Joysticks defined here
	public static final Joystick driveStick = new Joystick(RobotMap.JOYSTICK_DRIVE);

	// Buttons defined here
	public final Button percentDriveButton = new JoystickButton(driveStick, RobotMap.PERCENT_DRIVE_BUTTON);
	public final Button speedDriveButton = new JoystickButton(driveStick, RobotMap.SPEED_DRIVE_BUTTON);
	public final Button shooterButton = new JoystickButton(driveStick,RobotMap.SHOOTER_BUTTON);
	public final Button stopShooterButton = new JoystickButton(driveStick,RobotMap.STOP_SHOOTER_BUTTON);
	public final Button climberButton = new JoystickButton(driveStick,RobotMap.CLIMBER_BUTTON);
	public final Button stopClimberButton = new JoystickButton(driveStick,RobotMap.STOP_CLIMBER_BUTTON);
	public final Button collectorButton = new JoystickButton(driveStick,RobotMap.COLLECTOR_BUTTON);
	public final Button stopCollectorButton = new JoystickButton(driveStick,RobotMap.STOP_COLLECTOR_BUTTON);
	public final Button eStopButton = new JoystickButton(driveStick,RobotMap.EMERGENCY_STOP_BUTTON);

	public OI() {
		percentDriveButton.whenPressed(new ChangeDriveCommand("Percent"));
		speedDriveButton.whenPressed(new ChangeDriveCommand("Speed"));
		shooterButton.whenPressed(new ShootCommand());
		stopShooterButton.whenPressed(new StopShooterCommand());
		climberButton.whenPressed(new ClimbCommand());
		stopClimberButton.whenPressed(new StopClimbCommand());
		collectorButton.whenPressed(new CollectCommand());
		stopCollectorButton.whenPressed(new StopCollectCommand());
		eStopButton.whenPressed(new SoftEStopCommand());
	}

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
