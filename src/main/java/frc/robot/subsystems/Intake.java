package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake extends SubsystemBase {
    
    private final CANSparkMax intakeMotor = new CANSparkMax(Constants.IntakeConstants.CAN_ADDRESS_INTAKE_MOTOR, MotorType.kBrushless);

    public void rollIntake(double speed) {
        intakeMotor.set(speed);
    }
    
}
