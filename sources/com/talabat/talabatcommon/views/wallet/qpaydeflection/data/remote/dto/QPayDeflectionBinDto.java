package com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0004\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinDto;", "", "binNumber", "", "isQPayBin", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getBinNumber", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinDto;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayDeflectionBinDto {
    @SerializedName("binNumber")
    @Nullable
    private final String binNumber;
    @SerializedName("isQPayBin")
    @Nullable
    private final Boolean isQPayBin;

    public QPayDeflectionBinDto() {
        this((String) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
    }

    public QPayDeflectionBinDto(@Nullable String str, @Nullable Boolean bool) {
        this.binNumber = str;
        this.isQPayBin = bool;
    }

    public static /* synthetic */ QPayDeflectionBinDto copy$default(QPayDeflectionBinDto qPayDeflectionBinDto, String str, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = qPayDeflectionBinDto.binNumber;
        }
        if ((i11 & 2) != 0) {
            bool = qPayDeflectionBinDto.isQPayBin;
        }
        return qPayDeflectionBinDto.copy(str, bool);
    }

    @Nullable
    public final String component1() {
        return this.binNumber;
    }

    @Nullable
    public final Boolean component2() {
        return this.isQPayBin;
    }

    @NotNull
    public final QPayDeflectionBinDto copy(@Nullable String str, @Nullable Boolean bool) {
        return new QPayDeflectionBinDto(str, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QPayDeflectionBinDto)) {
            return false;
        }
        QPayDeflectionBinDto qPayDeflectionBinDto = (QPayDeflectionBinDto) obj;
        return Intrinsics.areEqual((Object) this.binNumber, (Object) qPayDeflectionBinDto.binNumber) && Intrinsics.areEqual((Object) this.isQPayBin, (Object) qPayDeflectionBinDto.isQPayBin);
    }

    @Nullable
    public final String getBinNumber() {
        return this.binNumber;
    }

    public int hashCode() {
        String str = this.binNumber;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isQPayBin;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode + i11;
    }

    @Nullable
    public final Boolean isQPayBin() {
        return this.isQPayBin;
    }

    @NotNull
    public String toString() {
        String str = this.binNumber;
        Boolean bool = this.isQPayBin;
        return "QPayDeflectionBinDto(binNumber=" + str + ", isQPayBin=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QPayDeflectionBinDto(String str, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : bool);
    }
}
