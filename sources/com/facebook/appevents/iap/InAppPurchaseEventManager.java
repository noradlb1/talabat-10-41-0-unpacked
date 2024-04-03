package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import datamodels.TypesAliasesKt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\b\u0010+\u001a\u00020,H\u0007J0\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001e\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u0004H\u0002J\u001e\u00103\u001a\u0004\u0018\u00010\"2\n\u00104\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u00105\u001a\u00020\u0004H\u0002J0\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J2\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007JF\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0007JF\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0002J\u000e\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0004JA\u0010E\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00012\u000e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010HH\u0002¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u00020A2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J,\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040L2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001c\u0010M\u001a\u00020,2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R2\u0010\u001d\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001ej\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f` X\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0\u001ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"` X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseEventManager;", "", "()V", "AS_INTERFACE", "", "CACHE_CLEAR_TIME_LIMIT_SEC", "", "DETAILS_LIST", "GET_PURCHASES", "GET_PURCHASE_HISTORY", "GET_SKU_DETAILS", "INAPP", "INAPP_CONTINUATION_TOKEN", "INAPP_PURCHASE_DATA_LIST", "IN_APP_BILLING_SERVICE", "IN_APP_BILLING_SERVICE_STUB", "IS_BILLING_SUPPORTED", "ITEM_ID_LIST", "LAST_CLEARED_TIME", "MAX_QUERY_PURCHASE_NUM", "PACKAGE_NAME", "kotlin.jvm.PlatformType", "PURCHASE_EXPIRE_TIME_SEC", "PURCHASE_INAPP_STORE", "PURCHASE_STOP_QUERY_TIME_SEC", "RESPONSE_CODE", "SKU_DETAILS_STORE", "SKU_DETAIL_EXPIRE_TIME_SEC", "SUBSCRIPTION", "classMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "methodMap", "Ljava/lang/reflect/Method;", "purchaseInappSharedPrefs", "Landroid/content/SharedPreferences;", "skuDetailSharedPrefs", "asInterface", "context", "Landroid/content/Context;", "service", "Landroid/os/IBinder;", "clearSkuDetailsCache", "", "filterPurchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchases", "getClass", "className", "getMethod", "classObj", "methodName", "getPurchaseHistory", "inAppBillingObj", "type", "getPurchaseHistoryInapp", "getPurchases", "getPurchasesInapp", "getPurchasesSubs", "getSkuDetails", "", "skuList", "isSubscription", "", "getSkuDetailsFromGoogle", "hasFreeTrialPeirod", "skuDetail", "invokeMethod", "obj", "args", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "isBillingSupported", "readSkuDetailsFromCache", "", "writeSkuDetailsToCache", "skuDetailsMap", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class InAppPurchaseEventManager {
    @NotNull
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    @NotNull
    private static final String DETAILS_LIST = "DETAILS_LIST";
    @NotNull
    private static final String GET_PURCHASES = "getPurchases";
    @NotNull
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    @NotNull
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    @NotNull
    private static final String INAPP = "inapp";
    @NotNull
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    @NotNull
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    @NotNull
    public static final InAppPurchaseEventManager INSTANCE = new InAppPurchaseEventManager();
    @NotNull
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    @NotNull
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    @NotNull
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    @NotNull
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    @NotNull
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    @NotNull
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    @NotNull
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    @NotNull
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    @NotNull
    private static final String SUBSCRIPTION = "subs";
    @NotNull
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    @NotNull
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);

    private InAppPurchaseEventManager() {
    }

    @JvmStatic
    @Nullable
    public static final Object asInterface(@NotNull Context context, @Nullable IBinder iBinder) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, (Object) null, new Object[]{iBinder});
    }

    @JvmStatic
    public static final void clearSkuDetailsCache() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = skuDetailSharedPrefs;
        long j11 = sharedPreferences.getLong(LAST_CLEARED_TIME, 0);
        if (j11 == 0) {
            sharedPreferences.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        } else if (currentTimeMillis - j11 > ((long) CACHE_CLEAR_TIME_LIMIT_SEC)) {
            sharedPreferences.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        }
    }

    private final ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                JSONObject jSONObject = new JSONObject(next);
                String string = jSONObject.getString("productId");
                long j11 = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j11 / 1000) <= 86400) {
                    if (!Intrinsics.areEqual((Object) purchaseInappSharedPrefs.getString(string, ""), (Object) string2)) {
                        edit.putString(string, string2);
                        arrayList2.add(next);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        edit.apply();
        return arrayList2;
    }

    private final Class<?> getClass(Context context, String str) {
        HashMap<String, Class<?>> hashMap = classMap;
        Class<?> cls = hashMap.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> classFromContext$facebook_core_release = InAppPurchaseUtils.getClassFromContext$facebook_core_release(context, str);
        if (classFromContext$facebook_core_release != null) {
            hashMap.put(str, classFromContext$facebook_core_release);
        }
        return classFromContext$facebook_core_release;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method getMethod(java.lang.Class<?> r13, java.lang.String r14) {
        /*
            r12 = this;
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r0 = methodMap
            java.lang.Object r1 = r0.get(r14)
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
            if (r1 == 0) goto L_0x000b
            return r1
        L_0x000b:
            int r1 = r14.hashCode()
            java.lang.Class<android.os.Bundle> r2 = android.os.Bundle.class
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            java.lang.String r7 = "TYPE"
            r8 = 0
            r9 = 1
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            switch(r1) {
                case -1801122596: goto L_0x007d;
                case -1450694211: goto L_0x0066;
                case -1123215065: goto L_0x0056;
                case -594356707: goto L_0x003a;
                case -573310373: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0096
        L_0x0020:
            java.lang.String r1 = "getSkuDetails"
            boolean r1 = r14.equals(r1)
            if (r1 != 0) goto L_0x002a
            goto L_0x0096
        L_0x002a:
            java.lang.Class[] r1 = new java.lang.Class[r4]
            java.lang.Class r4 = java.lang.Integer.TYPE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            r1[r8] = r4
            r1[r9] = r10
            r1[r6] = r10
            r1[r5] = r2
            goto L_0x0097
        L_0x003a:
            java.lang.String r1 = "getPurchaseHistory"
            boolean r1 = r14.equals(r1)
            if (r1 != 0) goto L_0x0043
            goto L_0x0096
        L_0x0043:
            r1 = 5
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class r11 = java.lang.Integer.TYPE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r7)
            r1[r8] = r11
            r1[r9] = r10
            r1[r6] = r10
            r1[r5] = r10
            r1[r4] = r2
            goto L_0x0097
        L_0x0056:
            java.lang.String r1 = "asInterface"
            boolean r1 = r14.equals(r1)
            if (r1 != 0) goto L_0x005f
            goto L_0x0096
        L_0x005f:
            java.lang.Class[] r1 = new java.lang.Class[r9]
            java.lang.Class<android.os.IBinder> r2 = android.os.IBinder.class
            r1[r8] = r2
            goto L_0x0097
        L_0x0066:
            java.lang.String r1 = "isBillingSupported"
            boolean r1 = r14.equals(r1)
            if (r1 != 0) goto L_0x006f
            goto L_0x0096
        L_0x006f:
            java.lang.Class[] r1 = new java.lang.Class[r5]
            java.lang.Class r2 = java.lang.Integer.TYPE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            r1[r8] = r2
            r1[r9] = r10
            r1[r6] = r10
            goto L_0x0097
        L_0x007d:
            java.lang.String r1 = "getPurchases"
            boolean r1 = r14.equals(r1)
            if (r1 != 0) goto L_0x0086
            goto L_0x0096
        L_0x0086:
            java.lang.Class[] r1 = new java.lang.Class[r4]
            java.lang.Class r2 = java.lang.Integer.TYPE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            r1[r8] = r2
            r1[r9] = r10
            r1[r6] = r10
            r1[r5] = r10
            goto L_0x0097
        L_0x0096:
            r1 = r3
        L_0x0097:
            if (r1 != 0) goto L_0x00a2
            java.lang.Class[] r1 = new java.lang.Class[r9]
            r1[r8] = r3
            java.lang.reflect.Method r13 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r13, r14, r1)
            goto L_0x00af
        L_0x00a2:
            com.facebook.appevents.iap.InAppPurchaseUtils r2 = com.facebook.appevents.iap.InAppPurchaseUtils.INSTANCE
            int r2 = r1.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r2)
            java.lang.Class[] r1 = (java.lang.Class[]) r1
            java.lang.reflect.Method r13 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r13, r14, r1)
        L_0x00af:
            if (r13 == 0) goto L_0x00b4
            r0.put(r14, r13)
        L_0x00b4:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getMethod(java.lang.Class, java.lang.String):java.lang.reflect.Method");
    }

    private final ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (isBillingSupported(context, obj, str)) {
            String str2 = null;
            int i11 = 0;
            boolean z11 = false;
            do {
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, new Object[]{6, PACKAGE_NAME, str, str2, new Bundle()});
                if (invokeMethod != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0 && (stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST)) != null) {
                        Iterator<String> it = stringArrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            try {
                                if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                    z11 = true;
                                    break;
                                }
                                arrayList.add(next);
                                i11++;
                            } catch (JSONException unused) {
                            }
                        }
                        str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        if (i11 >= 30 || str2 == null) {
                            break;
                        }
                    }
                }
                str2 = null;
            } while (!z11);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
        r1 = INSTANCE;
     */
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.ArrayList<java.lang.String> getPurchaseHistoryInapp(@org.jetbrains.annotations.NotNull android.content.Context r4, @org.jetbrains.annotations.Nullable java.lang.Object r5) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r5 != 0) goto L_0x000d
            return r0
        L_0x000d:
            com.facebook.appevents.iap.InAppPurchaseEventManager r1 = INSTANCE
            java.lang.String r2 = "com.android.vending.billing.IInAppBillingService"
            java.lang.Class r2 = r1.getClass(r4, r2)
            if (r2 != 0) goto L_0x0018
            return r0
        L_0x0018:
            java.lang.String r3 = "getPurchaseHistory"
            java.lang.reflect.Method r2 = r1.getMethod(r2, r3)
            if (r2 != 0) goto L_0x0021
            return r0
        L_0x0021:
            java.lang.String r0 = "inapp"
            java.util.ArrayList r4 = r1.getPurchaseHistory(r4, r5, r0)
            java.util.ArrayList r4 = r1.filterPurchases(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchaseHistoryInapp(android.content.Context, java.lang.Object):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b A[EDGE_INSN: B:19:0x005b->B:17:0x005b ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r13, java.lang.Object r14, java.lang.String r15) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r14 != 0) goto L_0x0008
            return r0
        L_0x0008:
            boolean r1 = r12.isBillingSupported(r13, r14, r15)
            if (r1 == 0) goto L_0x005b
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
        L_0x0012:
            r5 = 4
            java.lang.Object[] r11 = new java.lang.Object[r5]
            r5 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r11[r1] = r6
            r6 = 1
            java.lang.String r7 = PACKAGE_NAME
            r11[r6] = r7
            r6 = 2
            r11[r6] = r15
            r11[r5] = r3
            java.lang.String r8 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r9 = "getPurchases"
            r6 = r12
            r7 = r13
            r10 = r14
            java.lang.Object r3 = r6.invokeMethod(r7, r8, r9, r10, r11)
            if (r3 == 0) goto L_0x0054
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)
            if (r5 != 0) goto L_0x0054
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)
            if (r5 == 0) goto L_0x005b
            int r6 = r5.size()
            int r4 = r4 + r6
            r0.addAll(r5)
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)
            goto L_0x0055
        L_0x0054:
            r3 = r2
        L_0x0055:
            r5 = 30
            if (r4 >= r5) goto L_0x005b
            if (r3 != 0) goto L_0x0012
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String> getPurchasesInapp(@NotNull Context context, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(context, "context");
        InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
        return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, obj, INAPP));
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String> getPurchasesSubs(@NotNull Context context, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(context, "context");
        InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
        return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, obj, SUBSCRIPTION));
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> getSkuDetails(@NotNull Context context, @NotNull ArrayList<String> arrayList, @Nullable Object obj, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arrayList, "skuList");
        Map<String, String> readSkuDetailsFromCache = INSTANCE.readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!readSkuDetailsFromCache.containsKey(next)) {
                arrayList2.add(next);
            }
        }
        readSkuDetailsFromCache.putAll(INSTANCE.getSkuDetailsFromGoogle(context, arrayList2, obj, z11));
        return readSkuDetailsFromCache;
    }

    private final Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z11) {
        String str;
        int size;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (obj != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
            Object[] objArr = new Object[4];
            int i11 = 0;
            objArr[0] = 3;
            objArr[1] = PACKAGE_NAME;
            if (z11) {
                str = SUBSCRIPTION;
            } else {
                str = INAPP;
            }
            objArr[2] = str;
            objArr[3] = bundle;
            Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
            if (invokeMethod != null) {
                Bundle bundle2 = (Bundle) invokeMethod;
                if (bundle2.getInt(RESPONSE_CODE) == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                    if (stringArrayList != null && arrayList.size() == stringArrayList.size() && arrayList.size() - 1 >= 0) {
                        while (true) {
                            int i12 = i11 + 1;
                            String str2 = arrayList.get(i11);
                            Intrinsics.checkNotNullExpressionValue(str2, "skuList[i]");
                            String str3 = stringArrayList.get(i11);
                            Intrinsics.checkNotNullExpressionValue(str3, "skuDetailsList[i]");
                            linkedHashMap.put(str2, str3);
                            if (i12 > size) {
                                break;
                            }
                            i11 = i12;
                        }
                    }
                    writeSkuDetailsToCache(linkedHashMap);
                }
            }
        }
        return linkedHashMap;
    }

    private final Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        Class<?> cls = getClass(context, str);
        if (cls == null || (method = getMethod(cls, str2)) == null) {
            return null;
        }
        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
        return InAppPurchaseUtils.invokeMethod(cls, method, obj, Arrays.copyOf(objArr, objArr.length));
    }

    private final boolean isBillingSupported(Context context, Object obj, String str) {
        Object invokeMethod;
        if (obj == null || (invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str})) == null || ((Integer) invokeMethod).intValue() != 0) {
            return false;
        }
        return true;
    }

    private final Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String string = skuDetailSharedPrefs.getString(next, (String) null);
            if (string != null) {
                List split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{TypesAliasesKt.separator}, false, 2, 2, (Object) null);
                if (currentTimeMillis - Long.parseLong((String) split$default.get(0)) < 43200) {
                    Intrinsics.checkNotNullExpressionValue(next, "sku");
                    linkedHashMap.put(next, split$default.get(1));
                }
            }
        }
        return linkedHashMap;
    }

    private final void writeSkuDetailsToCache(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
        for (Map.Entry next : map.entrySet()) {
            edit.putString((String) next.getKey(), currentTimeMillis + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER + ((String) next.getValue()));
        }
        edit.apply();
    }

    public final boolean hasFreeTrialPeirod(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "skuDetail");
        try {
            String optString = new JSONObject(str).optString("freeTrialPeriod");
            if (optString == null) {
                return false;
            }
            if (optString.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return true;
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }
}
