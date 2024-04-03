package com.talabat.wallet.bnplmanager.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ2\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0006\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteResultDto;", "", "bNPLValidationError", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLValidationErrorDto;", "isHideBNPLPaymentMethod", "", "isBNPLEligible", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLValidationErrorDto;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBNPLValidationError", "()Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLValidationErrorDto;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLValidationErrorDto;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteResultDto;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLEligibilityRemoteResultDto {
    @SerializedName("validationError")
    @Nullable
    private final BNPLValidationErrorDto bNPLValidationError;
    @SerializedName("isBNPLEligible")
    @Nullable
    private final Boolean isBNPLEligible;
    @SerializedName("isHideBNPLPaymentMethod")
    @Nullable
    private final Boolean isHideBNPLPaymentMethod;

    public BNPLEligibilityRemoteResultDto() {
        this((BNPLValidationErrorDto) null, (Boolean) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    public BNPLEligibilityRemoteResultDto(@Nullable BNPLValidationErrorDto bNPLValidationErrorDto, @Nullable Boolean bool, @Nullable Boolean bool2) {
        this.bNPLValidationError = bNPLValidationErrorDto;
        this.isHideBNPLPaymentMethod = bool;
        this.isBNPLEligible = bool2;
    }

    public static /* synthetic */ BNPLEligibilityRemoteResultDto copy$default(BNPLEligibilityRemoteResultDto bNPLEligibilityRemoteResultDto, BNPLValidationErrorDto bNPLValidationErrorDto, Boolean bool, Boolean bool2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bNPLValidationErrorDto = bNPLEligibilityRemoteResultDto.bNPLValidationError;
        }
        if ((i11 & 2) != 0) {
            bool = bNPLEligibilityRemoteResultDto.isHideBNPLPaymentMethod;
        }
        if ((i11 & 4) != 0) {
            bool2 = bNPLEligibilityRemoteResultDto.isBNPLEligible;
        }
        return bNPLEligibilityRemoteResultDto.copy(bNPLValidationErrorDto, bool, bool2);
    }

    @Nullable
    public final BNPLValidationErrorDto component1() {
        return this.bNPLValidationError;
    }

    @Nullable
    public final Boolean component2() {
        return this.isHideBNPLPaymentMethod;
    }

    @Nullable
    public final Boolean component3() {
        return this.isBNPLEligible;
    }

    @NotNull
    public final BNPLEligibilityRemoteResultDto copy(@Nullable BNPLValidationErrorDto bNPLValidationErrorDto, @Nullable Boolean bool, @Nullable Boolean bool2) {
        return new BNPLEligibilityRemoteResultDto(bNPLValidationErrorDto, bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLEligibilityRemoteResultDto)) {
            return false;
        }
        BNPLEligibilityRemoteResultDto bNPLEligibilityRemoteResultDto = (BNPLEligibilityRemoteResultDto) obj;
        return Intrinsics.areEqual((Object) this.bNPLValidationError, (Object) bNPLEligibilityRemoteResultDto.bNPLValidationError) && Intrinsics.areEqual((Object) this.isHideBNPLPaymentMethod, (Object) bNPLEligibilityRemoteResultDto.isHideBNPLPaymentMethod) && Intrinsics.areEqual((Object) this.isBNPLEligible, (Object) bNPLEligibilityRemoteResultDto.isBNPLEligible);
    }

    @Nullable
    public final BNPLValidationErrorDto getBNPLValidationError() {
        return this.bNPLValidationError;
    }

    public int hashCode() {
        BNPLValidationErrorDto bNPLValidationErrorDto = this.bNPLValidationError;
        int i11 = 0;
        int hashCode = (bNPLValidationErrorDto == null ? 0 : bNPLValidationErrorDto.hashCode()) * 31;
        Boolean bool = this.isHideBNPLPaymentMethod;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isBNPLEligible;
        if (bool2 != null) {
            i11 = bool2.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isBNPLEligible() {
        return this.isBNPLEligible;
    }

    @Nullable
    public final Boolean isHideBNPLPaymentMethod() {
        return this.isHideBNPLPaymentMethod;
    }

    @NotNull
    public String toString() {
        BNPLValidationErrorDto bNPLValidationErrorDto = this.bNPLValidationError;
        Boolean bool = this.isHideBNPLPaymentMethod;
        Boolean bool2 = this.isBNPLEligible;
        return "BNPLEligibilityRemoteResultDto(bNPLValidationError=" + bNPLValidationErrorDto + ", isHideBNPLPaymentMethod=" + bool + ", isBNPLEligible=" + bool2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLEligibilityRemoteResultDto(BNPLValidationErrorDto bNPLValidationErrorDto, Boolean bool, Boolean bool2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bNPLValidationErrorDto, (i11 & 2) != 0 ? null : bool, (i11 & 4) != 0 ? null : bool2);
    }
}
