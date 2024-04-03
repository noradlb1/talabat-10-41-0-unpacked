package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVouchersView$vouchersViewCallback$1$onApplyVoucherItemClicked$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ApplyVouchersView f11762g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ VoucherDisplayModel f11763h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVouchersView$vouchersViewCallback$1$onApplyVoucherItemClicked$1$1(ApplyVouchersView applyVouchersView, VoucherDisplayModel voucherDisplayModel) {
        super(0);
        this.f11762g = applyVouchersView;
        this.f11763h = voucherDisplayModel;
    }

    public final void invoke() {
        ApplyVoucherViewModel applyVoucherViewModel = (ApplyVoucherViewModel) this.f11762g.getViewModel();
        ApplyVouchersViewCallback access$getCallback$p = this.f11762g.callback;
        ApplyVouchersViewCallback applyVouchersViewCallback = null;
        if (access$getCallback$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            access$getCallback$p = null;
        }
        String restaurantId = access$getCallback$p.getRestaurantId();
        ApplyVouchersViewCallback access$getCallback$p2 = this.f11762g.callback;
        if (access$getCallback$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            access$getCallback$p2 = null;
        }
        String branchId = access$getCallback$p2.getBranchId();
        ApplyVouchersViewCallback access$getCallback$p3 = this.f11762g.callback;
        if (access$getCallback$p3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            access$getCallback$p3 = null;
        }
        String groceryVendorId = access$getCallback$p3.getGroceryVendorId();
        if (groceryVendorId == null) {
            groceryVendorId = "";
        }
        String str = groceryVendorId;
        ApplyVouchersViewCallback access$getCallback$p4 = this.f11762g.callback;
        if (access$getCallback$p4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            access$getCallback$p4 = null;
        }
        float cartSubtotalForVoucherMov = access$getCallback$p4.getCartSubtotalForVoucherMov();
        ApplyVouchersViewCallback access$getCallback$p5 = this.f11762g.callback;
        if (access$getCallback$p5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        } else {
            applyVouchersViewCallback = access$getCallback$p5;
        }
        applyVoucherViewModel.dispatchAction(new ApplyVouchersActions.ApplyVoucherAction(this.f11763h, branchId, cartSubtotalForVoucherMov, restaurantId, str, applyVouchersViewCallback.getCartItem(), this.f11762g.getVerticalId()));
    }
}
