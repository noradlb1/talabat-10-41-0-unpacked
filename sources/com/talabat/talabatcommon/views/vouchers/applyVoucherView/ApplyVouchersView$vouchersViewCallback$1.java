package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import android.content.Context;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.core.tracking.data.events.rewards.RedeemEventParams;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersActions;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.ApplyVouchersViewPagerItemCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVouchersView$vouchersViewCallback$1", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/ApplyVouchersViewPagerItemCallback;", "onApplyVoucherItemClicked", "", "myPossibleVoucherDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "onRedeemVoucherItemClicked", "model", "onRemoveVoucherItemClicked", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyVouchersView$vouchersViewCallback$1 implements ApplyVouchersViewPagerItemCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ApplyVouchersView f11761a;

    public ApplyVouchersView$vouchersViewCallback$1(ApplyVouchersView applyVouchersView) {
        this.f11761a = applyVouchersView;
    }

    public void onApplyVoucherItemClicked(@NotNull VoucherDisplayModel voucherDisplayModel) {
        Intrinsics.checkNotNullParameter(voucherDisplayModel, "myPossibleVoucherDisplayModel");
        Context context = this.f11761a.getContext();
        if (context != null) {
            DialogUtilKt.showAlertDialog$default(context, 0, voucherDisplayModel.getTitle(), voucherDisplayModel.getSubTitle(), R.string.apply_voucher_confirm, new ApplyVouchersView$vouchersViewCallback$1$onApplyVoucherItemClicked$1$1(this.f11761a, voucherDisplayModel), R.string.apply_voucher_not_now, (Function0) null, 130, (Object) null);
        }
    }

    public void onRedeemVoucherItemClicked(@NotNull VoucherDisplayModel voucherDisplayModel) {
        String str;
        Intrinsics.checkNotNullParameter(voucherDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        GrowthTracker growthTracker = this.f11761a.getGrowthTracker();
        ApplyVoucherOwner access$getApplyVoucherOwner$p = this.f11761a.applyVoucherOwner;
        if (access$getApplyVoucherOwner$p == null || (str = access$getApplyVoucherOwner$p.getScreenName()) == null) {
            str = "";
        }
        growthTracker.onRedeemVoucherClicked(str, "", voucherDisplayModel.getVoucherData().getTitle(), RedeemEventParams.ScreenType.CART, voucherDisplayModel.getId());
        Context context = this.f11761a.getContext();
        if (context != null) {
            ApplyVouchersView applyVouchersView = this.f11761a;
            DialogUtilKt.showAlertDialog$default(context, 0, ViewKt.getString(applyVouchersView, R.string.apply_voucher_confirm_claim), String.valueOf(applyVouchersView.getRedeemConfirmationMessage(voucherDisplayModel)), R.string.apply_voucher_confirm, new ApplyVouchersView$vouchersViewCallback$1$onRedeemVoucherItemClicked$1$1(applyVouchersView, voucherDisplayModel), R.string.apply_voucher_not_now, new ApplyVouchersView$vouchersViewCallback$1$onRedeemVoucherItemClicked$1$2(applyVouchersView, voucherDisplayModel), 2, (Object) null);
        }
    }

    public void onRemoveVoucherItemClicked(@NotNull VoucherDisplayModel voucherDisplayModel) {
        Intrinsics.checkNotNullParameter(voucherDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        ApplyVoucherViewModel applyVoucherViewModel = (ApplyVoucherViewModel) this.f11761a.getViewModel();
        ApplyVouchersViewCallback access$getCallback$p = this.f11761a.callback;
        ApplyVouchersViewCallback applyVouchersViewCallback = null;
        if (access$getCallback$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            access$getCallback$p = null;
        }
        float cartSubtotalForVoucherMov = access$getCallback$p.getCartSubtotalForVoucherMov();
        ApplyVouchersViewCallback access$getCallback$p2 = this.f11761a.callback;
        if (access$getCallback$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        } else {
            applyVouchersViewCallback = access$getCallback$p2;
        }
        applyVoucherViewModel.dispatchAction(new ApplyVouchersActions.UnApplyVoucherAction(false, cartSubtotalForVoucherMov, applyVouchersViewCallback.getCartItem(), 1, (DefaultConstructorMarker) null));
    }
}
