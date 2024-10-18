package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class ItkanGirlsTeleop extends LinearOpMode {

    public RobotDrive bot;
    public Elevator elevator;
    public Intake intake;
    //public Arm arm;

    // Position of the arm when it's lifted
    public int top = 2380;
    public int middle = 1745;
    // Position of the arm when it's down
    public int downpos = 0;

    @Override
    public void runOpMode() {

        bot = new RobotDrive();
        elevator = new Elevator();
        intake = new Intake();
        //arm = new Arm();

        bot.init(hardwareMap);
        elevator.init(hardwareMap);
        intake.init(hardwareMap);
        //arm.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            double jx = -gamepad1.left_stick_y;
            double jy = -gamepad1.left_stick_x;
            double jw = -gamepad1.right_stick_x;

            // elevator
            if (gamepad1.dpad_down) {
                elevator.elevate(downpos, 0.5);
            }

            else if (gamepad1.dpad_up) {
                elevator.elevate(top, 0.5);
            }

            else if (gamepad1.right_bumper) {
                elevator.elevate(middle, 0.5);
            }

            //intake wheels
            if (gamepad1.right_trigger > 0.05) {
                intake.intake();
            } else if (gamepad1.left_trigger > 0.05) {
                intake.outtake();
            } else {
                intake.stop();
            }


            // drivetrain
            bot.driveXYW(jx, jy, jw);

            telemetry.addData("Status", "Running");
            telemetry.update();
        }

    }

}
