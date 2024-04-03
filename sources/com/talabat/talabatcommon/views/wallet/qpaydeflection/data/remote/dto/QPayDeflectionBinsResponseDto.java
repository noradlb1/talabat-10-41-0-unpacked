package com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinsResponseDto;", "", "qPayDeflectionBinsResultDto", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinsResultDto;", "(Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinsResultDto;)V", "getQPayDeflectionBinsResultDto", "()Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinsResultDto;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayDeflectionBinsResponseDto {
    @SerializedName("result")
    @Nullable
    private final QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto;

    public QPayDeflectionBinsResponseDto() {
        this((QPayDeflectionBinsResultDto) null, 1, (DefaultConstructorMarker) null);
    }

    public QPayDeflectionBinsResponseDto(@Nullable QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto2) {
        this.qPayDeflectionBinsResultDto = qPayDeflectionBinsResultDto2;
    }

    public static /* synthetic */ QPayDeflectionBinsResponseDto copy$default(QPayDeflectionBinsResponseDto qPayDeflectionBinsResponseDto, QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qPayDeflectionBinsResultDto2 = qPayDeflectionBinsResponseDto.qPayDeflectionBinsResultDto;
        }
        return qPayDeflectionBinsResponseDto.copy(qPayDeflectionBinsResultDto2);
    }

    @Nullable
    public final QPayDeflectionBinsResultDto component1() {
        return this.qPayDeflectionBinsResultDto;
    }

    @NotNull
    public final QPayDeflectionBinsResponseDto copy(@Nullable QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto2) {
        return new QPayDeflectionBinsResponseDto(qPayDeflectionBinsResultDto2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QPayDeflectionBinsResponseDto) && Intrinsics.areEqual((Object) this.qPayDeflectionBinsResultDto, (Object) ((QPayDeflectionBinsResponseDto) obj).qPayDeflectionBinsResultDto);
    }

    @Nullable
    public final QPayDeflectionBinsResultDto getQPayDeflectionBinsResultDto() {
        return this.qPayDeflectionBinsResultDto;
    }

    public int hashCode() {
        QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto2 = this.qPayDeflectionBinsResultDto;
        if (qPayDeflectionBinsResultDto2 == null) {
            return 0;
        }
        return qPayDeflectionBinsResultDto2.hashCode();
    }

    @NotNull
    public String toString() {
        QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto2 = this.qPayDeflectionBinsResultDto;
        return "QPayDeflectionBinsResponseDto(qPayDeflectionBinsResultDto=" + qPayDeflectionBinsResultDto2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QPayDeflectionBinsResponseDto(QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : qPayDeflectionBinsResultDto2);
    }
}
