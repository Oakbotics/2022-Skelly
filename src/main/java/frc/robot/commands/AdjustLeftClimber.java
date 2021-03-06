package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.ClimbConstants;

import frc.robot.subsystems.ClimberL;

public class AdjustLeftClimber extends CommandBase{
    private final ClimberL m_climberL;

    public AdjustLeftClimber(ClimberL m_climberL) {
        this.m_climberL = m_climberL;

        addRequirements(this.m_climberL);
    }

    @Override
    public void execute() {
        if (m_climberL.getLeftSetPoint() < m_climberL.getLeftMotorPosition() ) {
            m_climberL.runLeft(-0.10);
        }
        else {
            m_climberL.runLeft(0);
        }
        SmartDashboard.putNumber("leftSetPoint", m_climberL.getLeftSetPoint());
        SmartDashboard.putBoolean("retracted limit", (m_climberL.getLeftMotorPosition() > ClimbConstants.CLIMBER_STRAIGHT_LIMIT && m_climberL.pistonRectracted()));
        SmartDashboard.putBoolean("extended limit", (m_climberL.getLeftMotorPosition() > ClimbConstants.CLIMBER_FORWARD_LIMIT && m_climberL.pistonExtended()));


    }
}
