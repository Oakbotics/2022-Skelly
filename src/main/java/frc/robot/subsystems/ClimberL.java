package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Constants;



public class ClimberL extends SubsystemBase {

    private final CANSparkMax leftMotor = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_LEFT, MotorType.kBrushless);
    private final RelativeEncoder leftEncoder = leftMotor.getEncoder();  
    private final DoubleSolenoid climberSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);

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

    public void setSolenoidForward() {
        climberSolenoid.set(Value.kForward);
    }

    public void setSolenoidReverse() {
        climberSolenoid.set(Value.kReverse);
    }

} 