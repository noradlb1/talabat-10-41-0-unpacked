package com.instabug.crash;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.commons.di.CommonsLocator;
import com.instabug.commons.models.Incident;
import com.instabug.commons.threading.a;
import com.instabug.crash.di.d;
import com.instabug.crash.eventbus.NDKCrashReportingFeatureStateChange;
import com.instabug.crash.models.IBGNonFatalException;
import com.instabug.crash.models.a;
import com.instabug.crash.network.h;
import com.instabug.crash.settings.g;
import com.instabug.crash.utils.CrashReportingUtility;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.operation.WriteStateToFileDiskOperation;
import com.instabug.library.internal.video.ScreenRecordingService;
import com.instabug.library.model.Report;
import com.instabug.library.model.State;
import com.instabug.library.model.UserAttributes;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.MD5Generator;
import com.instabug.library.util.ReportHelper;
import com.instabug.library.util.threading.PoolProvider;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import fc.e;
import fc.f;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class CrashReporting {
    public static final String ANR_STATE = "anr_state";
    public static final String CRASH_STATE = "crash_state";
    private static final String TAG = "CrashReporting";

    public class a implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f46372a;

        public a(Feature.State state) {
            this.f46372a = state;
        }

        public void run() {
            boolean z11;
            Feature.State state = this.f46372a;
            Feature.State state2 = Feature.State.ENABLED;
            if (state != state2 || d.b().a()) {
                com.instabug.crash.configurations.c b11 = d.b();
                if (this.f46372a == state2) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                b11.a(z11);
                SDKCoreEventPublisher.post(new SDKCoreEvent("features", SDKCoreEvent.Feature.VALUE_UPDATED));
                return;
            }
            InstabugSDKLogger.e("Instabug-CrashReporting", "crash reporting wasn't enabled as it seems to be disabled for your Instabug company account. Please, contact support to switch it on for you.");
        }
    }

    public class b implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f46373a;

        public b(Feature.State state) {
            this.f46373a = state;
        }

        public void run() {
            boolean z11;
            Feature.State state = this.f46373a;
            Feature.State state2 = Feature.State.ENABLED;
            if (state != state2 || CrashReportingUtility.isCrashReportingEnabled()) {
                com.instabug.anr.configuration.c b11 = com.instabug.anr.di.c.b();
                if (this.f46373a == state2) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                b11.b(z11);
                SDKCoreEventPublisher.post(new SDKCoreEvent("features", SDKCoreEvent.Feature.VALUE_UPDATED));
                return;
            }
            InstabugSDKLogger.w("IBG-CR", "Can not enable ANR reporting while Crash reporting is disabled");
        }
    }

    public class c implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f46374a;

        public c(Feature.State state) {
            this.f46374a = state;
        }

        public void run() {
            if (NDKCrashReportingFeatureStateChange.getInstance() != null) {
                NDKCrashReportingFeatureStateChange.getInstance().post(this.f46374a);
            } else {
                InstabugSDKLogger.e("IBG-CR", "Couldn't not enable NDK crash reporting state is null.");
            }
        }
    }

    public static void addCrashAttachments(@NonNull Context context, com.instabug.crash.models.a aVar) {
        if (context != null && aVar != null && InstabugCore.getExtraAttachmentFiles() != null) {
            for (Map.Entry next : InstabugCore.getExtraAttachmentFiles().entrySet()) {
                Uri newFileAttachmentUri = AttachmentsUtility.getNewFileAttachmentUri(context, (Uri) next.getKey(), (String) next.getValue());
                if (newFileAttachmentUri != null) {
                    aVar.a(newFileAttachmentUri);
                }
            }
        }
    }

    private static void appendUserAttributes(@NonNull State state, Map<String, String> map) {
        UserAttributes userAttributes = new UserAttributes();
        try {
            if (state.getUserAttributes() != null) {
                JSONObject jSONObject = new JSONObject(state.getUserAttributes());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    userAttributes.put(next, jSONObject.getString(next));
                }
            }
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-CR", "Error while appending user attributes to crash report", e11);
        }
        if (map.size() > 100) {
            Log.w("Instabug-CrashReporting", "Some old user attributes were removed. Max allowed user attributes reached. Please note that you can add up to " + 100 + " user attributes.");
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            for (Map.Entry<String, String> key : map.entrySet()) {
                linkedHashMap.remove(key.getKey());
                if (linkedHashMap.size() <= 100) {
                    break;
                }
            }
            map.clear();
            map.putAll(linkedHashMap);
        }
        for (Map.Entry next2 : map.entrySet()) {
            if (map.get(next2.getKey()) != null) {
                if (((String) next2.getKey()).length() > 90 || ((String) next2.getValue()).length() > 90) {
                    Log.w("Instabug-CrashReporting", "Some user attributes weren't added. Max allowed user attributes characters limit is reached. Please note that you can add user attributes (key, value) with characters count up to " + 90 + " characters.");
                } else {
                    userAttributes.put((String) next2.getKey(), (String) next2.getValue());
                }
            }
        }
        state.setUserAttributes(userAttributes.toString());
    }

    private static void createFormattedException(@NonNull Throwable th2, @Nullable String str) {
        createFormattedException(th2, str, (Map<String, String>) null);
    }

    private static void createStateTextFile(@NonNull Context context, @NonNull com.instabug.crash.models.a aVar, @NonNull File file) {
        if (file != null && aVar != null && aVar.h() != null) {
            InstabugSDKLogger.v("IBG-CR", "Creating state file for crash: " + aVar.e());
            try {
                Uri execute = DiskUtils.with(context).writeOperation(new WriteStateToFileDiskOperation(file, aVar.h().toJson())).execute();
                if (execute != null) {
                    aVar.h().setUri(execute);
                }
                AttachmentsUtility.encryptAttachments(aVar.a());
            } catch (Throwable th2) {
                InstabugSDKLogger.e("IBG-CR", "error while creating state text file", th2);
            }
        }
    }

    public static void deleteAutoScreenRecording() {
        AutoScreenRecordingEventBus.getInstance().post(ScreenRecordingService.Action.STOP_DELETE);
    }

    @NonNull
    public static com.instabug.crash.models.a getCrash(JSONObject jSONObject, boolean z11, State state) {
        return getCrash(jSONObject, z11, state, (JSONObject) null, IBGNonFatalException.Level.ERROR);
    }

    @VisibleForTesting
    @Nullable
    public static JSONObject getFingerprintObject(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String generateMD5 = MD5Generator.generateMD5(trim.toLowerCase());
            if (generateMD5 == null || generateMD5.isEmpty()) {
                throw new IllegalStateException("Couldn't generate MD5 for fingerprint");
            }
            jSONObject.put("md5", (Object) generateMD5);
            jSONObject.put("length", trim.length());
            if (trim.length() > 40) {
                InstabugSDKLogger.w("IBG-CR", "Grouping string exceeds the defined maximum characters limit (40) so it will be trimmed");
                trim = trim.substring(0, 40);
            }
            jSONObject.put("original", (Object) trim);
            return jSONObject;
        } catch (Throwable th2) {
            InstabugSDKLogger.e("IBG-CR", "Failed to process fingerprint", th2);
            return null;
        }
    }

    @VisibleForTesting
    @Nullable
    public static JSONObject getFormattedException(@NonNull Throwable th2, @Nullable String str) {
        if (th2 == null) {
            return null;
        }
        InstabugSDKLogger.v("IBG-CR", "Creating formatted exception for error: " + th2.getClass().getCanonicalName());
        JSONObject a11 = new com.instabug.commons.threading.a(a.b.C0056a.f46351a, new a.C0054a.C0055a(th2, str)).a();
        if (a11.length() != 0) {
            return a11;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportException$5(JSONObject jSONObject, boolean z11, JSONObject jSONObject2, IBGNonFatalException.Level level, Map map) {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            State state = State.getState(applicationContext);
            com.instabug.crash.utils.b.a(state);
            Report report = ReportHelper.getReport(InstabugCore.getOnReportCreatedListener());
            com.instabug.crash.models.a crash = getCrash(jSONObject, z11, state, jSONObject2, level);
            ReportHelper.update(crash.h(), report);
            if (map != null && !map.isEmpty()) {
                appendUserAttributes(state, map);
            }
            if (InstabugCore.getExtraAttachmentFiles() != null && InstabugCore.getExtraAttachmentFiles().size() >= 1) {
                addCrashAttachments(applicationContext, crash);
            }
            createStateTextFile(applicationContext, crash, DiskUtils.createStateTextFile(applicationContext, "crash_state"));
            com.instabug.crash.cache.b.b(crash);
            CommonsLocator.getSessionLinker().a((Incident) crash, 1);
            InstabugSDKLogger.d("IBG-CR", "Your exception has been reported");
            h.b().start();
            com.instabug.crash.screenrecording.a.a().b();
        }
    }

    public static void report(@NonNull IBGNonFatalException iBGNonFatalException) {
        APIChecker.checkAndRunInExecutor("CrashReporting.report", new fc.d(iBGNonFatalException));
    }

    private static void reportCrashingSession() {
        InstabugSDKLogger.d("IBG-CR", "Report crashing session");
        SDKCoreEventPublisher.post(new SDKCoreEvent("cross_platform_crashed"));
        g.a().a(true);
    }

    @Deprecated
    public static void reportException(@NonNull Throwable th2) {
        APIChecker.checkAndRunInExecutor("CrashReporting.reportException", new f(th2));
    }

    /* access modifiers changed from: private */
    public static void reportHandledException(@NonNull Throwable th2, @Nullable String str, @Nullable Map<String, String> map, @Nullable String str2, @NonNull IBGNonFatalException.Level level) {
        if (th2 != null) {
            InstabugSDKLogger.d("IBG-CR", "Reporting handled exception: " + th2.getMessage());
            if (!CrashReportingUtility.isCrashReportingEnabled()) {
                InstabugSDKLogger.e("IBG-CR", "CrashReporting is disabled, Couldn't report error");
                return;
            }
            JSONObject formattedException = getFormattedException(th2, str);
            if (formattedException != null) {
                JSONObject fingerprintObject = getFingerprintObject(str2);
                if (fingerprintObject == null) {
                    InstabugSDKLogger.e("IBG-CR", "Grouping string not provided. This crash will be grouped by the default grouping algorithm.");
                }
                reportException(formattedException, true, map, fingerprintObject, level);
            }
        }
    }

    private static void reportUncaughtException(@NonNull JSONObject jSONObject) {
        if (jSONObject != null) {
            reportException(jSONObject, false);
        }
    }

    public static void setAnrState(@NonNull Feature.State state) {
        APIChecker.checkAndRunInExecutor("CrashReporting.setAnrState", new b(state));
    }

    public static void setNDKCrashesState(@NonNull Feature.State state) {
        APIChecker.checkAndRunInExecutor("CrashReporting.setNDKCrashesState", new c(state));
    }

    public static void setState(@NonNull Feature.State state) {
        InstabugSDKLogger.d("IBG-CR", "CrashReporting setState:" + state);
        APIChecker.checkAndRunInExecutor("CrashReporting.setState", new a(state));
    }

    private static void createFormattedException(@NonNull Throwable th2, @Nullable String str, @Nullable Map<String, String> map) {
        if (th2 != null) {
            InstabugSDKLogger.v("IBG-CR", "Creating formatted exception for error: " + th2.getClass().getCanonicalName());
            reportException(new com.instabug.commons.threading.a(a.b.C0056a.f46351a, new a.C0054a.C0055a(th2, str)).a(), true, map);
        }
    }

    @NonNull
    private static com.instabug.crash.models.a getCrash(JSONObject jSONObject, boolean z11, State state, @Nullable JSONObject jSONObject2, @NonNull IBGNonFatalException.Level level) {
        com.instabug.crash.models.a a11 = new a.b().a(state);
        a11.a(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        a11.a(a.C0057a.READY_TO_BE_SENT);
        a11.a(z11);
        a11.a(level);
        JSONArray b11 = new com.instabug.commons.threading.a(a.b.C0056a.f46351a, a.C0054a.b.f46350a).b();
        a11.e(!(b11 instanceof JSONArray) ? b11.toString() : JSONArrayInstrumentation.toString(b11));
        a11.b(jSONObject2 != null ? JSONObjectInstrumentation.toString(jSONObject2) : null);
        return a11;
    }

    @Deprecated
    public static void reportException(@NonNull Throwable th2, @Nullable String str) {
        APIChecker.checkAndRunInExecutor("CrashReporting.reportException", new fc.c(th2, str));
    }

    @Deprecated
    public static void reportException(@NonNull Throwable th2, @Nullable String str, @Nullable Map<String, String> map) {
        APIChecker.checkAndRunInExecutor("CrashReporting.reportException", new fc.g(th2, str, map));
    }

    @Deprecated
    public static void reportException(@NonNull Throwable th2, @Nullable String str, @Nullable Map<String, String> map, @Nullable String str2) {
        APIChecker.checkAndRunInExecutor("CrashReporting.reportException", new e(th2, str, map, str2));
    }

    private static void reportException(@NonNull JSONObject jSONObject, boolean z11) {
        reportException(jSONObject, z11, (Map<String, String>) null);
    }

    private static void reportException(@NonNull JSONObject jSONObject, boolean z11, @Nullable Map<String, String> map) {
        reportException(jSONObject, z11, map, (JSONObject) null);
    }

    private static void reportException(@NonNull JSONObject jSONObject, boolean z11, @Nullable Map<String, String> map, @Nullable JSONObject jSONObject2) {
        reportException(jSONObject, z11, map, jSONObject2, IBGNonFatalException.Level.ERROR);
    }

    private static void reportException(@NonNull JSONObject jSONObject, boolean z11, @Nullable Map<String, String> map, @Nullable JSONObject jSONObject2, @NonNull IBGNonFatalException.Level level) {
        if (jSONObject != null) {
            if (InstabugCore.getPlatform() != 2 && !z11) {
                reportCrashingSession();
            }
            if (CrashReportingUtility.isCrashReportingEnabled()) {
                if (com.instabug.crash.screenrecording.a.a().isEnabled() && SettingsManager.getInstance().autoScreenRecordingEnabled()) {
                    deleteAutoScreenRecording();
                }
                PoolProvider.getSingleThreadExecutor("HANDLED_CRASH").execute(new fc.h(jSONObject, z11, jSONObject2, level, map));
            }
        }
    }
}
