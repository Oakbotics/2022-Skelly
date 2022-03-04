package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Climber extends SubsystemBase {

    private final CANSparkMax leftMotor = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_LEFT, MotorType.kBrushless);
    private final CANSparkMax rightMotor = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_RIGHT, MotorType.kBrushless);
    private final DoubleSolenoid climberSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    private final Compressor m_compressor = new Compressor(PneumaticsModuleType.CTREPCM);

    public Climber() {
    }
    
    public void run(double speed) {
        leftMotor.set(-speed);
        rightMotor.set(speed);
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

    public void runCompressor() {
        m_compressor.enableDigital();
    }
    

} 