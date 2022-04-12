package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase{
    private final Shooter m_shooter;

    public Shoot(Shooter m_shooter) {
        this.m_shooter = m_shooter;
        addRequirements(this.m_shooter);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        m_shooter.runKicker(1);
        m_shooter.runShooter(0.75);
    }

    @Override
    public void end(boolean interrupted) {
        m_shooter.runShooter(0);
        m_shooter.runKicker(0);
    }

}       
