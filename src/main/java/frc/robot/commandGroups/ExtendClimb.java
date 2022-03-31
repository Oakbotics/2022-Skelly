package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.ClimberL;
import frc.robot.subsystems.ClimberR;
import frc.robot.commands.RunLeftClimberUp;
import frc.robot.commands.RunRightClimberUp;

public class ExtendClimb extends ParallelCommandGroup{
    public ExtendClimb(ClimberL m_climberL, ClimberR m_climberR) {
        addCommands(
            new RunLeftClimberUp(m_climberL, 0.3),

            new RunRightClimberUp(m_climberR, 0.3)
        );
    }
}
