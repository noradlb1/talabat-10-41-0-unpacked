package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;

    private AccessibilityServiceInfoCompat() {
    }

    @NonNull
    public static String capabilityToString(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 4 ? i11 != 8 ? "UNKNOWN" : "CAPABILITY_CAN_FILTER_KEY_EVENTS" : "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY" : "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION" : "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
    }

    @NonNull
    public static String feedbackTypeToString(int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        while (i11 > 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i11);
            i11 &= ~numberOfTrailingZeros;
            if (sb2.length() > 1) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            if (numberOfTrailingZeros == 1) {
                sb2.append("FEEDBACK_SPOKEN");
            } else if (numberOfTrailingZeros == 2) {
                sb2.append("FEEDBACK_HAPTIC");
            } else if (numberOfTrailingZeros == 4) {
                sb2.append("FEEDBACK_AUDIBLE");
            } else if (numberOfTrailingZeros == 8) {
                sb2.append("FEEDBACK_VISUAL");
            } else if (numberOfTrailingZeros == 16) {
                sb2.append("FEEDBACK_GENERIC");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Nullable
    public static String flagToString(int i11) {
        if (i11 == 1) {
            return "DEFAULT";
        }
        if (i11 == 2) {
            return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
        }
        if (i11 == 4) {
            return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
        }
        if (i11 == 8) {
            return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
        }
        if (i11 == 16) {
            return "FLAG_REPORT_VIEW_IDS";
        }
        if (i11 != 32) {
            return null;
        }
        return "FLAG_REQUEST_FILTER_KEY_EVENTS";
    }

    public static int getCapabilities(@NonNull AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getCapabilities();
    }

    @Nullable
    public static String loadDescription(@NonNull AccessibilityServiceInfo accessibilityServiceInfo, @NonNull PackageManager packageManager) {
        return accessibilityServiceInfo.loadDescription(packageManager);
    }
}
