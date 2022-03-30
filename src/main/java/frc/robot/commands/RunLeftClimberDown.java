package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ClimberL;

import frc.robot.Constants.ClimbConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class RunLeftClimberDown extends CommandBase {
    private final ClimberL m_Climber;
    private final double speed;

    public RunLeftClimberDown(ClimberL m_Climber, double speed) {
        this.m_Climber = m_Climber;
        this.speed = speed;
        addRequirements(this.m_Climber);
    }
    
    @Override
    public void execute(){
        m_Climber.runLeft(this.speed);
        SmartDashboard.putNumber("left", m_Climber.getLeftPosition());
    }

    @Override
    public void end(boolean interrupted) {
        m_Climber.runLeft(0);
    }

    @Override
    public boolean isFinished(){
        return m_Climber.getLeftMotorPosition() < 0;
    }

}
