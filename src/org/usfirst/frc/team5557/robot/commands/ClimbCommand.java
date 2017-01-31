package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5557.robot.Robot;
/**
 * Command for climbing mechanism
 */
public class ClimbCommand extends Command{
    public static boolean end;
    public ClimbCommand(){
        requires(Robot.mechanisms);
        end = false;
    }
    @Override
    protected void initialize(){
        Robot.mechanisms.actMech("Climber",0);
    }
    @Override
    protected void execute(){
        Robot.mechanisms.actMech("Climber",1);
    }
    @Override
    protected boolean isFinished(){
        return end;
    }
    @Override
    protected void interrupted(){
        Robot.mechanisms.actMech("Climber",0);
    }
    @Override
    protected void end(){
        Robot.mechanisms.actMech("Climber",0);
    }
}
