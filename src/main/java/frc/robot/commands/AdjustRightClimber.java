package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ClimberR;

public class AdjustRightClimber extends CommandBase{
    private final ClimberR m_climberR;

    public AdjustRightClimber(ClimberR m_climberR) {
        this.m_climberR = m_climberR;
        addRequirements(this.m_climberR);
    }

    @Override
    public void execute() {
        if (m_climberR.getRightSetPoint() < m_climberR.getRightMotorPosition()) {
            m_climberR.runRight(-0.10);
        }
        else {
            m_climberR.runRight(0);
        }
        SmartDashboard.putNumber("rightsetpoint", m_climberR.getRightSetPoint());
    }


}
