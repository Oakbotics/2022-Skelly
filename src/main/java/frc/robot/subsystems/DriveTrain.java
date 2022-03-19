package frc.robot.subsystems;

import frc.robot.Constants.DriveConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class DriveTrain extends SubsystemBase {

    private final WPI_TalonFX m_rightFrontMotor = new WPI_TalonFX(DriveConstants.CAN_ADDRESS_RIGHT_FRONT_MOTOR);
    private final WPI_TalonFX m_rightBackMotor = new WPI_TalonFX(DriveConstants.CAN_ADDRESS_RIGHT_BACK_MOTOR);
    private final WPI_TalonFX m_leftFrontMotor = new WPI_TalonFX(DriveConstants.CAN_ADDRESS_LEFT_FRONT_MOTOR);
    private final WPI_TalonFX m_leftBackMotor = new WPI_TalonFX(DriveConstants.CAN_ADDRESS_LEFT_BACK_MOTOR);

    
    private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_leftFrontMotor, m_leftBackMotor);
    private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_rightFrontMotor, m_rightBackMotor);

    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

    public DriveTrain() {
        m_rightMotors.setInverted(true);
    }

    public void arcadeDrive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, rot);
    }

    public void setSpeed(double speed) {
        m_leftMotors.set(speed);
        m_rightMotors.set(speed);
    }

    public void setMaxOutput(double maxOutput) {
        m_drive.setMaxOutput(maxOutput);
    }
}

