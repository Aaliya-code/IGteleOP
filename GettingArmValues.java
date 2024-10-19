package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class GettingArmValues extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Find a motor in the hardware map named "Arm Motor"
        DcMotor arm = hardwareMap.dcMotor.get("arm");
        Servo pivot = hardwareMap.get(Servo.class, "ipivot");

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        int pos;
        double pivot_curr_pos = 0;
        int previous = -1;
        pivot.setPosition(0);

        waitForStart();

        while (opModeIsActive()) {
            // Get the current position of the motor
            pos = arm.getCurrentPosition();

            if (previous==1 && !gamepad1.dpad_right && !gamepad1.dpad_left) {
                previous = -1;
            }

            if (gamepad1.dpad_right && pivot_curr_pos<1 && previous==-1) {
                pivot_curr_pos += 0.1;
                pivot.setPosition(pivot_curr_pos);
                previous = 1;
            }
            if (gamepad1.dpad_left && pivot_curr_pos>0 && previous==-1) {
                pivot_curr_pos -= 0.1;
                pivot.setPosition(pivot_curr_pos);
                previous = 1;

            }


            // Show the position of the motor on telemetry
            telemetry.addData("Arm Position", pos);
            telemetry.addData("Servo Position", pivot.getPosition());
            telemetry.update();
        }
    }
}
