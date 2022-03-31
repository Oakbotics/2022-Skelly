package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TimedDrive extends CommandBase {
    private final DriveTrain m_driveTrain;
    double startTime;
    double time;

    public TimedDrive (DriveTrain m_driveTrain) {
        this.m_driveTrain = m_driveTrain;
        addRequirements(m_driveTrain);
    }
        
    @Override
    public void initialize() {
        startTime  = Timer.getFPGATimestamp();
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        m_driveTrain.arcadeDrive(-1, 0);

        
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return time - startTime > 1;
    }





}
