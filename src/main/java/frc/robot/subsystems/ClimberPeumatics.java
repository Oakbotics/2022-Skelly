package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ClimberPeumatics extends SubsystemBase{
    
    
    private final DoubleSolenoid climberSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);

    public void setSolenoidForward() {
        climberSolenoid.set(Value.kForward);
    }

    public void setSolenoidReverse() {
        climberSolenoid.set(Value.kReverse);
    }

    public void solenoidToggle() {
        climberSolenoid.toggle();
    }

}
