
package org.usfirst.frc.team5557.robot;

import org.opencv.core.Mat;
import org.usfirst.frc.team5557.robot.commands.DashboardDataCommand;
import org.usfirst.frc.team5557.robot.commands.autogroups.AutoLeftGroup;
import org.usfirst.frc.team5557.robot.commands.autogroups.AutoRightGroup;
import org.usfirst.frc.team5557.robot.commands.autogroups.AutoStraightGroup;
import org.usfirst.frc.team5557.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team5557.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5557.robot.subsystems.SensorSubsystem;
import org.usfirst.frc.team5557.robot.subsystems.ShooterSubsystem;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveSubsystem drive = new DriveSubsystem();
	public static OI oi;
	public static final SensorSubsystem sensors = new SensorSubsystem();
	public static final ClimberSubsystem climber = new ClimberSubsystem();
	public static final ShooterSubsystem shooter = new ShooterSubsystem();

	Command autonomousCommand;
	Command dashboardDataCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();

		chooser.addDefault("Middle DS Auto", new AutoStraightGroup(true));
		chooser.addObject("Left DS Auto", new AutoLeftGroup(true));
		chooser.addObject("Right DS Auto", new AutoRightGroup(true));
		chooser.addObject("Middle DS No Shoot", new AutoStraightGroup(false));
		chooser.addObject("Left DS No Shoot", new AutoLeftGroup(false));
		chooser.addObject("Right DS No Shoot", new AutoRightGroup(false));
		SmartDashboard.putData("Autonomous Programs", chooser);
		dashboardDataCommand = new DashboardDataCommand();
		
		Thread camera = new Thread(() -> {
			boolean displaycam1 = true;
			UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture("Cam1",0);
			cam1.setResolution(160,120);
			cam1.setFPS(10);
			UsbCamera cam2 = CameraServer.getInstance().startAutomaticCapture("Cam2",1);
			cam2.setResolution(160,120);
			cam2.setFPS(10);
			CvSink cam1sink = CameraServer.getInstance().getVideo(cam1);
			CvSink cam2sink = CameraServer.getInstance().getVideo(cam2);
			CvSource switcher = CameraServer.getInstance().putVideo("Switcher",160,120);
			Mat image = new Mat();
			while(!Thread.interrupted()) {
				if (oi.driveStick.getRawButton(RobotMap.CAMERA_SWITCH)){
					displaycam1 = !displaycam1;
				}
				if(displaycam1) {
					cam1sink.setEnabled(true);
					cam2sink.setEnabled(false);
					cam1sink.grabFrame(image);
				}
				else{
					cam1sink.setEnabled(false);
					cam2sink.setEnabled(true);
					cam2sink.grabFrame(image);
				}
			}
			switcher.putFrame(image);
		});
		camera.start();
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		// Schedule the autonomous command
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
		drive.switchMode(TalonControlMode.Position);
		dashboardDataCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		drive.switchMode(TalonControlMode.PercentVbus);
		dashboardDataCommand.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
