package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;

public class ResetDriveTrainEncoder extends CommandBase {
    private final DriveTrain m_driveTrain;

    public ResetDriveTrainEncoder(DriveTrain m_driveTrain) {
        this.m_driveTrain = m_driveTrain;
        addRequirements(this.m_driveTrain);
    }

    @Override
    public void initialize() {
        m_driveTrain.resetEncoders();
    }

}