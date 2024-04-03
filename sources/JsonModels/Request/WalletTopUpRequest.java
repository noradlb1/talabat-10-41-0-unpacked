package JsonModels.Request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\"\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R \u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006*"}, d2 = {"LJsonModels/Request/WalletTopUpRequest;", "", "amount", "", "countryId", "", "cardTokenId", "", "card4Digits", "cardType", "binNumber", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBinNumber", "()Ljava/lang/Integer;", "setBinNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardTokenId", "getCardType", "setCardType", "getCountryId", "setCountryId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)LJsonModels/Request/WalletTopUpRequest;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpRequest {
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("binNumber")
    @Nullable
    private Integer binNumber;
    @SerializedName("card4Digits")
    @Nullable
    private String card4Digits;
    @SerializedName("cardTokenId")
    @Nullable
    private final String cardTokenId;
    @SerializedName("cardType")
    @Nullable
    private String cardType;
    @SerializedName("countryId")
    @Nullable
    private Integer countryId;

    public WalletTopUpRequest(@Nullable Float f11, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num2) {
        this.amount = f11;
        this.countryId = num;
        this.cardTokenId = str;
        this.card4Digits = str2;
        this.cardType = str3;
        this.binNumber = num2;
    }

    public static /* synthetic */ WalletTopUpRequest copy$default(WalletTopUpRequest walletTopUpRequest, Float f11, Integer num, String str, String str2, String str3, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = walletTopUpRequest.amount;
        }
        if ((i11 & 2) != 0) {
            num = walletTopUpRequest.countryId;
        }
        Integer num3 = num;
        if ((i11 & 4) != 0) {
            str = walletTopUpRequest.cardTokenId;
        }
        String str4 = str;
        if ((i11 & 8) != 0) {
            str2 = walletTopUpRequest.card4Digits;
        }
        String str5 = str2;
        if ((i11 & 16) != 0) {
            str3 = walletTopUpRequest.cardType;
        }
        String str6 = str3;
        if ((i11 & 32) != 0) {
            num2 = walletTopUpRequest.binNumber;
        }
        return walletTopUpRequest.copy(f11, num3, str4, str5, str6, num2);
    }

    @Nullable
    public final Float component1() {
        return this.amount;
    }

    @Nullable
    public final Integer component2() {
        return this.countryId;
    }

    @Nullable
    public final String component3() {
        return this.cardTokenId;
    }

    @Nullable
    public final String component4() {
        return this.card4Digits;
    }

    @Nullable
    public final String component5() {
        return this.cardType;
    }

    @Nullable
    public final Integer component6() {
        return this.binNumber;
    }

    @NotNull
    public final WalletTopUpRequest copy(@Nullable Float f11, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num2) {
        return new WalletTopUpRequest(f11, num, str, str2, str3, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTopUpRequest)) {
            return false;
        }
        WalletTopUpRequest walletTopUpRequest = (WalletTopUpRequest) obj;
        return Intrinsics.areEqual((Object) this.amount, (Object) walletTopUpRequest.amount) && Intrinsics.areEqual((Object) this.countryId, (Object) walletTopUpRequest.countryId) && Intrinsics.areEqual((Object) this.cardTokenId, (Object) walletTopUpRequest.cardTokenId) && Intrinsics.areEqual((Object) this.card4Digits, (Object) walletTopUpRequest.card4Digits) && Intrinsics.areEqual((Object) this.cardType, (Object) walletTopUpRequest.cardType) && Intrinsics.areEqual((Object) this.binNumber, (Object) walletTopUpRequest.binNumber);
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
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @Nullable
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    public int hashCode() {
        Float f11 = this.amount;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Integer num = this.countryId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.cardTokenId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.card4Digits;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cardType;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.binNumber;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode5 + i11;
    }

    public final void setBinNumber(@Nullable Integer num) {
        this.binNumber = num;
    }

    public final void setCard4Digits(@Nullable String str) {
        this.card4Digits = str;
    }

    public final void setCardType(@Nullable String str) {
        this.cardType = str;
    }

    public final void setCountryId(@Nullable Integer num) {
        this.countryId = num;
    }

    @NotNull
    public String toString() {
        Float f11 = this.amount;
        Integer num = this.countryId;
        String str = this.cardTokenId;
        String str2 = this.card4Digits;
        String str3 = this.cardType;
        Integer num2 = this.binNumber;
        return "WalletTopUpRequest(amount=" + f11 + ", countryId=" + num + ", cardTokenId=" + str + ", card4Digits=" + str2 + ", cardType=" + str3 + ", binNumber=" + num2 + ")";
    }
}
