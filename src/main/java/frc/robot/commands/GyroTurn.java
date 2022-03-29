package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveTrainForTurn;

public class GyroTurn extends PIDCommand{

    public final DriveTrainForTurn m_driveTrain;
    public final PIDController m_pidController;
    
    
    public GyroTurn(DriveTrainForTurn m_driveTrain, PIDController m_pidController, double targetDegrees) {
        super(m_pidController,
        m_driveTrain :: getGyro,
        (targetDegrees),
        output -> m_driveTrain.setSpeed_Dai_ver(output),                                                  
        m_driveTrain);
        this.m_pidController = m_pidController;
        this.m_driveTrain = m_driveTrain;

        m_driveTrain.setMaxSpeed(0.4);
        m_pidController.setTolerance(0.5, 0);
    }


    @Override
    public void initialize(){
        m_driveTrain.resetGyro();
        m_driveTrain.setNeutralModeBrake();

    }



    @Override
    public void execute()
    {
        m_useOutput.accept(
            m_controller.calculate(m_measurement.getAsDouble(), m_setpoint.getAsDouble()));
        SmartDashboard.putNumber("output value", m_controller.calculate(m_measurement.getAsDouble(), m_setpoint.getAsDouble()));   
        SmartDashboard.putNumber("Gyro read: ", m_driveTrain.getGyro());
        
    }  

    @Override
    public boolean isFinished() {
        return m_pidController.atSetpoint();
    }


    
}
