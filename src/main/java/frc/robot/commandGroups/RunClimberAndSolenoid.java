package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.RunSolenoid;
import frc.robot.commands.RunClimber;
import frc.robot.subsystems.*;

public class RunClimberAndSolenoid extends SequentialCommandGroup {
 
    public RunClimberAndSolenoid(Climber m_climber, double speed) {
        addCommands(
            new RunClimber(m_climber, speed),

            new RunSolenoid(m_climber),

            new RunClimber(m_climber, -speed)
        );
    }

}
