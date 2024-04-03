package com.talabat.growth.ui.vouchers.redeembottomsheet.model;

import android.content.Context;
import com.talabat.growth.ui.util.DisplayModelMapperUtilKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestVoucherDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"OUTPUT_DATE_FORMAT", "", "toRedeemVoucherBottomSheetDisplayModel", "Lcom/talabat/growth/ui/vouchers/redeembottomsheet/model/RedeemVoucherBottomSheetDisplayModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestVoucherDomainModel;", "context", "Landroid/content/Context;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/RedeemVoucherCodeDomainModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MapperKt {
    @NotNull
    public static final String OUTPUT_DATE_FORMAT = "LLLL dd, yyyy";

    @NotNull
    public static final RedeemVoucherBottomSheetDisplayModel toRedeemVoucherBottomSheetDisplayModel(@NotNull GuestVoucherDomainModel guestVoucherDomainModel, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(guestVoucherDomainModel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return new RedeemVoucherBottomSheetDisplayModel(guestVoucherDomainModel.getTitle(), guestVoucherDomainModel.getDescription(), guestVoucherDomainModel.getTag(), "", DisplayModelMapperUtilKt.getValidForDays(context, guestVoucherDomainModel.getValidTillDays()), DisplayModelMapperUtilKt.getMinOrderValue(context, guestVoucherDomainModel.getMinOrderValue()), guestVoucherDomainModel.getDeepLink(), guestVoucherDomainModel.getVoucherImage());
    }

    @NotNull
    public static final RedeemVoucherBottomSheetDisplayModel toRedeemVoucherBottomSheetDisplayModel(@NotNull RedeemVoucherCodeDomainModel redeemVoucherCodeDomainModel, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(redeemVoucherCodeDomainModel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String title = redeemVoucherCodeDomainModel.getTitle();
        String tag = redeemVoucherCodeDomainModel.getTag();
        String validTilDate = DisplayModelMapperUtilKt.getValidTilDate(context, redeemVoucherCodeDomainModel.getValidTil());
        return new RedeemVoucherBottomSheetDisplayModel(title, redeemVoucherCodeDomainModel.getDescription(), tag, validTilDate, "", DisplayModelMapperUtilKt.getMinOrderValue(context, redeemVoucherCodeDomainModel.getMinOrderValue()), redeemVoucherCodeDomainModel.getDeepLink(), redeemVoucherCodeDomainModel.getVoucherImage());
    }
}
