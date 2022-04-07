package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.commands.TimedDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class TimedDriveWithIntake extends ParallelRaceGroup{
    
    public TimedDriveWithIntake(DriveTrain m_driveTrain, Shooter m_shooter, Intake m_intake, double speed) {
        addCommands(
            new TimedDrive(m_driveTrain, -0.5, 2),

            new RunIntakeAndConveyor(m_intake, m_shooter)
        );
    }
}
