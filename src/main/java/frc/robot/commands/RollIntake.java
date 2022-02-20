package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Intake;

public class RollIntake extends CommandBase{
    private final Intake m_intake;
    private final double speed; 

    public RollIntake(Intake m_intake, double speed) {
        this.m_intake = m_intake;
        this.speed = speed;
        addRequirements(this.m_intake);
    }

    @Override
    public void execute() {
        this.m_intake.rollIntake(speed);
    }
}
