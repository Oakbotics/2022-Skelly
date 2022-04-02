package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;


public class TimedDrive extends CommandBase {
    private final DriveTrain m_driveTrain;
    private final double speed;
    private final double elaspTime;
    double startTime;
    double time;

    public TimedDrive (DriveTrain m_driveTrain, double speed, double elaspTime) {
        this.m_driveTrain = m_driveTrain;
        this.speed = speed;
        this.elaspTime = elaspTime;
        addRequirements(m_driveTrain);
    }
        
    @Override
    public void initialize() {
        startTime  = Timer.getFPGATimestamp();
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        m_driveTrain.arcadeDrive(speed, 0);

        
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return time - startTime > elaspTime;
    }





}
