package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ClimberL;




public class TempLeftClimbUp extends CommandBase {
    private final ClimberL m_climber;

    public TempLeftClimbUp(ClimberL m_climber) {
        this.m_climber = m_climber;
        addRequirements(this.m_climber);
    }
    
    @Override
    public void execute(){
        if (m_climber.getLeftMotorPosition() < 0) {
            m_climber.runLeft(0.05);
            m_climber.updateEncoderSetPoint();
        }
        else if (m_climber.getLeftMotorPosition() > 0) {
            m_climber.runLeft(-0.05);
            m_climber.updateEncoderSetPoint();
        }
        else {
            m_climber.runLeft(0);
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_climber.runLeft(0);
    }


}
