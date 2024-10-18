@TeleOp()
public class IGTeleOp extends LinearOpMode {
  DcMotorEx leftElevator, rightElevator

  @Override
    public void runOpMode() {

    leftElevator = hardwareMap.get(DcMotorEx.class, "Lelevator");
    rightElevator = hardwareMap.get(DcMotorEx.class, "Relevator");

    leftElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    rightElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    
    // Encoders
    leftElevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightElevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
    leftElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    rightElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    
    //Set position
    leftElevator.setTargetPosition(0);
    rightElevator.setTargetPosition(0);

     leftElevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      rightElevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    
    //Reverse motors
    leftElevator.setDirection(DcMotorEx.Direction.REVERSE);
    //rightElevator.setDirection(DcMotorEx.Direction.REVERSE)


    waitForStart();

        while(opModeIsActive()) {
           if(gamepad1.dpad_up) {
              leftElevator.setTargetPosition(2380); 
                rightElevator.setTargetPosition(2380);
                leftElevator.setPower(1.0);
                rightElevator.setPower(1.0);
          }
          else if (gamepad1.dpad_down) {
                // Retract
                leftElevator.setTargetPosition(0);
                rightElevator.setTargetPosition(0);
                leftElevator.setPower(1.0);
                rightElevator.setPower(1.0);
          }
          else if (gamepad1.right_bumper) {
                // Set position for outtake
                leftElevator.setTargetPosition(1745); 
                rightElevator.setTargetPosition(1745);
                leftElevator.setPower(1.0);
                rightElevator.setPower(1.0);
          }

        

        





    
          }
      }
  }
