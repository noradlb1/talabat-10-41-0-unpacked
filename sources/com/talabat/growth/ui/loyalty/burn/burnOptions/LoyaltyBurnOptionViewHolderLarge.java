package com.talabat.growth.ui.loyalty.burn.burnOptions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction;
import com.talabat.growth.ui.loyalty.burn.models.VoucherOfferType;
import com.talabat.talabatcommon.views.TalabatImageView;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.HeadlinesAdapterKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0013"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptions/LoyaltyBurnOptionViewHolderLarge;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyBrandUpdates", "", "populate", "model", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "setTag", "voucherOfferType", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyBurnOptionViewHolderLarge extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyBurnOptionViewHolderLarge(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_holder_loyalty_burn_item, this, true);
    }

    private final void applyBrandUpdates() {
        ((ImageView) _$_findCachedViewById(R.id.iv_pro)).setImageResource(com.example.talabatresources.R.drawable.bg_vendor_pro_tag_blue);
        int color = HeadlinesAdapterKt.getColor(com.talabat.talabatcommon.R.color.new_brand_blue);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.cv_pro_exclusive);
        if (_$_findCachedViewById != null) {
            ((CardView) _$_findCachedViewById).setCardBackgroundColor(color);
            ((ImageView) _$_findCachedViewById(R.id.iv_exclusive_pro)).setImageResource(R.drawable.ic_pro_reversive_blue);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.cardview.widget.CardView");
    }

    private final void setTag(VoucherOfferType voucherOfferType) {
        Integer icon = voucherOfferType.getIcon();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String label = voucherOfferType.getLabel(context);
        if (icon == null || label == null) {
            View _$_findCachedViewById = _$_findCachedViewById(R.id.label_voucher_type);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "label_voucher_type");
            _$_findCachedViewById.setVisibility(8);
            return;
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.label_voucher_type);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById2, "");
        _$_findCachedViewById2.setVisibility(0);
        ((ImageView) _$_findCachedViewById2.findViewById(R.id.iv_tag)).setImageResource(icon.intValue());
        ((TextView) _$_findCachedViewById2.findViewById(R.id.tv_tag)).setText(label);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void populate(@NotNull BurnItemDisplayModel burnItemDisplayModel) {
        boolean z11;
        int i11;
        Intrinsics.checkNotNullParameter(burnItemDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        TalabatImageView talabatImageView = (TalabatImageView) _$_findCachedViewById(R.id.loyaltyBurnOptionImageView);
        Intrinsics.checkNotNullExpressionValue(talabatImageView, "loyaltyBurnOptionImageView");
        int i12 = 0;
        TalabatImageView.setImageResizeUrl$default(talabatImageView, burnItemDisplayModel.getImageURL(), getResources().getDimensionPixelSize(R.dimen.loyalty_burn_item_image_large_width), 0, false, 12, (Object) null);
        ((TextView) _$_findCachedViewById(R.id.loyaltyBurnOptionTitleTextView)).setText(burnItemDisplayModel.getTitle());
        String string = getResources().getString(com.talabat.localization.R.string.loyalty_points_summary);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…g.loyalty_points_summary)");
        ((TextView) _$_findCachedViewById(R.id.loyaltyBurnOptionPointTextView)).setText(burnItemDisplayModel.getPointsCost() + " " + string);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_pro);
        Intrinsics.checkNotNullExpressionValue(imageView, "iv_pro");
        boolean z12 = true;
        if (burnItemDisplayModel.getSubscriptionRestriction() == SubscriptionRestriction.NON_T_PRO) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        imageView.setVisibility(i11);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.cv_pro_exclusive);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "cv_pro_exclusive");
        if (burnItemDisplayModel.getSubscriptionRestriction() != SubscriptionRestriction.T_PRO) {
            z12 = false;
        }
        if (!z12) {
            i12 = 8;
        }
        _$_findCachedViewById.setVisibility(i12);
        applyBrandUpdates();
        setTag(burnItemDisplayModel.getVoucherOfferType());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyBurnOptionViewHolderLarge(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_holder_loyalty_burn_item, this, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyBurnOptionViewHolderLarge(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_holder_loyalty_burn_item, this, true);
    }
}
