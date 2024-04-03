package androidx.constraintlayout.core.motion.utils;

import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static DebugHandle f10652a;

    public interface DebugHandle {
        void message(String str);
    }

    private static int clamp(int i11) {
        int i12 = (i11 & (~(i11 >> 31))) - 255;
        return (i12 & (i12 >> 31)) + 255;
    }

    public static void log(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(str + " : " + str2);
    }

    public static void logStack(String str, int i11) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i11, stackTrace.length - 1);
        String str2 = " ";
        for (int i12 = 1; i12 <= min; i12++) {
            StackTraceElement stackTraceElement = stackTrace[i12];
            str2 = str2 + " ";
            PrintStream printStream = System.out;
            printStream.println(str + str2 + (".(" + stackTrace[i12].getFileName() + CertificateUtil.DELIMITER + stackTrace[i12].getLineNumber() + ") " + stackTrace[i12].getMethodName()) + str2);
        }
    }

    public static void loge(String str, String str2) {
        PrintStream printStream = System.err;
        printStream.println(str + " : " + str2);
    }

    public static int rgbaTocColor(float f11, float f12, float f13, float f14) {
        int clamp = clamp((int) (f11 * 255.0f));
        int clamp2 = clamp((int) (f12 * 255.0f));
        return (clamp << 16) | (clamp((int) (f14 * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (f13 * 255.0f));
    }

    public static void setDebugHandle(DebugHandle debugHandle) {
        f10652a = debugHandle;
    }

    public static void socketSend(String str) {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public int getInterpolatedColor(float[] fArr) {
        int clamp = clamp((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
        int clamp2 = clamp((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp << 16) | (clamp2 << 8) | clamp((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public static void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String substring = (stackTraceElement.getMethodName() + "                  ").substring(0, 17);
        String str2 = ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")" + "    ".substring(Integer.toString(stackTraceElement.getLineNumber()).length()) + substring;
        System.out.println(str2 + " " + str);
        DebugHandle debugHandle = f10652a;
        if (debugHandle != null) {
            debugHandle.message(str2 + " " + str);
        }
    }
}
