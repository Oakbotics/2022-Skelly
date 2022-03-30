package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.RunSolenoid;
import frc.robot.commands.RunLeftClimberUp;
import frc.robot.subsystems.ClimberL;

public class RunClimberAndSolenoid extends SequentialCommandGroup {
 
    public RunClimberAndSolenoid(ClimberL m_climber, double speed) {
        addCommands(
            new RunLeftClimberUp(m_climber, speed),

            new RunSolenoid(m_climber),

            new RunLeftClimberUp(m_climber, -speed)
        );
    }

}
