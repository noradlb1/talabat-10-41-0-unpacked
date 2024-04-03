package com.talabat.growth.ui.loyalty.burn.list;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.core.navigation.domain.screen.rewards.BurnOptionsScreen;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;
import com.talabat.growth.ui.loyalty.burn.list.views.FeaturedListAdapter;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/growth/ui/loyalty/burn/list/FeaturedListFragment$featuredListItemClickListener$1", "Lcom/talabat/growth/ui/loyalty/burn/list/views/FeaturedListAdapter$FeaturedListItemClickListener;", "onItemClicked", "", "voucherPosition", "", "model", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedListFragment$featuredListItemClickListener$1 implements FeaturedListAdapter.FeaturedListItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeaturedListFragment f60637a;

    public FeaturedListFragment$featuredListItemClickListener$1(FeaturedListFragment featuredListFragment) {
        this.f60637a = featuredListFragment;
    }

    public void onItemClicked(int i11, @NotNull BurnItemDisplayModel burnItemDisplayModel) {
        String str;
        Intrinsics.checkNotNullParameter(burnItemDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        BurnOptionsScreen.Data access$getBurnOptionsScreenData = this.f60637a.getBurnOptionsScreenData();
        Integer num = null;
        if (access$getBurnOptionsScreenData != null) {
            str = access$getBurnOptionsScreenData.getChannelName();
        } else {
            str = null;
        }
        if (access$getBurnOptionsScreenData != null) {
            num = Integer.valueOf(access$getBurnOptionsScreenData.getChannelPosition());
        }
        FeaturedListFragment.access$getViewModel(this.f60637a).onBurnOptionClicked(i11, burnItemDisplayModel, new BurnOptionsDetailsFragment.VoucherPosition(str, num, i11));
    }
}
