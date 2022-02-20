package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveDistance extends CommandBase {
    private final DriveTrain m_driveTrain;
    private final double speed;

    public DriveDistance(DriveTrain m_driveTrain, double speed) {
        this.m_driveTrain = m_driveTrain;
        this.speed = speed;
        addRequirements(this.m_driveTrain);
    }

    @Override
    public void execute() {
        m_driveTrain.arcadeDrive(speed, 0);
        m_driveTrain.getLeftEncoder();
    }
}
