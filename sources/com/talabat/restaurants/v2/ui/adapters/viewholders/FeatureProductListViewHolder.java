package com.talabat.restaurants.v2.ui.adapters.viewholders;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.adapters.restaurantslist.RestaurantsListAdapterRefactor;
import com.talabat.helpers.HorizontalSpacesItemDecoration;
import com.talabat.restaurants.v2.ui.adapters.FeatureProductsAdapter;
import com.talabat.restaurants.v2.ui.adapters.viewholders.FeatureProductItemViewHolder;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0006\u0010\u001a\u001a\u00020\u0003J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "Lcom/talabat/adapters/restaurantslist/RestaurantsListAdapterRefactor$OnFeatureProductTrackingEnabled;", "containerView", "Landroid/view/View;", "onFeatureProductClick", "Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder$OnFeatureProductClick;", "onFeatureProductShown", "Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductListViewHolder$OnFeatureProductShown;", "(Landroid/view/View;Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder$OnFeatureProductClick;Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductListViewHolder$OnFeatureProductShown;)V", "getContainerView", "()Landroid/view/View;", "featureProductImpressionTracker", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "featureProducts", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "isTrackingEnabled", "", "bind", "", "featureProductList", "featureProductTrackingEnabled", "enabled", "getTrackingEnabledCallback", "trackItemImpression", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "OnFeatureProductShown", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureProductListViewHolder extends RecyclerView.ViewHolder implements LayoutContainer, RestaurantsListAdapterRefactor.OnFeatureProductTrackingEnabled {
    @NotNull
    private final View containerView;
    @NotNull
    private final HashSet<Integer> featureProductImpressionTracker = new HashSet<>();
    @Nullable
    private FeatureProductListDisplayModel featureProducts;
    /* access modifiers changed from: private */
    public boolean isTrackingEnabled;
    @Nullable
    private final FeatureProductItemViewHolder.OnFeatureProductClick onFeatureProductClick;
    @NotNull
    private final OnFeatureProductShown onFeatureProductShown;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductListViewHolder$OnFeatureProductShown;", "", "featureProductShown", "", "position", "", "listSize", "featureProduct", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFeatureProductShown {
        void featureProductShown(int i11, int i12, @NotNull FeatureProductDisplayModel featureProductDisplayModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeatureProductListViewHolder(@NotNull View view, @Nullable FeatureProductItemViewHolder.OnFeatureProductClick onFeatureProductClick2, @NotNull OnFeatureProductShown onFeatureProductShown2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        Intrinsics.checkNotNullParameter(onFeatureProductShown2, "onFeatureProductShown");
        this.containerView = view;
        this.onFeatureProductClick = onFeatureProductClick2;
        this.onFeatureProductShown = onFeatureProductShown2;
        View containerView2 = getContainerView();
        int i11 = R.id.featureProductList;
        ((RecyclerView) containerView2.findViewById(i11)).addItemDecoration(new HorizontalSpacesItemDecoration(getContainerView().getContext().getResources().getDimensionPixelOffset(R.dimen.hero_horizontal_space)));
        ((RecyclerView) getContainerView().findViewById(i11)).setNestedScrollingEnabled(false);
        ((RecyclerView) getContainerView().findViewById(i11)).startNestedScroll(1);
        ((RecyclerView) getContainerView().findViewById(i11)).setLayoutManager(new LinearLayoutManager(getContainerView().getContext(), 0, false));
    }

    /* access modifiers changed from: private */
    public final void trackItemImpression(RecyclerView recyclerView, FeatureProductListDisplayModel featureProductListDisplayModel) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (layoutManager2 != null) {
                int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition != -1 && findLastCompletelyVisibleItemPosition != -1 && findFirstCompletelyVisibleItemPosition <= findLastCompletelyVisibleItemPosition) {
                    while (true) {
                        if (!this.featureProductImpressionTracker.contains(Integer.valueOf(findFirstCompletelyVisibleItemPosition))) {
                            this.featureProductImpressionTracker.add(Integer.valueOf(findFirstCompletelyVisibleItemPosition));
                            this.onFeatureProductShown.featureProductShown(findFirstCompletelyVisibleItemPosition, featureProductListDisplayModel.getFeatureProductDisplayModels().size(), featureProductListDisplayModel.getFeatureProductDisplayModels().get(findFirstCompletelyVisibleItemPosition));
                        }
                        if (findFirstCompletelyVisibleItemPosition != findLastCompletelyVisibleItemPosition) {
                            findFirstCompletelyVisibleItemPosition++;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    public final void bind(@NotNull FeatureProductListDisplayModel featureProductListDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductListDisplayModel, "featureProductList");
        this.featureProducts = featureProductListDisplayModel;
        ((TextView) getContainerView().findViewById(R.id.featureProductTitle)).setText(featureProductListDisplayModel.getName());
        View containerView2 = getContainerView();
        int i11 = R.id.featureProductList;
        ((RecyclerView) containerView2.findViewById(i11)).addOnScrollListener(new FeatureProductListViewHolder$bind$1(this, featureProductListDisplayModel));
        ((RecyclerView) getContainerView().findViewById(i11)).setAdapter(new FeatureProductsAdapter(featureProductListDisplayModel.getFeatureProductDisplayModels(), this.onFeatureProductClick));
    }

    public void featureProductTrackingEnabled(boolean z11) {
        this.isTrackingEnabled = z11;
        this.featureProductImpressionTracker.clear();
        FeatureProductListDisplayModel featureProductListDisplayModel = this.featureProducts;
        if (featureProductListDisplayModel != null) {
            RecyclerView recyclerView = (RecyclerView) getContainerView().findViewById(R.id.featureProductList);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "containerView.featureProductList");
            trackItemImpression(recyclerView, featureProductListDisplayModel);
        }
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }

    @NotNull
    public final RestaurantsListAdapterRefactor.OnFeatureProductTrackingEnabled getTrackingEnabledCallback() {
        return this;
    }
}
