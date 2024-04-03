package com.facebook.appevents.iap;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import p6.e;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u0000 )2\u00020\u0001:\u0005()*+,B«\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001fJ\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001fH\u0002J(\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0&2\u0006\u0010#\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "", "context", "Landroid/content/Context;", "billingClient", "billingClientClazz", "Ljava/lang/Class;", "purchaseResultClazz", "purchaseClazz", "skuDetailsClazz", "purchaseHistoryRecordClazz", "skuDetailsResponseListenerClazz", "purchaseHistoryResponseListenerClazz", "queryPurchasesMethod", "Ljava/lang/reflect/Method;", "getPurchaseListMethod", "getOriginalJsonMethod", "getOriginalJsonSkuMethod", "getOriginalJsonPurchaseHistoryMethod", "querySkuDetailsAsyncMethod", "queryPurchaseHistoryAsyncMethod", "inAppPurchaseSkuDetailsWrapper", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "(Landroid/content/Context;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;)V", "historyPurchaseSet", "", "", "queryPurchase", "", "skuType", "querySkuRunnable", "Ljava/lang/Runnable;", "queryPurchaseHistory", "queryPurchaseHistoryRunnable", "queryPurchaseHistoryAsync", "runnable", "querySkuDetailsAsync", "skuIDs", "", "startConnection", "BillingClientStateListenerWrapper", "Companion", "PurchaseHistoryResponseListenerWrapper", "PurchasesUpdatedListenerWrapper", "SkuDetailsResponseListenerWrapper", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class InAppPurchaseBillingClientWrapper {
    @NotNull
    private static final String CLASSNAME_BILLING_CLIENT = "com.android.billingclient.api.BillingClient";
    @NotNull
    private static final String CLASSNAME_BILLING_CLIENT_BUILDER = "com.android.billingclient.api.BillingClient$Builder";
    @NotNull
    private static final String CLASSNAME_BILLING_CLIENT_STATE_LISTENER = "com.android.billingclient.api.BillingClientStateListener";
    @NotNull
    private static final String CLASSNAME_PURCHASE = "com.android.billingclient.api.Purchase";
    @NotNull
    private static final String CLASSNAME_PURCHASES_RESULT = "com.android.billingclient.api.Purchase$PurchasesResult";
    @NotNull
    private static final String CLASSNAME_PURCHASE_HISTORY_RECORD = "com.android.billingclient.api.PurchaseHistoryRecord";
    @NotNull
    private static final String CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER = "com.android.billingclient.api.PurchaseHistoryResponseListener";
    @NotNull
    private static final String CLASSNAME_PURCHASE_UPDATED_LISTENER = "com.android.billingclient.api.PurchasesUpdatedListener";
    @NotNull
    private static final String CLASSNAME_SKU_DETAILS = "com.android.billingclient.api.SkuDetails";
    @NotNull
    private static final String CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER = "com.android.billingclient.api.SkuDetailsResponseListener";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String IN_APP = "inapp";
    @NotNull
    private static final String METHOD_BUILD = "build";
    @NotNull
    private static final String METHOD_ENABLE_PENDING_PURCHASES = "enablePendingPurchases";
    @NotNull
    private static final String METHOD_GET_ORIGINAL_JSON = "getOriginalJson";
    @NotNull
    private static final String METHOD_GET_PURCHASE_LIST = "getPurchasesList";
    @NotNull
    private static final String METHOD_NEW_BUILDER = "newBuilder";
    @NotNull
    private static final String METHOD_ON_BILLING_SERVICE_DISCONNECTED = "onBillingServiceDisconnected";
    @NotNull
    private static final String METHOD_ON_BILLING_SETUP_FINISHED = "onBillingSetupFinished";
    @NotNull
    private static final String METHOD_ON_PURCHASE_HISTORY_RESPONSE = "onPurchaseHistoryResponse";
    @NotNull
    private static final String METHOD_ON_SKU_DETAILS_RESPONSE = "onSkuDetailsResponse";
    @NotNull
    private static final String METHOD_QUERY_PURCHASES = "queryPurchases";
    @NotNull
    private static final String METHOD_QUERY_PURCHASE_HISTORY_ASYNC = "queryPurchaseHistoryAsync";
    @NotNull
    private static final String METHOD_QUERY_SKU_DETAILS_ASYNC = "querySkuDetailsAsync";
    @NotNull
    private static final String METHOD_SET_LISTENER = "setListener";
    @NotNull
    private static final String METHOD_START_CONNECTION = "startConnection";
    @NotNull
    private static final String PACKAGE_NAME = "packageName";
    @NotNull
    private static final String PRODUCT_ID = "productId";
    /* access modifiers changed from: private */
    @NotNull
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    @Nullable
    public static InAppPurchaseBillingClientWrapper instance;
    /* access modifiers changed from: private */
    @NotNull
    public static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<String, JSONObject> purchaseDetailsMap = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<String, JSONObject> skuDetailsMap = new ConcurrentHashMap();
    @NotNull
    private final Object billingClient;
    @NotNull
    private final Class<?> billingClientClazz;
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;
    @NotNull
    private final Method getOriginalJsonMethod;
    /* access modifiers changed from: private */
    @NotNull
    public final Method getOriginalJsonPurchaseHistoryMethod;
    /* access modifiers changed from: private */
    @NotNull
    public final Method getOriginalJsonSkuMethod;
    @NotNull
    private final Method getPurchaseListMethod;
    /* access modifiers changed from: private */
    @NotNull
    public final Set<String> historyPurchaseSet;
    @NotNull
    private final InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;
    @NotNull
    private final Class<?> purchaseClazz;
    /* access modifiers changed from: private */
    @NotNull
    public final Class<?> purchaseHistoryRecordClazz;
    @NotNull
    private final Class<?> purchaseHistoryResponseListenerClazz;
    @NotNull
    private final Class<?> purchaseResultClazz;
    @NotNull
    private final Method queryPurchaseHistoryAsyncMethod;
    @NotNull
    private final Method queryPurchasesMethod;
    @NotNull
    private final Method querySkuDetailsAsyncMethod;
    /* access modifiers changed from: private */
    @NotNull
    public final Class<?> skuDetailsClazz;
    @NotNull
    private final Class<?> skuDetailsResponseListenerClazz;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$BillingClientStateListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "()V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @AutoHandleExceptions
    public static final class BillingClientStateListenerWrapper implements InvocationHandler {
        @Nullable
        public Object invoke(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) {
            Intrinsics.checkNotNullParameter(obj, "proxy");
            Intrinsics.checkNotNullParameter(method, "m");
            if (Intrinsics.areEqual((Object) method.getName(), (Object) InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SETUP_FINISHED)) {
                InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(true);
            } else {
                String name2 = method.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "m.name");
                if (StringsKt__StringsJVMKt.endsWith$default(name2, InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SERVICE_DISCONNECTED, false, 2, (Object) null)) {
                    InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(false);
                }
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010,\u001a\u0004\u0018\u00010\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\n\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0002J\u0010\u00101\u001a\u0002022\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020.H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001d\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)¨\u00064"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$Companion;", "", "()V", "CLASSNAME_BILLING_CLIENT", "", "CLASSNAME_BILLING_CLIENT_BUILDER", "CLASSNAME_BILLING_CLIENT_STATE_LISTENER", "CLASSNAME_PURCHASE", "CLASSNAME_PURCHASES_RESULT", "CLASSNAME_PURCHASE_HISTORY_RECORD", "CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER", "CLASSNAME_PURCHASE_UPDATED_LISTENER", "CLASSNAME_SKU_DETAILS", "CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER", "IN_APP", "METHOD_BUILD", "METHOD_ENABLE_PENDING_PURCHASES", "METHOD_GET_ORIGINAL_JSON", "METHOD_GET_PURCHASE_LIST", "METHOD_NEW_BUILDER", "METHOD_ON_BILLING_SERVICE_DISCONNECTED", "METHOD_ON_BILLING_SETUP_FINISHED", "METHOD_ON_PURCHASE_HISTORY_RESPONSE", "METHOD_ON_SKU_DETAILS_RESPONSE", "METHOD_QUERY_PURCHASES", "METHOD_QUERY_PURCHASE_HISTORY_ASYNC", "METHOD_QUERY_SKU_DETAILS_ASYNC", "METHOD_SET_LISTENER", "METHOD_START_CONNECTION", "PACKAGE_NAME", "PRODUCT_ID", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "isServiceConnected", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "purchaseDetailsMap", "", "Lorg/json/JSONObject;", "getPurchaseDetailsMap", "()Ljava/util/Map;", "skuDetailsMap", "getSkuDetailsMap", "createBillingClient", "context", "Landroid/content/Context;", "billingClientClazz", "Ljava/lang/Class;", "createInstance", "", "getOrCreateInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object createBillingClient(Context context, Class<?> cls) {
            Object invokeMethod;
            Object invokeMethod2;
            Object invokeMethod3;
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT_BUILDER);
            Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_UPDATED_LISTENER);
            if (cls2 == null || cls3 == null) {
                return null;
            }
            Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseBillingClientWrapper.METHOD_NEW_BUILDER, Context.class);
            Method method2 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_ENABLE_PENDING_PURCHASES, new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_SET_LISTENER, cls3);
            Method method4 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_BUILD, new Class[0]);
            if (method == null || method2 == null || method3 == null || method4 == null || (invokeMethod = InAppPurchaseUtils.invokeMethod(cls, method, (Object) null, context)) == null || (invokeMethod2 = InAppPurchaseUtils.invokeMethod(cls2, method3, invokeMethod, Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new PurchasesUpdatedListenerWrapper()))) == null || (invokeMethod3 = InAppPurchaseUtils.invokeMethod(cls2, method2, invokeMethod2, new Object[0])) == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(cls2, method4, invokeMethod3, new Object[0]);
        }

        private final void createInstance(Context context) {
            Object createBillingClient;
            InAppPurchaseSkuDetailsWrapper orCreateInstance = InAppPurchaseSkuDetailsWrapper.Companion.getOrCreateInstance();
            if (orCreateInstance != null) {
                Class<?> cls = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT);
                Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE);
                Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASES_RESULT);
                Class<?> cls4 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS);
                Class<?> cls5 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_HISTORY_RECORD);
                Class<?> cls6 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER);
                Class<?> cls7 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER);
                if (cls != null && cls3 != null && cls2 != null && cls4 != null && cls6 != null && cls5 != null && cls7 != null) {
                    Class<String> cls8 = String.class;
                    Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseBillingClientWrapper.METHOD_QUERY_PURCHASES, cls8);
                    Method method2 = InAppPurchaseUtils.getMethod(cls3, InAppPurchaseBillingClientWrapper.METHOD_GET_PURCHASE_LIST, new Class[0]);
                    Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_GET_ORIGINAL_JSON, new Class[0]);
                    Method method4 = InAppPurchaseUtils.getMethod(cls4, InAppPurchaseBillingClientWrapper.METHOD_GET_ORIGINAL_JSON, new Class[0]);
                    Method method5 = InAppPurchaseUtils.getMethod(cls5, InAppPurchaseBillingClientWrapper.METHOD_GET_ORIGINAL_JSON, new Class[0]);
                    Method method6 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseBillingClientWrapper.METHOD_QUERY_SKU_DETAILS_ASYNC, orCreateInstance.getSkuDetailsParamsClazz(), cls6);
                    Method method7 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseBillingClientWrapper.METHOD_QUERY_PURCHASE_HISTORY_ASYNC, cls8, cls7);
                    if (method != null && method2 != null && method3 != null && method4 != null && method5 != null && method6 != null && method7 != null && (createBillingClient = createBillingClient(context, cls)) != null) {
                        InAppPurchaseBillingClientWrapper.instance = new InAppPurchaseBillingClientWrapper(context, createBillingClient, cls, cls3, cls2, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, orCreateInstance, (DefaultConstructorMarker) null);
                        InAppPurchaseBillingClientWrapper access$getInstance$cp = InAppPurchaseBillingClientWrapper.instance;
                        if (access$getInstance$cp != null) {
                            access$getInstance$cp.startConnection();
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper");
                    }
                }
            }
        }

        @JvmStatic
        @Nullable
        public final synchronized InAppPurchaseBillingClientWrapper getOrCreateInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (InAppPurchaseBillingClientWrapper.initialized.get()) {
                return InAppPurchaseBillingClientWrapper.instance;
            }
            createInstance(context);
            InAppPurchaseBillingClientWrapper.initialized.set(true);
            return InAppPurchaseBillingClientWrapper.instance;
        }

        @NotNull
        public final Map<String, JSONObject> getPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapper.purchaseDetailsMap;
        }

        @NotNull
        public final Map<String, JSONObject> getSkuDetailsMap() {
            return InAppPurchaseBillingClientWrapper.skuDetailsMap;
        }

        @NotNull
        public final AtomicBoolean isServiceConnected() {
            return InAppPurchaseBillingClientWrapper.isServiceConnected;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J0\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$PurchaseHistoryResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "runnable", "Ljava/lang/Runnable;", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "getPurchaseHistoryRecord", "", "purchaseHistoryRecordList", "", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @AutoHandleExceptions
    public final class PurchaseHistoryResponseListenerWrapper implements InvocationHandler {
        @NotNull
        private Runnable runnable;
        final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public PurchaseHistoryResponseListenerWrapper(@NotNull InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable2) {
            Intrinsics.checkNotNullParameter(inAppPurchaseBillingClientWrapper, "this$0");
            Intrinsics.checkNotNullParameter(runnable2, "runnable");
            this.this$0 = inAppPurchaseBillingClientWrapper;
            this.runnable = runnable2;
        }

        private final void getPurchaseHistoryRecord(List<?> list) {
            String str;
            for (Object next : list) {
                try {
                    InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                    Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.this$0.purchaseHistoryRecordClazz, this.this$0.getOriginalJsonPurchaseHistoryMethod, next, new Object[0]);
                    if (invokeMethod instanceof String) {
                        str = (String) invokeMethod;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put("packageName", (Object) this.this$0.context.getPackageName());
                        if (jSONObject.has(InAppPurchaseBillingClientWrapper.PRODUCT_ID)) {
                            String string = jSONObject.getString(InAppPurchaseBillingClientWrapper.PRODUCT_ID);
                            this.this$0.historyPurchaseSet.add(string);
                            Map<String, JSONObject> purchaseDetailsMap = InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap();
                            Intrinsics.checkNotNullExpressionValue(string, "skuID");
                            purchaseDetailsMap.put(string, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.runnable.run();
        }

        @NotNull
        public final Runnable getRunnable() {
            return this.runnable;
        }

        @Nullable
        public Object invoke(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) {
            List list;
            Intrinsics.checkNotNullParameter(obj, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            if (Intrinsics.areEqual((Object) method.getName(), (Object) InAppPurchaseBillingClientWrapper.METHOD_ON_PURCHASE_HISTORY_RESPONSE)) {
                if (objArr == null) {
                    list = null;
                } else {
                    list = objArr[1];
                }
                if (list != null && (list instanceof List)) {
                    getPurchaseHistoryRecord(list);
                }
            }
            return null;
        }

        public final void setRunnable(@NotNull Runnable runnable2) {
            Intrinsics.checkNotNullParameter(runnable2, "<set-?>");
            this.runnable = runnable2;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$PurchasesUpdatedListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "()V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @AutoHandleExceptions
    public static final class PurchasesUpdatedListenerWrapper implements InvocationHandler {
        @Nullable
        public Object invoke(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) {
            Intrinsics.checkNotNullParameter(obj, "proxy");
            Intrinsics.checkNotNullParameter(method, "m");
            return null;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$SkuDetailsResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "runnable", "Ljava/lang/Runnable;", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "parseSkuDetails", "", "skuDetailsObjectList", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @AutoHandleExceptions
    public final class SkuDetailsResponseListenerWrapper implements InvocationHandler {
        @NotNull
        private Runnable runnable;
        final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public SkuDetailsResponseListenerWrapper(@NotNull InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable2) {
            Intrinsics.checkNotNullParameter(inAppPurchaseBillingClientWrapper, "this$0");
            Intrinsics.checkNotNullParameter(runnable2, "runnable");
            this.this$0 = inAppPurchaseBillingClientWrapper;
            this.runnable = runnable2;
        }

        @NotNull
        public final Runnable getRunnable() {
            return this.runnable;
        }

        @Nullable
        public Object invoke(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) {
            List list;
            Intrinsics.checkNotNullParameter(obj, "proxy");
            Intrinsics.checkNotNullParameter(method, "m");
            if (Intrinsics.areEqual((Object) method.getName(), (Object) InAppPurchaseBillingClientWrapper.METHOD_ON_SKU_DETAILS_RESPONSE)) {
                if (objArr == null) {
                    list = null;
                } else {
                    list = objArr[1];
                }
                if (list != null && (list instanceof List)) {
                    parseSkuDetails(list);
                }
            }
            return null;
        }

        public final void parseSkuDetails(@NotNull List<?> list) {
            String str;
            Intrinsics.checkNotNullParameter(list, "skuDetailsObjectList");
            for (Object next : list) {
                try {
                    InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                    Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.this$0.skuDetailsClazz, this.this$0.getOriginalJsonSkuMethod, next, new Object[0]);
                    if (invokeMethod instanceof String) {
                        str = (String) invokeMethod;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has(InAppPurchaseBillingClientWrapper.PRODUCT_ID)) {
                            String string = jSONObject.getString(InAppPurchaseBillingClientWrapper.PRODUCT_ID);
                            Map<String, JSONObject> skuDetailsMap = InAppPurchaseBillingClientWrapper.Companion.getSkuDetailsMap();
                            Intrinsics.checkNotNullExpressionValue(string, "skuID");
                            skuDetailsMap.put(string, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.runnable.run();
        }

        public final void setRunnable(@NotNull Runnable runnable2) {
            Intrinsics.checkNotNullParameter(runnable2, "<set-?>");
            this.runnable = runnable2;
        }
    }

    private InAppPurchaseBillingClientWrapper(Context context2, Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper2) {
        this.context = context2;
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseResultClazz = cls2;
        this.purchaseClazz = cls3;
        this.skuDetailsClazz = cls4;
        this.purchaseHistoryRecordClazz = cls5;
        this.skuDetailsResponseListenerClazz = cls6;
        this.purchaseHistoryResponseListenerClazz = cls7;
        this.queryPurchasesMethod = method;
        this.getPurchaseListMethod = method2;
        this.getOriginalJsonMethod = method3;
        this.getOriginalJsonSkuMethod = method4;
        this.getOriginalJsonPurchaseHistoryMethod = method5;
        this.querySkuDetailsAsyncMethod = method6;
        this.queryPurchaseHistoryAsyncMethod = method7;
        this.inAppPurchaseSkuDetailsWrapper = inAppPurchaseSkuDetailsWrapper2;
        this.historyPurchaseSet = new CopyOnWriteArraySet();
    }

    public /* synthetic */ InAppPurchaseBillingClientWrapper(Context context2, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, inAppPurchaseSkuDetailsWrapper2);
    }

    @JvmStatic
    @Nullable
    public static final synchronized InAppPurchaseBillingClientWrapper getOrCreateInstance(@NotNull Context context2) {
        InAppPurchaseBillingClientWrapper orCreateInstance;
        synchronized (InAppPurchaseBillingClientWrapper.class) {
            orCreateInstance = Companion.getOrCreateInstance(context2);
        }
        return orCreateInstance;
    }

    /* access modifiers changed from: private */
    /* renamed from: queryPurchaseHistory$lambda-0  reason: not valid java name */
    public static final void m8915queryPurchaseHistory$lambda0(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable) {
        Intrinsics.checkNotNullParameter(inAppPurchaseBillingClientWrapper, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$queryPurchaseHistoryRunnable");
        inAppPurchaseBillingClientWrapper.querySkuDetailsAsync(IN_APP, new ArrayList(inAppPurchaseBillingClientWrapper.historyPurchaseSet), runnable);
    }

    private final void queryPurchaseHistoryAsync(String str, Runnable runnable) {
        Object newProxyInstance = Proxy.newProxyInstance(this.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{this.purchaseHistoryResponseListenerClazz}, new PurchaseHistoryResponseListenerWrapper(this, runnable));
        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
        InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchaseHistoryAsyncMethod, this.billingClient, str, newProxyInstance);
    }

    private final void querySkuDetailsAsync(String str, List<String> list, Runnable runnable) {
        Object newProxyInstance = Proxy.newProxyInstance(this.skuDetailsResponseListenerClazz.getClassLoader(), new Class[]{this.skuDetailsResponseListenerClazz}, new SkuDetailsResponseListenerWrapper(this, runnable));
        Object skuDetailsParams = this.inAppPurchaseSkuDetailsWrapper.getSkuDetailsParams(str, list);
        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
        InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.querySkuDetailsAsyncMethod, this.billingClient, skuDetailsParams, newProxyInstance);
    }

    /* access modifiers changed from: private */
    public final void startConnection() {
        Method method;
        Class<?> cls = InAppPurchaseUtils.getClass(CLASSNAME_BILLING_CLIENT_STATE_LISTENER);
        if (cls != null && (method = InAppPurchaseUtils.getMethod(this.billingClientClazz, METHOD_START_CONNECTION, cls)) != null) {
            Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BillingClientStateListenerWrapper());
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, method, this.billingClient, newProxyInstance);
        }
    }

    public final void queryPurchase(@NotNull String str, @NotNull Runnable runnable) {
        List list;
        String str2;
        Intrinsics.checkNotNullParameter(str, "skuType");
        Intrinsics.checkNotNullParameter(runnable, "querySkuRunnable");
        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
        Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseResultClazz, this.getPurchaseListMethod, InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchasesMethod, this.billingClient, IN_APP), new Object[0]);
        if (invokeMethod instanceof List) {
            list = (List) invokeMethod;
        } else {
            list = null;
        }
        if (list != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Object next : list) {
                    InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
                    Object invokeMethod2 = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.getOriginalJsonMethod, next, new Object[0]);
                    if (invokeMethod2 instanceof String) {
                        str2 = (String) invokeMethod2;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has(PRODUCT_ID)) {
                            String string = jSONObject.getString(PRODUCT_ID);
                            arrayList.add(string);
                            Map<String, JSONObject> map = purchaseDetailsMap;
                            Intrinsics.checkNotNullExpressionValue(string, "skuID");
                            map.put(string, jSONObject);
                        }
                    }
                }
                querySkuDetailsAsync(str, arrayList, runnable);
            } catch (JSONException unused) {
            }
        }
    }

    public final void queryPurchaseHistory(@NotNull String str, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(str, "skuType");
        Intrinsics.checkNotNullParameter(runnable, "queryPurchaseHistoryRunnable");
        queryPurchaseHistoryAsync(str, new e(this, runnable));
    }
}
