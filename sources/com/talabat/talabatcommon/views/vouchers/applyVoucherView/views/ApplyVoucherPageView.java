package com.talabat.talabatcommon.views.vouchers.applyVoucherView.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import buisnessmodels.TalabatFormatter;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DisabledReason;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uv.b;
import uv.c;
import uv.d;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\tH\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006+"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/ApplyVoucherPageView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/ApplyVouchersViewPagerItemCallback;", "getCallback", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/ApplyVouchersViewPagerItemCallback;", "setCallback", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/ApplyVouchersViewPagerItemCallback;)V", "disableFreeDeliveryTypeVoucher", "", "disabledReason", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DisabledReason;", "hideSubTitle", "populate", "model", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "setListeners", "setRedeemSubTitle", "showAction", "possibleVoucherAction", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/PossibleVoucherAction;", "showAppliedMark", "showAppliedMarkWithRestriction", "restrictionDescription", "", "showApply", "showRedeem", "showRemove", "showSubTitle", "updateApplyVoucherViewHolderOfferIcon", "voucherOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "updateTitleMaxLines", "updatedMaxLines", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherPageView extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private ApplyVouchersViewPagerItemCallback callback;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[VoucherOptionType.values().length];
            iArr[VoucherOptionType.LOYALTY.ordinal()] = 1;
            iArr[VoucherOptionType.VOUCHER_CODE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DisabledReason.values().length];
            iArr2[DisabledReason.T_PRO.ordinal()] = 1;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PossibleVoucherAction.values().length];
            iArr3[PossibleVoucherAction.APPLY.ordinal()] = 1;
            iArr3[PossibleVoucherAction.REDEEM.ordinal()] = 2;
            iArr3[PossibleVoucherAction.REMOVE.ordinal()] = 3;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherPageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_holder_apply_voucher, this, true);
    }

    private final void disableFreeDeliveryTypeVoucher(DisabledReason disabledReason) {
        int i11;
        int i12 = R.id.applyVoucherViewHolderApplyButton;
        ((TextView) _$_findCachedViewById(i12)).setEnabled(false);
        ((TextView) _$_findCachedViewById(i12)).setTextColor(ContextCompat.getColor(getContext(), com.designsystem.marshmallow.R.color.ds_neutral_55));
        showSubTitle();
        if (WhenMappings.$EnumSwitchMapping$1[disabledReason.ordinal()] == 1) {
            i11 = com.talabat.localization.R.string.free_delivery_type_voucher_disabled_tPro;
        } else {
            i11 = com.talabat.localization.R.string.free_delivery_type_voucher_disabled_default;
        }
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderSubTitleTextView)).setText(i11);
    }

    private final void hideSubTitle() {
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderApplied)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderSubTitleTextView)).setVisibility(8);
    }

    private final void setListeners(VoucherDisplayModel voucherDisplayModel) {
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderApplyButton)).setOnClickListener(new b(this, voucherDisplayModel));
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderRedeemButton)).setOnClickListener(new c(this, voucherDisplayModel));
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderRemoveButton)).setOnClickListener(new d(this, voucherDisplayModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-1  reason: not valid java name */
    public static final void m5782setListeners$lambda1(ApplyVoucherPageView applyVoucherPageView, VoucherDisplayModel voucherDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(applyVoucherPageView, "this$0");
        Intrinsics.checkNotNullParameter(voucherDisplayModel, "$model");
        ApplyVouchersViewPagerItemCallback applyVouchersViewPagerItemCallback = applyVoucherPageView.callback;
        if (applyVouchersViewPagerItemCallback != null) {
            applyVouchersViewPagerItemCallback.onApplyVoucherItemClicked(voucherDisplayModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-2  reason: not valid java name */
    public static final void m5783setListeners$lambda2(ApplyVoucherPageView applyVoucherPageView, VoucherDisplayModel voucherDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(applyVoucherPageView, "this$0");
        Intrinsics.checkNotNullParameter(voucherDisplayModel, "$model");
        ApplyVouchersViewPagerItemCallback applyVouchersViewPagerItemCallback = applyVoucherPageView.callback;
        if (applyVouchersViewPagerItemCallback != null) {
            applyVouchersViewPagerItemCallback.onRedeemVoucherItemClicked(voucherDisplayModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-3  reason: not valid java name */
    public static final void m5784setListeners$lambda3(ApplyVoucherPageView applyVoucherPageView, VoucherDisplayModel voucherDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(applyVoucherPageView, "this$0");
        Intrinsics.checkNotNullParameter(voucherDisplayModel, "$model");
        ApplyVouchersViewPagerItemCallback applyVouchersViewPagerItemCallback = applyVoucherPageView.callback;
        if (applyVouchersViewPagerItemCallback != null) {
            applyVouchersViewPagerItemCallback.onRemoveVoucherItemClicked(voucherDisplayModel);
        }
    }

    private final void setRedeemSubTitle(VoucherDisplayModel voucherDisplayModel) {
        float minOrderValue = voucherDisplayModel.getVoucherData().getMinOrderValue();
        if (minOrderValue > 0.0f) {
            String subTitle = voucherDisplayModel.getSubTitle();
            String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(minOrderValue);
            String string = getContext().getString(com.talabat.localization.R.string.loyalty_min_order_value, new Object[]{subTitle, formattedCurrency});
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …edMinOrderValue\n        )");
            ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderSubTitleTextView)).setText(string);
        }
    }

    private final void showAction(PossibleVoucherAction possibleVoucherAction) {
        int i11 = R.id.applyVoucherViewHolderApplyButton;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(8);
        int i12 = R.id.applyVoucherViewHolderRedeemButton;
        ((TextView) _$_findCachedViewById(i12)).setVisibility(8);
        int i13 = R.id.applyVoucherViewHolderRemoveButton;
        ((TextView) _$_findCachedViewById(i13)).setVisibility(8);
        int i14 = WhenMappings.$EnumSwitchMapping$2[possibleVoucherAction.ordinal()];
        if (i14 == 1) {
            ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        } else if (i14 == 2) {
            ((TextView) _$_findCachedViewById(i12)).setVisibility(0);
        } else if (i14 == 3) {
            ((TextView) _$_findCachedViewById(i13)).setVisibility(0);
        }
    }

    private final void showAppliedMark() {
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderApplied)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderSubTitleTextView)).setVisibility(8);
    }

    private final void showAppliedMarkWithRestriction(String str) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderApplied);
        textView.setText(str);
        Context context = textView.getContext();
        int i11 = com.designsystem.marshmallow.R.color.ds_promo_100;
        textView.setTextColor(ContextCompat.getColor(context, i11));
        Drawable drawable = textView.getCompoundDrawablesRelative()[0];
        if (drawable != null) {
            Intrinsics.checkNotNullExpressionValue(drawable, "compoundDrawablesRelative[0]");
            drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(textView.getContext(), i11), PorterDuff.Mode.SRC_IN));
        }
        textView.setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderSubTitleTextView)).setVisibility(8);
    }

    private final void showApply() {
        updateTitleMaxLines(2);
        showAction(PossibleVoucherAction.APPLY);
        hideSubTitle();
    }

    private final void showRedeem(VoucherDisplayModel voucherDisplayModel) {
        updateTitleMaxLines(1);
        showAction(PossibleVoucherAction.REDEEM);
        setRedeemSubTitle(voucherDisplayModel);
        showSubTitle();
    }

    private final void showRemove(String str) {
        boolean z11 = true;
        updateTitleMaxLines(1);
        showAction(PossibleVoucherAction.REMOVE);
        if (!(str == null || str.length() == 0)) {
            z11 = false;
        }
        if (z11) {
            showAppliedMark();
        } else {
            showAppliedMarkWithRestriction(str);
        }
    }

    private final void showSubTitle() {
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderApplied)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderSubTitleTextView)).setVisibility(0);
    }

    private final void updateApplyVoucherViewHolderOfferIcon(VoucherOptionType voucherOptionType) {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.applyVoucherViewHolderOfferImageView);
        int i11 = WhenMappings.$EnumSwitchMapping$0[voucherOptionType.ordinal()];
        if (i11 == 1) {
            imageView.setImageResource(com.designsystem.marshmallow.R.drawable.ds_reward);
        } else if (i11 != 2) {
            imageView.setImageResource(com.designsystem.marshmallow.R.drawable.ds_voucher);
        } else {
            imageView.setImageResource(com.designsystem.marshmallow.R.drawable.ds_voucher);
        }
    }

    private final void updateTitleMaxLines(int i11) {
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderTitleTextView)).setMaxLines(i11);
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

    @Nullable
    public final ApplyVouchersViewPagerItemCallback getCallback() {
        return this.callback;
    }

    public final void populate(@NotNull VoucherDisplayModel voucherDisplayModel) {
        Intrinsics.checkNotNullParameter(voucherDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        setListeners(voucherDisplayModel);
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderTitleTextView)).setText(voucherDisplayModel.getTitle());
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewHolderSubTitleTextView)).setText(voucherDisplayModel.getSubTitle());
        updateApplyVoucherViewHolderOfferIcon(voucherDisplayModel.getVoucherData().getVoucherOptionType());
        if (voucherDisplayModel.isDisabled() && VoucherDataKt.isFreeDeliveryTypeVoucher(voucherDisplayModel.getVoucherData())) {
            disableFreeDeliveryTypeVoucher(voucherDisplayModel.getDisabledReason());
        } else if (voucherDisplayModel.isApplied()) {
            showRemove(voucherDisplayModel.getRestrictionDescription());
        } else if (voucherDisplayModel.getType() == VoucherType.VOUCHER) {
            showApply();
        } else if (voucherDisplayModel.getType() == VoucherType.REDEEM_OPTION) {
            showRedeem(voucherDisplayModel);
        }
    }

    public final void setCallback(@Nullable ApplyVouchersViewPagerItemCallback applyVouchersViewPagerItemCallback) {
        this.callback = applyVouchersViewPagerItemCallback;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherPageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_holder_apply_voucher, this, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherPageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_holder_apply_voucher, this, true);
    }
}
