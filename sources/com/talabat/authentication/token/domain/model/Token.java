package com.talabat.authentication.token.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/talabat/authentication/token/domain/model/Token;", "", "refreshToken", "", "accessToken", "expiresIn", "", "tokenType", "scope", "timeDifference", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;J)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()J", "getRefreshToken", "getScope", "getTimeDifference", "getTokenType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Token {
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

    public Token(@Nullable String str, @NotNull String str2, long j11, @NotNull String str3, @NotNull String str4, long j12) {
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

    public static /* synthetic */ Token copy$default(Token token, String str, String str2, long j11, String str3, String str4, long j12, int i11, Object obj) {
        Token token2 = token;
        return token.copy((i11 & 1) != 0 ? token2.refreshToken : str, (i11 & 2) != 0 ? token2.accessToken : str2, (i11 & 4) != 0 ? token2.expiresIn : j11, (i11 & 8) != 0 ? token2.tokenType : str3, (i11 & 16) != 0 ? token2.scope : str4, (i11 & 32) != 0 ? token2.timeDifference : j12);
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
    public final Token copy(@Nullable String str, @NotNull String str2, long j11, @NotNull String str3, @NotNull String str4, long j12) {
        Intrinsics.checkNotNullParameter(str2, "accessToken");
        Intrinsics.checkNotNullParameter(str3, "tokenType");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "scope");
        return new Token(str, str2, j11, str3, str5, j12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Token)) {
            return false;
        }
        Token token = (Token) obj;
        return Intrinsics.areEqual((Object) this.refreshToken, (Object) token.refreshToken) && Intrinsics.areEqual((Object) this.accessToken, (Object) token.accessToken) && this.expiresIn == token.expiresIn && Intrinsics.areEqual((Object) this.tokenType, (Object) token.tokenType) && Intrinsics.areEqual((Object) this.scope, (Object) token.scope) && this.timeDifference == token.timeDifference;
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
        return "Token(refreshToken=" + str + ", accessToken=" + str2 + ", expiresIn=" + j11 + ", tokenType=" + str3 + ", scope=" + str4 + ", timeDifference=" + j12 + ")";
    }
}
