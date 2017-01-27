package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team5557.robot.commands.autoLinear;
import org.usfirst.frc.team5557.robot.commands.autoTurn;

public class AutoGroup extends CommandGroup {
    public AutoGroup(){
        addSequential(new autoLinear(200));//Parameter is for the distance threshold.When encoders returns value above para, robot stops
        addSequential(new autoTurn(50));
    }
}
