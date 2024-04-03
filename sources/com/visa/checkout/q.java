package com.visa.checkout;

import android.app.Activity;
import com.visa.checkout.VisaCheckoutSdk;

final class q {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Activity f364;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Profile f365;

    /* renamed from: ˎ  reason: contains not printable characters */
    private VisaCheckoutSdk.VisaCheckoutBaseListener f366;

    /* renamed from: ˏ  reason: contains not printable characters */
    private PurchaseInfo f367;

    /* renamed from: ॱ  reason: contains not printable characters */
    private g f368 = null;

    public q(Activity activity, Profile profile, PurchaseInfo purchaseInfo, VisaCheckoutSdk.VisaCheckoutBaseListener visaCheckoutBaseListener) {
        this.f364 = activity;
        this.f365 = profile;
        this.f367 = purchaseInfo;
        this.f366 = visaCheckoutBaseListener;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final PurchaseInfo m6272() {
        return this.f367;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final Profile m6273() {
        return this.f365;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final Activity m6274() {
        return this.f364;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final VisaCheckoutSdk.VisaCheckoutBaseListener m6275() {
        return this.f366;
    }
}
