package com.facebook.appevents.iap;

import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import datamodels.TypesAliasesKt;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Instrumented
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\rH\u0001¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aJC\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u00142\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0001¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0007J2\u0010 \u001a\u00020\u00192\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\r2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0007J\u001c\u0010!\u001a\u00020\u00192\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0014H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseLoggerManager;", "", "()V", "CACHE_CLEAR_TIME_LIMIT_SEC", "", "LAST_CLEARED_TIME", "", "LAST_QUERY_PURCHASE_HISTORY_TIME", "PRODUCT_DETAILS_STORE", "PURCHASE_DETAILS_SET", "PURCHASE_IN_CACHE_INTERVAL", "PURCHASE_TIME", "cachedPurchaseMap", "", "", "cachedPurchaseSet", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "cacheDeDupPurchase", "", "Lorg/json/JSONObject;", "purchaseDetailsMap", "cacheDeDupPurchase$facebook_core_release", "clearOutdatedProductInfoInCache", "", "clearOutdatedProductInfoInCache$facebook_core_release", "constructLoggingReadyMap", "skuDetailsMap", "constructLoggingReadyMap$facebook_core_release", "eligibleQueryPurchaseHistory", "", "filterPurchaseLogging", "logPurchases", "readPurchaseCache", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class InAppPurchaseLoggerManager {
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    @NotNull
    public static final InAppPurchaseLoggerManager INSTANCE = new InAppPurchaseLoggerManager();
    @NotNull
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    @NotNull
    private static final String LAST_QUERY_PURCHASE_HISTORY_TIME = "LAST_QUERY_PURCHASE_HISTORY_TIME";
    @NotNull
    private static final String PRODUCT_DETAILS_STORE = "com.facebook.internal.iap.PRODUCT_DETAILS";
    @NotNull
    private static final String PURCHASE_DETAILS_SET = "PURCHASE_DETAILS_SET";
    private static final int PURCHASE_IN_CACHE_INTERVAL = 86400;
    @NotNull
    private static final String PURCHASE_TIME = "purchaseTime";
    @NotNull
    private static final Map<String, Long> cachedPurchaseMap = new ConcurrentHashMap();
    @NotNull
    private static final Set<String> cachedPurchaseSet = new CopyOnWriteArraySet();
    private static SharedPreferences sharedPreferences;

    private InAppPurchaseLoggerManager() {
    }

    @JvmStatic
    public static final boolean eligibleQueryPurchaseHistory() {
        INSTANCE.readPurchaseCache();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            long j11 = sharedPreferences2.getLong(LAST_QUERY_PURCHASE_HISTORY_TIME, 0);
            if (j11 != 0 && currentTimeMillis - j11 < ((long) 86400)) {
                return false;
            }
            SharedPreferences sharedPreferences3 = sharedPreferences;
            if (sharedPreferences3 != null) {
                sharedPreferences3.edit().putLong(LAST_QUERY_PURCHASE_HISTORY_TIME, currentTimeMillis).apply();
                return true;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        throw null;
    }

    @JvmStatic
    public static final void filterPurchaseLogging(@NotNull Map<String, JSONObject> map, @NotNull Map<String, ? extends JSONObject> map2) {
        Intrinsics.checkNotNullParameter(map, "purchaseDetailsMap");
        Intrinsics.checkNotNullParameter(map2, "skuDetailsMap");
        InAppPurchaseLoggerManager inAppPurchaseLoggerManager = INSTANCE;
        inAppPurchaseLoggerManager.readPurchaseCache();
        inAppPurchaseLoggerManager.logPurchases(inAppPurchaseLoggerManager.constructLoggingReadyMap$facebook_core_release(inAppPurchaseLoggerManager.cacheDeDupPurchase$facebook_core_release(map), map2));
    }

    private final void logPurchases(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (!(str == null || str2 == null)) {
                AutomaticAnalyticsLogger.logPurchase(str, str2, false);
            }
        }
    }

    private final void readPurchaseCache() {
        SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
        SharedPreferences sharedPreferences3 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
        if (sharedPreferences2.contains(LAST_CLEARED_TIME)) {
            sharedPreferences2.edit().clear().apply();
            sharedPreferences3.edit().clear().apply();
        }
        SharedPreferences sharedPreferences4 = FacebookSdk.getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences4, "getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, Context.MODE_PRIVATE)");
        sharedPreferences = sharedPreferences4;
        Set<String> set = cachedPurchaseSet;
        if (sharedPreferences4 != null) {
            Collection stringSet = sharedPreferences4.getStringSet(PURCHASE_DETAILS_SET, new HashSet());
            if (stringSet == null) {
                stringSet = new HashSet();
            }
            set.addAll(stringSet);
            for (String split$default : set) {
                List split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default, new String[]{TypesAliasesKt.separator}, false, 2, 2, (Object) null);
                cachedPurchaseMap.put(split$default2.get(0), Long.valueOf(Long.parseLong((String) split$default2.get(1))));
            }
            clearOutdatedProductInfoInCache$facebook_core_release();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        throw null;
    }

    @NotNull
    @VisibleForTesting(otherwise = 2)
    public final Map<String, JSONObject> cacheDeDupPurchase$facebook_core_release(@NotNull Map<String, JSONObject> map) {
        Intrinsics.checkNotNullParameter(map, "purchaseDetailsMap");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        for (Map.Entry entry : MapsKt__MapsKt.toMap(map).entrySet()) {
            String str = (String) entry.getKey();
            JSONObject jSONObject = (JSONObject) entry.getValue();
            try {
                if (jSONObject.has("purchaseToken")) {
                    String string = jSONObject.getString("purchaseToken");
                    if (cachedPurchaseMap.containsKey(string)) {
                        map.remove(str);
                    } else {
                        Set<String> set = cachedPurchaseSet;
                        set.add(string + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER + currentTimeMillis);
                    }
                }
            } catch (Exception unused) {
            }
        }
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).apply();
            return new HashMap(map);
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        throw null;
    }

    @VisibleForTesting(otherwise = 2)
    public final void clearOutdatedProductInfoInCache$facebook_core_release() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            long j11 = sharedPreferences2.getLong(LAST_CLEARED_TIME, 0);
            if (j11 == 0) {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                if (sharedPreferences3 != null) {
                    sharedPreferences3.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            } else if (currentTimeMillis - j11 > 604800) {
                for (Map.Entry entry : MapsKt__MapsKt.toMap(cachedPurchaseMap).entrySet()) {
                    String str = (String) entry.getKey();
                    long longValue = ((Number) entry.getValue()).longValue();
                    if (currentTimeMillis - longValue > 86400) {
                        Set<String> set = cachedPurchaseSet;
                        set.remove(str + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER + longValue);
                        cachedPurchaseMap.remove(str);
                    }
                }
                SharedPreferences sharedPreferences4 = sharedPreferences;
                if (sharedPreferences4 != null) {
                    sharedPreferences4.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        }
    }

    @NotNull
    @VisibleForTesting(otherwise = 2)
    public final Map<String, String> constructLoggingReadyMap$facebook_core_release(@NotNull Map<String, ? extends JSONObject> map, @NotNull Map<String, ? extends JSONObject> map2) {
        Intrinsics.checkNotNullParameter(map, "purchaseDetailsMap");
        Intrinsics.checkNotNullParameter(map2, "skuDetailsMap");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            JSONObject jSONObject = (JSONObject) next.getValue();
            JSONObject jSONObject2 = (JSONObject) map2.get((String) next.getKey());
            if (jSONObject != null && jSONObject.has(PURCHASE_TIME)) {
                try {
                    if (currentTimeMillis - (jSONObject.getLong(PURCHASE_TIME) / 1000) <= 86400) {
                        if (jSONObject2 != null) {
                            String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
                            Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "purchaseDetail.toString()");
                            String jSONObjectInstrumentation2 = JSONObjectInstrumentation.toString(jSONObject2);
                            Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation2, "skuDetail.toString()");
                            linkedHashMap.put(jSONObjectInstrumentation, jSONObjectInstrumentation2);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return linkedHashMap;
    }
}
