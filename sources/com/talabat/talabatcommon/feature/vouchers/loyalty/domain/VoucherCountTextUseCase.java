package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import android.content.Context;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.localization.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/VoucherCountTextUseCase;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "invoke", "", "voucherCount", "", "parseArabicVoucherCount", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherCountTextUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ONE = 1;
    public static final int TEN = 10;
    public static final int THREE = 3;
    public static final int TWO = 2;
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/VoucherCountTextUseCase$Companion;", "", "()V", "ONE", "", "TEN", "THREE", "TWO", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public VoucherCountTextUseCase(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final String parseArabicVoucherCount(int i11) {
        boolean z11 = true;
        if (i11 == 1) {
            String string = this.context.getString(R.string.one_voucher);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.one_voucher)");
            return string;
        } else if (i11 == 2) {
            String string2 = this.context.getString(R.string.dual_voucher);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.dual_voucher)");
            return string2;
        } else {
            if (3 > i11 || i11 >= 11) {
                z11 = false;
            }
            if (z11) {
                return i11 + " " + this.context.getString(R.string.vouchers_small_capital);
            }
            return i11 + " " + this.context.getString(R.string.voucher);
        }
    }

    @NotNull
    public final String invoke(int i11) {
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        if (companion.isArabic()) {
            return parseArabicVoucherCount(i11);
        }
        if (companion.isKurdish()) {
            String string = this.context.getString(R.string.voucher);
            return i11 + " " + string;
        } else if (i11 == 1) {
            String string2 = this.context.getString(R.string.voucher);
            return i11 + " " + string2;
        } else {
            String string3 = this.context.getString(R.string.vouchers_small_capital);
            return i11 + " " + string3;
        }
    }
}
