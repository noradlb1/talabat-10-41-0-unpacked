package com.talabat.wallet.bnplmanager.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ<\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "", "countryId", "", "orderAmount", "", "vertical", "deliveryProvider", "(ILjava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCountryId", "()I", "getDeliveryProvider", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOrderAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getVertical", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLEligibilityRequestDto {
    @SerializedName("country")
    private final int countryId;
    @SerializedName("deliveryProvider")
    @Nullable
    private final Integer deliveryProvider;
    @SerializedName("orderAmount")
    @Nullable
    private final Float orderAmount;
    @SerializedName("vertical")
    @Nullable
    private final Integer vertical;

    public BNPLEligibilityRequestDto(int i11, @Nullable Float f11, @Nullable Integer num, @Nullable Integer num2) {
        this.countryId = i11;
        this.orderAmount = f11;
        this.vertical = num;
        this.deliveryProvider = num2;
    }

    public static /* synthetic */ BNPLEligibilityRequestDto copy$default(BNPLEligibilityRequestDto bNPLEligibilityRequestDto, int i11, Float f11, Integer num, Integer num2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = bNPLEligibilityRequestDto.countryId;
        }
        if ((i12 & 2) != 0) {
            f11 = bNPLEligibilityRequestDto.orderAmount;
        }
        if ((i12 & 4) != 0) {
            num = bNPLEligibilityRequestDto.vertical;
        }
        if ((i12 & 8) != 0) {
            num2 = bNPLEligibilityRequestDto.deliveryProvider;
        }
        return bNPLEligibilityRequestDto.copy(i11, f11, num, num2);
    }

    public final int component1() {
        return this.countryId;
    }

    @Nullable
    public final Float component2() {
        return this.orderAmount;
    }

    @Nullable
    public final Integer component3() {
        return this.vertical;
    }

    @Nullable
    public final Integer component4() {
        return this.deliveryProvider;
    }

    @NotNull
    public final BNPLEligibilityRequestDto copy(int i11, @Nullable Float f11, @Nullable Integer num, @Nullable Integer num2) {
        return new BNPLEligibilityRequestDto(i11, f11, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLEligibilityRequestDto)) {
            return false;
        }
        BNPLEligibilityRequestDto bNPLEligibilityRequestDto = (BNPLEligibilityRequestDto) obj;
        return this.countryId == bNPLEligibilityRequestDto.countryId && Intrinsics.areEqual((Object) this.orderAmount, (Object) bNPLEligibilityRequestDto.orderAmount) && Intrinsics.areEqual((Object) this.vertical, (Object) bNPLEligibilityRequestDto.vertical) && Intrinsics.areEqual((Object) this.deliveryProvider, (Object) bNPLEligibilityRequestDto.deliveryProvider);
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final Integer getDeliveryProvider() {
        return this.deliveryProvider;
    }

    @Nullable
    public final Float getOrderAmount() {
        return this.orderAmount;
    }

    @Nullable
    public final Integer getVertical() {
        return this.vertical;
    }

    public int hashCode() {
        int i11 = this.countryId * 31;
        Float f11 = this.orderAmount;
        int i12 = 0;
        int hashCode = (i11 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Integer num = this.vertical;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.deliveryProvider;
        if (num2 != null) {
            i12 = num2.hashCode();
        }
        return hashCode2 + i12;
    }

    @NotNull
    public String toString() {
        int i11 = this.countryId;
        Float f11 = this.orderAmount;
        Integer num = this.vertical;
        Integer num2 = this.deliveryProvider;
        return "BNPLEligibilityRequestDto(countryId=" + i11 + ", orderAmount=" + f11 + ", vertical=" + num + ", deliveryProvider=" + num2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLEligibilityRequestDto(int i11, Float f11, Integer num, Integer num2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? null : f11, (i12 & 4) != 0 ? null : num, (i12 & 8) != 0 ? null : num2);
    }
}
