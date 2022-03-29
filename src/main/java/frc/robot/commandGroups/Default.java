package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.subsystems.DriveTrain;
// import frc.robot.subsystems.;

import frc.robot.commands.Drive;

public class Default extends ParallelCommandGroup{
    public Default(DriveTrain m_robotDrive, GenericHID driveController, GenericHID opController) {
        addCommands(
            new Drive(m_robotDrive,() -> opController.getRawAxis(1),() -> opController.getRawAxis(4))

        );
    }
}
