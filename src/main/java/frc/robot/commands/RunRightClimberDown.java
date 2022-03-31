package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberR;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunRightClimberDown extends CommandBase{
    
    private final ClimberR m_climber;
    private final double speed;

    public RunRightClimberDown(ClimberR m_climber, double speed) {
        this.m_climber = m_climber;
        this.speed = speed;
        addRequirements(this.m_climber);
    }
    
    @Override
    public void execute(){
        m_climber.runRight(this.speed);
        m_climber.updateEncoderSetPoint();
        SmartDashboard.putNumber("right", m_climber.getRightMotorPosition());
    }

    @Override
    public void end(boolean interrupted) {
        m_climber.runRight(0);
    }

    @Override
    public boolean isFinished(){
        return m_climber.getRightMotorPosition() <= 0;
    }

}
