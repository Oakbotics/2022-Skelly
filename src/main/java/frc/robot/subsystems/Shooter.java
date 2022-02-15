package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Shooter extends SubsystemBase{
    private final CANSparkMax topConveryorMotor = new CANSparkMax(Constants.ShooterConstant.CAN_ADDRESS_TOP_CONVEYOR_MOTOR, MotorType.kBrushless);



    public double method1() {

    }

    public void methosd2() {
        
    }


}
