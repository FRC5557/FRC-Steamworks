package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.commands.Command;
/**
 * Button activated command that changes the drive control on motor controllers
 */
public class changeDrive extends Command {
    private String type;
    public changeDrive(String my_type){
        type = new String(my_type);
        requires(Robot.drive);
    }
    protected void initialize(){}

    protected void execute(){
        Robot.drive.switchMode(this.type);
    }

    protected boolean isFinished(){return true;}

    protected void interrupted(){}

    protected void end(){}
}
