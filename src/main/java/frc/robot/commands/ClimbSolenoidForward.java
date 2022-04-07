package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberL;
import frc.robot.subsystems.ClimberPeumatics;
import frc.robot.subsystems.ClimberR;


public class ClimbSolenoidForward extends CommandBase {
    private final ClimberPeumatics m_climberP;
    private final ClimberL m_climberL;
    private final ClimberR m_climberR;

    public ClimbSolenoidForward(ClimberPeumatics m_climberP, ClimberL m_climberL, ClimberR m_climberR) {
        this.m_climberP = m_climberP;
        this.m_climberL = m_climberL;
        this.m_climberR = m_climberR;
        addRequirements(this.m_climberP, this.m_climberR, this.m_climberL);
    }


    @Override
    public void initialize() {
        m_climberP.setSolenoidForward();
        m_climberL.setPistonStatus(true);
        m_climberR.setPistonStatus(true);
    }

}
