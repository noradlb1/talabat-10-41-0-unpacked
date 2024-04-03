package com.talabat.growth.ui.vouchers.list;

import androidx.annotation.VisibleForTesting;
import com.designsystem.ds_list_item_v2.DSListItem;
import com.talabat.growth.R;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter;
import com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"onItemClick", "", "Lcom/talabat/growth/ui/vouchers/list/VoucherItemViewHolder;", "voucherItemDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/bottomSheetButton/model/VoucherItemDisplayModel;", "onItemClicked", "Lkotlin/Function1;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VouchersListAdapterKt {
    @VisibleForTesting
    public static final void onItemClick(@NotNull VoucherItemViewHolder voucherItemViewHolder, @NotNull VoucherItemDisplayModel voucherItemDisplayModel, @Nullable Function1<? super VoucherItemDisplayModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(voucherItemViewHolder, "<this>");
        Intrinsics.checkNotNullParameter(voucherItemDisplayModel, "voucherItemDisplayModel");
        LogManager.debug("onItemClick: >> " + voucherItemDisplayModel);
        if (voucherItemDisplayModel.getStatus() == VouchersStatusFilter.ACTIVE) {
            ((DSListItem) voucherItemViewHolder.itemView.findViewById(R.id.voucherListItem)).setOnTap(new VouchersListAdapterKt$onItemClick$1(function1, voucherItemDisplayModel));
        } else {
            ((DSListItem) voucherItemViewHolder.itemView.findViewById(R.id.voucherListItem)).setOnTap(VouchersListAdapterKt$onItemClick$2.INSTANCE);
        }
    }
}
