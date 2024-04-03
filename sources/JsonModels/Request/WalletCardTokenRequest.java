package JsonModels.Request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u001b"}, d2 = {"LJsonModels/Request/WalletCardTokenRequest;", "", "cToken", "", "countryId", "language", "binNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBinNumber", "()Ljava/lang/String;", "setBinNumber", "(Ljava/lang/String;)V", "getCToken", "getCountryId", "setCountryId", "getLanguage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardTokenRequest {
    @SerializedName("binNumber")
    @Nullable
    private String binNumber;
    @SerializedName("cToken")
    @Nullable
    private final String cToken;
    @SerializedName("countryId")
    @Nullable
    private String countryId;
    @SerializedName("lang")
    @Nullable
    private final String language;

    public WalletCardTokenRequest(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.cToken = str;
        this.countryId = str2;
        this.language = str3;
        this.binNumber = str4;
    }

    public static /* synthetic */ WalletCardTokenRequest copy$default(WalletCardTokenRequest walletCardTokenRequest, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletCardTokenRequest.cToken;
        }
        if ((i11 & 2) != 0) {
            str2 = walletCardTokenRequest.countryId;
        }
        if ((i11 & 4) != 0) {
            str3 = walletCardTokenRequest.language;
        }
        if ((i11 & 8) != 0) {
            str4 = walletCardTokenRequest.binNumber;
        }
        return walletCardTokenRequest.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.cToken;
    }

    @Nullable
    public final String component2() {
        return this.countryId;
    }

    @Nullable
    public final String component3() {
        return this.language;
    }

    @Nullable
    public final String component4() {
        return this.binNumber;
    }

    @NotNull
    public final WalletCardTokenRequest copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new WalletCardTokenRequest(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCardTokenRequest)) {
            return false;
        }
        WalletCardTokenRequest walletCardTokenRequest = (WalletCardTokenRequest) obj;
        return Intrinsics.areEqual((Object) this.cToken, (Object) walletCardTokenRequest.cToken) && Intrinsics.areEqual((Object) this.countryId, (Object) walletCardTokenRequest.countryId) && Intrinsics.areEqual((Object) this.language, (Object) walletCardTokenRequest.language) && Intrinsics.areEqual((Object) this.binNumber, (Object) walletCardTokenRequest.binNumber);
    }

    @Nullable
    public final String getBinNumber() {
        return this.binNumber;
    }

    @Nullable
    public final String getCToken() {
        return this.cToken;
    }

    @Nullable
    public final String getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    public int hashCode() {
        String str = this.cToken;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.countryId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.language;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.binNumber;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void setBinNumber(@Nullable String str) {
        this.binNumber = str;
    }

    public final void setCountryId(@Nullable String str) {
        this.countryId = str;
    }

    @NotNull
    public String toString() {
        String str = this.cToken;
        String str2 = this.countryId;
        String str3 = this.language;
        String str4 = this.binNumber;
        return "WalletCardTokenRequest(cToken=" + str + ", countryId=" + str2 + ", language=" + str3 + ", binNumber=" + str4 + ")";
    }
}
