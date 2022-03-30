package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimbConstants;
import frc.robot.subsystems.ClimberR;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunRightClimberUp extends CommandBase{
    
    private final ClimberR m_Climber;
    private final double speed;

    public RunRightClimberUp(ClimberR m_Climber, double speed) {
        this.m_Climber = m_Climber;
        this.speed = speed;
        addRequirements(this.m_Climber);
    }
    
    @Override
    public void execute(){
        m_Climber.runRight(this.speed);
        SmartDashboard.putNumber("right", m_Climber.getRightMotorPosition());
    }

    @Override
    public void end(boolean interrupted) {
        m_Climber.runRight(0);
    }

    @Override
    public boolean isFinished(){
        return m_Climber.getRightMotorPosition() >= ClimbConstants.CLIMBER_LIMIT;
    }

}
