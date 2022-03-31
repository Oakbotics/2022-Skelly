package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.ClimberL;
import frc.robot.subsystems.ClimberR;
import frc.robot.commands.RunLeftClimberDown;
import frc.robot.commands.RunRightClimberDown;

public class RetractClimb extends ParallelCommandGroup{

    public RetractClimb(ClimberL m_climberL, ClimberR m_climberR) {
        addCommands(
            new RunLeftClimberDown(m_climberL, -1),

            new RunRightClimberDown(m_climberR, -1)
        );
    }
}