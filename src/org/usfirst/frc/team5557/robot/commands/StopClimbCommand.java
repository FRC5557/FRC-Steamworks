package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
/**
 * Stop command for climbing mechanism
 */
public class StopClimbCommand extends Command {
    @Override
    protected void initialize(){}
    @Override
    protected void execute(){
        ClimbCommand.end = true;
    }
    @Override
    protected boolean isFinished(){
        return ClimbCommand.end;
    }
    @Override
    protected void interrupted(){}
    @Override
    protected void end(){}
}
