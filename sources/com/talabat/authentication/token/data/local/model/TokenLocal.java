package com.talabat.authentication.token.data.local.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.authentication.token.domain.model.Token;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BC\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0003\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00062\b\b\u0003\u0010\u000b\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\u0006\u0010#\u001a\u00020\u0003R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006$"}, d2 = {"Lcom/talabat/authentication/token/data/local/model/TokenLocal;", "", "token", "Lcom/talabat/authentication/token/domain/model/Token;", "(Lcom/talabat/authentication/token/domain/model/Token;)V", "refreshToken", "", "accessToken", "expiresIn", "", "tokenType", "scope", "timeDifference", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;J)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()J", "getRefreshToken", "getScope", "getTimeDifference", "getTokenType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "toToken", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenLocal {
    @NotNull
    private final String accessToken;
    private final long expiresIn;
    @Nullable
    private final String refreshToken;
    @NotNull
    private final String scope;
    private final long timeDifference;
    @NotNull
    private final String tokenType;

    public TokenLocal(@Nullable @Json(name = "refreshToken") String str, @NotNull @Json(name = "accessToken") String str2, @Json(name = "expiresIn") long j11, @NotNull @Json(name = "tokenType") String str3, @NotNull @Json(name = "scope") String str4, @Json(name = "timeDifference") long j12) {
        Intrinsics.checkNotNullParameter(str2, "accessToken");
        Intrinsics.checkNotNullParameter(str3, "tokenType");
        Intrinsics.checkNotNullParameter(str4, "scope");
        this.refreshToken = str;
        this.accessToken = str2;
        this.expiresIn = j11;
        this.tokenType = str3;
        this.scope = str4;
        this.timeDifference = j12;
    }

    public static /* synthetic */ TokenLocal copy$default(TokenLocal tokenLocal, String str, String str2, long j11, String str3, String str4, long j12, int i11, Object obj) {
        TokenLocal tokenLocal2 = tokenLocal;
        return tokenLocal.copy((i11 & 1) != 0 ? tokenLocal2.refreshToken : str, (i11 & 2) != 0 ? tokenLocal2.accessToken : str2, (i11 & 4) != 0 ? tokenLocal2.expiresIn : j11, (i11 & 8) != 0 ? tokenLocal2.tokenType : str3, (i11 & 16) != 0 ? tokenLocal2.scope : str4, (i11 & 32) != 0 ? tokenLocal2.timeDifference : j12);
    }

    @Nullable
    public final String component1() {
        return this.refreshToken;
    }

    @NotNull
    public final String component2() {
        return this.accessToken;
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

    public final long component6() {
        return this.timeDifference;
    }

    @NotNull
    public final TokenLocal copy(@Nullable @Json(name = "refreshToken") String str, @NotNull @Json(name = "accessToken") String str2, @Json(name = "expiresIn") long j11, @NotNull @Json(name = "tokenType") String str3, @NotNull @Json(name = "scope") String str4, @Json(name = "timeDifference") long j12) {
        Intrinsics.checkNotNullParameter(str2, "accessToken");
        Intrinsics.checkNotNullParameter(str3, "tokenType");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "scope");
        return new TokenLocal(str, str2, j11, str3, str5, j12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenLocal)) {
            return false;
        }
        TokenLocal tokenLocal = (TokenLocal) obj;
        return Intrinsics.areEqual((Object) this.refreshToken, (Object) tokenLocal.refreshToken) && Intrinsics.areEqual((Object) this.accessToken, (Object) tokenLocal.accessToken) && this.expiresIn == tokenLocal.expiresIn && Intrinsics.areEqual((Object) this.tokenType, (Object) tokenLocal.tokenType) && Intrinsics.areEqual((Object) this.scope, (Object) tokenLocal.scope) && this.timeDifference == tokenLocal.timeDifference;
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

    public final long getTimeDifference() {
        return this.timeDifference;
    }

    @NotNull
    public final String getTokenType() {
        return this.tokenType;
    }

    public int hashCode() {
        String str = this.refreshToken;
        return ((((((((((str == null ? 0 : str.hashCode()) * 31) + this.accessToken.hashCode()) * 31) + a.a(this.expiresIn)) * 31) + this.tokenType.hashCode()) * 31) + this.scope.hashCode()) * 31) + a.a(this.timeDifference);
    }

    @NotNull
    public String toString() {
        String str = this.refreshToken;
        String str2 = this.accessToken;
        long j11 = this.expiresIn;
        String str3 = this.tokenType;
        String str4 = this.scope;
        long j12 = this.timeDifference;
        return "TokenLocal(refreshToken=" + str + ", accessToken=" + str2 + ", expiresIn=" + j11 + ", tokenType=" + str3 + ", scope=" + str4 + ", timeDifference=" + j12 + ")";
    }

    @NotNull
    public final Token toToken() {
        return new Token(this.refreshToken, this.accessToken, this.expiresIn, this.tokenType, this.scope, this.timeDifference);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TokenLocal(String str, String str2, long j11, String str3, String str4, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, str2, j11, str3, str4, (i11 & 32) != 0 ? 0 : j12);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TokenLocal(@NotNull Token token) {
        this(token.getRefreshToken(), token.getAccessToken(), token.getExpiresIn(), token.getTokenType(), token.getScope(), token.getTimeDifference());
        Intrinsics.checkNotNullParameter(token, LegacyTokenLocalDataSourceImpl.KEY);
    }
}
