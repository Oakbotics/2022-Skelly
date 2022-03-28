package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake extends SubsystemBase {
    
    private final CANSparkMax intakeMotor = new CANSparkMax(Constants.IntakeConstants.CAN_ADDRESS_INTAKE_MOTOR, MotorType.kBrushless);
    private final DoubleSolenoid intakeSolenoid = 
        new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 
        Constants.IntakeConstants.PCM_ADDRESS_INTKAESOLENOID_FORWARD, 
        Constants.IntakeConstants.PCM_ADDRESS_INTKAESOLENOID_REVERSE);

    public void rollIntake(double speed) {
        intakeMotor.set(speed);
    }

    public void setSolenoidForward() {
        intakeSolenoid.set(Value.kForward);
    }

    public void setSolenoidReverse() {
        intakeSolenoid.set(Value.kReverse);
    }
    
}
