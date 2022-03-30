package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ClimberL;


public class RunSolenoid extends CommandBase {
    private final ClimberL m_Climber;

    public RunSolenoid(ClimberL m_Climber) {
        this.m_Climber = m_Climber;
        addRequirements(this.m_Climber);
    }
    
    @Override
    public void initialize() {
        m_Climber.setSolenoidForward();
    }

    @Override
    public void end(boolean interrupted) {
        m_Climber.setSolenoidReverse();
    }

}
