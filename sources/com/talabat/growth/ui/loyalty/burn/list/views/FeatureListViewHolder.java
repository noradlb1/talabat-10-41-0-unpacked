package com.talabat.growth.ui.loyalty.burn.list.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction;
import com.talabat.growth.ui.loyalty.burn.models.VoucherOfferType;
import com.talabat.talabatcommon.extentions.ImageViewForTalabatKt;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.HeadlinesAdapterKt;
import com.talabat.talabatcore.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\fJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/list/views/FeatureListViewHolder;", "Lcom/talabat/talabatcore/BaseViewHolder;", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "applyBrandUpdates", "", "populate", "model", "setOnClickListener", "itemClickListener", "Lkotlin/Function0;", "setTag", "voucherOfferType", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureListViewHolder extends BaseViewHolder<BurnItemDisplayModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeatureListViewHolder(@NotNull ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_holder_featured_list);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    private final void applyBrandUpdates() {
        boolean z11;
        View view = this.itemView;
        ((ImageView) view.findViewById(R.id.iv_pro)).setImageResource(com.example.talabatresources.R.drawable.bg_vendor_pro_tag_blue);
        int i11 = R.id.cv_pro_exclusive;
        View findViewById = view.findViewById(i11);
        Intrinsics.checkNotNullExpressionValue(findViewById, "cv_pro_exclusive");
        if (findViewById.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int color = HeadlinesAdapterKt.getColor(com.talabat.talabatcommon.R.color.new_brand_blue);
            View findViewById2 = view.findViewById(i11);
            if (findViewById2 != null) {
                ((CardView) findViewById2).setCardBackgroundColor(color);
                ((ImageView) view.findViewById(R.id.iv_exclusive_pro)).setImageResource(R.drawable.ic_pro_reversive_blue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.cardview.widget.CardView");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnClickListener$lambda-1  reason: not valid java name */
    public static final void m10603setOnClickListener$lambda1(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$itemClickListener");
        function0.invoke();
    }

    private final void setTag(VoucherOfferType voucherOfferType) {
        Integer icon = voucherOfferType.getIcon();
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        String label = voucherOfferType.getLabel(context);
        if (icon == null || label == null) {
            View findViewById = this.itemView.findViewById(R.id.label_voucher_type);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.label_voucher_type");
            findViewById.setVisibility(8);
            return;
        }
        View findViewById2 = this.itemView.findViewById(R.id.label_voucher_type);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        findViewById2.setVisibility(0);
        ((ImageView) findViewById2.findViewById(R.id.iv_tag)).setImageResource(icon.intValue());
        ((TextView) findViewById2.findViewById(R.id.tv_tag)).setText(label);
    }

    public final void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "itemClickListener");
        this.itemView.setOnClickListener(new a(function0));
    }

    public void populate(@NotNull BurnItemDisplayModel burnItemDisplayModel) {
        Intrinsics.checkNotNullParameter(burnItemDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        View view = this.itemView;
        ImageView imageView = (ImageView) view.findViewById(R.id.featuredListViewHolderImageView);
        String imageURL = burnItemDisplayModel.getImageURL();
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.featuredListViewHolderImageHeight);
        int i11 = view.getResources().getDisplayMetrics().widthPixels;
        Intrinsics.checkNotNullExpressionValue(imageView, "featuredListViewHolderImageView");
        ImageViewForTalabatKt.setImageResizeUrl$default(imageView, imageURL, i11, dimensionPixelSize, false, 8, (Object) null);
        ((TextView) view.findViewById(R.id.featuredListViewHolderTitleTextView)).setText(burnItemDisplayModel.getTitle());
        ((TextView) view.findViewById(R.id.featuredListViewHolderPointsTextView)).setText(String.valueOf(burnItemDisplayModel.getPointsCost()));
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_pro);
        Intrinsics.checkNotNullExpressionValue(imageView2, "iv_pro");
        boolean z11 = true;
        int i12 = 0;
        imageView2.setVisibility(burnItemDisplayModel.getSubscriptionRestriction() == SubscriptionRestriction.NON_T_PRO ? 0 : 8);
        View findViewById = view.findViewById(R.id.cv_pro_exclusive);
        Intrinsics.checkNotNullExpressionValue(findViewById, "cv_pro_exclusive");
        if (burnItemDisplayModel.getSubscriptionRestriction() != SubscriptionRestriction.T_PRO) {
            z11 = false;
        }
        if (!z11) {
            i12 = 8;
        }
        findViewById.setVisibility(i12);
        setTag(burnItemDisplayModel.getVoucherOfferType());
        applyBrandUpdates();
    }
}
