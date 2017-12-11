package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by ${alon} on 02/12/2017.
 */
@Autonomous(name = "navigation")
public class navigation extends LinearOpMode {

   VuforiaLocalizer vuforiaL;
   double Xtarget=0;
   double Ytarget=20;
   double Ztarget=0;
   double x=0;
   double y=0;
   double z=0;
   DcMotor LF;
   DcMotor LB;
   DcMotor RF;
   DcMotor RB;
   BNO055IMU gyro;


    @Override
    public void runOpMode() throws InterruptedException {
        LF=hardwareMap.dcMotor.get("lf");
        LB=hardwareMap.dcMotor.get("lb");
        RF=hardwareMap.dcMotor.get("rf");
        RB=hardwareMap.dcMotor.get("rb");
        RF.setDirection(DcMotorSimple.Direction.REVERSE);
        RB.setDirection(DcMotorSimple.Direction.REVERSE);
        gyro = hardwareMap.get(BNO055IMU.class, "gyro");
        BNO055IMU.Parameters p = new BNO055IMU.Parameters();
        gyro.initialize(p);
        int cameraMonitorViewId=hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters=new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey="AVmiHF3/////AAAAGTLb6D5vqUgdt1adb6Mf4sYb0tD0exNoGb4Af3FwgeOibcDTUsLJKtf9NcniZiHzmpuCChQnyFA1I/qwBlAnuy6jnujS0l0oVf8vRW5VMnMnnIRyisoKU8YuVDfI2aH5/zNibuTrUikvDuVGWH4DtnU1ZF+T/aG2p6lm6RWJCN1H0PVoMjkE2gPeqL6ShE6SvqNtYlByfFwlL613ptwTStn+VVAjCBkqiUtdAz0N3cbLR7aw7yAerGobh6X0vxvlADE9iDZLl+pJ725mEFJZHryiD3JF38AOESrY+5Fv49Wns+/VnXFqmZieQf7OnXjQX6Phc6Y0qkAHEYh2rz2Or7n6Ny19XCUdVWvfQTeOKkev";
        parameters.cameraDirection=VuforiaLocalizer.CameraDirection.BACK;
        this.vuforiaL= ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables=this.vuforiaL.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate= relicTrackables.get(0);
        RelicRecoveryVuMark vuMark=RelicRecoveryVuMark.from(relicTemplate);
        VuforiaTrackableDefaultListener listener=(VuforiaTrackableDefaultListener) relicTemplate.getListener();
        OpenGLMatrix location=null;
        VectorF trans;

        waitForStart();

        relicTrackables.activate();

            Orientation a = gyro.getAngularOrientation();
            Orientation f = a.toAngleUnit(AngleUnit.DEGREES);
            double g = f.angleUnit.toDegrees(f.firstAngle);
            while (vuMark==null){
                LF.setPower(0.2);
                LB.setPower(0.2);
                RF.setPower(0.2);
                RB.setPower(0.2);
            }
            location=listener.getUpdatedRobotLocation();
            trans=location.getTranslation();
            x=trans.get(0);
            y=trans.get(1);

            if (Xtarget>0){
                while (g<90) {
                    LF.setPower(0.2);
                    LB.setPower(0.2);
                    RF.setPower(-0.2);
                    RB.setPower(-0.2);
                }
                while (Xtarget!=x){
                    location=listener.getUpdatedRobotLocation();
                    trans=location.getTranslation();
                    x=trans.get(0);
                    LF.setPower(0.2);
                    LB.setPower(0.2);
                    RF.setPower(0.2);
                    RB.setPower(0.2);
                }
                while (g > -90) {
                    LF.setPower(-0.2);
                    LB.setPower(-0.2);
                    RF.setPower(0.2);
                    RB.setPower(0.2);
                }
            }
            if (Xtarget<0) {
                while (g > -90) {
                    LF.setPower(-0.2);
                    LB.setPower(-0.2);
                    RF.setPower(0.2);
                    RB.setPower(0.2);
                }
                while (Xtarget != x) {
                    location = listener.getUpdatedRobotLocation();
                    trans = location.getTranslation();
                    x = trans.get(0);
                    LF.setPower(0.2);
                    LB.setPower(0.2);
                    RF.setPower(0.2);
                }
                while (g < 90) {
                    LF.setPower(0.2);
                    LB.setPower(0.2);
                    RF.setPower(-0.2);
                    RB.setPower(-0.2);
                }
            }
            if (Ytarget>y){
                while (Ytarget>y){
                    location=listener.getUpdatedRobotLocation();
                    trans=location.getTranslation();
                    y=trans.get(1);
                    LF.setPower(0.2);
                    LB.setPower(0.2);
                    RF.setPower(0.2);
                    RB.setPower(0.2);
                }
            }
        }
}
