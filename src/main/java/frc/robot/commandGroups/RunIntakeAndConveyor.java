package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

import frc.robot.commands.RunIntake;
import frc.robot.commands.RunConveryor;

public class RunIntakeAndConveyor extends ParallelCommandGroup{
    
    public RunIntakeAndConveyor(Intake m_intake, Shooter m_shooter) {
        addCommands(
            new RunIntake(m_intake, 0.6),
            new RunConveryor(m_shooter, 0.9)
        );
    }
}
