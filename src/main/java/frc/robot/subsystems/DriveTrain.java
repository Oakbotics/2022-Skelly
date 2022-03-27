package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
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
        m_rightMotors.setInverted(true);
        
    }

    public double getmeasurement() {
        return getAverageEncoderDistance();
    }

    public void arcadeDrive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, -0.80*(rot));
        SmartDashboard.putNumber("forward value", fwd);
    }

    public void setNeutralModeBrake() {
        leftPrimaryMotor.setNeutralMode(NeutralMode.Brake);
        leftSecondaryMotor.setNeutralMode(NeutralMode.Brake);
        rightPrimaryMotor.setNeutralMode(NeutralMode.Brake);
        rightSecondaryMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void setNeutralmodeNoCoast() {
        leftPrimaryMotor.setNeutralMode(NeutralMode.Coast);
        leftSecondaryMotor.setNeutralMode(NeutralMode.Coast);
        rightPrimaryMotor.setNeutralMode(NeutralMode.Coast);
        rightSecondaryMotor.setNeutralMode(NeutralMode.Coast);
    }

    public void setSpeed(double speed) {
        m_leftMotors.set(-speed);
        m_rightMotors.set(speed);
    }

    public void voltDrive(double current) {
        leftPrimaryMotor.set(ControlMode.Current, -current);
        leftSecondaryMotor.set(ControlMode.Current, -current);
        rightPrimaryMotor.set(ControlMode.Current, current);
        rightSecondaryMotor.set(ControlMode.Current, current);
    }

    public void setMaxOutput(double maxOutput) {
        m_drive.setMaxOutput(maxOutput);
    }

    public double getAverageEncoderDistance() {
        return ((leftPrimaryMotor.getSelectedSensorPosition()) + -(rightPrimaryMotor.getSelectedSensorPosition())) / 2.0;
    }

    public void resetEncoders() {
        leftPrimaryMotor.setSelectedSensorPosition(0);
        rightPrimaryMotor.setSelectedSensorPosition(0);
        SmartDashboard.putNumber("left encoder", leftPrimaryMotor.getSelectedSensorPosition());
        SmartDashboard.putNumber("right encoder", rightPrimaryMotor.getSelectedSensorPosition());
    }

    public void getEncoders() {
        SmartDashboard.putNumber("left encoder", -(leftPrimaryMotor.getSelectedSensorPosition()));
        SmartDashboard.putNumber("right encoder", rightPrimaryMotor.getSelectedSensorPosition());
    }

    public double getAverageEncoderDistanceNoReverse() {
        return ((leftPrimaryMotor.getSelectedSensorPosition()) + (rightPrimaryMotor.getSelectedSensorPosition())) / 2.0;
    }

}

