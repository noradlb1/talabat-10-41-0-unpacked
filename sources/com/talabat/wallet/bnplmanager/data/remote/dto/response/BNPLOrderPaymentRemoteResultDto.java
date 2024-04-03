package com.talabat.wallet.bnplmanager.data.remote.dto.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentRemoteResultDto;", "", "bNPLOrderPaymentErrorRemoteDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentErrorRemoteDto;", "paymentStatus", "", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentErrorRemoteDto;Ljava/lang/Integer;)V", "getBNPLOrderPaymentErrorRemoteDto", "()Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentErrorRemoteDto;", "getPaymentStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentErrorRemoteDto;Ljava/lang/Integer;)Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentRemoteResultDto;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLOrderPaymentRemoteResultDto {
    @SerializedName("paymentError")
    @Nullable
    private final BNPLOrderPaymentErrorRemoteDto bNPLOrderPaymentErrorRemoteDto;
    @SerializedName("paymentStatus")
    @Nullable
    private final Integer paymentStatus;

    public BNPLOrderPaymentRemoteResultDto() {
        this((BNPLOrderPaymentErrorRemoteDto) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public BNPLOrderPaymentRemoteResultDto(@Nullable BNPLOrderPaymentErrorRemoteDto bNPLOrderPaymentErrorRemoteDto2, @Nullable Integer num) {
        this.bNPLOrderPaymentErrorRemoteDto = bNPLOrderPaymentErrorRemoteDto2;
        this.paymentStatus = num;
    }

    public static /* synthetic */ BNPLOrderPaymentRemoteResultDto copy$default(BNPLOrderPaymentRemoteResultDto bNPLOrderPaymentRemoteResultDto, BNPLOrderPaymentErrorRemoteDto bNPLOrderPaymentErrorRemoteDto2, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bNPLOrderPaymentErrorRemoteDto2 = bNPLOrderPaymentRemoteResultDto.bNPLOrderPaymentErrorRemoteDto;
        }
        if ((i11 & 2) != 0) {
            num = bNPLOrderPaymentRemoteResultDto.paymentStatus;
        }
        return bNPLOrderPaymentRemoteResultDto.copy(bNPLOrderPaymentErrorRemoteDto2, num);
    }

    @Nullable
    public final BNPLOrderPaymentErrorRemoteDto component1() {
        return this.bNPLOrderPaymentErrorRemoteDto;
    }

    @Nullable
    public final Integer component2() {
        return this.paymentStatus;
    }

    @NotNull
    public final BNPLOrderPaymentRemoteResultDto copy(@Nullable BNPLOrderPaymentErrorRemoteDto bNPLOrderPaymentErrorRemoteDto2, @Nullable Integer num) {
        return new BNPLOrderPaymentRemoteResultDto(bNPLOrderPaymentErrorRemoteDto2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLOrderPaymentRemoteResultDto)) {
            return false;
        }
        BNPLOrderPaymentRemoteResultDto bNPLOrderPaymentRemoteResultDto = (BNPLOrderPaymentRemoteResultDto) obj;
        return Intrinsics.areEqual((Object) this.bNPLOrderPaymentErrorRemoteDto, (Object) bNPLOrderPaymentRemoteResultDto.bNPLOrderPaymentErrorRemoteDto) && Intrinsics.areEqual((Object) this.paymentStatus, (Object) bNPLOrderPaymentRemoteResultDto.paymentStatus);
    }

    @Nullable
    public final BNPLOrderPaymentErrorRemoteDto getBNPLOrderPaymentErrorRemoteDto() {
        return this.bNPLOrderPaymentErrorRemoteDto;
    }

    @Nullable
    public final Integer getPaymentStatus() {
        return this.paymentStatus;
    }

    public int hashCode() {
        BNPLOrderPaymentErrorRemoteDto bNPLOrderPaymentErrorRemoteDto2 = this.bNPLOrderPaymentErrorRemoteDto;
        int i11 = 0;
        int hashCode = (bNPLOrderPaymentErrorRemoteDto2 == null ? 0 : bNPLOrderPaymentErrorRemoteDto2.hashCode()) * 31;
        Integer num = this.paymentStatus;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        BNPLOrderPaymentErrorRemoteDto bNPLOrderPaymentErrorRemoteDto2 = this.bNPLOrderPaymentErrorRemoteDto;
        Integer num = this.paymentStatus;
        return "BNPLOrderPaymentRemoteResultDto(bNPLOrderPaymentErrorRemoteDto=" + bNPLOrderPaymentErrorRemoteDto2 + ", paymentStatus=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLOrderPaymentRemoteResultDto(BNPLOrderPaymentErrorRemoteDto bNPLOrderPaymentErrorRemoteDto2, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bNPLOrderPaymentErrorRemoteDto2, (i11 & 2) != 0 ? null : num);
    }
}
