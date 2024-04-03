package com.talabat.wallet.bnplmanager.data.remote.dto.request;

import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;", "", "planId", "", "encryptedOrderId", "card", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLCardDetail;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLCardDetail;)V", "getCard", "()Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLCardDetail;", "getEncryptedOrderId", "()Ljava/lang/String;", "getPlanId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLOrderPaymentRequestDto {
    @NotNull
    private final BNPLCardDetail card;
    @Nullable
    private final String encryptedOrderId;
    @NotNull
    private final String planId;

    public BNPLOrderPaymentRequestDto(@NotNull String str, @Nullable String str2, @NotNull BNPLCardDetail bNPLCardDetail) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(bNPLCardDetail, "card");
        this.planId = str;
        this.encryptedOrderId = str2;
        this.card = bNPLCardDetail;
    }

    public static /* synthetic */ BNPLOrderPaymentRequestDto copy$default(BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto, String str, String str2, BNPLCardDetail bNPLCardDetail, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bNPLOrderPaymentRequestDto.planId;
        }
        if ((i11 & 2) != 0) {
            str2 = bNPLOrderPaymentRequestDto.encryptedOrderId;
        }
        if ((i11 & 4) != 0) {
            bNPLCardDetail = bNPLOrderPaymentRequestDto.card;
        }
        return bNPLOrderPaymentRequestDto.copy(str, str2, bNPLCardDetail);
    }

    @NotNull
    public final String component1() {
        return this.planId;
    }

    @Nullable
    public final String component2() {
        return this.encryptedOrderId;
    }

    @NotNull
    public final BNPLCardDetail component3() {
        return this.card;
    }

    @NotNull
    public final BNPLOrderPaymentRequestDto copy(@NotNull String str, @Nullable String str2, @NotNull BNPLCardDetail bNPLCardDetail) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(bNPLCardDetail, "card");
        return new BNPLOrderPaymentRequestDto(str, str2, bNPLCardDetail);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLOrderPaymentRequestDto)) {
            return false;
        }
        BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto = (BNPLOrderPaymentRequestDto) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) bNPLOrderPaymentRequestDto.planId) && Intrinsics.areEqual((Object) this.encryptedOrderId, (Object) bNPLOrderPaymentRequestDto.encryptedOrderId) && Intrinsics.areEqual((Object) this.card, (Object) bNPLOrderPaymentRequestDto.card);
    }

    @NotNull
    public final BNPLCardDetail getCard() {
        return this.card;
    }

    @Nullable
    public final String getEncryptedOrderId() {
        return this.encryptedOrderId;
    }

    @NotNull
    public final String getPlanId() {
        return this.planId;
    }

    public int hashCode() {
        int hashCode = this.planId.hashCode() * 31;
        String str = this.encryptedOrderId;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.card.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        String str2 = this.encryptedOrderId;
        BNPLCardDetail bNPLCardDetail = this.card;
        return "BNPLOrderPaymentRequestDto(planId=" + str + ", encryptedOrderId=" + str2 + ", card=" + bNPLCardDetail + ")";
    }
}
