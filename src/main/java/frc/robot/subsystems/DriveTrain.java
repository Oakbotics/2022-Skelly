package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.MotionMagicConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class DriveTrain extends SubsystemBase {

    private final WPI_TalonFX leftSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_SECONDARY_MOTOR);
    private final WPI_TalonFX leftPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_PRIMARY_MOTOR);
    private final WPI_TalonFX rightSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_SECONDARY_MOTOR);
    private final WPI_TalonFX rightPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_PRIMARY_MOTOR);


    
    private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(leftPrimaryMotor, leftSecondaryMotor);
    private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(rightPrimaryMotor, rightSecondaryMotor);

    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
    
    
    
    public DriveTrain() {
        leftPrimaryMotor.setSelectedSensorPosition(0);
        rightPrimaryMotor.setSelectedSensorPosition(0);
        m_rightMotors.setInverted(true);
    }

    public void arcadeDrive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, -rot);
    }

    public void setSpeed(double speed) {
        m_leftMotors.set(-speed);
        m_rightMotors.set(speed);
    }

    public void motionMagicInit(){

        
        leftPrimaryMotor.selectProfileSlot(0, 0);
        leftPrimaryMotor.config_kF(0, 0, MotionMagicConstants.TIMEOUTMS);
        leftPrimaryMotor.config_kP(0, 0.2, MotionMagicConstants.TIMEOUTMS);

        leftPrimaryMotor.configMotionCruiseVelocity(10000, MotionMagicConstants.TIMEOUTMS);
        leftPrimaryMotor.configMotionAcceleration(2500, MotionMagicConstants.TIMEOUTMS);

    }        
  
    public void goForwardMotionMagic(Double inches){
        leftPrimaryMotor.set(TalonFXControlMode.MotionMagic, AutoConstants.ENCODER_TICKS_PER_INCH*inches);
    }

    public void setMaxOutput(double maxOutput) {
        m_drive.setMaxOutput(maxOutput);
    }

    public double getAverageEncoderDistance() {
        return (-(leftPrimaryMotor.getSelectedSensorPosition()) + rightPrimaryMotor.getSelectedSensorPosition()) / 2.0;
    }

    // public void goForwardInches(double distance) {
    //     rightPrimaryMotor.set(TalonFXControlMode.Position, distance*(Constants.AutoConstants.ENCODER_TICKS_PER_INCH));
    //     rightSecondaryMotor.set(TalonFXControlMode.Position, distance*(Constants.AutoConstants.ENCODER_TICKS_PER_INCH));
    //     leftPrimaryMotor.set(TalonFXControlMode.Position, -(distance*(Constants.AutoConstants.ENCODER_TICKS_PER_INCH)));
    //     leftSecondaryMotor.set(TalonFXControlMode.Position, -(distance*(Constants.AutoConstants.ENCODER_TICKS_PER_INCH)));
    // }

    public void resetEncoders() {
        leftPrimaryMotor.setSelectedSensorPosition(0);
        rightPrimaryMotor.setSelectedSensorPosition(0);
        SmartDashboard.putNumber("left encoder", leftPrimaryMotor.getSelectedSensorPosition());
        SmartDashboard.putNumber("right encoder", rightPrimaryMotor.getSelectedSensorPosition());
    }

    public void getEncoders() {
        SmartDashboard.putNumber("left encoder", leftPrimaryMotor.getSelectedSensorPosition());
        SmartDashboard.putNumber("right encoder", rightPrimaryMotor.getSelectedSensorPosition());
    }
}

