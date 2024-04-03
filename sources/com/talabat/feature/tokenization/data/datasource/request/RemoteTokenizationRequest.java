package com.talabat.feature.tokenization.data.datasource.request;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/feature/tokenization/data/datasource/request/RemoteTokenizationRequest;", "", "cardNumber", "", "cardHolderName", "cardExpiryMonth", "cardExpiryYear", "cardCvv", "publicKey", "env", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardCvv", "()Ljava/lang/String;", "getCardExpiryMonth", "getCardExpiryYear", "getCardHolderName", "getCardNumber", "getEnv", "getPublicKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tokenization_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RemoteTokenizationRequest {
    @NotNull
    private final String cardCvv;
    @NotNull
    private final String cardExpiryMonth;
    @NotNull
    private final String cardExpiryYear;
    @NotNull
    private final String cardHolderName;
    @NotNull
    private final String cardNumber;
    @NotNull
    private final String env;
    @NotNull
    private final String publicKey;

    public RemoteTokenizationRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "cardHolderName");
        Intrinsics.checkNotNullParameter(str3, "cardExpiryMonth");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryYear");
        Intrinsics.checkNotNullParameter(str5, "cardCvv");
        Intrinsics.checkNotNullParameter(str6, "publicKey");
        Intrinsics.checkNotNullParameter(str7, CardTokenizationPlugin.ARG_ENV_KEY);
        this.cardNumber = str;
        this.cardHolderName = str2;
        this.cardExpiryMonth = str3;
        this.cardExpiryYear = str4;
        this.cardCvv = str5;
        this.publicKey = str6;
        this.env = str7;
    }

    public static /* synthetic */ RemoteTokenizationRequest copy$default(RemoteTokenizationRequest remoteTokenizationRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = remoteTokenizationRequest.cardNumber;
        }
        if ((i11 & 2) != 0) {
            str2 = remoteTokenizationRequest.cardHolderName;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = remoteTokenizationRequest.cardExpiryMonth;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = remoteTokenizationRequest.cardExpiryYear;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = remoteTokenizationRequest.cardCvv;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = remoteTokenizationRequest.publicKey;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = remoteTokenizationRequest.env;
        }
        return remoteTokenizationRequest.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final String component1() {
        return this.cardNumber;
    }

    @NotNull
    public final String component2() {
        return this.cardHolderName;
    }

    @NotNull
    public final String component3() {
        return this.cardExpiryMonth;
    }

    @NotNull
    public final String component4() {
        return this.cardExpiryYear;
    }

    @NotNull
    public final String component5() {
        return this.cardCvv;
    }

    @NotNull
    public final String component6() {
        return this.publicKey;
    }

    @NotNull
    public final String component7() {
        return this.env;
    }

    @NotNull
    public final RemoteTokenizationRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "cardHolderName");
        Intrinsics.checkNotNullParameter(str3, "cardExpiryMonth");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryYear");
        Intrinsics.checkNotNullParameter(str5, "cardCvv");
        Intrinsics.checkNotNullParameter(str6, "publicKey");
        String str8 = str7;
        Intrinsics.checkNotNullParameter(str8, CardTokenizationPlugin.ARG_ENV_KEY);
        return new RemoteTokenizationRequest(str, str2, str3, str4, str5, str6, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteTokenizationRequest)) {
            return false;
        }
        RemoteTokenizationRequest remoteTokenizationRequest = (RemoteTokenizationRequest) obj;
        return Intrinsics.areEqual((Object) this.cardNumber, (Object) remoteTokenizationRequest.cardNumber) && Intrinsics.areEqual((Object) this.cardHolderName, (Object) remoteTokenizationRequest.cardHolderName) && Intrinsics.areEqual((Object) this.cardExpiryMonth, (Object) remoteTokenizationRequest.cardExpiryMonth) && Intrinsics.areEqual((Object) this.cardExpiryYear, (Object) remoteTokenizationRequest.cardExpiryYear) && Intrinsics.areEqual((Object) this.cardCvv, (Object) remoteTokenizationRequest.cardCvv) && Intrinsics.areEqual((Object) this.publicKey, (Object) remoteTokenizationRequest.publicKey) && Intrinsics.areEqual((Object) this.env, (Object) remoteTokenizationRequest.env);
    }

    @NotNull
    public final String getCardCvv() {
        return this.cardCvv;
    }

    @NotNull
    public final String getCardExpiryMonth() {
        return this.cardExpiryMonth;
    }

    @NotNull
    public final String getCardExpiryYear() {
        return this.cardExpiryYear;
    }

    @NotNull
    public final String getCardHolderName() {
        return this.cardHolderName;
    }

    @NotNull
    public final String getCardNumber() {
        return this.cardNumber;
    }

    @NotNull
    public final String getEnv() {
        return this.env;
    }

    @NotNull
    public final String getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        return (((((((((((this.cardNumber.hashCode() * 31) + this.cardHolderName.hashCode()) * 31) + this.cardExpiryMonth.hashCode()) * 31) + this.cardExpiryYear.hashCode()) * 31) + this.cardCvv.hashCode()) * 31) + this.publicKey.hashCode()) * 31) + this.env.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cardNumber;
        String str2 = this.cardHolderName;
        String str3 = this.cardExpiryMonth;
        String str4 = this.cardExpiryYear;
        String str5 = this.cardCvv;
        String str6 = this.publicKey;
        String str7 = this.env;
        return "RemoteTokenizationRequest(cardNumber=" + str + ", cardHolderName=" + str2 + ", cardExpiryMonth=" + str3 + ", cardExpiryYear=" + str4 + ", cardCvv=" + str5 + ", publicKey=" + str6 + ", env=" + str7 + ")";
    }
}
