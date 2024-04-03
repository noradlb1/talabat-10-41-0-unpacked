package com.talabat.growth.ui.loyalty.dashboard;

import com.talabat.growth.ui.loyalty.burn.burnOptions.BurnOptionClickListener;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardFragment$getOnBurnOptionClickListener$1", "Lcom/talabat/growth/ui/loyalty/burn/burnOptions/BurnOptionClickListener;", "onBurnOptionClicked", "", "voucherPosition", "", "burnItemDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardFragment$getOnBurnOptionClickListener$1 implements BurnOptionClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f60649a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f60650b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardFragment f60651c;

    public LoyaltyDashboardFragment$getOnBurnOptionClickListener$1(String str, int i11, LoyaltyDashboardFragment loyaltyDashboardFragment) {
        this.f60649a = str;
        this.f60650b = i11;
        this.f60651c = loyaltyDashboardFragment;
    }

    public void onBurnOptionClicked(int i11, @NotNull BurnItemDisplayModel burnItemDisplayModel) {
        Intrinsics.checkNotNullParameter(burnItemDisplayModel, "burnItemDisplayModel");
        this.f60651c.getViewModel().onBurnOptionClicked(burnItemDisplayModel, new BurnOptionsDetailsFragment.VoucherPosition(this.f60649a, Integer.valueOf(this.f60650b), i11));
    }
}
