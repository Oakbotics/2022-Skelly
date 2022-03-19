package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;

public class Drive extends CommandBase {
    private final DriveTrain m_driveTrain;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_rotation;

    public Drive (DriveTrain driveTrain, DoubleSupplier forward, DoubleSupplier rotation) {
        this.m_driveTrain = driveTrain;
        this.m_forward = forward;
        this.m_rotation = rotation;
        addRequirements(m_driveTrain);
    }

    @Override
    public void execute(){
        this.m_driveTrain.arcadeDrive(m_forward.getAsDouble(), m_rotation.getAsDouble());
    }
}
