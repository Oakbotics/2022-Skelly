package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriveTrainForTurn;

public class DelayForSeconds extends CommandBase{
    private final DriveTrain m_driveTrain;
    private final DriveTrainForTurn m_driveTrainForTurn;
    private final double time;
    private double startTime = Timer.getFPGATimestamp();
    private double currentTime;

    public DelayForSeconds(DriveTrain m_driveTrain, DriveTrainForTurn m_driveTrainForTurn, double time) {
        this.m_driveTrain = m_driveTrain;
        this.m_driveTrainForTurn = m_driveTrainForTurn;
        this.time = time;
        addRequirements(m_driveTrainForTurn);
        addRequirements(m_driveTrain);
    }

    @Override
    public void initialize() {
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        currentTime = Timer.getFPGATimestamp();
        m_driveTrain.arcadeDrive(0, 0);
        m_driveTrain.setNeutralModeBrake();
        m_driveTrainForTurn.arcadeDrive(0, 0);
        m_driveTrainForTurn.setNeutralModeBrake();
    }

    @Override
    public void end(boolean interrupted) {
        m_driveTrain.resetEncoders();
        m_driveTrainForTurn.resetEncoders();
    }

    @Override 
    public boolean isFinished() {
        return (currentTime - time) > startTime;
    }
}
