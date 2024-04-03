package com.talabat.darkstores.feature.home.viewholder;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.impression.TrackingData;
import com.talabat.darkstores.feature.home.BannerItemViewHolderData;
import com.talabat.darkstores.feature.home.banner.BannerView;
import com.talabat.darkstores.feature.home.banner.LoopingViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/viewholder/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "productImpressionTracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "trackingData", "Lcom/talabat/darkstores/data/tracking/impression/TrackingData;", "(Landroid/view/View;Landroidx/lifecycle/LifecycleOwner;Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;Lcom/talabat/darkstores/data/tracking/impression/TrackingData;)V", "bind", "", "itemData", "Lcom/talabat/darkstores/feature/home/BannerItemViewHolderData;", "bannerPosition", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerViewHolder(@NotNull View view, @NotNull LifecycleOwner lifecycleOwner, @NotNull ProductImpressionTracker productImpressionTracker, @NotNull TrackingData trackingData) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(productImpressionTracker, "productImpressionTracker");
        Intrinsics.checkNotNullParameter(trackingData, "trackingData");
        productImpressionTracker.unregister();
        ((BannerView) this.itemView.findViewById(R.id.banner_view)).setupImpressionTracking(productImpressionTracker, trackingData, lifecycleOwner);
    }

    public final void bind(@NotNull BannerItemViewHolderData bannerItemViewHolderData, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(bannerItemViewHolderData, "itemData");
        View view = this.itemView;
        int i12 = R.id.banner_view;
        ((BannerView) view.findViewById(i12)).setupAdapter(bannerItemViewHolderData.getBanners(), bannerItemViewHolderData.getOnBannerClicked(), bannerItemViewHolderData.getBannerType());
        ((BannerView) view.findViewById(i12)).setOnBannerShownListener(new BannerViewHolder$bind$1$1(bannerItemViewHolderData));
        Integer valueOf = Integer.valueOf(i11);
        if (valueOf.intValue() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            valueOf = null;
        }
        if (valueOf != null) {
            ((LoopingViewPager) ((BannerView) view.findViewById(i12))._$_findCachedViewById(R.id.viewpager)).setCurrentItem(valueOf.intValue());
        }
    }
}
