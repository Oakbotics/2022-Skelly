package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

public class RunShooterAllTogether extends CommandBase{
    private final Shooter m_shooter;

    public RunShooterAllTogether(Shooter m_shooter) {
        this.m_shooter = m_shooter;
        addRequirements(this.m_shooter);
    }

    @Override
    public void execute() {
        m_shooter.runShooter(0.40);
        m_shooter.runKicker(0.75);
        m_shooter.runConveryor(0.90);
    }

    @Override
    public void end(boolean interrupted) {
        m_shooter.runShooter(0);
        m_shooter.runKicker(0);
        m_shooter.runConveryor(0);
    }
}
