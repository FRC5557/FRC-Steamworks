package org.usfirst.frc.team5557.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Driver input devices are mapped here
	public static int JOYSTICK_DRIVE = 0;
	public static int PERCENT_DRIVE_BUTTON = 1;
	public static int SPEED_DRIVE_BUTTON = 2;

	// Motor controllers are mapped here
	public static final int LEFT_FRONT_MOTOR = 1;
	public static final int LEFT_REAR_MOTOR = 3;
	public static final int RIGHT_FRONT_MOTOR = 2;
	public static final int RIGHT_REAR_MOTOR = 4;

	// Sensors are mapped here
	public static final int ULTRA_ANALOG = 0;
	public static final int ULTRA_CHANNEL_1 = 1;
	public static final int ULTRA_CHANNEL_2 = 2;

	// Additional constants are placed here
	public static final double MAXBOTIX_VOLTAGE_CONSTANT_MM = 1024;
}
