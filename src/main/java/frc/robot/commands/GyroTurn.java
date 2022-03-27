package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveTrainForTurn;

public class GyroTurn extends PIDCommand{

    public final DriveTrainForTurn m_driveTrain;
    
    
    public GyroTurn(DriveTrainForTurn m_driveTrain, double targetDegrees) {
        super(new PIDController(0.03, 0, 0),
        m_driveTrain :: getGyro,
        (targetDegrees),
        output -> m_driveTrain.tankDrive(output),                                                  
        m_driveTrain);
        
        this.m_driveTrain = m_driveTrain;

        getController().setTolerance(DriveConstants.positionTolerance, DriveConstants.speedTolerance);
        
        m_driveTrain.setMaxSpeed(0.4);
    }

    @Override
    public void execute()
    {
        m_driveTrain.resetGyro();
        m_useOutput.accept(
            m_controller.calculate(m_measurement.getAsDouble(), m_setpoint.getAsDouble()));
    }



}