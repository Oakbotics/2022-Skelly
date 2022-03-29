package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Climber;

import frc.robot.Constants.ClimbConstants;



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

    @Override
    public void end(boolean interrupted) {
        m_Climber.run(0);
    }

    @Override
    public boolean isFinished(){
        return m_Climber.getMotorPosition() > ClimbConstants.CLIMBER_LIMIT;
    }

}
