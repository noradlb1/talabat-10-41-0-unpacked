package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.growth.ui.vouchers.list.VouchersListFragment;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GrowthTracker$onVoucherRedeemed$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VoucherData f61663g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f61664h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f61665i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GrowthTracker$onVoucherRedeemed$1(VoucherData voucherData, String str, String str2) {
        super(0);
        this.f61663g = voucherData;
        this.f61664h = str;
        this.f61665i = str2;
    }

    public final void invoke() {
        GrowthTracker.brazeGrowthTrackerRepoImpl.onVoucherRedeemed(new AppVoucherRedeemedTrackingEvent(this.f61663g));
        String str = this.f61664h;
        if (!Intrinsics.areEqual((Object) str, (Object) VouchersListFragment.VOUCHER_LIST)) {
            str = null;
        }
        if (str != null) {
            String str2 = this.f61665i;
            String str3 = this.f61664h;
            VoucherData voucherData = this.f61663g;
            TalabatTracker access$getTalabatTracker$p = GrowthTracker.talabatTracker;
            if (access$getTalabatTracker$p != null) {
                if (str2 == null) {
                    str2 = "";
                }
                if (str3 == null) {
                    str3 = "";
                }
                access$getTalabatTracker$p.track(new PromoCodeSubmitSuccessfullyEvent(str2, str3, voucherData));
            }
        }
    }
}
