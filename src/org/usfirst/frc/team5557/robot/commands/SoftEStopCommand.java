package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
/**
 * Driver Controlled Emergency Stop for all Mechanisms
 */
public class SoftEStopCommand extends Command {
    public static boolean end;
    @Override
    protected void initialize(){end=false;}
    @Override
    protected void execute(){
        Scheduler.getInstance().removeAll();
        end = true;
    }
    @Override
    protected boolean isFinished(){
        return end;
    }
    @Override
    protected void interrupted(){}
    @Override
    protected void end(){}
}
