package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import android.content.Context;
import buisnessmodels.TalabatFormatter;
import com.talabat.localization.R;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.ServerError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\t"}, d2 = {"handleLowerThanAcceptedAmount", "", "context", "Landroid/content/Context;", "failure", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$OrderLowerThanMinAcceptedAmount;", "handleOtherErrors", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "getUserErrorMessage", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ApplyVouchersViewUserErrorMapperKt {
    @Nullable
    public static final String getUserErrorMessage(@NotNull VoucherFailures voucherFailures, @NotNull Context context) {
        String str;
        boolean z11;
        Intrinsics.checkNotNullParameter(voucherFailures, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if ((voucherFailures instanceof VoucherFailures.FailToApplyVoucher) || (voucherFailures instanceof VoucherFailures.FailToLoadFreeVoucherItems)) {
            Failure dataFailure = voucherFailures.getDataFailure();
            String str2 = null;
            if (dataFailure != null) {
                str = dataFailure.getMessage();
            } else {
                str = null;
            }
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (true ^ z11) {
                str2 = str;
            }
            if (str2 != null) {
                return str2;
            }
            String string = context.getString(R.string.apply_voucher_item_error);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …m_error\n                )");
            return string;
        } else if (voucherFailures instanceof VoucherFailures.TargetedItemMissed) {
            return context.getString(R.string.apply_voucher_missing_targeted_items_general_error_message);
        } else {
            if (voucherFailures instanceof VoucherFailures.OrderLowerThanMinAcceptedAmount) {
                return handleLowerThanAcceptedAmount(context, (VoucherFailures.OrderLowerThanMinAcceptedAmount) voucherFailures);
            }
            if (voucherFailures instanceof VoucherFailures.FailToLoadGuestVoucher) {
                return context.getString(R.string.voucher_invalid_or_expired);
            }
            return handleOtherErrors(context, voucherFailures);
        }
    }

    @Nullable
    public static final String handleLowerThanAcceptedAmount(@NotNull Context context, @NotNull VoucherFailures.OrderLowerThanMinAcceptedAmount orderLowerThanMinAcceptedAmount) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orderLowerThanMinAcceptedAmount, "failure");
        Float valueOf = Float.valueOf(orderLowerThanMinAcceptedAmount.getReamingAmount());
        if (valueOf.floatValue() > 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        valueOf.floatValue();
        return context.getResources().getString(R.string.minimum_order_error_loyalty, new Object[]{TalabatFormatter.getInstance().getFormattedCurrency(orderLowerThanMinAcceptedAmount.getReamingAmount(), true)});
    }

    @NotNull
    public static final String handleOtherErrors(@NotNull Context context, @NotNull VoucherFailures voucherFailures) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(voucherFailures, "failure");
        Failure dataFailure = voucherFailures.getDataFailure();
        if (dataFailure != null) {
            if (dataFailure instanceof ServerError) {
                ServerError serverError = (ServerError) dataFailure;
                if (!StringsKt__StringsJVMKt.isBlank(serverError.getMessage())) {
                    str = serverError.getMessage();
                } else {
                    str = context.getString(R.string.server_error_msg);
                    Intrinsics.checkNotNullExpressionValue(str, "{\n                    co…or_msg)\n                }");
                }
            } else if (dataFailure instanceof Failure.NetworkConnection) {
                str = context.getString(R.string.no_net_reasontxt);
                Intrinsics.checkNotNullExpressionValue(str, "{\n                contex…_reasontxt)\n            }");
            } else {
                str = context.getString(R.string.server_error_msg);
                Intrinsics.checkNotNullExpressionValue(str, "context.getString(com.ta….string.server_error_msg)");
            }
            if (str != null) {
                return str;
            }
        }
        String string = context.getString(R.string.server_error_msg);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta….string.server_error_msg)");
        return string;
    }
}
