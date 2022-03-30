package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ClimberL;

import frc.robot.Constants.ClimbConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class RunLeftClimberUp extends CommandBase {
    private final ClimberL m_climber;
    private final double speed;

    public RunLeftClimberUp(ClimberL m_climber, double speed) {
        this.m_climber = m_climber;
        this.speed = speed;
        addRequirements(this.m_climber);
    }
    
    @Override
    public void execute(){
        m_climber.runLeft(this.speed);
        SmartDashboard.putNumber("left", m_climber.getLeftPosition());
    }

    @Override
    public void end(boolean interrupted) {
        m_climber.runLeft(0);
    }

    @Override
    public boolean isFinished(){
        return m_climber.getLeftMotorPosition() > ClimbConstants.CLIMBER_LIMIT_Left;
    }

}
