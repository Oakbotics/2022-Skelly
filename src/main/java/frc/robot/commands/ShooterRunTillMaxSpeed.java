package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

import frc.robot.Constants.ShooterConstant;

public class ShooterRunTillMaxSpeed extends CommandBase{
    private final Shooter m_shooter;

    public ShooterRunTillMaxSpeed(Shooter m_shooter) {
        this.m_shooter = m_shooter;
        addRequirements(this.m_shooter);
    }

    @Override
    public void initialize() {
        m_shooter.runShooter(1);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return (m_shooter.getShooterVelocity() > ShooterConstant.shooterMaxVelocity);
    }
}
