package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;

public class TimedShoot extends CommandBase{
    private final Shooter m_shooter;
    private final double elaspTime;
    double startTime;
    double time;

    public TimedShoot(Shooter m_shooter, double elaspTime) {
        this.m_shooter = m_shooter;
        this.elaspTime = elaspTime;
        addRequirements(this.m_shooter);
    }

    @Override
    public void initialize() {
        startTime  = Timer.getFPGATimestamp();
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        m_shooter.runShooter(0.3);
        m_shooter.runKicker(0.75);
        m_shooter.runConveryor(0.90);
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void end(boolean interrupted) {
        m_shooter.runShooter(0);
        m_shooter.runKicker(0);
        m_shooter.runConveryor(0);
    }

    @Override
    public boolean isFinished() {
        return time - startTime > elaspTime;
    }
}
