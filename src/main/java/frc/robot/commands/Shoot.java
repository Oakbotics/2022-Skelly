package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase{
    private Shooter m_shooter;
    private double speed;

    public void shoot(Shooter m_shooter, double speed) {
        this.m_shooter = m_shooter;
        this.speed = speed;
        addRequirements(this.m_shooter);
    }

    @Override
    public void execute() {
        m_shooter.shoot(this.speed);
    }




}
