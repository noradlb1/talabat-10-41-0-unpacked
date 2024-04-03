package com.instabug.survey.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.util.InstabugSDKLogger;

public abstract class j {
    public static void a() {
        try {
            new Handler(Looper.getMainLooper()).post(new i());
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", "AfterShowingSurveyRunnable has been failed to run.", e11);
        }
    }

    public static boolean a(@Nullable String str) {
        if (str == null) {
            return false;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1464712027:
                if (str.equals("days_since_signup")) {
                    c11 = 0;
                    break;
                }
                break;
            case -901870406:
                if (str.equals("app_version")) {
                    c11 = 1;
                    break;
                }
                break;
            case -12379384:
                if (str.equals("android_version")) {
                    c11 = 2;
                    break;
                }
                break;
            case 3076014:
                if (str.equals("date")) {
                    c11 = 3;
                    break;
                }
                break;
            case 96619420:
                if (str.equals("email")) {
                    c11 = 4;
                    break;
                }
                break;
            case 957831062:
                if (str.equals("country")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1421955229:
                if (str.equals("days_since_dismiss")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1694233633:
                if (str.equals("app_version_v2")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1905908461:
                if (str.equals("sessions_count")) {
                    c11 = 8;
                    break;
                }
                break;
            case 2013274756:
                if (str.equals(InstabugDbContract.UserEntity.COLUMN_LAST_SEEN)) {
                    c11 = 9;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static void b() {
        try {
            new Handler(Looper.getMainLooper()).post(new h());
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", "AfterShowingSurveyRunnable has been failed to run.", e11);
        }
    }

    public static boolean c() {
        return InstabugCore.isFeatureAvailable(Feature.SURVEYS);
    }

    public static boolean d() {
        return InstabugCore.getFeatureState(Feature.SURVEYS) == Feature.State.ENABLED;
    }
}
