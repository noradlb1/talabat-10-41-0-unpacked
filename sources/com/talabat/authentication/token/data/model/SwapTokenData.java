package com.talabat.authentication.token.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/authentication/token/data/model/SwapTokenData;", "", "access_token", "", "expires_in", "", "token_type", "(Ljava/lang/String;JLjava/lang/String;)V", "getAccess_token", "()Ljava/lang/String;", "getExpires_in", "()J", "getToken_type", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwapTokenData {
    @NotNull
    private final String access_token;
    private final long expires_in;
    @NotNull
    private final String token_type;

    public SwapTokenData(@NotNull String str, long j11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "access_token");
        Intrinsics.checkNotNullParameter(str2, "token_type");
        this.access_token = str;
        this.expires_in = j11;
        this.token_type = str2;
    }

    public static /* synthetic */ SwapTokenData copy$default(SwapTokenData swapTokenData, String str, long j11, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swapTokenData.access_token;
        }
        if ((i11 & 2) != 0) {
            j11 = swapTokenData.expires_in;
        }
        if ((i11 & 4) != 0) {
            str2 = swapTokenData.token_type;
        }
        return swapTokenData.copy(str, j11, str2);
    }

    @NotNull
    public final String component1() {
        return this.access_token;
    }

    public final long component2() {
        return this.expires_in;
    }

    @NotNull
    public final String component3() {
        return this.token_type;
    }

    @NotNull
    public final SwapTokenData copy(@NotNull String str, long j11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "access_token");
        Intrinsics.checkNotNullParameter(str2, "token_type");
        return new SwapTokenData(str, j11, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwapTokenData)) {
            return false;
        }
        SwapTokenData swapTokenData = (SwapTokenData) obj;
        return Intrinsics.areEqual((Object) this.access_token, (Object) swapTokenData.access_token) && this.expires_in == swapTokenData.expires_in && Intrinsics.areEqual((Object) this.token_type, (Object) swapTokenData.token_type);
    }

    @NotNull
    public final String getAccess_token() {
        return this.access_token;
    }

    public final long getExpires_in() {
        return this.expires_in;
    }

    @NotNull
    public final String getToken_type() {
        return this.token_type;
    }

    public int hashCode() {
        return (((this.access_token.hashCode() * 31) + a.a(this.expires_in)) * 31) + this.token_type.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.access_token;
        long j11 = this.expires_in;
        String str2 = this.token_type;
        return "SwapTokenData(access_token=" + str + ", expires_in=" + j11 + ", token_type=" + str2 + ")";
    }
}
