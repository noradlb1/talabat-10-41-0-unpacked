package com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayStatusResultDto;", "", "isServiceDown", "", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayStatusResultDto;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayStatusResultDto {
    @SerializedName("isServiceDown")
    @Nullable
    private final Boolean isServiceDown;

    public QPayStatusResultDto() {
        this((Boolean) null, 1, (DefaultConstructorMarker) null);
    }

    public QPayStatusResultDto(@Nullable Boolean bool) {
        this.isServiceDown = bool;
    }

    public static /* synthetic */ QPayStatusResultDto copy$default(QPayStatusResultDto qPayStatusResultDto, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = qPayStatusResultDto.isServiceDown;
        }
        return qPayStatusResultDto.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.isServiceDown;
    }

    @NotNull
    public final QPayStatusResultDto copy(@Nullable Boolean bool) {
        return new QPayStatusResultDto(bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QPayStatusResultDto) && Intrinsics.areEqual((Object) this.isServiceDown, (Object) ((QPayStatusResultDto) obj).isServiceDown);
    }

    public int hashCode() {
        Boolean bool = this.isServiceDown;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    @Nullable
    public final Boolean isServiceDown() {
        return this.isServiceDown;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isServiceDown;
        return "QPayStatusResultDto(isServiceDown=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QPayStatusResultDto(Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool);
    }
}
