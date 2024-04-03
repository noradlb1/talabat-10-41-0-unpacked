package p6;

import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppPurchaseBillingClientWrapper f34633b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f34634c;

    public /* synthetic */ e(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable) {
        this.f34633b = inAppPurchaseBillingClientWrapper;
        this.f34634c = runnable;
    }

    public final void run() {
        InAppPurchaseBillingClientWrapper.m8915queryPurchaseHistory$lambda0(this.f34633b, this.f34634c);
    }
}
