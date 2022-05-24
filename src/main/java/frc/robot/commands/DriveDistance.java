package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;

public class DriveDistance extends PIDCommand {

    public final DriveTrain m_driveTrain;

    public DriveDistance(DriveTrain m_driveTrain, double targetDistance) {
        super(new PIDController(DriveConstants.kP, DriveConstants.kI, DriveConstants.kD),
        m_driveTrain :: getmeasurement,
        -(targetDistance*AutoConstants.ENCODER_TICKS_PER_INCH),
        output -> m_driveTrain.arcadeDrive(output, 0),
        m_driveTrain);

        this.m_driveTrain = m_driveTrain;
        getController().setTolerance(DriveConstants.positionTolerance, DriveConstants.speedTolerance);

    }

    @Override
    public void initialize() {
        this.m_driveTrain.resetEncoders();
    }

    @Override
    public void execute() {
    m_useOutput.accept(
        MathUtil.clamp(m_controller.calculate(m_measurement.getAsDouble(), m_setpoint.getAsDouble()), -0.5, 0.5));
    m_driveTrain.getEncoders();
    SmartDashboard.putNumber("output value", m_controller.calculate(m_measurement.getAsDouble(), m_setpoint.getAsDouble()));
    }

    @Override
    public void end(boolean interrupted) {
        m_driveTrain.setNeutralModeBrake();
        m_driveTrain.resetEncoders();
    }
    
    @Override
    public boolean isFinished() {
      return getController().atSetpoint();
    }


}
