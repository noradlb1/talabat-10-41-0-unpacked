package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v6.e;
import v6.f;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Instrumented
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u00013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u001fH\u0007J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0017\u0010$\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020'J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0007J\u001f\u0010)\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\b+J\b\u0010,\u001a\u00020'H\u0002J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001fH\u0007J\b\u0010/\u001a\u00020'H\u0007J\u001a\u00100\u001a\u00020'2\b\b\u0002\u0010\u001d\u001a\u00020\u00042\u0006\u00101\u001a\u000202H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u00064"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager;", "", "()V", "APPLICATION_FIELDS", "", "APPLICATION_GATEKEEPER_CACHE_TIMEOUT", "", "APPLICATION_GATEKEEPER_EDGE", "APPLICATION_GATEKEEPER_FIELD", "APPLICATION_GRAPH_DATA", "APPLICATION_PLATFORM", "APPLICATION_SDK_VERSION", "APP_GATEKEEPERS_PREFS_KEY_FORMAT", "APP_GATEKEEPERS_PREFS_STORE", "APP_PLATFORM", "TAG", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "fetchedAppGateKeepers", "", "Lorg/json/JSONObject;", "gateKeeperRuntimeCache", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "timestamp", "Ljava/lang/Long;", "getAppGateKeepersQueryResponse", "applicationId", "getGateKeeperForKey", "", "name", "defaultValue", "getGateKeepersForApplication", "", "isTimestampValid", "(Ljava/lang/Long;)Z", "loadAppGateKeepersAsync", "", "callback", "parseAppGateKeepersFromJSON", "gateKeepersJSON", "parseAppGateKeepersFromJSON$facebook_core_release", "pollCallbacks", "queryAppGateKeepers", "forceRequery", "resetRuntimeGateKeeperCache", "setRuntimeGateKeeper", "gateKeeper", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FetchedAppGateKeepersManager {
    @NotNull
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    @NotNull
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    @NotNull
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    @NotNull
    private static final String APPLICATION_GRAPH_DATA = "data";
    @NotNull
    private static final String APPLICATION_PLATFORM = "platform";
    @NotNull
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    @NotNull
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    @NotNull
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    @NotNull
    private static final String APP_PLATFORM = "android";
    @NotNull
    public static final FetchedAppGateKeepersManager INSTANCE = new FetchedAppGateKeepersManager();
    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(FetchedAppGateKeepersManager.class).getSimpleName();
    @NotNull
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    @NotNull
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();
    @Nullable
    private static GateKeeperRuntimeCache gateKeeperRuntimeCache;
    @NotNull
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    @Nullable
    private static Long timestamp;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "", "onCompleted", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void onCompleted();
    }

    private FetchedAppGateKeepersManager() {
    }

    private final JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        bundle.putString("sdk_version", FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest.Companion companion = GraphRequest.Companion;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("app/%s", Arrays.copyOf(new Object[]{APPLICATION_GATEKEEPER_EDGE}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        GraphRequest newGraphPathRequest = companion.newGraphPathRequest((AccessToken) null, format, (GraphRequest.Callback) null);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        if (jsonObject == null) {
            return new JSONObject();
        }
        return jsonObject;
    }

    @JvmStatic
    public static final boolean getGateKeeperForKey(@NotNull String str, @Nullable String str2, boolean z11) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "name");
        Map<String, Boolean> gateKeepersForApplication = INSTANCE.getGateKeepersForApplication(str2);
        if (gateKeepersForApplication.containsKey(str) && (bool = gateKeepersForApplication.get(str)) != null) {
            return bool.booleanValue();
        }
        return z11;
    }

    private final boolean isTimestampValid(Long l11) {
        return l11 != null && System.currentTimeMillis() - l11.longValue() < 3600000;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAppGateKeepersAsync$lambda-0  reason: not valid java name */
    public static final void m8950loadAppGateKeepersAsync$lambda0(String str, Context context, String str2) {
        Intrinsics.checkNotNullParameter(str, "$applicationId");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str2, "$gateKeepersKey");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
        JSONObject appGateKeepersQueryResponse = fetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(str);
        if (appGateKeepersQueryResponse.length() != 0) {
            parseAppGateKeepersFromJSON$facebook_core_release(str, appGateKeepersQueryResponse);
            context.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(str2, JSONObjectInstrumentation.toString(appGateKeepersQueryResponse)).apply();
            timestamp = Long.valueOf(System.currentTimeMillis());
        }
        fetchedAppGateKeepersManager.pollCallbacks();
        isLoading.set(false);
    }

    @JvmStatic
    @NotNull
    @VisibleForTesting(otherwise = 2)
    public static final synchronized JSONObject parseAppGateKeepersFromJSON$facebook_core_release(@NotNull String str, @Nullable JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (FetchedAppGateKeepersManager.class) {
            Intrinsics.checkNotNullParameter(str, "applicationId");
            jSONObject2 = fetchedAppGateKeepers.get(str);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            int i11 = 0;
            JSONObject jSONObject3 = null;
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    jSONObject3 = optJSONArray.optJSONObject(0);
                }
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            JSONArray optJSONArray2 = jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
            if (optJSONArray2 == null) {
                optJSONArray2 = new JSONArray();
            }
            int length = optJSONArray2.length();
            if (length > 0) {
                while (true) {
                    int i12 = i11 + 1;
                    try {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i11);
                        jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean("value"));
                    } catch (JSONException e11) {
                        Utility.logd(Utility.LOG_TAG, (Exception) e11);
                    }
                    if (i12 >= length) {
                        break;
                    }
                    i11 = i12;
                }
            }
            fetchedAppGateKeepers.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    private final void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<Callback> concurrentLinkedQueue = callbacks;
            if (!concurrentLinkedQueue.isEmpty()) {
                Callback poll = concurrentLinkedQueue.poll();
                if (poll != null) {
                    handler.post(new f(poll));
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: pollCallbacks$lambda-1  reason: not valid java name */
    public static final void m8951pollCallbacks$lambda1(Callback callback) {
        callback.onCompleted();
    }

    @JvmStatic
    @NotNull
    public static final JSONObject queryAppGateKeepers(@NotNull String str, boolean z11) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "applicationId");
        if (!z11) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(str)) {
                JSONObject jSONObject = map.get(str);
                if (jSONObject == null) {
                    return new JSONObject();
                }
                return jSONObject;
            }
        }
        JSONObject appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(str);
        Context applicationContext = FacebookSdk.getApplicationContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        SharedPreferences.Editor edit = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit();
        if (!(appGateKeepersQueryResponse instanceof JSONObject)) {
            str2 = appGateKeepersQueryResponse.toString();
        } else {
            str2 = JSONObjectInstrumentation.toString(appGateKeepersQueryResponse);
        }
        edit.putString(format, str2).apply();
        return parseAppGateKeepersFromJSON$facebook_core_release(str, appGateKeepersQueryResponse);
    }

    @JvmStatic
    public static final void resetRuntimeGateKeeperCache() {
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 != null) {
            GateKeeperRuntimeCache.resetCache$default(gateKeeperRuntimeCache2, (String) null, 1, (Object) null);
        }
    }

    @JvmStatic
    public static final void setRuntimeGateKeeper(@NotNull String str, @NotNull GateKeeper gateKeeper) {
        GateKeeper gateKeeper2;
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(gateKeeper, "gateKeeper");
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 == null) {
            gateKeeper2 = null;
        } else {
            gateKeeper2 = gateKeeperRuntimeCache2.getGateKeeper(str, gateKeeper.getName());
        }
        if (gateKeeper2 != null) {
            GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
            if (gateKeeperRuntimeCache3 != null) {
                gateKeeperRuntimeCache3.setGateKeeper(str, gateKeeper);
                return;
            }
            return;
        }
        Log.w(TAG, "Missing gatekeeper runtime cache");
    }

    public static /* synthetic */ void setRuntimeGateKeeper$default(String str, GateKeeper gateKeeper, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        setRuntimeGateKeeper(str, gateKeeper);
    }

    @NotNull
    public final Map<String, Boolean> getGateKeepersForApplication(@Nullable String str) {
        List<GateKeeper> list;
        loadAppGateKeepersAsync();
        if (str != null) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(str)) {
                GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
                if (gateKeeperRuntimeCache2 == null) {
                    list = null;
                } else {
                    list = gateKeeperRuntimeCache2.dumpGateKeepers(str);
                }
                if (list != null) {
                    HashMap hashMap = new HashMap();
                    for (GateKeeper gateKeeper : list) {
                        hashMap.put(gateKeeper.getName(), Boolean.valueOf(gateKeeper.getValue()));
                    }
                    return hashMap;
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject = map.get(str);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    hashMap2.put(next, Boolean.valueOf(jSONObject.optBoolean(next)));
                }
                GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
                if (gateKeeperRuntimeCache3 == null) {
                    gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
                }
                ArrayList arrayList = new ArrayList(hashMap2.size());
                for (Map.Entry entry : hashMap2.entrySet()) {
                    arrayList.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                gateKeeperRuntimeCache3.setGateKeepers(str, arrayList);
                gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
                return hashMap2;
            }
        }
        return new HashMap();
    }

    public final void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync((Callback) null);
    }

    @JvmStatic
    public static final synchronized void loadAppGateKeepersAsync(@Nullable Callback callback) {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (callback != null) {
                try {
                    callbacks.add(callback);
                } catch (JSONException e11) {
                    Utility.logd(Utility.LOG_TAG, (Exception) e11);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            String applicationId = FacebookSdk.getApplicationId();
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
            if (!fetchedAppGateKeepersManager.isTimestampValid(timestamp) || !fetchedAppGateKeepers.containsKey(applicationId)) {
                Context applicationContext = FacebookSdk.getApplicationContext();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                if (applicationContext != null) {
                    JSONObject jSONObject = null;
                    String string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(format, (String) null);
                    if (!Utility.isNullOrEmpty(string)) {
                        jSONObject = new JSONObject(string);
                        if (jSONObject != null) {
                            parseAppGateKeepersFromJSON$facebook_core_release(applicationId, jSONObject);
                        }
                    }
                    Executor executor = FacebookSdk.getExecutor();
                    if (executor != null) {
                        if (isLoading.compareAndSet(false, true)) {
                            executor.execute(new e(applicationId, applicationContext, format));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            fetchedAppGateKeepersManager.pollCallbacks();
        }
    }
}
