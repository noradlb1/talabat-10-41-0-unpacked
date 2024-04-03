package com.instabug.library.usersteps;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.instabug.library.model.StepType;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public abstract class h {
    private static String a(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1854350643:
                if (str.equals(StepType.SCROLL)) {
                    c11 = 0;
                    break;
                }
                break;
            case 82819:
                if (str.equals(StepType.TAP)) {
                    c11 = 1;
                    break;
                }
                break;
            case 76133530:
                if (str.equals(StepType.PINCH)) {
                    c11 = 2;
                    break;
                }
                break;
            case 79316762:
                if (str.equals(StepType.SWIPE)) {
                    c11 = 3;
                    break;
                }
                break;
            case 1074528416:
                if (str.equals(StepType.LONG_PRESS)) {
                    c11 = 4;
                    break;
                }
                break;
            case 1265144341:
                if (str.equals(StepType.DOUBLE_TAP)) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return "Scroll";
            case 1:
                return "Tap";
            case 2:
                return "Pinch";
            case 3:
                return "Swipe";
            case 4:
                return "Long press";
            case 5:
                return "Double tap";
            default:
                return "";
        }
    }

    public static String a(String str, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        StringBuilder sb2 = new StringBuilder();
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1854350643:
                if (str.equals(StepType.SCROLL)) {
                    c11 = 0;
                    break;
                }
                break;
            case 82819:
                if (str.equals(StepType.TAP)) {
                    c11 = 1;
                    break;
                }
                break;
            case 76133530:
                if (str.equals(StepType.PINCH)) {
                    c11 = 2;
                    break;
                }
                break;
            case 78862054:
                if (str.equals(StepType.SHAKE)) {
                    c11 = 3;
                    break;
                }
                break;
            case 79316762:
                if (str.equals(StepType.SWIPE)) {
                    c11 = 4;
                    break;
                }
                break;
            case 1074528416:
                if (str.equals(StepType.LONG_PRESS)) {
                    c11 = 5;
                    break;
                }
                break;
            case 1265144341:
                if (str.equals(StepType.DOUBLE_TAP)) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
                sb2.append(a(str));
                sb2.append(" in ");
                if (str4 != null && !str4.isEmpty()) {
                    sb2.append("\"");
                    sb2.append(str4);
                    sb2.append("\"");
                    sb2.append(" of type \"");
                    sb2.append(str2);
                    sb2.append("\"");
                } else if (str3 != null) {
                    sb2.append("\"");
                    sb2.append(str3);
                    sb2.append("\"");
                    sb2.append(" of type \"");
                    sb2.append(str2);
                    sb2.append("\"");
                } else {
                    sb2.append("\"");
                    sb2.append(str2);
                    sb2.append("\"");
                }
                sb2.append(" in \"");
                sb2.append(str5);
                sb2.append("\"");
                break;
            case 2:
                sb2.append("Pinch in ");
                sb2.append(str5);
                break;
            case 3:
                sb2.append("The user shook the phone in ");
                sb2.append(str5);
                break;
        }
        return sb2.toString();
    }

    public static String a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1705165623:
                if (str.equals(StepType.ACTIVITY_DESTROYED)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1647502663:
                if (str.equals(StepType.APPLICATION_CREATED)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1643440744:
                if (str.equals(StepType.ACTIVITY_CREATED)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1574447993:
                if (str.equals(StepType.ACTIVITY_RESUMED)) {
                    c11 = 3;
                    break;
                }
                break;
            case -274213071:
                if (str.equals(StepType.ACTIVITY_STARTED)) {
                    c11 = 4;
                    break;
                }
                break;
            case -261347203:
                if (str.equals(StepType.ACTIVITY_STOPPED)) {
                    c11 = 5;
                    break;
                }
                break;
            case 3213533:
                if (str.equals(StepType.OPEN_DIALOG)) {
                    c11 = 6;
                    break;
                }
                break;
            case 26863710:
                if (str.equals(StepType.ACTIVITY_PAUSED)) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                sb2.append(str2);
                sb2.append(" was destroyed.");
                break;
            case 1:
            case 2:
                sb2.append(str2);
                sb2.append(" was created.");
                break;
            case 3:
                sb2.append(str2);
                sb2.append(" was resumed.");
                break;
            case 4:
                sb2.append(str2);
                sb2.append(" was started.");
                break;
            case 5:
                sb2.append(str2);
                sb2.append(" was stopped.");
                break;
            case 6:
                sb2.append("In container ");
                sb2.append(str2);
                sb2.append(": dialog ");
                sb2.append(str2);
                sb2.append(" was displayed.");
                break;
            case 7:
                sb2.append(str2);
                sb2.append(" was paused.");
                break;
        }
        return sb2.toString();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static String a(String str, String str2, String str3, @Nullable String str4) {
        StringBuilder sb2 = new StringBuilder();
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1933282175:
                if (str.equals(StepType.FRAGMENT_DETACHED)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1431942979:
                if (str.equals(StepType.FRAGMENT_VIEW_CREATED)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1382777347:
                if (str.equals(StepType.FRAGMENT_PAUSED)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1023412878:
                if (str.equals(StepType.FRAGMENT_STARTED)) {
                    c11 = 3;
                    break;
                }
                break;
            case -1010547010:
                if (str.equals(StepType.FRAGMENT_STOPPED)) {
                    c11 = 4;
                    break;
                }
                break;
            case -730405706:
                if (str.equals(StepType.FRAGMENT_VISIBILITY_CHANGED)) {
                    c11 = 5;
                    break;
                }
                break;
            case 3213533:
                if (str.equals(StepType.OPEN_DIALOG)) {
                    c11 = 6;
                    break;
                }
                break;
            case 1855874739:
                if (str.equals(StepType.FRAGMENT_ATTACHED)) {
                    c11 = 7;
                    break;
                }
                break;
            case 1971319496:
                if (str.equals(StepType.FRAGMENT_RESUMED)) {
                    c11 = 8;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                sb2.append("In activity ");
                sb2.append(str3);
                sb2.append(": fragment ");
                sb2.append(str2);
                sb2.append(" was detached.");
                break;
            case 1:
                sb2.append("In activity ");
                sb2.append(str3);
                sb2.append(": fragment ");
                sb2.append(str2);
                sb2.append(" was created.");
                break;
            case 2:
                sb2.append("In activity ");
                sb2.append(str3);
                sb2.append(": fragment ");
                sb2.append(str2);
                sb2.append(" was paused.");
                break;
            case 3:
                sb2.append("In activity ");
                sb2.append(str3);
                sb2.append(": fragment ");
                sb2.append(str2);
                sb2.append(" was started.");
                break;
            case 4:
                sb2.append("In activity ");
                sb2.append(str3);
                sb2.append(": fragment ");
                sb2.append(str2);
                sb2.append(" was stopped.");
                break;
            case 5:
                sb2.append("In activity ");
                sb2.append(str3);
                sb2.append(": visibility of fragment ");
                sb2.append(str2);
                sb2.append(" changed, ");
                sb2.append(str4);
                sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                break;
            case 6:
                sb2.append("In container ");
                sb2.append(str2);
                sb2.append(": dialog ");
                sb2.append(str2);
                sb2.append(" was displayed.");
                break;
            case 7:
                sb2.append("In activity ");
                sb2.append(str3);
                sb2.append(": fragment ");
                sb2.append(str2);
                sb2.append(" was attached.");
                break;
            case 8:
                sb2.append("In activity ");
                sb2.append(str3);
                sb2.append(": fragment ");
                sb2.append(str2);
                sb2.append(" was resumed.");
                break;
        }
        return sb2.toString();
    }
}
