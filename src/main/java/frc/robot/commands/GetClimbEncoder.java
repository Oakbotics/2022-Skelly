package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberL;
import frc.robot.subsystems.ClimberR;

public class GetClimbEncoder extends CommandBase{
    private final ClimberL m_climberL;
    private final ClimberR m_climberR;
    
    public GetClimbEncoder(ClimberL m_climberL, ClimberR m_climberR) {
        this.m_climberL = m_climberL;
        this.m_climberR = m_climberR;
        addRequirements(this.m_climberL, this.m_climberR);
    }

    @Override
    public void execute() {
        m_climberL.updateEncoderSetPoint();
        m_climberR.updateEncoderSetPoint();
    }
}
