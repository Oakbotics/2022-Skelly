package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunPneumatics extends CommandBase {
    private final Intake m_intake;

    public RunPneumatics(Intake m_intake) {
        this.m_intake = m_intake;
        addRequirements(this.m_intake);
    }

    @Override
    public void initialize() {
        m_intake.setSolenoidForward();
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.setSolenoidReverse();
    }
}
