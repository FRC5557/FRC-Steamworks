package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Encoder;
/**
 * Created by James on 1/26/2017.
 */
public class SensorSubsystem extends Subsystem {
    private PWM ultra = new PWM(0);
    private Encoder UL = new Encoder(0,1);
    private Encoder BL = new Encoder(2,3);
    private Encoder UR = new Encoder(4,5);
    private Encoder BR = new Encoder(6,7);
    public SensorSubsystem(){

    }
    public void initDefaultCommand(){}
    public double getUltra(){
        return ultra.getRaw();
    }
    public void resetEncoders(){
        UL.reset();
        BL.reset();
        UR.reset();
        BR.reset();
    }
    public double getDis(){
        double avgDis = (UL.getDistance()+BL.getDistance()+UR.getDistance()+BR.getDistance())/4;
        return avgDis;
    }
}
