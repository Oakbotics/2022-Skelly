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
    public static final class DriveConstants {
        public static final int CAN_ADDRESS_LEFT_SECONDARY_MOTOR = 3;
        public static final int CAN_ADDRESS_LEFT_PRIMARY_MOTOR = 2;
        public static final int CAN_ADDRESS_RIGHT_SECONDARY_MOTOR = 5;
        public static final int CAN_ADDRESS_RIGHT_PRIMARY_MOTOR = 4; 
        public static final double kP = 0.00007;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double positionTolerance = 1000;
        public static final double speedTolerance = 10;
    }
    
    public static final class LogitechConstants {
        public static final int CAN_ADDRESS_LOGITECHCONTROLLER = 0;
        public static final int CONTROLLER_A = 1;
        public static final int CONTROLLER_B = 2;
        public static final int CONTROLLER_X = 3;
        public static final int CONTROLLER_Y = 4;
        public static final int CONTROLLER_L_BUMPER = 5;
        public static final int CONTROLLER_R_BUMPER = 6;
        public static final int CONTROLLER_L_JOYSTICK = 9;
        public static final int CONTROLLER_R_JOYSTICK = 10;
    }

    public static final class DoubleShockConstants {
        public static final int CAN_ADDRESS_DOUBLESHOCKCONTROLLER = 1;
        public static final int CONTROLLER_CROSS = 1;
        public static final int CONTROLLER_CIRCLE = 2;
        public static final int CONTROLLER_SQUARE = 3;
        public static final int CONTROLLER_TRIANGLE = 4;
        public static final int CONTROLLER_L_BUMPER = 5;
        public static final int CONTROLLER_R_BUMPER = 6;
        public static final int CONTROLLER_L_JOYSTICK = 9;
        public static final int CONTROLLER_R_JOYSTICK = 10;
    }

    public static final class AutoConstants {
       
        public static final double ENCODER_TICKS_PER_INCH = 1100;
        // 2048 / ((Math.PI*6 )/10);
        public static final double ENCODER_TICKS_PER_DEGREE = 375;
    }
}
