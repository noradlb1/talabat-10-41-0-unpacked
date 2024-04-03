package datamodels;

public class SmsVerificationInstance {
    public static boolean isFirst;
    public static int previousSecond;
    private static SmsVerificationInstance smsInstance = new SmsVerificationInstance();
    public static long timeStamp;
    public static String userMobileNumber;

    private SmsVerificationInstance() {
    }

    public static SmsVerificationInstance getSmsInstance() {
        return smsInstance;
    }

    public static void resetInstance() {
        smsInstance = null;
        smsInstance = new SmsVerificationInstance();
        userMobileNumber = "";
        timeStamp = -1;
        previousSecond = -1;
    }
}
