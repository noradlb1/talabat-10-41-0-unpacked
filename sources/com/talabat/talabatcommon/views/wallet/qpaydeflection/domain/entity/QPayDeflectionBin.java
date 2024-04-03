package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity;

import com.talabat.mapper.ModelMapping;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/QPayDeflectionBin;", "", "binNumber", "", "isQPayBin", "", "(Ljava/lang/String;Z)V", "getBinNumber", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayDeflectionBin {
    @NotNull
    @ModelMapping({"binNumber"})
    private final String binNumber;
    @ModelMapping({"isQPayBin"})
    private final boolean isQPayBin;

    public QPayDeflectionBin() {
        this((String) null, false, 3, (DefaultConstructorMarker) null);
    }

    public QPayDeflectionBin(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "binNumber");
        this.binNumber = str;
        this.isQPayBin = z11;
    }

    public static /* synthetic */ QPayDeflectionBin copy$default(QPayDeflectionBin qPayDeflectionBin, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = qPayDeflectionBin.binNumber;
        }
        if ((i11 & 2) != 0) {
            z11 = qPayDeflectionBin.isQPayBin;
        }
        return qPayDeflectionBin.copy(str, z11);
    }

    @NotNull
    public final String component1() {
        return this.binNumber;
    }

    public final boolean component2() {
        return this.isQPayBin;
    }

    @NotNull
    public final QPayDeflectionBin copy(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "binNumber");
        return new QPayDeflectionBin(str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QPayDeflectionBin)) {
            return false;
        }
        QPayDeflectionBin qPayDeflectionBin = (QPayDeflectionBin) obj;
        return Intrinsics.areEqual((Object) this.binNumber, (Object) qPayDeflectionBin.binNumber) && this.isQPayBin == qPayDeflectionBin.isQPayBin;
    }

    @NotNull
    public final String getBinNumber() {
        return this.binNumber;
    }

    public int hashCode() {
        int hashCode = this.binNumber.hashCode() * 31;
        boolean z11 = this.isQPayBin;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isQPayBin() {
        return this.isQPayBin;
    }

    @NotNull
    public String toString() {
        String str = this.binNumber;
        boolean z11 = this.isQPayBin;
        return "QPayDeflectionBin(binNumber=" + str + ", isQPayBin=" + z11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QPayDeflectionBin(String str, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? false : z11);
    }
}
