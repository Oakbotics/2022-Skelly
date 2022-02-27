package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Intake;

public class RunIntake extends CommandBase{
    private final Intake m_intake;
    private final double speed; 

    public RunIntake(Intake m_intake, double speed) {
        this.m_intake = m_intake;
        this.speed = speed;
        addRequirements(this.m_intake);
    }

    @Override
    public void initialize() {
        m_intake.setSolenoidForward();
    }

    @Override
    public void execute() {
        m_intake.rollIntake(speed);
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.rollIntake(0);
        m_intake.setSolenoidReverse();
    }
}
