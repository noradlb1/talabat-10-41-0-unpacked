package com.uxcam;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.uxcam.datamodel.UXCamOccludeAllTextFields;
import com.uxcam.datamodel.UXCamOcclusion;
import com.uxcam.datamodel.UXCamOverlay;
import com.uxcam.datamodel.UXConfig;
import com.uxcam.internals.bi;
import com.uxcam.internals.bj;
import com.uxcam.internals.by;
import com.uxcam.internals.ee;
import com.uxcam.internals.eq;
import com.uxcam.internals.fn;
import com.uxcam.internals.gc;
import com.uxcam.internals.gm;
import com.uxcam.internals.gu;
import com.uxcam.internals.hm;
import com.uxcam.internals.hn;
import com.uxcam.internals.ho;
import com.uxcam.internals.hs;
import com.uxcam.internals.hu;
import com.uxcam.internals.ia;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class UXCam {
    public static void addScreenNameToIgnore(String str) {
        gm.D.add(str);
    }

    public static void addScreenNamesToIgnore(List list) {
        gm.D.addAll(list);
    }

    @Deprecated
    public static void addTagWithProperties(String str) {
        logEvent(str);
    }

    public static void addVerificationListener(OnVerificationListener onVerificationListener) {
        try {
            hm f11 = hm.f();
            f11.f13576a.clear();
            f11.f13576a.add(onVerificationListener);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static void allowShortBreakForAnotherApp() {
        fn.f13380k = (long) 180000;
    }

    public static void applyOcclusion(UXCamOcclusion uXCamOcclusion) {
        ee.b(uXCamOcclusion);
    }

    public static void attachUnsupportedView(SupportMapFragment supportMapFragment) {
        hm.a(supportMapFragment);
    }

    public static void attachWebviewInterface(WebView webView) {
        gm.G = false;
        webView.addJavascriptInterface(new hs(), "UXCam");
    }

    public static void cancelCurrentSession() {
        gm.f13465n = true;
        stopSessionAndUploadData();
    }

    @Deprecated
    public static void cancelRecording() {
        cancelCurrentSession();
    }

    public static void deletePendingUploads() {
        try {
            new gc(ia.f13617c).a();
            hu.a("deletePendingUploadApiCalled", new HashMap());
        } catch (Exception unused) {
            gu.f13504c.getClass();
        }
    }

    @Deprecated
    public static void disableCrashHandling(boolean z11) {
        try {
            hm.a(z11);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static boolean getMultiSessionRecord() {
        if (hm.e().f12944d == UXConfig.MultiSessionRecordStatus.ENABLED) {
            return true;
        }
        return false;
    }

    public static ho getOkHttpInterceptor() {
        ho.aa aaVar = new ho.aa();
        ho.f13585c = true;
        return new ho(aaVar.f13588a);
    }

    public static String getSdkVersionInfo() {
        return String.format(Locale.ENGLISH, "%s (%d)", new Object[]{"3.4.4", 561});
    }

    @Deprecated
    public static void identify(String str) {
        hm.f().a(str);
    }

    @Deprecated
    public static void ignoreRecording() {
        cancelCurrentSession();
    }

    public static boolean isRecording() {
        try {
            return bi.f13066a;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static void logEvent(String str) {
        try {
            hm.a(str, (Map) null);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void logNotification(android.content.Context r4, android.content.Intent r5) {
        /*
            if (r5 == 0) goto L_0x0018
            java.lang.String r0 = "UXCam_data"
            boolean r1 = r5.hasExtra(r0)
            if (r1 == 0) goto L_0x0018
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0014 }
            java.lang.String r5 = r5.getStringExtra(r0)     // Catch:{ JSONException -> 0x0014 }
            r1.<init>((java.lang.String) r5)     // Catch:{ JSONException -> 0x0014 }
            goto L_0x0019
        L_0x0014:
            r5 = move-exception
            r5.getMessage()
        L_0x0018:
            r1 = 0
        L_0x0019:
            if (r1 == 0) goto L_0x0055
            com.uxcam.internals.es r5 = new com.uxcam.internals.es
            long r2 = java.lang.System.currentTimeMillis()
            r5.<init>(r2, r1)
            java.util.List r0 = com.uxcam.internals.et.a((android.content.Context) r4)
            r1 = r0
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            r1.add(r5)
            org.json.JSONArray r5 = com.uxcam.internals.et.a((java.util.List) r0)
            com.uxcam.internals.eq r0 = new com.uxcam.internals.eq
            r0.<init>(r4)
            boolean r4 = r5 instanceof org.json.JSONArray
            if (r4 != 0) goto L_0x0040
            java.lang.String r4 = r5.toString()
            goto L_0x0044
        L_0x0040:
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation.toString(r5)
        L_0x0044:
            android.content.SharedPreferences r5 = r0.f13291a
            if (r5 == 0) goto L_0x0055
            android.content.SharedPreferences$Editor r5 = r5.edit()
            java.lang.String r0 = "push_notification_data"
            android.content.SharedPreferences$Editor r4 = r5.putString(r0, r4)
            r4.apply()
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.UXCam.logNotification(android.content.Context, android.content.Intent):void");
    }

    @Deprecated
    public static void markSessionAsFavorite() {
        setSessionProperty("kUXCam_isFavourite", "true");
    }

    public static void occludeAllTextFields(boolean z11) {
        UXCamOccludeAllTextFields build = new UXCamOccludeAllTextFields.Builder().build();
        if (z11) {
            ee.b((UXCamOcclusion) build);
        } else {
            ee.c((UXCamOcclusion) build);
        }
        if (!z11) {
            Iterator it = fn.f13382m.iterator();
            while (it.hasNext()) {
                if (!((hn) it.next()).f13583n) {
                    it.remove();
                }
            }
        }
    }

    @Deprecated
    public static void occludeAllTextView() {
        occludeAllTextFields(true);
    }

    public static void occludeRectsOnNextFrame(JSONArray jSONArray) {
        int i11 = 0;
        while (i11 < jSONArray.length()) {
            try {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i11);
                Rect rect = new Rect();
                rect.left = jSONArray2.getInt(0);
                rect.top = jSONArray2.getInt(1);
                rect.right = jSONArray2.getInt(2);
                rect.bottom = jSONArray2.getInt(3);
                fn.f13383n.add(rect);
                i11++;
            } catch (JSONException e11) {
                e11.printStackTrace();
                return;
            }
        }
    }

    public static void occludeSensitiveScreen(boolean z11) {
        try {
            UXCamOverlay build = new UXCamOverlay.Builder().build();
            if (z11) {
                applyOcclusion(build);
            } else {
                removeOcclusion(build);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void occludeSensitiveView(View view) {
        try {
            hn hnVar = new hn(true);
            hnVar.f13590b = new WeakReference(view);
            hnVar.f13591c = false;
            fn.f13382m.add(hnVar);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void occludeSensitiveViewWithoutGesture(View view) {
        try {
            hn hnVar = new hn(true);
            hnVar.f13590b = new WeakReference(view);
            hnVar.f13591c = true;
            fn.f13382m.add(hnVar);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static void optIn() {
        optInOverall();
    }

    public static void optInOverall() {
        hm.b(false);
        hm.f13569l = true;
    }

    public static boolean optInOverallStatus() {
        if (ia.f13617c == null) {
            hm.c();
        }
        return !new eq(ia.f13617c).a("opt_out");
    }

    @Deprecated
    public static boolean optInStatus() {
        return optInOverallStatus();
    }

    public static boolean optInVideoRecordingStatus() {
        if (ia.f13617c == null) {
            hm.c();
        }
        return !new eq(ia.f13617c).a("opt_out_of_video_recording");
    }

    public static void optIntoVideoRecording() {
        SharedPreferences sharedPreferences;
        hm.c();
        Context context = ia.f13617c;
        if (context != null && (sharedPreferences = new eq(context).f13291a) != null) {
            sharedPreferences.edit().putBoolean("opt_out_of_video_recording", false).apply();
        }
    }

    @Deprecated
    public static void optOut() {
        optOutOverall();
    }

    public static void optOutOfVideoRecording() {
        SharedPreferences sharedPreferences;
        hm.c();
        Context context = ia.f13617c;
        if (!(context == null || (sharedPreferences = new eq(context).f13291a) == null)) {
            sharedPreferences.edit().putBoolean("opt_out_of_video_recording", true).apply();
        }
        if (bi.f13066a) {
            bj.f13070g = true;
        }
    }

    public static void optOutOverall() {
        hm.b(true);
        hm.f13569l = false;
    }

    @Deprecated
    public static boolean optStatus() {
        return optInStatus();
    }

    @Deprecated
    public static void pause() {
        pauseScreenRecording();
    }

    public static void pauseScreenRecording() {
        try {
            occludeSensitiveScreen(true, true);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static int pendingSessionCount() {
        return pendingUploads();
    }

    public static int pendingUploads() {
        String str = ia.f13615a;
        try {
            hm.c();
            return new File(by.a()).list().length;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void pluginType(String str, String str2) {
        hm.f13566i = str;
        hm.f13567j = str2;
    }

    public static void removeAllScreenNamesToIgnore() {
        gm.D = new TreeSet();
    }

    public static void removeOcclusion(UXCamOcclusion uXCamOcclusion) {
        ee.c(uXCamOcclusion);
    }

    public static void removeScreenNameToIgnore(String str) {
        gm.D.remove(str);
    }

    public static void removeScreenNamesToIgnore(List list) {
        gm.D.removeAll(list);
    }

    public static void removeVerificationListener(OnVerificationListener onVerificationListener) {
        try {
            hm.f().f13576a.remove(onVerificationListener);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void reportBugEvent(String str) {
        try {
            hm.b(str, (Map) null);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void reportExceptionEvent(Throwable th2, Map map) {
        try {
            hm.a(th2, map);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static void resume() {
        resumeScreenRecording();
    }

    public static void resumeScreenRecording() {
        try {
            occludeSensitiveScreen(false, false);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static void resumeShortBreakForAnotherApp() {
        fn.f13380k = 0;
    }

    public static List screenNamesBeingIgnored() {
        return new ArrayList(gm.D);
    }

    @Deprecated
    public static void setAutomaticScreenNameTagging(boolean z11) {
        try {
            hm.e().f12943c = z11;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static void setImprovedScreenCaptureEnabled(boolean z11) {
        hm.e().f12946f = z11;
    }

    @Deprecated
    public static void setMultiSessionRecord(boolean z11) {
        UXConfig.MultiSessionRecordStatus multiSessionRecordStatus;
        UXConfig e11 = hm.e();
        e11.getClass();
        if (z11) {
            multiSessionRecordStatus = UXConfig.MultiSessionRecordStatus.ENABLED;
        } else {
            multiSessionRecordStatus = UXConfig.MultiSessionRecordStatus.DISABLED_BUT_NOT_STARTED;
        }
        e11.f12944d = multiSessionRecordStatus;
    }

    public static void setPushNotificationToken(String str) {
        hm.c();
        Context context = ia.f13617c;
        if (context != null) {
            eq eqVar = new eq(context);
            if (str == null) {
                str = "";
            }
            SharedPreferences sharedPreferences = eqVar.f13291a;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("push_notification_token", str).apply();
            }
        }
    }

    @Deprecated
    public static void setSessionProperty(String str, String str2) {
        hm.f().a(str, (Object) str2);
    }

    public static void setUserIdentity(String str) {
        hm.f().a(str);
    }

    public static void setUserProperty(String str, String str2) {
        hm.f().f13582g.f13613b.put(str, str2);
    }

    public static void startApplicationWithKeyForCordova(Activity activity, String str) {
        try {
            hm.a(activity, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void startNewSession() {
        hm.g();
    }

    public static void startWithConfiguration(UXConfig uXConfig) {
        try {
            hm.a(uXConfig);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void startWithConfigurationCrossPlatform(Activity activity, UXConfig uXConfig) {
        try {
            hm.e().e(uXConfig);
            hm.b(activity);
            for (UXCamOcclusion b11 : uXConfig.f12941a) {
                ee.b(b11);
            }
        } catch (Exception e11) {
            try {
                e11.printStackTrace();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    @Deprecated
    public static void startWithKey(String str) {
        try {
            hm.c(str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void startWithKeyForAppcelerator(Activity activity, String str) {
        try {
            hm.a(activity, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static void stopApplicationAndUploadData() {
        try {
            stopSessionAndUploadData();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void stopSessionAndUploadData() {
        try {
            hm.f13573p = true;
            hm.f13569l = false;
            hm.f().b(ia.f13617c);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void tagScreenName(String str) {
        try {
            hm.d(str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static void tagUsersName(String str) {
        identify(str);
    }

    public static void unOccludeSensitiveView(View view) {
        try {
            if (!fn.f13382m.isEmpty()) {
                Iterator it = fn.f13382m.iterator();
                while (it.hasNext()) {
                    hn hnVar = (hn) it.next();
                    if (((View) hnVar.f13590b.get()).equals(view)) {
                        fn.f13382m.remove(hnVar);
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static String urlForCurrentSession() {
        try {
            return gm.f13463l;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String urlForCurrentUser() {
        try {
            return gm.f13462k;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static void addTagWithProperties(String str, Map map) {
        logEvent(str, map);
    }

    public static void allowShortBreakForAnotherApp(boolean z11) {
        if (z11) {
            fn.f13380k = (long) 180000;
        } else {
            fn.f13380k = 0;
        }
    }

    public static void attachUnsupportedView(MapFragment mapFragment) {
        hm.a(mapFragment);
    }

    @Deprecated
    public static void setSessionProperty(String str, int i11) {
        hm.f().a(str, (Object) Integer.valueOf(i11));
    }

    @Deprecated
    public static void addTagWithProperties(String str, JSONObject jSONObject) {
        logEvent(str, jSONObject);
    }

    public static void attachUnsupportedView(MapView mapView) {
        hm.a(mapView);
    }

    public static void logEvent(String str, Map map) {
        try {
            hm.a(str, map);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void reportBugEvent(String str, Map map) {
        try {
            hm.b(str, map);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void reportExceptionEvent(Throwable th2) {
        try {
            hm.a(th2, (Map) null);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static void setSessionProperty(String str, float f11) {
        hm.f().a(str, (Object) Float.valueOf(f11));
    }

    @Deprecated
    public static void startApplicationWithKeyForCordova(Activity activity, String str, String str2) {
        try {
            gm.f13454c = str2;
            hm.a(activity, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void startWithConfiguration(UXConfig uXConfig, Activity activity, boolean z11) {
        try {
            hm.e().e(uXConfig);
            hm.a(activity, false, z11);
        } catch (NullPointerException e11) {
            try {
                e11.printStackTrace();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    @Deprecated
    public static void startWithKey(String str, Activity activity, boolean z11) {
        try {
            hm.e().f12942b = str;
            hm.a(activity, false, z11);
        } catch (NullPointerException e11) {
            try {
                e11.printStackTrace();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    @Deprecated
    public static void startWithKeyForAppcelerator(Activity activity, String str, String str2) {
        try {
            gm.f13454c = str2;
            hm.a(activity, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void allowShortBreakForAnotherApp(int i11) {
        fn.f13380k = (long) i11;
    }

    public static void setSessionProperty(String str, boolean z11) {
        hm.f().a(str, (Object) Boolean.valueOf(z11));
    }

    public static void setUserProperty(String str, int i11) {
        hm f11 = hm.f();
        f11.f13582g.f13613b.put(str, Integer.valueOf(i11));
    }

    public static void logEvent(String str, JSONObject jSONObject) {
        try {
            hm.a(str, ia.a(jSONObject));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void occludeSensitiveScreen(boolean z11, boolean z12) {
        try {
            applyOcclusion(new UXCamOverlay.Builder().withoutGesture(z12).build());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void reportBugEvent(String str, JSONObject jSONObject) {
        try {
            hm.b(str, ia.a(jSONObject));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void setUserProperty(String str, float f11) {
        hm f12 = hm.f();
        f12.f13582g.f13613b.put(str, Float.valueOf(f11));
    }

    @Deprecated
    public static void startWithKey(String str, String str2) {
        try {
            gm.f13454c = str2;
            startWithKey(str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void setUserProperty(String str, boolean z11) {
        hm f11 = hm.f();
        f11.f13582g.f13613b.put(str, Boolean.valueOf(z11));
    }

    @Deprecated
    public static void startWithKey(String str, String str2, OnVerificationListener onVerificationListener) {
        try {
            gm.f13454c = str2;
            startWithKey(str);
            hm f11 = hm.f();
            f11.f13576a.clear();
            f11.f13576a.add(onVerificationListener);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Deprecated
    public static void startWithKey(String str, OnVerificationListener onVerificationListener) {
        try {
            hm.c(str);
            hm f11 = hm.f();
            f11.f13576a.clear();
            f11.f13576a.add(onVerificationListener);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
