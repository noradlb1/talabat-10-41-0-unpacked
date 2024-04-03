package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import com.talabat.core.tracking.data.events.rewards.RedeemEventParams;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsAttributes;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsClickedTrackingEvent;
import com.talabat.core.tracking.domain.TalabatTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GrowthTracker$onRedeemVoucherClicked$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f61653g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f61654h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f61655i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RedeemEventParams.ScreenType f61656j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f61657k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GrowthTracker$onRedeemVoucherClicked$1(String str, String str2, String str3, RedeemEventParams.ScreenType screenType, String str4) {
        super(0);
        this.f61653g = str;
        this.f61654h = str2;
        this.f61655i = str3;
        this.f61656j = screenType;
        this.f61657k = str4;
    }

    public final void invoke() {
        RedeemEventParams redeemEventParams = new RedeemEventParams(this.f61653g, this.f61654h, this.f61655i, this.f61656j, this.f61657k);
        TalabatTracker access$getTalabatTracker$p = GrowthTracker.talabatTracker;
        if (access$getTalabatTracker$p != null) {
            access$getTalabatTracker$p.track(new RedeemPointsClickedTrackingEvent(redeemEventParams, (RedeemPointsAttributes) null, 2, (DefaultConstructorMarker) null));
        }
    }
}
