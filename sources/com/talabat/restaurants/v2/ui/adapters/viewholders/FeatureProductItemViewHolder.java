package com.talabat.restaurants.v2.ui.adapters.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.helpers.ImagesHelper;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.PriceDisplayType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "onFeatureProductClick", "Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder$OnFeatureProductClick;", "(Landroid/view/View;Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder$OnFeatureProductClick;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "featureProduct", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "position", "", "listSize", "OnFeatureProductClick", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureProductItemViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;
    @Nullable
    private final OnFeatureProductClick onFeatureProductClick;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder$OnFeatureProductClick;", "", "featureProductClick", "", "position", "", "listSize", "featureProduct", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFeatureProductClick {
        void featureProductClick(int i11, int i12, @NotNull FeatureProductDisplayModel featureProductDisplayModel);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PriceDisplayType.values().length];
            iArr[PriceDisplayType.ONLY_PRICE.ordinal()] = 1;
            iArr[PriceDisplayType.PRICE_ON_SELECTION.ordinal()] = 2;
            iArr[PriceDisplayType.DISCOUNT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeatureProductItemViewHolder(@NotNull View view, @Nullable OnFeatureProductClick onFeatureProductClick2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.onFeatureProductClick = onFeatureProductClick2;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10756bind$lambda0(FeatureProductItemViewHolder featureProductItemViewHolder, int i11, int i12, FeatureProductDisplayModel featureProductDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(featureProductItemViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "$featureProduct");
        OnFeatureProductClick onFeatureProductClick2 = featureProductItemViewHolder.onFeatureProductClick;
        if (onFeatureProductClick2 != null) {
            onFeatureProductClick2.featureProductClick(i11, i12, featureProductDisplayModel);
        }
    }

    public final void bind(@NotNull FeatureProductDisplayModel featureProductDisplayModel, int i11, int i12) {
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featureProduct");
        getContainerView().setOnClickListener(new a(this, i11, i12, featureProductDisplayModel));
        ((TextView) getContainerView().findViewById(R.id.itemName)).setText(featureProductDisplayModel.getItemName());
        ((TextView) getContainerView().findViewById(R.id.vendorName)).setText(featureProductDisplayModel.getVendorName());
        ImagesHelper.Companion companion = ImagesHelper.Companion;
        Context context = getContainerView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        String itemImg = featureProductDisplayModel.getItemImg();
        ImageView imageView = (ImageView) getContainerView().findViewById(R.id.itemImage);
        Intrinsics.checkNotNullExpressionValue(imageView, "containerView.itemImage");
        companion.loadImageWithRadius(context, itemImg, imageView, 8.0f);
        int i13 = WhenMappings.$EnumSwitchMapping$0[featureProductDisplayModel.getPriceDisplayType().ordinal()];
        if (i13 == 1) {
            View containerView2 = getContainerView();
            int i14 = R.id.itemPrice;
            ((TextView) containerView2.findViewById(i14)).setText(featureProductDisplayModel.getPrice());
            ((TextView) getContainerView().findViewById(R.id.priceOnSelection)).setVisibility(8);
            ((TextView) getContainerView().findViewById(R.id.itemOldPrice)).setVisibility(8);
            ((TextView) getContainerView().findViewById(i14)).setVisibility(0);
        } else if (i13 == 2) {
            ((TextView) getContainerView().findViewById(R.id.priceOnSelection)).setVisibility(0);
            ((TextView) getContainerView().findViewById(R.id.itemOldPrice)).setVisibility(8);
            ((TextView) getContainerView().findViewById(R.id.itemPrice)).setVisibility(8);
        } else if (i13 == 3) {
            View containerView3 = getContainerView();
            int i15 = R.id.itemOldPrice;
            ((TextView) containerView3.findViewById(i15)).setText(featureProductDisplayModel.getOldPrice());
            ((TextView) getContainerView().findViewById(i15)).setPaintFlags(((TextView) getContainerView().findViewById(i15)).getPaintFlags() | 16);
            View containerView4 = getContainerView();
            int i16 = R.id.itemPrice;
            ((TextView) containerView4.findViewById(i16)).setText(featureProductDisplayModel.getPrice());
            ((TextView) getContainerView().findViewById(R.id.priceOnSelection)).setVisibility(8);
            ((TextView) getContainerView().findViewById(i15)).setVisibility(0);
            ((TextView) getContainerView().findViewById(i16)).setVisibility(0);
        }
        ((TextView) getContainerView().findViewById(R.id.itemPrice)).setText(featureProductDisplayModel.getPrice());
        ((TextView) getContainerView().findViewById(R.id.deliveryTime)).setText(featureProductDisplayModel.getDeliveryTimeText());
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
