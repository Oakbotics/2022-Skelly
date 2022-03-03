package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class GetEncoder extends CommandBase{
    private final DriveTrain m_driveTrain;

    public GetEncoder(DriveTrain m_driveTrain) {
        this.m_driveTrain = m_driveTrain;
        addRequirements(this.m_driveTrain);
    }

    @Override
    public void initialize() {
        m_driveTrain.resetEncoders();
    }

    @Override
    public void execute() {
        m_driveTrain.getEncoders();
    }
}

