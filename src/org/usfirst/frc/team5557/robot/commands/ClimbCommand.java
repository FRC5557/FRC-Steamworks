package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for climbing mechanism
 */
public class ClimbCommand extends Command {
	public static boolean end;
	private double speed;

	public ClimbCommand(double my_speed) {
		requires(Robot.mechanisms);
		end = false;
		speed = my_speed;
	}

	@Override
	protected void initialize() {
		Robot.mechanisms.climb(0);
		end = false;
	}

	@Override
	protected void execute() {
		Robot.mechanisms.climb(speed);
	}

	@Override
	protected boolean isFinished() {
		return end;
	}

	@Override
	protected void interrupted() {
		Robot.mechanisms.climb(0);
	}

	@Override
	protected void end() {
		Robot.mechanisms.climb(0);
	}
}
