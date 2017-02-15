package org.usfirst.frc.team5557.robot;

import com.ctre.CANTalon.FeedbackDevice;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Driver input devices are mapped here
	public static int JOYSTICK_DRIVE = 0;
	public static int PERCENT_DRIVE_BUTTON = 10;
	public static int SPEED_DRIVE_BUTTON = 2;
	public static int SHOOTER_BUTTON = 1;
	public static int STOP_SHOOTER_BUTTON = 4;
	public static int CLIMBER_BUTTON = 5;
	public static int STOP_CLIMBER_BUTTON = 6;
	public static int COLLECTOR_BUTTON = 7;
	public static int STOP_COLLECTOR_BUTTON = 8;
	public static int REVERSE_CLIMBER_BUTTON = 3;
	public static int EMERGENCY_STOP_BUTTON = 12;

	// Motor controllers are mapped here
	public static final int LEFT_FRONT_MOTOR = 4;
	public static final int LEFT_REAR_MOTOR = 2;
	public static final int RIGHT_FRONT_MOTOR = 3;
	public static final int RIGHT_REAR_MOTOR = 1;
	public static final int SHOOTER_MOTOR = 6;
	public static final int CLIMBER_MOTOR = 7;

	// Sensors are mapped here
	public static final int ULTRA_ANALOG = 0;

	// Constants for encoders connected to Talon SRX
	public static final float PEAK_OUTPUT_VOLTAGE = 9f;
	public static final float NOMINAL_OUTPUT_VOLTAGE = 0f;
	public static final int ENCODER_CODES_PER_REV = 40;
	public static final FeedbackDevice TALON_FEEDBACK_DEVICE = FeedbackDevice.QuadEncoder;
	public static final int ENCODER_PROFILE = 0;
	public static final double PID_FEEDFORWARD = 0;
	public static final double PID_PROPORTIONAL = 0.1;
	public static final double PID_INTEGRAL = 0;
	public static final double PID_DERIVATIVE = 0;

	// Additional constants are placed here
	public static final double MAXBOTIX_VOLTAGE_CONSTANT_MM = 1024f;
	public static final double BASE_CURVATURE_CONSTANT = 20.36;
}
