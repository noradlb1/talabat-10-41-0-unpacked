package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"LJsonModels/Response/WalletSaveCreditCardResponse;", "", "displayMessage", "", "isValid", "", "redirectUrl", "responseCode", "", "verificationCode", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDisplayMessage", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "setValid", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRedirectUrl", "getResponseCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVerificationCode", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)LJsonModels/Response/WalletSaveCreditCardResponse;", "equals", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletSaveCreditCardResponse {
    @SerializedName("DisplayMessage")
    @Nullable
    private final String displayMessage;
    @SerializedName("IsValid")
    @Nullable
    private Boolean isValid;
    @SerializedName("RedirectUrl")
    @Nullable
    private final String redirectUrl;
    @SerializedName("ResponseCode")
    @Nullable
    private final Integer responseCode;
    @SerializedName("verificationCode")
    @Nullable
    private final Integer verificationCode;

    public WalletSaveCreditCardResponse(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2) {
        this.displayMessage = str;
        this.isValid = bool;
        this.redirectUrl = str2;
        this.responseCode = num;
        this.verificationCode = num2;
    }

    public static /* synthetic */ WalletSaveCreditCardResponse copy$default(WalletSaveCreditCardResponse walletSaveCreditCardResponse, String str, Boolean bool, String str2, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletSaveCreditCardResponse.displayMessage;
        }
        if ((i11 & 2) != 0) {
            bool = walletSaveCreditCardResponse.isValid;
        }
        Boolean bool2 = bool;
        if ((i11 & 4) != 0) {
            str2 = walletSaveCreditCardResponse.redirectUrl;
        }
        String str3 = str2;
        if ((i11 & 8) != 0) {
            num = walletSaveCreditCardResponse.responseCode;
        }
        Integer num3 = num;
        if ((i11 & 16) != 0) {
            num2 = walletSaveCreditCardResponse.verificationCode;
        }
        return walletSaveCreditCardResponse.copy(str, bool2, str3, num3, num2);
    }

    @Nullable
    public final String component1() {
        return this.displayMessage;
    }

    @Nullable
    public final Boolean component2() {
        return this.isValid;
    }

    @Nullable
    public final String component3() {
        return this.redirectUrl;
    }

    @Nullable
    public final Integer component4() {
        return this.responseCode;
    }

    @Nullable
    public final Integer component5() {
        return this.verificationCode;
    }

    @NotNull
    public final WalletSaveCreditCardResponse copy(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2) {
        return new WalletSaveCreditCardResponse(str, bool, str2, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletSaveCreditCardResponse)) {
            return false;
        }
        WalletSaveCreditCardResponse walletSaveCreditCardResponse = (WalletSaveCreditCardResponse) obj;
        return Intrinsics.areEqual((Object) this.displayMessage, (Object) walletSaveCreditCardResponse.displayMessage) && Intrinsics.areEqual((Object) this.isValid, (Object) walletSaveCreditCardResponse.isValid) && Intrinsics.areEqual((Object) this.redirectUrl, (Object) walletSaveCreditCardResponse.redirectUrl) && Intrinsics.areEqual((Object) this.responseCode, (Object) walletSaveCreditCardResponse.responseCode) && Intrinsics.areEqual((Object) this.verificationCode, (Object) walletSaveCreditCardResponse.verificationCode);
    }

    @Nullable
    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    @Nullable
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Nullable
    public final Integer getResponseCode() {
        return this.responseCode;
    }

    @Nullable
    public final Integer getVerificationCode() {
        return this.verificationCode;
    }

    public int hashCode() {
        String str = this.displayMessage;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isValid;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.redirectUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.responseCode;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.verificationCode;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode4 + i11;
    }

    @Nullable
    public final Boolean isValid() {
        return this.isValid;
    }

    public final void setValid(@Nullable Boolean bool) {
        this.isValid = bool;
    }

    @NotNull
    public String toString() {
        String str = this.displayMessage;
        Boolean bool = this.isValid;
        String str2 = this.redirectUrl;
        Integer num = this.responseCode;
        Integer num2 = this.verificationCode;
        return "WalletSaveCreditCardResponse(displayMessage=" + str + ", isValid=" + bool + ", redirectUrl=" + str2 + ", responseCode=" + num + ", verificationCode=" + num2 + ")";
    }
}
