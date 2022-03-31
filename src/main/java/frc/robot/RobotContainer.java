// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// constants 
import frc.robot.Constants.LogitechConstants;
import frc.robot.Constants.DoubleShockConstants;
// subsystems
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
//commands
import frc.robot.commands.TimedDrive;
import frc.robot.commands.Drive;
import frc.robot.commands.RunConveryor;
import frc.robot.commandGroups.AutoRunShooter;
//commandgroups
import frc.robot.commandGroups.RunIntakeAndConveyor;
import frc.robot.commandGroups.TimedAuto;
import frc.robot.commandGroups.ExtendClimb;
import frc.robot.commandGroups.RetractClimb;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SolenoidForward;
import frc.robot.commands.SolenoidInitialize;
import frc.robot.commands.SolenoidReverse;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ClimberL;
import frc.robot.subsystems.ClimberPeumatics;
import frc.robot.subsystems.ClimberR;
import frc.robot.commands.RunRightClimberUp;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  //subsystems
  private final DriveTrain m_robotDrive = new DriveTrain();
  private final Intake m_intake = new Intake();
  private final Shooter m_shooter = new Shooter();

  //controllers
  GenericHID opController = new GenericHID(LogitechConstants.CAN_ADDRESS_LOGITECHCONTROLLER);
  GenericHID driveController = new GenericHID(DoubleShockConstants.CAN_ADDRESS_DOUBLESHOCKCONTROLLER);
  
  //autocommand
  private final Command m_autoCommand = new TimedAuto(m_robotDrive, m_shooter);
  private final ClimberL m_climberL = new ClimberL();
  private final ClimberR m_climberR = new ClimberR();
  private final ClimberPeumatics m_climberP = new ClimberPeumatics();

  private final GenericHID m_controller = new GenericHID(0);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    
    m_robotDrive.setDefaultCommand(
      new Drive(m_robotDrive,() -> opController.getRawAxis(1),() -> opController.getRawAxis(4))
      );
    m_climberP.setDefaultCommand(new SolenoidInitialize(m_climberP));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //Intake Command
    new JoystickButton(opController, LogitechConstants.CONTROLLER_B)
    .whenHeld(new RunIntakeAndConveyor(m_intake, m_shooter));
    //Run Entire Shooter System Command
    new JoystickButton(opController, LogitechConstants.CONTROLLER_R_BUMPER)
    .whenHeld(new AutoRunShooter(m_shooter));
    //Run Just Conveyor Command
    new JoystickButton(opController, LogitechConstants.CONTROLLER_A)
    .whenHeld(new RunConveryor(m_shooter, 0.90));
    new JoystickButton(m_controller, 1)
    .whenHeld(new ExtendClimb(m_climberL, m_climberR));

    new JoystickButton(m_controller, 2)
    .whenHeld(new RetractClimb(m_climberL, m_climberR));

    new JoystickButton(m_controller, 5)
    .whenPressed(new SolenoidReverse(m_climberP));

    new JoystickButton(m_controller, 6)
    .whenPressed(new SolenoidForward(m_climberP));

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
