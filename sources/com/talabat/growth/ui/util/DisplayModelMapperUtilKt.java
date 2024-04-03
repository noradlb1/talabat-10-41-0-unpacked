package com.talabat.growth.ui.util;

import android.content.Context;
import buisnessmodels.TalabatFormatter;
import com.talabat.localization.R;
import com.talabat.talabatcommon.utils.DateUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b\u001a\u0016\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0001¨\u0006\u000b"}, d2 = {"getMinOrderValue", "", "context", "Landroid/content/Context;", "minOrderValue", "", "getValidForDays", "validTilDays", "", "getValidTilDate", "validTilDate", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DisplayModelMapperUtilKt {
    @NotNull
    public static final String getMinOrderValue(@NotNull Context context, float f11) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.voucher_sheet_min_order_amount, new Object[]{TalabatFormatter.getInstance().getFormattedCurrency(f11, true)});
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …inOrderValue, true)\n    )");
        return string;
    }

    @NotNull
    public static final String getValidForDays(@NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.valid_for, new Object[]{Integer.valueOf(i11)});
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta….valid_for, validTilDays)");
        return string;
    }

    @NotNull
    public static final String getValidTilDate(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "validTilDate");
        String string = context.getString(R.string.valid_till, new Object[]{DateUtils.Companion.getLocalizedFormattedDateString(str, "LLLL dd, yyyy")});
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ate, OUTPUT_DATE_FORMAT))");
        return string;
    }
}
