package com.talabat.authentication.token.data.remote.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/authentication/token/data/remote/api/SwapTokenResponse;", "", "accessToken", "", "expiresIn", "", "tokenType", "(Ljava/lang/String;JLjava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()J", "getTokenType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwapTokenResponse {
    @SerializedName("access_token")
    @NotNull
    private final String accessToken;
    @SerializedName("expires_in")
    private final long expiresIn;
    @SerializedName("token_type")
    @NotNull
    private final String tokenType;

    public SwapTokenResponse(@NotNull String str, long j11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "tokenType");
        this.accessToken = str;
        this.expiresIn = j11;
        this.tokenType = str2;
    }

    public static /* synthetic */ SwapTokenResponse copy$default(SwapTokenResponse swapTokenResponse, String str, long j11, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swapTokenResponse.accessToken;
        }
        if ((i11 & 2) != 0) {
            j11 = swapTokenResponse.expiresIn;
        }
        if ((i11 & 4) != 0) {
            str2 = swapTokenResponse.tokenType;
        }
        return swapTokenResponse.copy(str, j11, str2);
    }

    @NotNull
    public final String component1() {
        return this.accessToken;
    }

    public final long component2() {
        return this.expiresIn;
    }

    @NotNull
    public final String component3() {
        return this.tokenType;
    }

    @NotNull
    public final SwapTokenResponse copy(@NotNull String str, long j11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "tokenType");
        return new SwapTokenResponse(str, j11, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwapTokenResponse)) {
            return false;
        }
        SwapTokenResponse swapTokenResponse = (SwapTokenResponse) obj;
        return Intrinsics.areEqual((Object) this.accessToken, (Object) swapTokenResponse.accessToken) && this.expiresIn == swapTokenResponse.expiresIn && Intrinsics.areEqual((Object) this.tokenType, (Object) swapTokenResponse.tokenType);
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final long getExpiresIn() {
        return this.expiresIn;
    }

    @NotNull
    public final String getTokenType() {
        return this.tokenType;
    }

    public int hashCode() {
        return (((this.accessToken.hashCode() * 31) + a.a(this.expiresIn)) * 31) + this.tokenType.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.accessToken;
        long j11 = this.expiresIn;
        String str2 = this.tokenType;
        return "SwapTokenResponse(accessToken=" + str + ", expiresIn=" + j11 + ", tokenType=" + str2 + ")";
    }
}
