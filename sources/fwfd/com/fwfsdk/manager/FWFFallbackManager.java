package fwfd.com.fwfsdk.manager;

import android.content.Context;
import fwfd.com.fwfsdk.constant.FWFConstants;
import fwfd.com.fwfsdk.manager.callback.FWFFeatureCallback;
import fwfd.com.fwfsdk.manager.callback.FWFFeaturesCallback;
import fwfd.com.fwfsdk.model.dao.FWFDBRepository;
import fwfd.com.fwfsdk.model.db.FWFFallback;
import fwfd.com.fwfsdk.model.db.FWFFeature;
import fwfd.com.fwfsdk.model.db.FWFResult;
import fwfd.com.fwfsdk.util.FWFDBCallback;
import fwfd.com.fwfsdk.util.FWFResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FWFFallbackManager {
    public static void createFWFResultFallback(Context context, String str, String str2, final FWFFallback fWFFallback, final String str3, final FWFFeatureCallback fWFFeatureCallback) {
        if (str == null || str2 == null || context == null || fWFFallback == null) {
            fWFFeatureCallback.onFwfResponse(getValueFallback(fWFFallback, str3));
        } else {
            getFlagById(context, str, str2, new FWFDBCallback<FWFFeature>() {
                public void onResponse(FWFFeature fWFFeature) {
                    FWFFeatureCallback.this.onFwfResponse(FWFFallbackManager.evaluateFallback(fWFFeature, fWFFallback, str3));
                }
            });
        }
    }

    public static void createFWFResultsFallback(Context context, final HashMap<String, FWFFallback> hashMap, String str, final String str2, final FWFFeaturesCallback fWFFeaturesCallback) {
        getFlagsById(context, new ArrayList(hashMap.keySet()), str, new FWFDBCallback<List<FWFFeature>>() {
            public void onResponse(List<FWFFeature> list) {
                HashMap hashMap = new HashMap();
                if (list == null || list.isEmpty()) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        hashMap.put((String) entry.getKey(), FWFFallbackManager.getValueFallback((FWFFallback) entry.getValue(), str2));
                    }
                } else {
                    for (FWFFeature next : list) {
                        FWFFallback fWFFallback = (FWFFallback) hashMap.get(next.getKey());
                        if (fWFFallback != null) {
                            hashMap.put(next.getKey(), FWFFallbackManager.evaluateFallback(next, fWFFallback, str2));
                        }
                    }
                }
                fWFFeaturesCallback.onFwfResponse(hashMap);
            }
        });
    }

    /* access modifiers changed from: private */
    public static FWFResult evaluateFallback(FWFFeature fWFFeature, FWFFallback fWFFallback, String str) {
        if (fWFFallback == null) {
            return getValueFallback(new FWFFallback("No fallback", FWFFallback.FallbackTypes.FROM_VALUE), "");
        }
        if (fWFFallback.getType() == FWFFallback.FallbackTypes.FROM_DB) {
            return getDBFallback(fWFFeature, fWFFallback, str);
        }
        return getValueFallback(fWFFallback, str);
    }

    private static FWFResult getDBFallback(FWFFeature fWFFeature, FWFFallback fWFFallback, String str) {
        if (fWFFeature == null || fWFFeature.getVariation() == null) {
            return getValueFallback(fWFFallback, str + ". No variation found on DB");
        }
        Object variation = fWFFeature.getVariation();
        return new FWFResult(variation, str + ". Retrieving last variation found from DB.", FWFConstants.EXPLANATION_KIND_DB_FALLBACK, fWFFeature.getTrackInfo());
    }

    private static void getFlagById(Context context, String str, String str2, final FWFDBCallback<FWFFeature> fWFDBCallback) {
        new FWFDBRepository(context).getFlagById(str, str2, new FWFResultCallback<FWFFeature>() {
            public void onError(String str) {
                FWFDBCallback.this.onResponse(null);
            }

            public void onResponse(FWFFeature fWFFeature) {
                FWFDBCallback.this.onResponse(fWFFeature);
            }
        });
    }

    private static void getFlagsById(Context context, List<String> list, String str, final FWFDBCallback<List<FWFFeature>> fWFDBCallback) {
        new FWFDBRepository(context).getFlagsById(list, str, new FWFResultCallback<List<FWFFeature>>() {
            public void onError(String str) {
                FWFDBCallback.this.onResponse(null);
            }

            public void onResponse(List<FWFFeature> list) {
                FWFDBCallback.this.onResponse(list);
            }
        });
    }

    /* access modifiers changed from: private */
    public static FWFResult getValueFallback(FWFFallback fWFFallback, String str) {
        if (fWFFallback != null) {
            Object value = fWFFallback.getValue();
            return new FWFResult(value, str + ". Retrieving fallback from value.", FWFConstants.EXPLANATION_KIND_VALUE_FALLBACK);
        }
        return new FWFResult((Object) null, str + ". Retrieving fallback from value.", FWFConstants.EXPLANATION_KIND_NULL_FALLBACK);
    }
}
