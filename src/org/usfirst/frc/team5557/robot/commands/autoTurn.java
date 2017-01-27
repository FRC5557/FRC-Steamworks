package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5557.robot.Robot;
/**
 * Basic autonomous turning using Encoders
 */
public class autoTurn extends Command {
    private double angle;
    public autoTurn(double my_angle){
        angle = my_angle;
        requires(Robot.drive);
        requires(Robot.sensor);
    }
    protected void initialize(){
        Robot.sensor.resetEncoders();
    }

    /**
     * Positive angles will make the robot turn to the right. Negative angles will do the opposite
     */
    protected void execute(){
        Robot.drive.manualDrive(.5,this.angle);
    }

    /**
     * Needs to be updated
     * Checks if distance is greater than wheel circumference times fraction of full revolution
     * Circumference of Mecanum wheels on robot is 8pi
     */
    protected boolean isFinished(){
        if(Robot.sensor.getDis()>=(this.angle/360)*(8*Math.PI)){
            return true;
        }
        else{
            return false;
        }
    }
    protected void interrupted(){}
    protected void end(){}
}
