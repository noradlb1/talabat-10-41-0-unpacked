package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u001c\u0010\u000f\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/integrity/IntegrityManager;", "", "()V", "INTEGRITY_TYPE_ADDRESS", "", "INTEGRITY_TYPE_HEALTH", "INTEGRITY_TYPE_NONE", "RESTRICTIVE_ON_DEVICE_PARAMS_KEY", "enabled", "", "isSampleEnabled", "enable", "", "getIntegrityPredictionResult", "textFeature", "processParameters", "parameters", "", "shouldFilter", "input", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class IntegrityManager {
    @NotNull
    public static final IntegrityManager INSTANCE = new IntegrityManager();
    @NotNull
    public static final String INTEGRITY_TYPE_ADDRESS = "address";
    @NotNull
    public static final String INTEGRITY_TYPE_HEALTH = "health";
    @NotNull
    public static final String INTEGRITY_TYPE_NONE = "none";
    @NotNull
    private static final String RESTRICTIVE_ON_DEVICE_PARAMS_KEY = "_onDeviceParams";
    private static boolean enabled;
    private static boolean isSampleEnabled;

    private IntegrityManager() {
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
    }

    private final String getIntegrityPredictionResult(String str) {
        String str2;
        float[] fArr = new float[30];
        for (int i11 = 0; i11 < 30; i11++) {
            fArr[i11] = 0.0f;
        }
        ModelManager modelManager = ModelManager.INSTANCE;
        String[] predict = ModelManager.predict(ModelManager.Task.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
        if (predict == null || (str2 = predict[0]) == null) {
            return "none";
        }
        return str2;
    }

    @JvmStatic
    public static final void processParameters(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "parameters");
        if (enabled && !map.isEmpty()) {
            try {
                List<String> list = CollectionsKt___CollectionsKt.toList(map.keySet());
                JSONObject jSONObject = new JSONObject();
                for (String str : list) {
                    String str2 = map.get(str);
                    if (str2 != null) {
                        String str3 = str2;
                        IntegrityManager integrityManager = INSTANCE;
                        if (integrityManager.shouldFilter(str) || integrityManager.shouldFilter(str3)) {
                            map.remove(str);
                            if (!isSampleEnabled) {
                                str3 = "";
                            }
                            jSONObject.put(str, (Object) str3);
                        }
                    } else {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                }
                if (jSONObject.length() != 0) {
                    String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
                    Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "restrictiveParamJson.toString()");
                    map.put(RESTRICTIVE_ON_DEVICE_PARAMS_KEY, jSONObjectInstrumentation);
                }
            } catch (Exception unused) {
            }
        }
    }

    private final boolean shouldFilter(String str) {
        return !Intrinsics.areEqual((Object) "none", (Object) getIntegrityPredictionResult(str));
    }
}
