package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

public class RunConveyor extends CommandBase {
    private final Shooter m_shooter;
    private final double converyorSpeed;

    public RunConveyor(Shooter m_shooter, double speed) {
        this.m_shooter = m_shooter;
        this.converyorSpeed = speed;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        this.m_shooter.runConveryor(this.converyorSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        this.m_shooter.runConveryor(0);
    }

}