package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Climber;



public class RunClimber extends CommandBase {
    private final Climber m_Climber;
    private final double speed;

    public RunClimber(Climber m_Climber, double speed) {
        this.m_Climber = m_Climber;
        this.speed = speed;
        addRequirements(this.m_Climber);
    }
    
    @Override
    public void execute(){
        m_Climber.run(this.speed);
    }

}
