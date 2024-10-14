@TeleOp()
public class IGteleOp extends LinearOpMode {
  DcMotorEx intake, rElevator, lElevator, armPiviot, frontLeft, frontRight, backLeft, backRight;
  Servo intakePiviot, hangHook;

  //target for motors
  int armTarget = 0;
  int extendTarget = 0;

  @Override
  public void runOpMode() {
    intake =  hardwareMap.get(DcMotorEX.class, "intake");
    rElevator =  hardwareMap.get(DcMotorEX.class, "rElevator");
    lElevator =  hardwareMap.get(DcMotorEX.class, "lElevator");
    armPiviot =  hardwareMap.get(DcMotorEX.class, "armPiviot");
    frontLeft =  hardwareMap.get(DcMotorEX.class, "frontLeft");
    frontRight =  hardwareMap.get(DcMotorEX.class, "frontRight");
    backLeft =  hardwareMap.get(DcMotorEX.class, "backLeft");
    backRight =  hardwareMap.get(DcMotorEX.class, "backRight");

    rElevator.setZeroPowerBehavior(DcMotor.ZeroPwerBehavior.BRAKE);
    lElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    armPiviot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontLeft.setZeroPowerBehavior(DcMotor.ZeroPOwerBehavior.BRAKE);
    frontRight.setZeroPowerBehavior(DcMotor.ZeroPOwerBehavior.BRAKE);
    backLeft.setZeroPowerBehavior(DcMotor.ZeroPOwerBehavior.BRAKE);
    backRight.setZeroPowerBehavior(DcMotor.ZeroPOwerBehavior.BRAKE);

    intake.setPower(0);

    frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    backRight.setDirection(DcMotorSimple.Direction.REVERSE);

    rElevator.setTargetPosition(0);
    rElevator.setPower(1.0);
    rElevator.setPower(DcMotorEx.RunMode.RUN_TO_POSTION);
    rElevator.setTargetPosition(0);

    lElevator.setTargetPosition(0);
    lElevator.setPower(1.0);
    lElevator.setPower(DcMotorEx.RunMode.RUN_TO_POSTION);
    lElevator.setTargetPosition(0);

    intakePiviot = hardwareMap.get(Servo.class, "intakePiviot");
    hangHook = hardwareMap.get(Servo.class, "hankHook");

    intakePiviot.setPosition(0);
    armMotor.setPower(0);
    hangHook.setPosition(0);
    //0.1 is home
    //0.5 is deployed

    waitForStart();

    while(opModeIsActive()) {
      if (gamepad1.right_trigger > 0.1) {
        intakePiviot.setPosition(1.0);
        armPiviot.setPower(0.5);
      }
      else{
        intakePiviot.setPostion(0);
        armPiviot.setPower(0);
      }
      if (gamepad1.left_trigger > 0.1) {
        intakePiviot.setPosition(0.5);
      }
    }

    //Drive Code


        while(opModeIsActive()) {

            frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            backRight = hardwareMap.get(DcMotor.class, "backRight");

            float power;

            

            waitForStart();


            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            frontLeft.setPower(frontLeftPower);
            backLeft.setPower(backLeftPower);
            frontRight.setPower(frontRightPower);
            backRight.setPower(backRightPower);



        
        }


    }


}
    

    

    
      
     
  }
}
