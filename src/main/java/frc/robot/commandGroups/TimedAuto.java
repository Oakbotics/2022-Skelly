package frc.robot.commandGroups;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.TimedDrive;
import frc.robot.commands.TimedShoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

public class TimedAuto extends SequentialCommandGroup{
    
    public TimedAuto(DriveTrain m_driveTrain, Shooter m_shooter){
        addCommands(
            
            new TimedShoot(m_shooter, 5),

            new TimedDrive(m_driveTrain, -0.5, 2)
        );
    }
}
