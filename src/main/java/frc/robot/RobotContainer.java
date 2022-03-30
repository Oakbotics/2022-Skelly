// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commandGroups.ExtendClimb;
import frc.robot.commandGroups.RetractClimb;
import frc.robot.commandGroups.RunClimberAndSolenoid;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RunLeftClimberUp;
import frc.robot.commands.RunRightClimberDown;
import frc.robot.commands.RunSolenoid;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ClimberL;
import frc.robot.subsystems.ClimberR;
import frc.robot.commands.RunRightClimberUp;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ClimberL m_climberL = new ClimberL();
  private final ClimberR m_climberR = new ClimberR();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final GenericHID m_controller = new GenericHID(0);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(m_controller, 1)
    .whenHeld(new ExtendClimb(m_climberL, m_climberR));

    new JoystickButton(m_controller, 2)
    .whenHeld(new RetractClimb(m_climberL, m_climberR));

    new JoystickButton(m_controller, 6)
    .whenHeld(new RunSolenoid(m_climberL));
    
    new JoystickButton(m_controller, 4)
    .whenHeld(new RunRightClimberUp(m_climberR, -0.05));

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
