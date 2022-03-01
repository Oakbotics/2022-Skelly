package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase{
    private final Shooter m_shooter;
    private final double speed;

    public Shoot(Shooter m_shooter, double speed) {
        this.m_shooter = m_shooter;
        this.speed = speed;
        addRequirements(m_shooter);
    }

    @Override
    public void execute() {
        this.m_shooter.runShooter(speed);
    }




}
