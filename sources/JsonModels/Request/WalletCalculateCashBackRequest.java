package JsonModels.Request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006 "}, d2 = {"LJsonModels/Request/WalletCalculateCashBackRequest;", "", "amount", "", "eventType", "", "countryId", "binNumber", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBinNumber", "()Ljava/lang/Integer;", "setBinNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCountryId", "getEventType", "setEventType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)LJsonModels/Request/WalletCalculateCashBackRequest;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCalculateCashBackRequest {
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("binNumber")
    @Nullable
    private Integer binNumber;
    @SerializedName("countryId")
    @Nullable
    private final Integer countryId;
    @SerializedName("eventType")
    @Nullable
    private Integer eventType;

    public WalletCalculateCashBackRequest(@Nullable Float f11, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.amount = f11;
        this.eventType = num;
        this.countryId = num2;
        this.binNumber = num3;
    }

    public static /* synthetic */ WalletCalculateCashBackRequest copy$default(WalletCalculateCashBackRequest walletCalculateCashBackRequest, Float f11, Integer num, Integer num2, Integer num3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = walletCalculateCashBackRequest.amount;
        }
        if ((i11 & 2) != 0) {
            num = walletCalculateCashBackRequest.eventType;
        }
        if ((i11 & 4) != 0) {
            num2 = walletCalculateCashBackRequest.countryId;
        }
        if ((i11 & 8) != 0) {
            num3 = walletCalculateCashBackRequest.binNumber;
        }
        return walletCalculateCashBackRequest.copy(f11, num, num2, num3);
    }

    @Nullable
    public final Float component1() {
        return this.amount;
    }

    @Nullable
    public final Integer component2() {
        return this.eventType;
    }

    @Nullable
    public final Integer component3() {
        return this.countryId;
    }

    @Nullable
    public final Integer component4() {
        return this.binNumber;
    }

    @NotNull
    public final WalletCalculateCashBackRequest copy(@Nullable Float f11, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        return new WalletCalculateCashBackRequest(f11, num, num2, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCalculateCashBackRequest)) {
            return false;
        }
        WalletCalculateCashBackRequest walletCalculateCashBackRequest = (WalletCalculateCashBackRequest) obj;
        return Intrinsics.areEqual((Object) this.amount, (Object) walletCalculateCashBackRequest.amount) && Intrinsics.areEqual((Object) this.eventType, (Object) walletCalculateCashBackRequest.eventType) && Intrinsics.areEqual((Object) this.countryId, (Object) walletCalculateCashBackRequest.countryId) && Intrinsics.areEqual((Object) this.binNumber, (Object) walletCalculateCashBackRequest.binNumber);
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    @Nullable
    public final Integer getBinNumber() {
        return this.binNumber;
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final Integer getEventType() {
        return this.eventType;
    }

    public int hashCode() {
        Float f11 = this.amount;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Integer num = this.eventType;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.countryId;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.binNumber;
        if (num3 != null) {
            i11 = num3.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void setBinNumber(@Nullable Integer num) {
        this.binNumber = num;
    }

    public final void setEventType(@Nullable Integer num) {
        this.eventType = num;
    }

    @NotNull
    public String toString() {
        Float f11 = this.amount;
        Integer num = this.eventType;
        Integer num2 = this.countryId;
        Integer num3 = this.binNumber;
        return "WalletCalculateCashBackRequest(amount=" + f11 + ", eventType=" + num + ", countryId=" + num2 + ", binNumber=" + num3 + ")";
    }
}
