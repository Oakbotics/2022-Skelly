package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

public class RunConveryor extends CommandBase {
    private final Shooter m_Shooter;
    private final double converyorSpeed;

    public RunConveryor(Shooter m_Shooter, double speed) {
        this.m_Shooter = m_Shooter;
        this.converyorSpeed = speed;
        addRequirements(m_Shooter);
    }

    @Override
    public void execute() {
        this.m_Shooter.runConveryor(this.converyorSpeed);
    }
}