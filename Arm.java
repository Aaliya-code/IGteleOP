package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {

    DcMotorEx arm;
    Servo pivot;
    int armIntaking = 350;
    int armOuttaking = 100;
    double pivotIntaking = 0.1;
    double pivotOuttaking = 0.4;

    public void init(HardwareMap hardwareMap) {
        arm = initDcMotor(hardwareMap, "arm", DcMotor.Direction.FORWARD);
        pivot = hardwareMap.get(Servo.class, "ipivot");
        pivot.setPosition(0.5);
    }

    public DcMotorEx initDcMotor(HardwareMap hardwareMap,
                                 String name,
                                 DcMotor.Direction dir) {
        DcMotorEx m = hardwareMap.get(DcMotorEx.class, name);
        m.setDirection(dir);
        m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m.setTargetPosition(0);
        m.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m.setPower(0.5);
        return m;
    }

    public void intaking() {
        pivot.setPosition(pivotIntaking);
        arm.setTargetPosition(armIntaking);
        arm.setPower(1);
    }

    public void outtaking() {
        pivot.setPosition(pivotOuttaking);
        arm.setTargetPosition(armOuttaking);
        arm.setPower(1);
    }



}
