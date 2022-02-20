package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;

import frc.robot.Constants;

public class DriveDistance extends CommandBase {
    private final DriveTrain m_driveTrain;
    private final double m_distance;
    private final double speed;

    public DriveDistance(DriveTrain m_driveTrain, double inches, double speed) {
        this.m_driveTrain = m_driveTrain;
        this.m_distance = inches * Constants.AutoConstants.ENCODER_TICKS_PER_INCH;
        this.speed = speed;
        addRequirements(this.m_driveTrain);
    }

    @Override
    public void initialize() {
        m_driveTrain.resetEncoders();
    }

    @Override 
    public void execute() {
        m_driveTrain.arcadeDrive(-speed, 0);
        m_driveTrain.getEncoders();
    }
    
    @Override
    public boolean isFinished() {
        return Math.abs(m_driveTrain.getAverageEncoderDistance()) >= m_distance;
  }

}
