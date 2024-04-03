package com.talabat.wallet.bnplmanager.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRemoteDto;", "", "installmentAmount", "", "installmentDate", "", "(Ljava/lang/Float;Ljava/lang/String;)V", "getInstallmentAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getInstallmentDate", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/String;)Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRemoteDto;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLInstallmentRemoteDto {
    @SerializedName("installmentAmount")
    @Nullable
    private final Float installmentAmount;
    @SerializedName("installmentDate")
    @Nullable
    private final String installmentDate;

    public BNPLInstallmentRemoteDto() {
        this((Float) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public BNPLInstallmentRemoteDto(@Nullable Float f11, @Nullable String str) {
        this.installmentAmount = f11;
        this.installmentDate = str;
    }

    public static /* synthetic */ BNPLInstallmentRemoteDto copy$default(BNPLInstallmentRemoteDto bNPLInstallmentRemoteDto, Float f11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = bNPLInstallmentRemoteDto.installmentAmount;
        }
        if ((i11 & 2) != 0) {
            str = bNPLInstallmentRemoteDto.installmentDate;
        }
        return bNPLInstallmentRemoteDto.copy(f11, str);
    }

    @Nullable
    public final Float component1() {
        return this.installmentAmount;
    }

    @Nullable
    public final String component2() {
        return this.installmentDate;
    }

    @NotNull
    public final BNPLInstallmentRemoteDto copy(@Nullable Float f11, @Nullable String str) {
        return new BNPLInstallmentRemoteDto(f11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLInstallmentRemoteDto)) {
            return false;
        }
        BNPLInstallmentRemoteDto bNPLInstallmentRemoteDto = (BNPLInstallmentRemoteDto) obj;
        return Intrinsics.areEqual((Object) this.installmentAmount, (Object) bNPLInstallmentRemoteDto.installmentAmount) && Intrinsics.areEqual((Object) this.installmentDate, (Object) bNPLInstallmentRemoteDto.installmentDate);
    }

    @Nullable
    public final Float getInstallmentAmount() {
        return this.installmentAmount;
    }

    @Nullable
    public final String getInstallmentDate() {
        return this.installmentDate;
    }

    public int hashCode() {
        Float f11 = this.installmentAmount;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        String str = this.installmentDate;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Float f11 = this.installmentAmount;
        String str = this.installmentDate;
        return "BNPLInstallmentRemoteDto(installmentAmount=" + f11 + ", installmentDate=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLInstallmentRemoteDto(Float f11, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : f11, (i11 & 2) != 0 ? null : str);
    }
}
