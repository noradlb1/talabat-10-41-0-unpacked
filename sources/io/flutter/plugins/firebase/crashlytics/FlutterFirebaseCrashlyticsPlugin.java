package io.flutter.plugins.firebase.crashlytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import zz.a;
import zz.b;
import zz.c;
import zz.d;
import zz.e;
import zz.f;
import zz.g;
import zz.h;
import zz.i;
import zz.j;
import zz.k;
import zz.l;
import zz.m;

public class FlutterFirebaseCrashlyticsPlugin implements FlutterFirebasePlugin, FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final String TAG = "FLTFirebaseCrashlytics";
    private MethodChannel channel;

    private Task<Map<String, Object>> checkForUnsentReports() {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new c(this));
    }

    private void crash() {
        new Handler().postDelayed(new d(), 50);
    }

    private Task<Void> deleteUnsentReports() {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new j());
    }

    private Task<Map<String, Object>> didCrashOnPreviousExecution() {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new a(this));
    }

    private StackTraceElement generateStackTraceElement(Map<String, String> map) {
        try {
            String str = map.get("file");
            String str2 = map.get(Constants.LINE);
            String str3 = map.get("class");
            String str4 = map.get("method");
            if (str3 == null) {
                str3 = "";
            }
            Objects.requireNonNull(str2);
            return new StackTraceElement(str3, str4, str, Integer.parseInt(str2));
        } catch (Exception unused) {
            Log.e(TAG, "Unable to generate stack trace element from Dart error.");
            return null;
        }
    }

    private SharedPreferences getCrashlyticsSharedPrefs(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    private void initInstance(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_crashlytics");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_crashlytics", this);
    }

    /* access modifiers changed from: private */
    public boolean isCrashlyticsCollectionEnabled(FirebaseApp firebaseApp) {
        SharedPreferences crashlyticsSharedPrefs = getCrashlyticsSharedPrefs(firebaseApp.getApplicationContext());
        if (crashlyticsSharedPrefs.contains("firebase_crashlytics_collection_enabled")) {
            return crashlyticsSharedPrefs.getBoolean("firebase_crashlytics_collection_enabled", true);
        }
        if (!firebaseApp.isDataCollectionDefaultEnabled()) {
            return false;
        }
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Map lambda$checkForUnsentReports$0() throws Exception {
        return new HashMap<String, Object>(((Boolean) Tasks.await(FirebaseCrashlytics.getInstance().checkForUnsentReports())).booleanValue()) {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f14308b;

            {
                this.f14308b = r2;
                put(Constants.UNSENT_REPORTS, Boolean.valueOf(r2));
            }
        };
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$crash$1() {
        throw new FirebaseCrashlyticsTestCrash();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Map lambda$didCrashOnPreviousExecution$3() throws Exception {
        return new HashMap<String, Object>(FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution()) {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f14310b;

            {
                this.f14310b = r2;
                put(Constants.DID_CRASH_ON_PREVIOUS_EXECUTION, Boolean.valueOf(r2));
            }
        };
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void lambda$didReinitializeFirebaseCore$12() throws Exception {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Map lambda$getPluginConstantsForFirebaseApp$11() throws Exception {
        return new HashMap<String, Object>() {
            {
                put(Constants.IS_CRASHLYTICS_COLLECTION_ENABLED, Boolean.valueOf(FlutterFirebaseCrashlyticsPlugin.this.isCrashlyticsCollectionEnabled(FirebaseApp.getInstance())));
            }
        };
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void lambda$log$5(Map map) throws Exception {
        Object obj = map.get("message");
        Objects.requireNonNull(obj);
        FirebaseCrashlytics.getInstance().log((String) obj);
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onMethodCall$10(MethodChannel.Result result, Task task) {
        String str;
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = exception.getMessage();
        } else {
            str = "An unknown error occurred";
        }
        result.error("firebase_crashlytics", str, (Object) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$recordError$4(Map map) throws Exception {
        FlutterError flutterError;
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        Object obj = map.get("exception");
        Objects.requireNonNull(obj);
        String str = (String) obj;
        String str2 = (String) map.get("reason");
        Object obj2 = map.get("information");
        Objects.requireNonNull(obj2);
        String str3 = (String) obj2;
        boolean booleanValue = ((Boolean) map.get("fatal")).booleanValue();
        if (str2 != null) {
            instance.setCustomKey(Constants.FLUTTER_ERROR_REASON, "thrown " + str2);
            flutterError = new FlutterError(str + ". Error thrown " + str2 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        } else {
            flutterError = new FlutterError(str);
        }
        if (booleanValue) {
            CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger((AnalyticsConnector) FirebaseApp.getInstance().get(AnalyticsConnector.class));
            Bundle bundle = new Bundle();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", currentTimeMillis);
            instance.setCustomKey(Constants.CRASH_EVENT_KEY, currentTimeMillis);
            crashlyticsOriginAnalyticsEventLogger.logEvent(Constants.FIREBASE_APPLICATION_EXCEPTION, bundle);
        }
        instance.setCustomKey(Constants.FLUTTER_ERROR_EXCEPTION, str);
        ArrayList arrayList = new ArrayList();
        Object obj3 = map.get(Constants.STACK_TRACE_ELEMENTS);
        Objects.requireNonNull(obj3);
        for (Map generateStackTraceElement : (List) obj3) {
            StackTraceElement generateStackTraceElement2 = generateStackTraceElement(generateStackTraceElement);
            if (generateStackTraceElement2 != null) {
                arrayList.add(generateStackTraceElement2);
            }
        }
        flutterError.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
        if (!str3.isEmpty()) {
            instance.log(str3);
        }
        instance.recordException(flutterError);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Map lambda$setCrashlyticsCollectionEnabled$7(Map map) throws Exception {
        Object obj = map.get("enabled");
        Objects.requireNonNull(obj);
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled((Boolean) obj);
        return new HashMap<String, Object>() {
            {
                put(Constants.IS_CRASHLYTICS_COLLECTION_ENABLED, Boolean.valueOf(FlutterFirebaseCrashlyticsPlugin.this.isCrashlyticsCollectionEnabled(FirebaseApp.getInstance())));
            }
        };
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void lambda$setCustomKey$9(Map map) throws Exception {
        Object obj = map.get("key");
        Objects.requireNonNull(obj);
        Object obj2 = map.get("value");
        Objects.requireNonNull(obj2);
        FirebaseCrashlytics.getInstance().setCustomKey((String) obj, (String) obj2);
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void lambda$setUserIdentifier$8(Map map) throws Exception {
        Object obj = map.get(Constants.IDENTIFIER);
        Objects.requireNonNull(obj);
        FirebaseCrashlytics.getInstance().setUserId((String) obj);
        return null;
    }

    private Task<Void> log(Map<String, Object> map) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new k(map));
    }

    private Task<Void> recordError(Map<String, Object> map) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new f(this, map));
    }

    private Task<Void> sendUnsentReports() {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new b());
    }

    private Task<Map<String, Object>> setCrashlyticsCollectionEnabled(Map<String, Object> map) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new g(this, map));
    }

    private Task<Void> setCustomKey(Map<String, Object> map) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new l(map));
    }

    private Task<Void> setUserIdentifier(Map<String, Object> map) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new h(map));
    }

    public Task<Void> didReinitializeFirebaseCore() {
        return Tasks.call(new e());
    }

    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        return Tasks.call(new i(this));
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            this.channel = null;
        }
    }

    public void onMethodCall(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Task task;
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2094964816:
                if (str.equals("Crashlytics#didCrashOnPreviousExecution")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1437158995:
                if (str.equals("Crashlytics#recordError")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1025128541:
                if (str.equals("Crashlytics#checkForUnsentReports")) {
                    c11 = 2;
                    break;
                }
                break;
            case -424770276:
                if (str.equals("Crashlytics#sendUnsentReports")) {
                    c11 = 3;
                    break;
                }
                break;
            case -108157790:
                if (str.equals("Crashlytics#setCrashlyticsCollectionEnabled")) {
                    c11 = 4;
                    break;
                }
                break;
            case 28093114:
                if (str.equals("Crashlytics#log")) {
                    c11 = 5;
                    break;
                }
                break;
            case 108415030:
                if (str.equals("Crashlytics#setCustomKey")) {
                    c11 = 6;
                    break;
                }
                break;
            case 213629529:
                if (str.equals("Crashlytics#deleteUnsentReports")) {
                    c11 = 7;
                    break;
                }
                break;
            case 679831756:
                if (str.equals("Crashlytics#setUserIdentifier")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1219454365:
                if (str.equals("Crashlytics#crash")) {
                    c11 = 9;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                task = didCrashOnPreviousExecution();
                break;
            case 1:
                task = recordError((Map) methodCall.arguments());
                break;
            case 2:
                task = checkForUnsentReports();
                break;
            case 3:
                task = sendUnsentReports();
                break;
            case 4:
                task = setCrashlyticsCollectionEnabled((Map) methodCall.arguments());
                break;
            case 5:
                task = log((Map) methodCall.arguments());
                break;
            case 6:
                task = setCustomKey((Map) methodCall.arguments());
                break;
            case 7:
                task = deleteUnsentReports();
                break;
            case 8:
                task = setUserIdentifier((Map) methodCall.arguments());
                break;
            case 9:
                crash();
                return;
            default:
                result.notImplemented();
                return;
        }
        task.addOnCompleteListener(new m(result));
    }
}
