package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GrowthTracker$voucherFailToApply$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f61676g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f61677h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f61678i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f61679j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f61680k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Float f61681l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f61682m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GrowthTracker$voucherFailToApply$1(String str, String str2, String str3, String str4, String str5, Float f11, String str6) {
        super(0);
        this.f61676g = str;
        this.f61677h = str2;
        this.f61678i = str3;
        this.f61679j = str4;
        this.f61680k = str5;
        this.f61681l = f11;
        this.f61682m = str6;
    }

    public final void invoke() {
        TalabatTracker access$getTalabatTracker$p = GrowthTracker.talabatTracker;
        if (access$getTalabatTracker$p != null) {
            String str = this.f61676g;
            if (str == null) {
                str = "N/A";
            }
            String str2 = str;
            String str3 = this.f61677h;
            if (str3 == null) {
                str3 = "checkout";
            }
            access$getTalabatTracker$p.track(new PromoCodeSubmitFailedEvent(str2, str3, this.f61678i, this.f61679j, this.f61680k, this.f61681l, this.f61682m));
        }
        GrowthTracker.gaGrowthTrackerRepoImpl.voucherFailToApply(this.f61678i, this.f61679j, this.f61682m, this.f61680k);
    }
}
