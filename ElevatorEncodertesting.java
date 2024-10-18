package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class IGEncoderTesting extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Find a motor in the hardware map named "Arm Motor"
        DcMotor elevatorRight = hardwareMap.dcMotor.get("ER");
        DcMotor elevatorLeft = hardwareMap.dcMotor.get("EL");


        // Reset the motor encoder so that it reads zero ticks
        elevatorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevatorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Turn the motor back on, required if you use STOP_AND_RESET_ENCODER
        elevatorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        elevatorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            // Get the current position of the motor
            int elevatorRightPos = elevatorRight.getCurrentPosition();
            int elevatorLeftPos = elevatorLeft.getCurrentPosition();

            // Show the position of the motor on telemetry
            telemetry.addData("Right elevator Position", elevatorRightPos);
            telemetry.addData("Left elevator Position", elevatorLeftPos);
            telemetry.update();
        }
    }
}
