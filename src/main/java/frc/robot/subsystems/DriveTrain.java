package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class DriveTrain extends SubsystemBase {

    private final WPI_TalonFX leftSecondaryMotor;
    private final WPI_TalonFX leftPrimaryMotor;
    private final WPI_TalonFX rightSecondaryMotor;
    private final WPI_TalonFX rightPrimaryMotor;


    
    private final SpeedControllerGroup m_leftMotors;
    private final SpeedControllerGroup m_rightMotors;

    private final DifferentialDrive m_drive;

    public DriveTrain() {
        // super();

        leftSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_SECONDARY_MOTOR);
        leftPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_PRIMARY_MOTOR);
        rightSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_SECONDARY_MOTOR);
        rightPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_PRIMARY_MOTOR);


        m_leftMotors = new SpeedControllerGroup(leftPrimaryMotor, leftSecondaryMotor);
        m_rightMotors = new SpeedControllerGroup(rightPrimaryMotor, rightSecondaryMotor);

        m_leftMotors.setInverted(true);
        m_rightMotors.setInverted(true);

        m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
    }

    public void arcadeDrive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, rot);
    }

    public void setSpeed(double speed) {
        m_leftMotors.set(-speed);
        m_rightMotors.set(speed);
    }

    public void setMaxOutput(double maxOutput) {
        m_drive.setMaxOutput(maxOutput);
    }
}

