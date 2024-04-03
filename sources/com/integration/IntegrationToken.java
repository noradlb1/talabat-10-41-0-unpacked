package com.integration;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/integration/IntegrationToken;", "", "accessToken", "", "tokenType", "expiresIn", "refreshToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "getExpiresIn", "setExpiresIn", "getRefreshToken", "setRefreshToken", "getTokenType", "setTokenType", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegrationToken {
    @NotNull
    private String accessToken;
    @NotNull
    private String expiresIn;
    @NotNull
    private String refreshToken;
    @NotNull
    private String tokenType;

    public IntegrationToken() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public IntegrationToken(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "tokenType");
        Intrinsics.checkNotNullParameter(str3, "expiresIn");
        Intrinsics.checkNotNullParameter(str4, "refreshToken");
        this.accessToken = str;
        this.tokenType = str2;
        this.expiresIn = str3;
        this.refreshToken = str4;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final String getExpiresIn() {
        return this.expiresIn;
    }

    @NotNull
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @NotNull
    public final String getTokenType() {
        return this.tokenType;
    }

    public final void setAccessToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessToken = str;
    }

    public final void setExpiresIn(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expiresIn = str;
    }

    public final void setRefreshToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refreshToken = str;
    }

    public final void setTokenType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tokenType = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntegrationToken(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4);
    }
}
