package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Constants;



public class ClimberR extends SubsystemBase {
    
    private final CANSparkMax rightMotor = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_RIGHT, MotorType.kBrushless);
    private final RelativeEncoder rightEncoder = rightMotor.getEncoder();
    private double encoderSetPoint = 0;

    public ClimberR() {
        rightMotor.setIdleMode(IdleMode.kBrake);
        rightMotor.setInverted(true);
        rightEncoder.setPosition(0);
    }

    public void runRight(double speed) {
        rightMotor.set(speed);
    }

    public double getRightMotorPosition() {
        return rightEncoder.getPosition();
    }

    public double getRightSetPoint() {
        return encoderSetPoint;
    }

    public void updateEncoderSetPoint() {
        encoderSetPoint = rightEncoder.getPosition();
    }

    

} 