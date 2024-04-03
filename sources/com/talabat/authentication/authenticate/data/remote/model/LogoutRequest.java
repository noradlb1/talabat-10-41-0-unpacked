package com.talabat.authentication.authenticate.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/authentication/authenticate/data/remote/model/LogoutRequest;", "", "token", "", "tokenTypeHint", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogoutRequest {
    @SerializedName("token")
    @NotNull
    private final String token;
    @SerializedName("token_type_hint")
    @NotNull
    private final String tokenTypeHint;

    public LogoutRequest(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str2, "tokenTypeHint");
        this.token = str;
        this.tokenTypeHint = str2;
    }

    private final String component1() {
        return this.token;
    }

    private final String component2() {
        return this.tokenTypeHint;
    }

    public static /* synthetic */ LogoutRequest copy$default(LogoutRequest logoutRequest, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = logoutRequest.token;
        }
        if ((i11 & 2) != 0) {
            str2 = logoutRequest.tokenTypeHint;
        }
        return logoutRequest.copy(str, str2);
    }

    @NotNull
    public final LogoutRequest copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str2, "tokenTypeHint");
        return new LogoutRequest(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogoutRequest)) {
            return false;
        }
        LogoutRequest logoutRequest = (LogoutRequest) obj;
        return Intrinsics.areEqual((Object) this.token, (Object) logoutRequest.token) && Intrinsics.areEqual((Object) this.tokenTypeHint, (Object) logoutRequest.tokenTypeHint);
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.tokenTypeHint.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.token;
        String str2 = this.tokenTypeHint;
        return "LogoutRequest(token=" + str + ", tokenTypeHint=" + str2 + ")";
    }
}
