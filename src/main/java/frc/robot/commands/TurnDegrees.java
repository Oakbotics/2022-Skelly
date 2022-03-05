package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrainForTurn;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;

public class TurnDegrees extends PIDCommand {

    public final DriveTrainForTurn m_driveTrain;

    public TurnDegrees(DriveTrainForTurn m_driveTrain, double targetDegrees) {
        super(new PIDController(DriveConstants.kP, DriveConstants.kI, DriveConstants.kD),
        m_driveTrain :: getmeasurement,
        (targetDegrees*AutoConstants.ENCODER_TICKS_PER_DEGREE),
        output -> m_driveTrain.arcadeDrive(0, -(output/600000)),                                                  
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
        m_controller.calculate(m_measurement.getAsDouble(), m_setpoint.getAsDouble()));
    m_driveTrain.getEncoders();
    SmartDashboard.putNumber("output value", m_controller.calculate(m_measurement.getAsDouble(), m_setpoint.getAsDouble()));
    SmartDashboard.putNumber("degrees", (m_driveTrain.getAverageEncoderDistanceNoReverse()/AutoConstants.ENCODER_TICKS_PER_DEGREE));
    }

    @Override
    public void end(boolean interrupted) {

    }
    
    @Override
    public boolean isFinished() {
      // End when the controller is at the reference.
      return getController().atSetpoint();
    }


}
