package com.instabug.bug.view.disclaimer;

import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.bug.n;
import com.instabug.bug.utils.d;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.State;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.ArrayList;
import okhttp3.HttpUrl;
import org.json.JSONArray;

@Instrumented
public abstract class e {
    private static String a(String str) {
        return d.a(str, "#metadata-screen", "instabug-bug://instabug-disclaimer.com/disclaimer");
    }

    public static ArrayList a() {
        State state;
        ArrayList arrayList = new ArrayList();
        com.instabug.bug.model.d c11 = n.e().c();
        if (!(c11 == null || c11.getState() == null || (state = c11.getState()) == null)) {
            if (state.getAppPackageName() != null) {
                b(new a(State.KEY_APP_PACKAGE_NAME, state.getAppPackageName()), arrayList);
            }
            if (state.getAppVersion() != null) {
                b(new a("app_version", state.getAppVersion()), arrayList);
            }
            if (state.getBatteryState() != null) {
                b(new a("BATTERY", state.getBatteryLevel() + "%, " + state.getBatteryState()), arrayList);
            }
            if (state.getCarrier() != null) {
                b(new a("carrier", state.getCarrier()), arrayList);
            }
            if (b()) {
                JSONArray consoleLog = state.getConsoleLog();
                b(new a(State.KEY_CONSOLE_LOG, !(consoleLog instanceof JSONArray) ? consoleLog.toString() : JSONArrayInstrumentation.toString(consoleLog)).a(true), arrayList);
            }
            if (state.getCurrentView() != null) {
                b(new a(State.KEY_CURRENT_VIEW, state.getCurrentView()), arrayList);
            }
            if (state.getScreenDensity() != null) {
                b(new a(State.KEY_DENSITY, state.getScreenDensity()), arrayList);
            }
            if (state.getDevice() != null) {
                b(new a("device", state.getDevice()), arrayList);
            }
            b(new a(State.KEY_DEVICE_ROOTED, String.valueOf(state.isDeviceRooted())), arrayList);
            b(new a("duration", String.valueOf(state.getDuration())), arrayList);
            if (state.getUserEmail() != null) {
                b(new a("email", state.getUserEmail()), arrayList);
            }
            if (state.getInstabugLog() != null) {
                b(new a(State.KEY_INSTABUG_LOG, state.getInstabugLog()).a(true), arrayList);
            }
            if (state.getLocale() != null) {
                b(new a("locale", state.getLocale()), arrayList);
            }
            b(new a("MEMORY", (((float) state.getUsedMemory()) / 1000.0f) + "/" + (((float) state.getTotalMemory()) / 1000.0f) + " GB"), arrayList);
            if (state.getNetworkLogs() != null) {
                b(new a(State.KEY_NETWORK_LOGS, state.getNetworkLogs()).a(true), arrayList);
            }
            if (state.getScreenOrientation() != null) {
                b(new a("orientation", state.getScreenOrientation()), arrayList);
            }
            if (state.getOS() != null) {
                b(new a("os", state.getOS()), arrayList);
            }
            b(new a(State.KEY_REPORTED_AT, String.valueOf(state.getReportedAt())), arrayList);
            if (state.getScreenSize() != null) {
                b(new a(State.KEY_SCREEN_SIZE, state.getScreenSize()), arrayList);
            }
            if (state.getSdkVersion() != null) {
                b(new a("sdk_version", state.getSdkVersion()), arrayList);
            }
            b(new a("STORAGE", (((float) state.getUsedStorage()) / 1000.0f) + "/" + (((float) state.getTotalStorage()) / 1000.0f) + " GB"), arrayList);
            if (state.getUserAttributes() != null) {
                b(new a("user_attributes", state.getUserAttributes()).a(true), arrayList);
            }
            if (state.getUserData() != null) {
                b(new a(State.KEY_USER_DATA, state.getUserData()).a(true), arrayList);
            }
            if (d()) {
                JSONArray userSteps = state.getUserSteps();
                b(new a(State.KEY_USER_STEPS, !(userSteps instanceof JSONArray) ? userSteps.toString() : JSONArrayInstrumentation.toString(userSteps)).a(true), arrayList);
            }
            if (c()) {
                b(new a(State.KEY_VISUAL_USER_STEPS, state.getVisualUserSteps()).a(true), arrayList);
            }
            b(new a(State.KEY_WIFI_STATE, String.valueOf(state.isWifiEnable())), arrayList);
        }
        return arrayList;
    }

    public static boolean a(@Nullable Uri uri) {
        return uri != null && "instabug-bug".equals(uri.getScheme()) && "instabug-disclaimer.com".equals(uri.getHost()) && "/disclaimer".equals(uri.getPath());
    }

    public static Spanned b(String str) {
        String a11 = a(str);
        return Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(a11, 0) : Html.fromHtml(a11);
    }

    @VisibleForTesting
    public static void b(a aVar, ArrayList arrayList) {
        if (aVar.b() != null && !aVar.b().isEmpty() && !aVar.b().equals("{}") && !aVar.b().equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            aVar.a(aVar.a().toUpperCase().replace('_', ' '));
            arrayList.add(aVar);
        }
    }

    private static boolean b() {
        return InstabugCore.getFeatureState(Feature.CONSOLE_LOGS) == Feature.State.ENABLED;
    }

    private static boolean c() {
        return InstabugCore.getFeatureState(Feature.REPRO_STEPS) == Feature.State.ENABLED;
    }

    private static boolean d() {
        return InstabugCore.getFeatureState(Feature.TRACK_USER_STEPS) == Feature.State.ENABLED;
    }
}
