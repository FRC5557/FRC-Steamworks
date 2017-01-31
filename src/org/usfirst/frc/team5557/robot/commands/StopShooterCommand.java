package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to stop shooter motor
 */
public class StopShooterCommand extends Command {
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		ShootCommand.end = true;
	}

	@Override
	protected boolean isFinished() {
		return ShootCommand.end;
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected void end() {
	}
}
