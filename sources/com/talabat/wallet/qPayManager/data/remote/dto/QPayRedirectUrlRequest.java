package com.talabat.wallet.qPayManager.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRequest;", "", "transactionId", "", "countryId", "language", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryId", "()Ljava/lang/String;", "setCountryId", "(Ljava/lang/String;)V", "getLanguage", "getTransactionId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayRedirectUrlRequest {
    @SerializedName("countryId")
    @NotNull
    private String countryId;
    @SerializedName("lang")
    @NotNull
    private final String language;
    @SerializedName("eTransId")
    @NotNull
    private final String transactionId;

    public QPayRedirectUrlRequest(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "countryId");
        Intrinsics.checkNotNullParameter(str3, ConstantsKt.ADJUST_LANGUAGE);
        this.transactionId = str;
        this.countryId = str2;
        this.language = str3;
    }

    public static /* synthetic */ QPayRedirectUrlRequest copy$default(QPayRedirectUrlRequest qPayRedirectUrlRequest, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = qPayRedirectUrlRequest.transactionId;
        }
        if ((i11 & 2) != 0) {
            str2 = qPayRedirectUrlRequest.countryId;
        }
        if ((i11 & 4) != 0) {
            str3 = qPayRedirectUrlRequest.language;
        }
        return qPayRedirectUrlRequest.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.transactionId;
    }

    @NotNull
    public final String component2() {
        return this.countryId;
    }

    @NotNull
    public final String component3() {
        return this.language;
    }

    @NotNull
    public final QPayRedirectUrlRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "countryId");
        Intrinsics.checkNotNullParameter(str3, ConstantsKt.ADJUST_LANGUAGE);
        return new QPayRedirectUrlRequest(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QPayRedirectUrlRequest)) {
            return false;
        }
        QPayRedirectUrlRequest qPayRedirectUrlRequest = (QPayRedirectUrlRequest) obj;
        return Intrinsics.areEqual((Object) this.transactionId, (Object) qPayRedirectUrlRequest.transactionId) && Intrinsics.areEqual((Object) this.countryId, (Object) qPayRedirectUrlRequest.countryId) && Intrinsics.areEqual((Object) this.language, (Object) qPayRedirectUrlRequest.language);
    }

    @NotNull
    public final String getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getTransactionId() {
        return this.transactionId;
    }

    public int hashCode() {
        return (((this.transactionId.hashCode() * 31) + this.countryId.hashCode()) * 31) + this.language.hashCode();
    }

    public final void setCountryId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countryId = str;
    }

    @NotNull
    public String toString() {
        String str = this.transactionId;
        String str2 = this.countryId;
        String str3 = this.language;
        return "QPayRedirectUrlRequest(transactionId=" + str + ", countryId=" + str2 + ", language=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QPayRedirectUrlRequest(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? IntegrationGlobalDataModel.Companion.selectedLanguage() : str3);
    }
}
