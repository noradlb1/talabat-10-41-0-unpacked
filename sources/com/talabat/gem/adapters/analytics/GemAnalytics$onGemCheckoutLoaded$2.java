package com.talabat.gem.adapters.analytics;

import com.talabat.gem.IntegrationKt;
import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemAnalytics$onGemCheckoutLoaded$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemAnalytics f59832g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemAnalytics$onGemCheckoutLoaded$2(GemAnalytics gemAnalytics) {
        super(0);
        this.f59832g = gemAnalytics;
    }

    public final void invoke() {
        IntegrationKt.getLogger().logMessage("GemAnalytics", "joker_checkout_loaded");
        TalabatGTM.Companion.onJokerCheckoutLoaded(this.f59832g.getApplication(), this.f59832g.getGemRemainingSecondsText(), GlobalDataModel.SELECTED.getRestaurant());
    }
}
