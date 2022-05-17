package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.TimedDrive;
import frc.robot.commands.TimedRunIntakeAndConveyor;
import frc.robot.commands.TimedShoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class TwoBallAutoUpdated extends SequentialCommandGroup{
    
    public TwoBallAutoUpdated(DriveTrain m_driveTrain, Shooter m_shooter, Intake m_intake) {
        addCommands(
            new TimedDriveWithIntake(m_driveTrain, m_shooter, m_intake, -0.5),

            new TimedRunIntakeAndConveyor(m_intake, 0.6, m_shooter, 0.9, 1.5),

            new TimedDrive(m_driveTrain, 0.5, 1.8),

            new TimedShoot(m_shooter, 2),
             
            new TimedDrive(m_driveTrain, -0.5, 2.3)

        );
    }
}
