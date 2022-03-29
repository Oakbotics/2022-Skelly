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



public class Climber extends SubsystemBase {

    private final CANSparkMax leftMotor = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_LEFT, MotorType.kBrushless);
    private final CANSparkMax rightMotor = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_RIGHT, MotorType.kBrushless);
    private final RelativeEncoder leftEncoder = leftMotor.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 1);
    private final RelativeEncoder rightEncoder = rightMotor.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 1);
    private final DoubleSolenoid climberSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);

    public Climber() {
        leftMotor.setIdleMode(IdleMode.kBrake);
        rightMotor.setIdleMode(IdleMode.kBrake);
    }
    
    public void run(double speed) {
        leftMotor.set(-speed);
        rightMotor.set(speed);
    }

    public double getMotorPosition() {
        return ((leftEncoder.getPosition() + rightEncoder.getPosition()) / 2);
    }

    public void setSolenoidForward() {
        climberSolenoid.set(Value.kForward);
    }

    public void setSolenoidReverse() {
        climberSolenoid.set(Value.kReverse);
    }

    // public void toggleSolenoid() {
    //     climberSolenoid.toggle();
    // }

    // public void runCompressor() {
    //     m_compressor.enableDigital();
    // }
    

} 