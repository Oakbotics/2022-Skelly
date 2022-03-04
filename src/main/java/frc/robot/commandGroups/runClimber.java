package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.RunSolenoid;
import frc.robot.commands.runMotor;
import frc.robot.subsystems.*;

public class runClimber extends SequentialCommandGroup {
 
    public runClimber(Climber m_climber, double speed) {
        addCommands(
            new runMotor(m_climber, speed),

            new RunSolenoid(m_climber),

            new runMotor(m_climber, -speed)
        );
    }

}
