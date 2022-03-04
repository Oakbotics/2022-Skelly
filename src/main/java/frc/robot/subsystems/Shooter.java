package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.Timer;
//import com.revrobotics.CANSparkMax.ControlType.kVelocity


public class Shooter extends SubsystemBase{
    private final CANSparkMax topConveryorMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_TOP_CONVEYOR_MOTOR, MotorType.kBrushless);
    private final CANSparkMax bottomConveryorMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_BOTTOM_CONVEYOR_MOTOR, MotorType.kBrushless);
    private final CANSparkMax leftShooterMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_LEFT_SHOOTER_MOTOR, MotorType.kBrushless);
    private final CANSparkMax rightShooterMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_RIGHT_SHOOTER_MOTOR, MotorType.kBrushless);
    private final VictorSPX kicker = new VictorSPX(Constants.ShooterConstant.CAN_ADDRESS_KICKER);

    //double final maxRPM = 5700;
    //double velocity;

    public void runConveryor(double speed) {
        topConveryorMotor.set(speed);
        bottomConveryorMotor.set(-speed);
    }

    public void runShooter(double speed) {
        leftShooterMotor.set(speed);
        rightShooterMotor.set(-speed);
    }

    public void runKicker() {
        kicker.set(ControlMode.PercentOutput, 1);
    }
    
    //public void shooting()  {
    //    velocity.getVelocity();
    //}
}
