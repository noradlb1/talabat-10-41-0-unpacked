package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import datamodels.CartMenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\b\u0010\u000b\u001a\u00020\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u001e\u0010\u0013\u001a\u00020\u00032\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0016H&J\b\u0010\u001a\u001a\u00020\u0003H&¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVouchersViewCallback;", "", "applyVouchersViewFailure", "", "applyVoucherViewFailure", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "getBranchId", "", "getCartItem", "", "Ldatamodels/CartMenuItem;", "getCartSubtotalForVoucherMov", "", "getGroceryVendorId", "getRestaurantId", "getVerticalId", "", "()Ljava/lang/Integer;", "redirectToLogin", "successApplyFreeItemVoucher", "voucherFreeItemResult", "Lkotlin/Pair;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "successApplyVoucher", "voucherData", "unAppliedAllVouchers", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ApplyVouchersViewCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void applyVouchersViewFailure(@NotNull ApplyVouchersViewCallback applyVouchersViewCallback, @NotNull VoucherFailures voucherFailures) {
            Intrinsics.checkNotNullParameter(voucherFailures, "applyVoucherViewFailure");
        }

        @NotNull
        public static String getBranchId(@NotNull ApplyVouchersViewCallback applyVouchersViewCallback) {
            return StringUtils.empty(StringCompanionObject.INSTANCE);
        }

        @Nullable
        public static List<CartMenuItem> getCartItem(@NotNull ApplyVouchersViewCallback applyVouchersViewCallback) {
            return null;
        }

        @Nullable
        public static String getGroceryVendorId(@NotNull ApplyVouchersViewCallback applyVouchersViewCallback) {
            return null;
        }

        @NotNull
        public static String getRestaurantId(@NotNull ApplyVouchersViewCallback applyVouchersViewCallback) {
            return StringUtils.empty(StringCompanionObject.INSTANCE);
        }

        @Nullable
        public static Integer getVerticalId(@NotNull ApplyVouchersViewCallback applyVouchersViewCallback) {
            return null;
        }

        public static void redirectToLogin(@NotNull ApplyVouchersViewCallback applyVouchersViewCallback) {
        }
    }

    void applyVouchersViewFailure(@NotNull VoucherFailures voucherFailures);

    @NotNull
    String getBranchId();

    @Nullable
    List<CartMenuItem> getCartItem();

    float getCartSubtotalForVoucherMov();

    @Nullable
    String getGroceryVendorId();

    @NotNull
    String getRestaurantId();

    @Nullable
    Integer getVerticalId();

    void redirectToLogin();

    void successApplyFreeItemVoucher(@NotNull Pair<VoucherData, VoucherItemsDisplayModel> pair);

    void successApplyVoucher(@NotNull VoucherData voucherData);

    void unAppliedAllVouchers();
}
