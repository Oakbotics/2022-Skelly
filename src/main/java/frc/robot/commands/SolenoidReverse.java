package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ClimberPeumatics;


public class SolenoidReverse extends CommandBase {
    private final ClimberPeumatics m_climberP;

    public SolenoidReverse(ClimberPeumatics m_climberP) {
        this.m_climberP = m_climberP;
        addRequirements(this.m_climberP);
    }


    @Override
    public void initialize() {
        m_climberP.setSolenoidReverse();
    }

}
