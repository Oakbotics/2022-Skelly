package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.subsystems.Shooter;

public class TimedRunConveyorOut extends CommandBase {
    private final Shooter m_shooter;
    private final double speed;
    double startTime;
    double time;

    public TimedRunConveyorOut(Shooter m_shooter, double speed) {
        this.m_shooter = m_shooter;
        this.speed = speed;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        startTime  = Timer.getFPGATimestamp();
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        this.m_shooter.runConveryor(speed);
        
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void end(boolean interrupted) {
        this.m_shooter.runConveryor(0);
    }

    @Override
    public boolean isFinished(){
        return time - startTime > 1;
    }
}