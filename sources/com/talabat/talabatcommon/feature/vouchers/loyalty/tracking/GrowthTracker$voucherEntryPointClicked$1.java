package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.events.VoucherEntryPointClickedTrackingEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GrowthTracker$voucherEntryPointClicked$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f61670g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f61671h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f61672i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GrowthTracker$voucherEntryPointClicked$1(String str, String str2, String str3) {
        super(0);
        this.f61670g = str;
        this.f61671h = str2;
        this.f61672i = str3;
    }

    public final void invoke() {
        TalabatTracker access$getTalabatTracker$p = GrowthTracker.talabatTracker;
        if (access$getTalabatTracker$p != null) {
            access$getTalabatTracker$p.track(new VoucherEntryPointClickedTrackingEvent(this.f61670g, this.f61671h, this.f61672i));
        }
    }
}
