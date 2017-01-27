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

	// Motor controllers are mapped here
	public static final int LEFT_FRONT_MOTOR = 1;
	public static final int LEFT_REAR_MOTOR = 3;
	public static final int RIGHT_FRONT_MOTOR = 2;
	public static final int RIGHT_REAR_MOTOR = 4;

	// Sensors are mapped here
	public static final int PWM_CHANNEL = 0;
	public static final int ULTRA_CHANNEL_1 = 0;
	public static final int ULTRA_CHANNEL_2 = 1;
	public static final int ENCODER_UL_1 = 0;
	public static final int ENCODER_UL_2 = 1;
	public static final int ENCODER_BL_1 = 2;
	public static final int ENCODER_BL_2 = 3;
	public static final int ENCODER_UR_1 = 4;
	public static final int ENCODER_UR_2 = 5;
	public static final int ENCODER_BR_1 = 6;
	public static final int ENCODER_BR_2 = 7;
}
