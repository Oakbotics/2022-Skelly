package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxRelativeEncoder.Type;

//import edu.wpi.first.wpilibj.Timer;
//import com.revrobotics.CANSparkMax.ControlType.kVelocity


public class Shooter extends SubsystemBase{
    private final CANSparkMax topConveryorMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_TOP_CONVEYOR_MOTOR, MotorType.kBrushless);
    private final CANSparkMax bottomConveryorMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_BOTTOM_CONVEYOR_MOTOR, MotorType.kBrushless);
    private final CANSparkMax leftShooterMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_LEFT_SHOOTER_MOTOR, MotorType.kBrushless);
    private final CANSparkMax rightShooterMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_RIGHT_SHOOTER_MOTOR, MotorType.kBrushless);
    private final VictorSPX kicker = new VictorSPX(Constants.ShooterConstant.CAN_ADDRESS_KICKER);

    // private final RelativeEncoder leftShooterMotorEncoder = new RelativeEncoder(
    //     leftShooterMotor.getEncoder(), 
    //     leftShooterMotor.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42), 
    //     leftShooterMotor.getAlternateEncoder(42));
    private final RelativeEncoder leftShooterMotorEncoder = leftShooterMotor.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
    private final RelativeEncoder rightShooterMotorEncoder = rightShooterMotor.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
    
    public Shooter() {
        kicker.setNeutralMode(NeutralMode.Brake);
    }

    public void runConveryor(double speed) {
        topConveryorMotor.set(-speed);
        bottomConveryorMotor.set(-speed);
    }

    public void runShooter(double speed) {
        leftShooterMotor.set(speed);
        rightShooterMotor.set(speed);
    }

    public void runKicker(double speed) {
        kicker.set(ControlMode.PercentOutput, speed);
    }

    
    public double getShooterVelocity()  {
        return ((leftShooterMotorEncoder.getVelocity() + -(rightShooterMotorEncoder.getVelocity())) / 2);
    }
}
