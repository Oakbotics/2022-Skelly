package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

import frc.robot.commands.RunIntake;
import frc.robot.commands.RunConveyor;

public class Outtake extends ParallelCommandGroup{
    
    public Outtake(Intake m_intake, Shooter m_shooter) {
        addCommands(
            new RunIntake(m_intake, -0.6),
            new RunConveyor(m_shooter, -0.9)
        );
    }
}
