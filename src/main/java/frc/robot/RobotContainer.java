// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TimedAuto;
import frc.robot.commands.TurnDegrees;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriveTrainForTurn;
import frc.robot.Constants.AutoConstants;
import frc.robot.commands.Drive;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.ResetDriveTrainEncoder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.LogitechConstants;
import frc.robot.commandGroups.StraightThenTurn90;
import frc.robot.Constants.DoubleShockConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RunIntake;
import frc.robot.commandGroups.AutoRunShooter;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RunConveryor;
import frc.robot.commands.RunShooterAllTogether;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final DriveTrain m_robotDrive = new DriveTrain();
  
  private final Intake m_intake = new Intake();

  private final DriveTrainForTurn m_driveTrainForTurn = new DriveTrainForTurn();


  private final Command m_autoCommand = new TimedAuto(m_robotDrive);
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);


  GenericHID m_controller0 = new GenericHID(LogitechConstants.CAN_ADDRESS_LOGITECHCONTROLLER);
  GenericHID m_controller1 = new GenericHID(DoubleShockConstants.CAN_ADDRESS_DOUBLESHOCKCONTROLLER);
  

  private final Shooter m_shooter = new Shooter();

  private final GenericHID m_controller = new GenericHID(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    
    m_robotDrive.setDefaultCommand(
        new Drive(
            m_robotDrive,
            () -> m_controller1.getRawAxis(1),
            () -> m_controller1.getRawAxis(4))
            );
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_controller0, LogitechConstants.CONTROLLER_Y)
    .whenPressed(new DriveDistance(m_robotDrive, 30));
    new JoystickButton(m_controller0, LogitechConstants.CONTROLLER_B)
    .whenPressed(new StraightThenTurn90(m_robotDrive, m_driveTrainForTurn));
    new JoystickButton(m_controller0, LogitechConstants.CONTROLLER_L_BUMPER)
    .whenPressed(new ResetDriveTrainEncoder(m_robotDrive));
    new JoystickButton(m_controller0, LogitechConstants.CONTROLLER_A)
    .whenPressed(new TurnDegrees(m_driveTrainForTurn, 90));
    new JoystickButton(m_controller, 6)
    .whenHeld(new RunIntake(m_intake, 1));
    
    new JoystickButton(m_controller, 5)
    .whenHeld(new RunShooterAllTogether(m_shooter));
    new JoystickButton(m_controller, 4)
    .whenHeld(new RunConveryor(m_shooter, 0.90));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
