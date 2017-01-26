package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.Command;
/**
 * Basic Linear Movement in Autonomous
 */
public class autoLinear extends Command {
    public autoLinear(){
        requires(Robot.drive);
        requires(Robot.sensor);
    }
    protected void initialize(){
        Robot.sensor.resetEncoders();
    }
    protected void execute(){
        while(Robot.sensor.getDis()<200) {
            Robot.drive.drive();
        }

    }
    protected boolean isFinished(){
        if (Robot.sensor.getDis() <200){
            return false;
        }
        else{
            return true;
        }
    }
    protected void interrupted(){}
    protected void end(){}
}
