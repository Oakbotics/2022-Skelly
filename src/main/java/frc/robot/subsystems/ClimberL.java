package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Constants;



public class ClimberL extends SubsystemBase {

    private final CANSparkMax leftMotor = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_LEFT, MotorType.kBrushless);
    private final RelativeEncoder leftEncoder = leftMotor.getEncoder();  

    public ClimberL() {
        leftMotor.setIdleMode(IdleMode.kBrake);
        leftMotor.setInverted(false);
        leftEncoder.setPosition(0);
    }
    
    public void runLeft(double speed) {
        leftMotor.set(speed);
    }

    public double getLeftMotorPosition() {
        return leftEncoder.getPosition();
    }

    public double getLeftPosition() {
        return leftEncoder.getPosition();
    }

} 