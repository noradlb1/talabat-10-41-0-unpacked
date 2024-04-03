package com.facebook.appevents.iap;

import androidx.annotation.RestrictTo;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", "", "()V", "BILLING_CLIENT_PURCHASE_NAME", "", "logPurchase", "", "startIapLogging", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class InAppPurchaseAutoLogger {
    @NotNull
    private static final String BILLING_CLIENT_PURCHASE_NAME = "com.android.billingclient.api.Purchase";
    @NotNull
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();

    private InAppPurchaseAutoLogger() {
    }

    private final void logPurchase() {
        InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
        InAppPurchaseBillingClientWrapper.Companion companion = InAppPurchaseBillingClientWrapper.Companion;
        InAppPurchaseLoggerManager.filterPurchaseLogging(companion.getPurchaseDetailsMap(), companion.getSkuDetailsMap());
        companion.getPurchaseDetailsMap().clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r0 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.Companion;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void startIapLogging(@org.jetbrains.annotations.NotNull android.content.Context r2) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "com.android.billingclient.api.Purchase"
            java.lang.Class r0 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper$Companion r0 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.Companion
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r2 = r0.getOrCreateInstance(r2)
            if (r2 != 0) goto L_0x0017
            return
        L_0x0017:
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.isServiceConnected()
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x003a
            boolean r0 = com.facebook.appevents.iap.InAppPurchaseLoggerManager.eligibleQueryPurchaseHistory()
            java.lang.String r1 = "inapp"
            if (r0 == 0) goto L_0x0032
            p6.c r0 = new p6.c
            r0.<init>()
            r2.queryPurchaseHistory(r1, r0)
            goto L_0x003a
        L_0x0032:
            p6.d r0 = new p6.d
            r0.<init>()
            r2.queryPurchase(r1, r0)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseAutoLogger.startIapLogging(android.content.Context):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: startIapLogging$lambda-0  reason: not valid java name */
    public static final void m8913startIapLogging$lambda0() {
        INSTANCE.logPurchase();
    }

    /* access modifiers changed from: private */
    /* renamed from: startIapLogging$lambda-1  reason: not valid java name */
    public static final void m8914startIapLogging$lambda1() {
        INSTANCE.logPurchase();
    }
}
