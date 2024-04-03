package com.talabat.feature.tpro.presentation.payment;

import androidx.fragment.app.FragmentActivity;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t¨\u0006\u000e"}, d2 = {"showPaymentBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "activity", "Landroidx/fragment/app/FragmentActivity;", "tproPlan", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "isReactivate", "", "voucherCode", "", "showPaymentBottomSheetFromOTP", "", "orderId", "deliveryFee", "com_talabat_feature_tpro_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TProPaymentBottomSheetFragmentKt {
    @NotNull
    public static final DSBottomSheet showPaymentBottomSheet(@NotNull FragmentActivity fragmentActivity, @NotNull TProPlanDisplayModel tProPlanDisplayModel, boolean z11, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(tProPlanDisplayModel, "tproPlan");
        DSBottomSheet dSBottomSheet = new DSBottomSheet();
        dSBottomSheet.setBody(TProPaymentBottomSheetFragment.Companion.getInstance$default(TProPaymentBottomSheetFragment.Companion, tProPlanDisplayModel, z11, dSBottomSheet, str, false, (String) null, (String) null, 112, (Object) null));
        dSBottomSheet.show(fragmentActivity.getSupportFragmentManager(), TProPaymentBottomSheetFragment.TAG);
        return dSBottomSheet;
    }

    public static /* synthetic */ DSBottomSheet showPaymentBottomSheet$default(FragmentActivity fragmentActivity, TProPlanDisplayModel tProPlanDisplayModel, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str = "";
        }
        return showPaymentBottomSheet(fragmentActivity, tProPlanDisplayModel, z11, str);
    }

    public static final void showPaymentBottomSheetFromOTP(@NotNull FragmentActivity fragmentActivity, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "deliveryFee");
        DSBottomSheet dSBottomSheet = new DSBottomSheet();
        dSBottomSheet.setBody(TProPaymentBottomSheetFragment.Companion.getInstance$default(TProPaymentBottomSheetFragment.Companion, (TProPlanDisplayModel) null, false, dSBottomSheet, (String) null, true, str, str2, 11, (Object) null));
        dSBottomSheet.show(fragmentActivity.getSupportFragmentManager(), TProPaymentBottomSheetFragment.TAG);
    }
}
