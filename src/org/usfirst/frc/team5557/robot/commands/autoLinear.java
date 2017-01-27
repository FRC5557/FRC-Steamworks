package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * Basic Linear Movement in Autonomous
 */
public class autoLinear extends Command {
    private double dis;
    public autoLinear(double my_dis){
        dis = my_dis;
        requires(Robot.drive);
        requires(Robot.sensor);
    }
    protected void initialize(){
        Robot.sensor.resetEncoders();
    }
    protected void execute(){
        Robot.drive.manualDrive(.5,0);
    }
    protected boolean isFinished(){
        if (Robot.sensor.getDis() <this.dis){
            return false;
        }
        else{
            return true;
        }
    }
    protected void interrupted(){}
    protected void end(){}
}
