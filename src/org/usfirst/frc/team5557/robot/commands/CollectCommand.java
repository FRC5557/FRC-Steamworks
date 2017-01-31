package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5557.robot.Robot;

/**
 * Command for Fuel Collector
 */
public class CollectCommand extends Command {
    private double count;
    private boolean timed;
    public static boolean end;
    public CollectCommand(){
        requires(Robot.mechanisms);
        timed = false;
        end = false;
    }
    public CollectCommand(double my_count){
        requires(Robot.mechanisms);
        timed = true;
        end = false;
        count = my_count;
    }
    @Override
    protected void initialize(){
        Robot.mechanisms.actMech("Collector",0);
        if(timed) {
            setTimeout(count);
        }
    }
    @Override
    protected void execute(){
        Robot.mechanisms.actMech("Collector",1);
    }
    @Override
    protected boolean isFinished(){
        if(timed){
            return isTimedOut();
        }
        return end;
    }
    @Override
    protected void interrupted(){
        Robot.mechanisms.actMech("Collector",0);
    }
    @Override
    protected void end(){
        Robot.mechanisms.actMech("Collector",0);
    }
}
