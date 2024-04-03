package flutter.plugins.vibrate;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

class VibrateMethodCallHandler implements MethodChannel.MethodCallHandler {
    private final boolean hasVibrator;
    private final boolean legacyVibrator;
    private final Vibrator vibrator;

    public VibrateMethodCallHandler(Vibrator vibrator2) {
        boolean z11;
        this.vibrator = vibrator2;
        this.hasVibrator = vibrator2.hasVibrator();
        if (Build.VERSION.SDK_INT < 26) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.legacyVibrator = z11;
    }

    private void vibrate(int i11) {
        if (!this.hasVibrator) {
            return;
        }
        if (this.legacyVibrator) {
            this.vibrator.vibrate((long) i11);
        } else {
            this.vibrator.vibrate(VibrationEffect.createOneShot((long) i11, -1));
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1867169789:
                if (str.equals("success")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1715965556:
                if (str.equals("selection")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1184809658:
                if (str.equals("impact")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1078030475:
                if (str.equals("medium")) {
                    c11 = 3;
                    break;
                }
                break;
            case -952818817:
                if (str.equals("canVibrate")) {
                    c11 = 4;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c11 = 5;
                    break;
                }
                break;
            case 99152071:
                if (str.equals("heavy")) {
                    c11 = 6;
                    break;
                }
                break;
            case 102970646:
                if (str.equals("light")) {
                    c11 = 7;
                    break;
                }
                break;
            case 451310959:
                if (str.equals("vibrate")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1124446108:
                if (str.equals("warning")) {
                    c11 = 9;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                vibrate(50);
                result.success((Object) null);
                return;
            case 1:
                vibrate(3);
                result.success((Object) null);
                return;
            case 2:
                vibrate(1);
                result.success((Object) null);
                return;
            case 3:
                vibrate(40);
                result.success((Object) null);
                return;
            case 4:
                result.success(Boolean.valueOf(this.hasVibrator));
                return;
            case 5:
                vibrate(500);
                result.success((Object) null);
                return;
            case 6:
                vibrate(100);
                result.success((Object) null);
                return;
            case 7:
                vibrate(10);
                result.success((Object) null);
                return;
            case 8:
                vibrate(((Integer) methodCall.argument("duration")).intValue());
                result.success((Object) null);
                return;
            case 9:
                vibrate(250);
                result.success((Object) null);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
