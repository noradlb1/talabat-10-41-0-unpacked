package com.talabat.talabatcommon.feature.vouchers.loyalty.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/RedeemTrackData;", "", "voucherName", "", "userId", "", "(Ljava/lang/String;I)V", "getUserId", "()I", "getVoucherName", "()Ljava/lang/String;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemTrackData {
    private final int userId;
    @NotNull
    private final String voucherName;

    public RedeemTrackData(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "voucherName");
        this.voucherName = str;
        this.userId = i11;
    }

    public final int getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getVoucherName() {
        return this.voucherName;
    }
}
