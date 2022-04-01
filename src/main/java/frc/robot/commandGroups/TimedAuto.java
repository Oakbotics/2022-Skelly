package frc.robot.commandGroups;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.RunConveryor;
import frc.robot.commands.TimedDrive;
import frc.robot.commands.TimedShoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

public class TimedAuto extends SequentialCommandGroup{
    
    public TimedAuto(DriveTrain m_driveTrain, Shooter m_shooter){
        addCommands(
            new RunConveryor(m_shooter, -0.90),
            
            new TimedShoot(m_shooter),

            new TimedDrive(m_driveTrain)
        );
    }
}
