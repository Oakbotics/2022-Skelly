package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberL;
import frc.robot.subsystems.ClimberPeumatics;
import frc.robot.subsystems.ClimberR;


public class ClimbSolenoidReverse extends CommandBase {
    private final ClimberPeumatics m_climberP;
    private final ClimberL m_climberL;
    private final ClimberR m_climberR;

    public ClimbSolenoidReverse(ClimberPeumatics m_climberP, ClimberL m_climberL, ClimberR m_climberR) {
        this.m_climberP = m_climberP;
        this.m_climberL = m_climberL;
        this.m_climberR = m_climberR;
        addRequirements(this.m_climberP, this.m_climberR, this.m_climberL);
    }


    @Override
    public void initialize() {
        m_climberP.setSolenoidReverse();
        m_climberL.setPistonStatus(false);
        m_climberR.setPistonStatus(false);
    }

}
