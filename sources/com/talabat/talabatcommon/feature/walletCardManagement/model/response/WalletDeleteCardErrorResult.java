package com.talabat.talabatcommon.feature.walletCardManagement.model.response;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;", "", "title", "", "body", "code", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardError;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardError;)V", "getBody", "()Ljava/lang/String;", "getCode", "()Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardError;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDeleteCardErrorResult {
    @NotNull
    private final String body;
    @NotNull
    private final WalletDeleteCardError code;
    @NotNull
    private final String title;

    public WalletDeleteCardErrorResult(@NotNull @Json(name = "title") String str, @NotNull @Json(name = "body") String str2, @NotNull @Json(name = "code") WalletDeleteCardError walletDeleteCardError) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "body");
        Intrinsics.checkNotNullParameter(walletDeleteCardError, Constant.PARAM_ERROR_CODE);
        this.title = str;
        this.body = str2;
        this.code = walletDeleteCardError;
    }

    public static /* synthetic */ WalletDeleteCardErrorResult copy$default(WalletDeleteCardErrorResult walletDeleteCardErrorResult, String str, String str2, WalletDeleteCardError walletDeleteCardError, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletDeleteCardErrorResult.title;
        }
        if ((i11 & 2) != 0) {
            str2 = walletDeleteCardErrorResult.body;
        }
        if ((i11 & 4) != 0) {
            walletDeleteCardError = walletDeleteCardErrorResult.code;
        }
        return walletDeleteCardErrorResult.copy(str, str2, walletDeleteCardError);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.body;
    }

    @NotNull
    public final WalletDeleteCardError component3() {
        return this.code;
    }

    @NotNull
    public final WalletDeleteCardErrorResult copy(@NotNull @Json(name = "title") String str, @NotNull @Json(name = "body") String str2, @NotNull @Json(name = "code") WalletDeleteCardError walletDeleteCardError) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "body");
        Intrinsics.checkNotNullParameter(walletDeleteCardError, Constant.PARAM_ERROR_CODE);
        return new WalletDeleteCardErrorResult(str, str2, walletDeleteCardError);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletDeleteCardErrorResult)) {
            return false;
        }
        WalletDeleteCardErrorResult walletDeleteCardErrorResult = (WalletDeleteCardErrorResult) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) walletDeleteCardErrorResult.title) && Intrinsics.areEqual((Object) this.body, (Object) walletDeleteCardErrorResult.body) && this.code == walletDeleteCardErrorResult.code;
    }

    @NotNull
    public final String getBody() {
        return this.body;
    }

    @NotNull
    public final WalletDeleteCardError getCode() {
        return this.code;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.body.hashCode()) * 31) + this.code.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.body;
        WalletDeleteCardError walletDeleteCardError = this.code;
        return "WalletDeleteCardErrorResult(title=" + str + ", body=" + str2 + ", code=" + walletDeleteCardError + ")";
    }
}
