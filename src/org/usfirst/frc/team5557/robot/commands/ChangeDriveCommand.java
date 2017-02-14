package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Button activated command that changes the drive control on motor controllers
 */
public class ChangeDriveCommand extends Command {
	private String type;

	public ChangeDriveCommand(String my_type) {
		type = my_type;
		requires(Robot.drive);
		System.out.println("Lauren Lugones");
	}

	@Override
	protected void initialize() {
	}

	@Override
	public void execute() {
		SmartDashboard.putString("CDC mode", this.type);
		Robot.drive.switchMode(this.type);
		System.out.println("EXECUTE" + type);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected void end() {
	}
}
