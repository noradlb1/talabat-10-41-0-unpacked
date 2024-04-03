package com.talabat.restaurants.v2.ui.adapters.viewholders;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductListViewHolder$bind$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureProductListViewHolder$bind$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeatureProductListViewHolder f61253a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FeatureProductListDisplayModel f61254b;

    public FeatureProductListViewHolder$bind$1(FeatureProductListViewHolder featureProductListViewHolder, FeatureProductListDisplayModel featureProductListDisplayModel) {
        this.f61253a = featureProductListViewHolder;
        this.f61254b = featureProductListDisplayModel;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.f61253a.isTrackingEnabled) {
            this.f61253a.trackItemImpression(recyclerView, this.f61254b);
        }
    }
}
