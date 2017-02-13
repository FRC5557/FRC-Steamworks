package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Fuel Shooter Command
 */
public class ShootCommand extends Command {
	private double count;
	private boolean timed;
	public static boolean end;

	public ShootCommand() {
		requires(Robot.mechanisms);
		timed = false;
		end = false;
	}

	public ShootCommand(double my_count) {
		requires(Robot.mechanisms);
		timed = true;
		end = false;
		count = my_count;
	}

	@Override
	protected void initialize() {
		Robot.mechanisms.actMech("Shooter", 1);
		end = false;
		if (timed) {
			setTimeout(count);
		}
	}

	@Override
	protected void execute() {
		Robot.mechanisms.actMech("Shooter", 1);
	}

	@Override
	protected boolean isFinished() {
		if (timed) {
			return isTimedOut();
		}
		return end;
	}

	@Override
	protected void interrupted() {
		Robot.mechanisms.actMech("Shooter", 0);
	}

	@Override
	protected void end() {
		Robot.mechanisms.actMech("Shooter", 0);
	}
}
