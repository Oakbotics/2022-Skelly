package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class MotionMagic extends CommandBase {
    private final DriveTrain m_driveTrain;
    private double m_distanceInInches;

    public MotionMagic(DriveTrain DriveTrain, Double distanceInInches) {
        m_driveTrain = DriveTrain;
        m_distanceInInches = distanceInInches;

        m_driveTrain.resetEncoders();
        addRequirements(m_driveTrain);


    }

    @Override
    public void execute() {
        m_driveTrain.getEncoders();
        m_driveTrain.goForwardMotionMagic(m_distanceInInches);
        m_driveTrain.getEncoders();
    }

    @Override
    public void initialize() {
        m_driveTrain.motionMagicInit();
    }
}
