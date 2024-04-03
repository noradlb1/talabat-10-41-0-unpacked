package fwfd.com.fwfsdk.manager;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.gson.JsonObject;
import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.manager.callback.FWFFeatureCallback;
import fwfd.com.fwfsdk.manager.callback.FWFFeaturesCallback;
import fwfd.com.fwfsdk.manager.callback.FWFFlagKeysCallback;
import fwfd.com.fwfsdk.model.api.FWFSubscribeResult;
import fwfd.com.fwfsdk.model.db.FWFFallback;
import fwfd.com.fwfsdk.model.db.FWFResult;
import fwfd.com.fwfsdk.tracker.FWFTrackManager;
import fwfd.com.fwfsdk.util.FWFSubscribeObserverCallback;
import fwfd.com.fwfsdk.util.FWFTrackingCallback;
import java.util.HashMap;
import java.util.Map;

public class FWFFeatureManager {
    /* access modifiers changed from: private */
    public static final FWFTrackManager trackManager = new FWFTrackManager();

    public static void cleanDBOnVersionUpdate() {
        FWFDataManager.getInstance().cleanDBOnVersionUpdate();
    }

    public static void eraseData() {
        FWFDataManager.getInstance().deleteAllFlags();
    }

    public static void getExperimentsToTrack(Context context, FWFTrackingCallback fWFTrackingCallback) {
        FWFDataManager.getInstance().getAllExperiments(context, fWFTrackingCallback);
    }

    public static void getFlagKeys(String str, FWFFlagKeysCallback fWFFlagKeysCallback) {
        FWFDataManager.getInstance().getFlagKeys(str, fWFFlagKeysCallback);
    }

    public static void getFlags(String str, Boolean bool, FWFFeaturesCallback fWFFeaturesCallback) {
        FWFDataManager.getInstance().getFlags(str, bool, fWFFeaturesCallback);
    }

    public static void getFlagsFromApiWithTracking(String str, Boolean bool, @Nullable final Map<String, String> map, final FWFFeaturesCallback fWFFeaturesCallback) {
        final JsonObject trackingContext = FunWithFlags.getInstance().getUser().getTrackingContext();
        FWFDataManager.getInstance().getFlags(str, bool, new FWFFeaturesCallback() {
            public void onFwfResponse(HashMap<String, FWFResult> hashMap) {
                FWFFeaturesCallback.this.onFwfResponse(hashMap);
                FWFFeatureManager.trackManager.trackEvents(trackingContext, hashMap, map);
            }
        });
    }

    public static void getFlagsToTrack(Context context, FWFTrackingCallback fWFTrackingCallback) {
        FWFDataManager.getInstance().getFlagsToTrack(context, fWFTrackingCallback);
    }

    public static void getVariationFromApi(String str, String str2, FWFFallback fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, FWFFeatureCallback fWFFeatureCallback) {
        FWFDataManager.getInstance().getVariationFromApi(str, str2, fWFFallback, fWFSubscribeCallbackExplanation, true, fWFFeatureCallback);
    }

    public static void getVariationFromApiWithTracking(final String str, String str2, FWFFallback fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, @Nullable final Map<String, String> map, final FWFFeatureCallback fWFFeatureCallback) {
        final JsonObject trackingContext = FunWithFlags.getInstance().getUser().getTrackingContext();
        FWFDataManager.getInstance().getVariationFromApi(str, str2, fWFFallback, fWFSubscribeCallbackExplanation, true, new FWFFeatureCallback() {
            public void onFwfResponse(FWFResult fWFResult) {
                FWFFeatureCallback.this.onFwfResponse(fWFResult);
                FWFFeatureManager.trackManager.trackEvent(trackingContext, str, fWFResult, map);
            }
        });
    }

    public static void getVariationFromDB(String str, String str2, FWFFallback fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, FWFFeatureCallback fWFFeatureCallback) {
        FWFDataManager.getInstance().getVariationFromDB(str, str2, fWFFallback, fWFSubscribeCallbackExplanation, fWFFeatureCallback);
    }

    public static void getVariationFromDBWithTracking(final String str, String str2, FWFFallback fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, @Nullable final Map<String, String> map, final FWFFeatureCallback fWFFeatureCallback) {
        final JsonObject trackingContext = FunWithFlags.getInstance().getUser().getTrackingContext();
        FWFDataManager.getInstance().getVariationFromDB(str, str2, fWFFallback, fWFSubscribeCallbackExplanation, new FWFFeatureCallback() {
            public void onFwfResponse(FWFResult fWFResult) {
                FWFFeatureCallback.this.onFwfResponse(fWFResult);
                FWFFeatureManager.trackManager.trackEvent(trackingContext, str, fWFResult, map);
            }
        });
    }

    public static void getVariationsFromApi(HashMap<String, FWFFallback> hashMap, String str, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, FWFFeaturesCallback fWFFeaturesCallback) {
        FWFDataManager.getInstance().getVariationsFromAPI(hashMap, str, fWFSubscribeCallbackExplanation, true, fWFFeaturesCallback);
    }

    public static void getVariationsFromApiWithTracking(HashMap<String, FWFFallback> hashMap, String str, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, @Nullable final Map<String, String> map, final FWFFeaturesCallback fWFFeaturesCallback) {
        final JsonObject trackingContext = FunWithFlags.getInstance().getUser().getTrackingContext();
        FWFDataManager.getInstance().getVariationsFromAPI(hashMap, str, fWFSubscribeCallbackExplanation, true, new FWFFeaturesCallback() {
            public void onFwfResponse(HashMap<String, FWFResult> hashMap) {
                FWFFeaturesCallback.this.onFwfResponse(hashMap);
                FWFFeatureManager.trackManager.trackEvents(trackingContext, hashMap, map);
            }
        });
    }

    public static void getVariationsFromDB(HashMap<String, FWFFallback> hashMap, String str, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, FWFFeaturesCallback fWFFeaturesCallback) {
        FWFDataManager.getInstance().getVariationsFromDB(hashMap, str, fWFSubscribeCallbackExplanation, fWFFeaturesCallback);
    }

    public static void getVariationsFromDBWithTracking(HashMap<String, FWFFallback> hashMap, String str, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, @Nullable final Map<String, String> map, final FWFFeaturesCallback fWFFeaturesCallback) {
        final JsonObject trackingContext = FunWithFlags.getInstance().getUser().getTrackingContext();
        FWFDataManager.getInstance().getVariationsFromDB(hashMap, str, fWFSubscribeCallbackExplanation, new FWFFeaturesCallback() {
            public void onFwfResponse(HashMap<String, FWFResult> hashMap) {
                FWFFeaturesCallback.this.onFwfResponse(hashMap);
                FWFFeatureManager.trackManager.trackEvents(trackingContext, hashMap, map);
            }
        });
    }

    public static void subscribeFeatures(String[] strArr, String str) {
        FWFDataManager.getInstance().subscribeFeatures(strArr, str);
    }

    public static void subscribeObserver(@Nullable String str, FWFSubscribeObserverCallback fWFSubscribeObserverCallback) {
        FWFDataManager.getInstance().addObserver(str, fWFSubscribeObserverCallback);
    }

    public static void subscribeFeatures(String[] strArr, String str, FWFFeaturesCallback fWFFeaturesCallback) {
        FWFDataManager.getInstance().subscribeFeatures(strArr, str, fWFFeaturesCallback);
    }
}
