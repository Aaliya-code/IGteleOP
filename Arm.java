package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {

    DcMotorEx arm;
    Servo pivot;
    double pivotExtendedPos = 0;
    double pivotRetractedPos = 1;
    int armExtendedPos = 0;
    int armRetractedPos = 0;

    public void init(HardwareMap hardwareMap) {
        arm = initDcMotor(hardwareMap, "arm", DcMotor.Direction.FORWARD);
        pivot = hardwareMap.get(Servo.class, "ipivot");
    }

    public DcMotorEx initDcMotor(HardwareMap hardwareMap,
                                 String name,
                                 DcMotor.Direction dir) {
        DcMotorEx m = hardwareMap.get(DcMotorEx.class, name);
        m.setDirection(dir);
        m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m.setTargetPosition(m.getCurrentPosition());
        m.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m.setPower(0.5);
        return m;
    }

    public void extend() {
        pivot.setPosition(pivotExtendedPos);
        arm.setTargetPosition(armExtendedPos);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(0.5);
    }

    public void retract() {
        pivot.setPosition(pivotRetractedPos);
        arm.setTargetPosition(armRetractedPos);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(0.5);
    }



}
