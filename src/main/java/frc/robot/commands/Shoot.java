package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase{
    private final Shooter m_shooter;
    private final double m_speed;

    public void shoot(Shooter shooter, double speed) {
        m_shooter = shooter;
        m_speed = speed;
        addRequirements(m_shooter);
    }

    @Override
    public void execute() {
        m_shooter.shoot(m_speed);
    }




}
