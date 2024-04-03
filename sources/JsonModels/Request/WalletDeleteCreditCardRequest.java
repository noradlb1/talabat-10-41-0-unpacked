package JsonModels.Request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"LJsonModels/Request/WalletDeleteCreditCardRequest;", "", "eTokenId", "", "paymentProvider", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getETokenId", "()Ljava/lang/String;", "getPaymentProvider", "()Ljava/lang/Integer;", "setPaymentProvider", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)LJsonModels/Request/WalletDeleteCreditCardRequest;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDeleteCreditCardRequest {
    @SerializedName("eTokenId")
    @Nullable
    private final String eTokenId;
    @SerializedName("paymentProvider")
    @Nullable
    private Integer paymentProvider;

    public WalletDeleteCreditCardRequest(@Nullable String str, @Nullable Integer num) {
        this.eTokenId = str;
        this.paymentProvider = num;
    }

    public static /* synthetic */ WalletDeleteCreditCardRequest copy$default(WalletDeleteCreditCardRequest walletDeleteCreditCardRequest, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletDeleteCreditCardRequest.eTokenId;
        }
        if ((i11 & 2) != 0) {
            num = walletDeleteCreditCardRequest.paymentProvider;
        }
        return walletDeleteCreditCardRequest.copy(str, num);
    }

    @Nullable
    public final String component1() {
        return this.eTokenId;
    }

    @Nullable
    public final Integer component2() {
        return this.paymentProvider;
    }

    @NotNull
    public final WalletDeleteCreditCardRequest copy(@Nullable String str, @Nullable Integer num) {
        return new WalletDeleteCreditCardRequest(str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletDeleteCreditCardRequest)) {
            return false;
        }
        WalletDeleteCreditCardRequest walletDeleteCreditCardRequest = (WalletDeleteCreditCardRequest) obj;
        return Intrinsics.areEqual((Object) this.eTokenId, (Object) walletDeleteCreditCardRequest.eTokenId) && Intrinsics.areEqual((Object) this.paymentProvider, (Object) walletDeleteCreditCardRequest.paymentProvider);
    }

    @Nullable
    public final String getETokenId() {
        return this.eTokenId;
    }

    @Nullable
    public final Integer getPaymentProvider() {
        return this.paymentProvider;
    }

    public int hashCode() {
        String str = this.eTokenId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.paymentProvider;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode + i11;
    }

    public final void setPaymentProvider(@Nullable Integer num) {
        this.paymentProvider = num;
    }

    @NotNull
    public String toString() {
        String str = this.eTokenId;
        Integer num = this.paymentProvider;
        return "WalletDeleteCreditCardRequest(eTokenId=" + str + ", paymentProvider=" + num + ")";
    }
}
