// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// constants 
import frc.robot.Constants.DriveControllerConstats;
import frc.robot.Constants.OperateControllerConstants;
// subsystems
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ClimberL;
import frc.robot.subsystems.ClimberPeumatics;
import frc.robot.subsystems.ClimberR;
//commands
import frc.robot.commands.Drive;
import frc.robot.commands.RunConveyor;
import frc.robot.commands.AdjustLeftClimber;
import frc.robot.commands.AdjustRightClimber;
import frc.robot.commands.TempLeftClimbUp;
import frc.robot.commands.ClimbSolenoidForward;
import frc.robot.commands.ClimbSolenoidReverse;
//commandgroups
import frc.robot.commandGroups.RunIntakeAndConveyor;
import frc.robot.commandGroups.TimedAuto;
import frc.robot.commandGroups.TwoBallAuto;
import frc.robot.commandGroups.TwoBallAutoUpdated;
import frc.robot.commandGroups.AutoRunShooter;
import frc.robot.commandGroups.ExtendClimb;
import frc.robot.commandGroups.Outtake;
import frc.robot.commandGroups.RetractClimb;
// import frc.robot.commandGroups.TwoBallAuto;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  //subsystems
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Intake m_intake = new Intake();
  private final Shooter m_shooter = new Shooter();
  private final ClimberL m_climberL = new ClimberL();
  private final ClimberR m_climberR = new ClimberR();
  private final ClimberPeumatics m_climberP = new ClimberPeumatics();

  //controllers
  GenericHID opController = new GenericHID(OperateControllerConstants.OperateController_ID);
  GenericHID driveController = new GenericHID(DriveControllerConstats.DriveController_ID);
  
  //autocommand
  private final Command m_oneBallAuto = new TimedAuto(m_driveTrain, m_shooter);
  private final Command m_twoBallAuto = new TwoBallAuto(m_driveTrain, m_shooter, m_intake);
  // private final Command m_twoBallAutoUpdated = new TwoBallAutoUpdated(m_driveTrain, m_shooter, m_intake);g



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    
    m_driveTrain.setDefaultCommand(
      new Drive(m_driveTrain,() -> driveController.getRawAxis(1),() -> driveController.getRawAxis(4))
      );
    
    m_climberL.setDefaultCommand(new AdjustLeftClimber(m_climberL));
    m_climberR.setDefaultCommand(new AdjustRightClimber(m_climberR));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Intake Command
    new JoystickButton(driveController, DriveControllerConstats.CONTROLLER_L_BUMPER)
    .whenHeld(new RunIntakeAndConveyor(m_intake, m_shooter));
    //Outtake Command
    new JoystickButton(driveController, DriveControllerConstats.CONTROLLER_R_BUMPER)
    .whenHeld(new Outtake(m_intake, m_shooter));

    new JoystickButton(driveController, DriveControllerConstats.CONTROLLER_Y)
    .whenHeld(new TempLeftClimbUp(m_climberL));
    //Run Entire Shooter System Command
    new JoystickButton(opController, OperateControllerConstants.CONTROLLER_SQUARE)
    .whenHeld(new AutoRunShooter(m_shooter));
    //Run Just Conveyor Command
    new JoystickButton(opController, OperateControllerConstants.CONTROLLER_TRIANGLE)
    .whenHeld(new RunConveyor(m_shooter, 0.90));
    //Extends Climber
    new JoystickButton(opController, OperateControllerConstants.CONTROLLER_CIRCLE)
    .whenHeld(new ExtendClimb(m_climberL, m_climberR));
    //Retracts Climber
    new JoystickButton(opController, OperateControllerConstants.CONTROLLER_CROSS)
    .whenHeld(new RetractClimb(m_climberL, m_climberR));
    //Solenoid up
    new JoystickButton(opController, OperateControllerConstants.CONTROLLER_R_BUMPER)
    .whenPressed(new ClimbSolenoidReverse(m_climberP, m_climberL, m_climberR));
    //Solenoid forward
    new JoystickButton(opController, OperateControllerConstants.CONTROLLER_L_BUMPER)
    .whenPressed(new ClimbSolenoidForward(m_climberP, m_climberL, m_climberR));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_twoBallAuto;
  }
}
