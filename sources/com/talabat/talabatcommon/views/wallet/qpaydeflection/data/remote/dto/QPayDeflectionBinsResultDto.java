package com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinsResultDto;", "", "binsDto", "", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinDto;", "savedCardExpiryDate", "", "(Ljava/util/List;Ljava/lang/String;)V", "getBinsDto", "()Ljava/util/List;", "getSavedCardExpiryDate", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayDeflectionBinsResultDto {
    @SerializedName("bins")
    @Nullable
    private final List<QPayDeflectionBinDto> binsDto;
    @SerializedName("savedcardExpiryDate")
    @Nullable
    private final String savedCardExpiryDate;

    public QPayDeflectionBinsResultDto() {
        this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public QPayDeflectionBinsResultDto(@Nullable List<QPayDeflectionBinDto> list, @Nullable String str) {
        this.binsDto = list;
        this.savedCardExpiryDate = str;
    }

    public static /* synthetic */ QPayDeflectionBinsResultDto copy$default(QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto, List<QPayDeflectionBinDto> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = qPayDeflectionBinsResultDto.binsDto;
        }
        if ((i11 & 2) != 0) {
            str = qPayDeflectionBinsResultDto.savedCardExpiryDate;
        }
        return qPayDeflectionBinsResultDto.copy(list, str);
    }

    @Nullable
    public final List<QPayDeflectionBinDto> component1() {
        return this.binsDto;
    }

    @Nullable
    public final String component2() {
        return this.savedCardExpiryDate;
    }

    @NotNull
    public final QPayDeflectionBinsResultDto copy(@Nullable List<QPayDeflectionBinDto> list, @Nullable String str) {
        return new QPayDeflectionBinsResultDto(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QPayDeflectionBinsResultDto)) {
            return false;
        }
        QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto = (QPayDeflectionBinsResultDto) obj;
        return Intrinsics.areEqual((Object) this.binsDto, (Object) qPayDeflectionBinsResultDto.binsDto) && Intrinsics.areEqual((Object) this.savedCardExpiryDate, (Object) qPayDeflectionBinsResultDto.savedCardExpiryDate);
    }

    @Nullable
    public final List<QPayDeflectionBinDto> getBinsDto() {
        return this.binsDto;
    }

    @Nullable
    public final String getSavedCardExpiryDate() {
        return this.savedCardExpiryDate;
    }

    public int hashCode() {
        List<QPayDeflectionBinDto> list = this.binsDto;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.savedCardExpiryDate;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        List<QPayDeflectionBinDto> list = this.binsDto;
        String str = this.savedCardExpiryDate;
        return "QPayDeflectionBinsResultDto(binsDto=" + list + ", savedCardExpiryDate=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QPayDeflectionBinsResultDto(List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str);
    }
}
