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
        public static final int CAN_ADDRESS_LEFT_SECONDARY_MOTOR = 2;
        public static final int CAN_ADDRESS_LEFT_PRIMARY_MOTOR = 3;
        public static final int CAN_ADDRESS_RIGHT_SECONDARY_MOTOR = 4;
        public static final int CAN_ADDRESS_RIGHT_PRIMARY_MOTOR = 5;   



        //test constants(coeffecients for autonomous)
        public static final double INCHES_PER_ENCODER_TICK = ((Math.PI*6)/10)/2048;  /*((circumference of wheel)/rotations of motor for one rotation of wheel)/ticks encoder reads for one rotation of motor*/
        public static final double ENCODER_TICKS_PER_INCH = 2048 /*encoder ticks in one rotation of motor*/  / ((Math.PI*6 /* Circumference of wheel*/ )/10/* One rotation of motor = 0.1 rotation of wheel*/);  //(encoder ticks in one rotation of motor) / (inches in one rotation of motor)
        //public static final boolean PHASE_CORRECTION = false;

    }
}
