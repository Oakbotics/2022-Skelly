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
    private double encoderSetPoint = 0;
    
    private boolean pistonExtended;
    private boolean pistonRectracted;

    public ClimberL() {
        leftMotor.setIdleMode(IdleMode.kBrake);
        leftMotor.setInverted(false);
        leftEncoder.setPosition(-0.8);
    }
    
    public void runLeft(double speed) {
        leftMotor.set(speed);
    }

    public double getLeftMotorPosition() {
        return leftEncoder.getPosition();
    }

    public double getLeftSetPoint() {
        return encoderSetPoint;
    }

    public void updateEncoderSetPoint() {
        encoderSetPoint = leftEncoder.getPosition();
    }

    public void setPistonStatus(boolean extended) {
        pistonExtended = extended;
        pistonRectracted = !extended;
    }

    public boolean pistonExtended() {
        return pistonExtended;
    }

    public boolean pistonRectracted() {
        return pistonRectracted;
    }

} 