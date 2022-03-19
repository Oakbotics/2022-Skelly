// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    //remember to change it to the new drivetrain later!!!!!
    
    public static final class DriveConstants {
        public static final int CAN_ADDRESS_RIGHT_FRONT_MOTOR = 2;
        public static final int CAN_ADDRESS_RIGHT_BACK_MOTOR = 3;
        public static final int CAN_ADDRESS_LEFT_FRONT_MOTOR = 4;
        public static final int CAN_ADDRESS_LEFT_BACK_MOTOR = 5;   
    }
    
    public static final class IOConstants {
        public static final int CAN_ADDRESS_DRIVERCONTROLLER = 0;
    }
}
