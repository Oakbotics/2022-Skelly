package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DelayForSeconds;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.TurnDegrees;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriveTrainForTurn;

public class StraightThenTurn90 extends SequentialCommandGroup{
    
    public StraightThenTurn90(DriveTrain m_driveTrain, DriveTrainForTurn m_driveTrainForTurn) {
        addCommands(
            new TurnDegrees(m_driveTrainForTurn, 90),

            new DelayForSeconds(m_driveTrain, m_driveTrainForTurn, 1),

            new DriveDistance(m_driveTrain, 30)

        );

    }
}
