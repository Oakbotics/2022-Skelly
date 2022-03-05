package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;

public class Drive extends CommandBase {
    private final DriveTrain m_driveTrain;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_rotation;

    public Drive (DriveTrain DriveTrain, DoubleSupplier forward, DoubleSupplier rotation) {
        m_driveTrain = DriveTrain;
        m_forward = forward;
        m_rotation = rotation;
        addRequirements(m_driveTrain);
    }

    @Override
    public void initialize() {
        m_driveTrain.resetEncoders();
        m_driveTrain.setNeutralModeBrake();
    }

    @Override
    public void execute() {
        m_driveTrain.arcadeDrive(m_forward.getAsDouble(), m_rotation.getAsDouble());
        m_driveTrain.getEncoders();
    }
}
