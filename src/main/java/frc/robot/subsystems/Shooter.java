package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Shooter extends SubsystemBase{
    private final CANSparkMax topConveryorMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_TOP_CONVEYOR_MOTOR, MotorType.kBrushless);
    private final CANSparkMax bottomConveryorMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_BOTTOM_CONVEYOR_MOTOR, MotorType.kBrushless);
    private final CANSparkMax leftShooterMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_LEFT_SHOOTER_MOTOR, MotorType.kBrushless);
    private final CANSparkMax rightShooterMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_RIGHT_SHOOTER_MOTOR, MotorType.kBrushless);


    public void shoot(double speed) {
        topConveryorMotor.set(speed);
        bottomConveryorMotor.set(-speed);
        leftShooterMotor.set(speed);
        rightShooterMotor.set(-speed);
    }


}
