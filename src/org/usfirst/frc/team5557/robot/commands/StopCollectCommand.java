package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
/**
 * Stop command for fuel collector
 */
public class StopCollectCommand extends Command {
    @Override
    protected void initialize(){}
    @Override
    protected void execute(){
        CollectCommand.end = true;
    }
    @Override
    protected boolean isFinished(){
        return CollectCommand.end;
    }
    @Override
    protected void interrupted(){}
    @Override
    protected void end(){}
}
