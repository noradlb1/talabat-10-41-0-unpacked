package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GrowthTracker$onVoucherRemoved$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f61666g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f61667h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f61668i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f61669j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GrowthTracker$onVoucherRemoved$1(String str, String str2, float f11, String str3) {
        super(0);
        this.f61666g = str;
        this.f61667h = str2;
        this.f61668i = f11;
        this.f61669j = str3;
    }

    public final void invoke() {
        GrowthTracker.gaGrowthTrackerRepoImpl.onVoucherRemoved(this.f61666g, this.f61667h, this.f61668i, this.f61669j);
    }
}
