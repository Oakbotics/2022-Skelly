package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Climber;


public class RunCompressor extends CommandBase {
    private final Climber m_Climber;

    public RunCompressor(Climber m_Climber) {
        this.m_Climber = m_Climber;
        addRequirements(this.m_Climber);
    }
    
    @Override
    public void execute(){
        m_Climber.runCompressor();
    }
}
