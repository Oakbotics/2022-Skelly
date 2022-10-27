package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class DriveTrain extends SubsystemBase {

    private final CANSparkMax leftSecondaryMotor = new CANSparkMax(Constants.DriveConstants.CAN_ADDRESS_LEFT_SECONDARY_MOTOR, MotorType.kBrushless);
    private final CANSparkMax leftPrimaryMotor = new CANSparkMax(Constants.DriveConstants.CAN_ADDRESS_LEFT_PRIMARY_MOTOR, MotorType.kBrushless);
    private final CANSparkMax rightSecondaryMotor = new CANSparkMax(Constants.DriveConstants.CAN_ADDRESS_RIGHT_SECONDARY_MOTOR,MotorType.kBrushless);
    private final CANSparkMax rightPrimaryMotor = new CANSparkMax(Constants.DriveConstants.CAN_ADDRESS_RIGHT_PRIMARY_MOTOR, MotorType.kBrushless);


    //private final CANSparkMax leftPrimaryNEO = new CANSparkMax(Constants.DriveConstants.CAN_ADDRESS_LEFT_PRIMARY_MOTOR, MotorType.kBrushless);
    

    private StatorCurrentLimitConfiguration motorCurrentLimit = new StatorCurrentLimitConfiguration();
    
    private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(leftPrimaryMotor, leftSecondaryMotor);
    private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(rightPrimaryMotor, rightSecondaryMotor);

    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

    private final RelativeEncoder leftPrimaryEncoder = leftPrimaryMotor.getEncoder();
    private final RelativeEncoder rightPrimaryEncoder = rightPrimaryMotor.getEncoder();



    public DriveTrain() {
        m_rightMotors.setInverted(true);

        motorCurrentLimit.currentLimit = 50;

        // leftSecondaryMotor.setSmartCurrentLimit(motorCurrentLimit);
        // leftPrimaryMotor.configStatorCurrentLimit(motorCurrentLimit, 0);
        // rightSecondaryMotor.configStatorCurrentLimit(motorCurrentLimit, 0);
        // rightPrimaryMotor.configStatorCurrentLimit(motorCurrentLimit, 0);
        
    }

    public double getmeasurement() {
        return getAverageEncoderDistance();
    }

    public void arcadeDrive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, -0.50*(rot));
        SmartDashboard.putNumber("forward value", fwd);
    }

    public void setNeutralModeBrake() {
        leftPrimaryMotor.setIdleMode(IdleMode.kBrake);
        leftSecondaryMotor.setIdleMode(IdleMode.kBrake);
        rightPrimaryMotor.setIdleMode(IdleMode.kBrake);
        rightSecondaryMotor.setIdleMode(IdleMode.kBrake);
    }

    public void setNeutralModeCoast() {
        leftPrimaryMotor.setIdleMode(IdleMode.kCoast);
        leftSecondaryMotor.setIdleMode(IdleMode.kCoast);
        rightPrimaryMotor.setIdleMode(IdleMode.kCoast);
        rightSecondaryMotor.setIdleMode(IdleMode.kCoast);
    }

    public void setSpeed(double speed) {
        m_leftMotors.set(-speed);
        m_rightMotors.set(speed);
    }

    

    // public void voltDrive(double current) {
    //     leftPrimaryMotor.set(ControlMode.Current, -current);
    //     leftSecondaryMotor.set(ControlMode.Current, -current);
    //     rightPrimaryMotor.set(ControlMode.Current, current);
    //     rightSecondaryMotor.set(ControlMode.Current, current);
    // }

    public void setMaxOutput(double maxOutput) {
        m_drive.setMaxOutput(maxOutput);
    }

    public double getAverageEncoderDistance() {
        return ((leftPrimaryEncoder.getPosition()) + -(rightPrimaryEncoder.getPosition())) / 2.0;
    }



    public void resetEncoders() {
        leftPrimaryEncoder.setPosition(0);
        rightPrimaryEncoder.setPosition(0);
        SmartDashboard.putNumber("left encoder", leftPrimaryEncoder.getPosition());
        SmartDashboard.putNumber("right encoder", rightPrimaryEncoder.getPosition());
    }

    public void getEncoders() {
        SmartDashboard.putNumber("left encoder", -(leftPrimaryEncoder.getPosition()));
        SmartDashboard.putNumber("right encoder", rightPrimaryEncoder.getPosition());
    }

    public double getAverageEncoderDistanceNoReverse() {
        return ((leftPrimaryEncoder.getPosition()) + (rightPrimaryEncoder.getPosition())) / 2.0;
    }

}

