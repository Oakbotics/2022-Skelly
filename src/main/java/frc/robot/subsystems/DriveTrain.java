package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class DriveTrain extends SubsystemBase {

    private final WPI_TalonFX leftSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_SECONDARY_MOTOR);;
    private final WPI_TalonFX leftPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_PRIMARY_MOTOR);;
    private final WPI_TalonFX rightSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_SECONDARY_MOTOR);;
    private final WPI_TalonFX rightPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_PRIMARY_MOTOR);;


    
    private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(leftPrimaryMotor, leftSecondaryMotor);;
    private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(rightPrimaryMotor, rightSecondaryMotor);;

    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);;

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

    public void resetEncoders() {
        leftPrimaryMotor.setSelectedSensorPosition(0);
        SmartDashboard.putNumber("left encoder", leftPrimaryMotor.getSelectedSensorPosition());
    }
}

