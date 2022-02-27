package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.RollIntake;
import frc.robot.commands.RunPneumatics;
import frc.robot.subsystems.Intake;

public class RunIntake extends ParallelCommandGroup {
    
    public RunIntake(Intake m_intake) {
        addCommands(
            new RunPneumatics(m_intake),

            new RollIntake(m_intake, 1)
        );
    }
}
