package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.RunShooterAllTogether;
import frc.robot.commands.ShooterRunTillMaxSpeed;
import frc.robot.subsystems.Shooter;

public class AutoRunShooter extends SequentialCommandGroup {
    
    public AutoRunShooter(Shooter m_shooter) {
        addCommands(
            new ShooterRunTillMaxSpeed(m_shooter),

            new RunShooterAllTogether(m_shooter)
        );

    }
}