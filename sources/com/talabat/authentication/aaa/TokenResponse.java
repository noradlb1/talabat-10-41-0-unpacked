package com.talabat.authentication.aaa;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/talabat/authentication/aaa/TokenResponse;", "", "accessToken", "", "refreshToken", "expiresIn", "", "tokenType", "scope", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()J", "getRefreshToken", "getScope", "getTokenType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenResponse {
    @SerializedName("access_token")
    @NotNull
    private final String accessToken;
    @SerializedName("expires_in")
    private final long expiresIn;
    @SerializedName("refresh_token")
    @Nullable
    private final String refreshToken;
    @SerializedName("scope")
    @NotNull
    private final String scope;
    @SerializedName("token_type")
    @NotNull
    private final String tokenType;

    public TokenResponse(@NotNull String str, @Nullable String str2, long j11, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str3, "tokenType");
        Intrinsics.checkNotNullParameter(str4, "scope");
        this.accessToken = str;
        this.refreshToken = str2;
        this.expiresIn = j11;
        this.tokenType = str3;
        this.scope = str4;
    }

    public static /* synthetic */ TokenResponse copy$default(TokenResponse tokenResponse, String str, String str2, long j11, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tokenResponse.accessToken;
        }
        if ((i11 & 2) != 0) {
            str2 = tokenResponse.refreshToken;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            j11 = tokenResponse.expiresIn;
        }
        long j12 = j11;
        if ((i11 & 8) != 0) {
            str3 = tokenResponse.tokenType;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = tokenResponse.scope;
        }
        return tokenResponse.copy(str, str5, j12, str6, str4);
    }

    @NotNull
    public final String component1() {
        return this.accessToken;
    }

    @Nullable
    public final String component2() {
        return this.refreshToken;
    }

    public final long component3() {
        return this.expiresIn;
    }

    @NotNull
    public final String component4() {
        return this.tokenType;
    }

    @NotNull
    public final String component5() {
        return this.scope;
    }

    @NotNull
    public final TokenResponse copy(@NotNull String str, @Nullable String str2, long j11, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str3, "tokenType");
        Intrinsics.checkNotNullParameter(str4, "scope");
        return new TokenResponse(str, str2, j11, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenResponse)) {
            return false;
        }
        TokenResponse tokenResponse = (TokenResponse) obj;
        return Intrinsics.areEqual((Object) this.accessToken, (Object) tokenResponse.accessToken) && Intrinsics.areEqual((Object) this.refreshToken, (Object) tokenResponse.refreshToken) && this.expiresIn == tokenResponse.expiresIn && Intrinsics.areEqual((Object) this.tokenType, (Object) tokenResponse.tokenType) && Intrinsics.areEqual((Object) this.scope, (Object) tokenResponse.scope);
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final long getExpiresIn() {
        return this.expiresIn;
    }

    @Nullable
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @NotNull
    public final String getScope() {
        return this.scope;
    }

    @NotNull
    public final String getTokenType() {
        return this.tokenType;
    }

    public int hashCode() {
        int hashCode = this.accessToken.hashCode() * 31;
        String str = this.refreshToken;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.expiresIn)) * 31) + this.tokenType.hashCode()) * 31) + this.scope.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.accessToken;
        String str2 = this.refreshToken;
        long j11 = this.expiresIn;
        String str3 = this.tokenType;
        String str4 = this.scope;
        return "TokenResponse(accessToken=" + str + ", refreshToken=" + str2 + ", expiresIn=" + j11 + ", tokenType=" + str3 + ", scope=" + str4 + ")";
    }
}
