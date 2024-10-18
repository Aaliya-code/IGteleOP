package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    DcMotorEx intakeMotor;

    public void init(HardwareMap hardwareMap) {
        intakeMotor = initDcMotor(hardwareMap, "intake", DcMotorSimple.Direction.FORWARD);
    }

    public DcMotorEx initDcMotor(HardwareMap hardwareMap,
                                 String name,
                                 DcMotor.Direction dir) {
        DcMotorEx m = hardwareMap.get(DcMotorEx.class, name);
        m.setDirection(dir);
        m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        return m;
    }

    public void intake() {
        intakeMotor.setPower(1);
    }

    public void outtake() {
        intakeMotor.setPower(-1);
    }
    
    public void stop() {
        intakeMotor.setPower(0);
    }

}
