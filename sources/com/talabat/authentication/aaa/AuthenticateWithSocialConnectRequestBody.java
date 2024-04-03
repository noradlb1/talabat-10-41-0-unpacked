package com.talabat.authentication.aaa;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/authentication/aaa/AuthenticateWithSocialConnectRequestBody;", "", "email", "", "platform", "socialToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getPlatform", "getSocialToken", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthenticateWithSocialConnectRequestBody {
    @SerializedName("email")
    @NotNull
    private final String email;
    @SerializedName("platform")
    @NotNull
    private final String platform;
    @SerializedName("social_token")
    @NotNull
    private final String socialToken;

    public AuthenticateWithSocialConnectRequestBody(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "platform");
        Intrinsics.checkNotNullParameter(str3, "socialToken");
        this.email = str;
        this.platform = str2;
        this.socialToken = str3;
    }

    public static /* synthetic */ AuthenticateWithSocialConnectRequestBody copy$default(AuthenticateWithSocialConnectRequestBody authenticateWithSocialConnectRequestBody, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = authenticateWithSocialConnectRequestBody.email;
        }
        if ((i11 & 2) != 0) {
            str2 = authenticateWithSocialConnectRequestBody.platform;
        }
        if ((i11 & 4) != 0) {
            str3 = authenticateWithSocialConnectRequestBody.socialToken;
        }
        return authenticateWithSocialConnectRequestBody.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.email;
    }

    @NotNull
    public final String component2() {
        return this.platform;
    }

    @NotNull
    public final String component3() {
        return this.socialToken;
    }

    @NotNull
    public final AuthenticateWithSocialConnectRequestBody copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "platform");
        Intrinsics.checkNotNullParameter(str3, "socialToken");
        return new AuthenticateWithSocialConnectRequestBody(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticateWithSocialConnectRequestBody)) {
            return false;
        }
        AuthenticateWithSocialConnectRequestBody authenticateWithSocialConnectRequestBody = (AuthenticateWithSocialConnectRequestBody) obj;
        return Intrinsics.areEqual((Object) this.email, (Object) authenticateWithSocialConnectRequestBody.email) && Intrinsics.areEqual((Object) this.platform, (Object) authenticateWithSocialConnectRequestBody.platform) && Intrinsics.areEqual((Object) this.socialToken, (Object) authenticateWithSocialConnectRequestBody.socialToken);
    }

    @NotNull
    public final String getEmail() {
        return this.email;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    public final String getSocialToken() {
        return this.socialToken;
    }

    public int hashCode() {
        return (((this.email.hashCode() * 31) + this.platform.hashCode()) * 31) + this.socialToken.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.email;
        String str2 = this.platform;
        String str3 = this.socialToken;
        return "AuthenticateWithSocialConnectRequestBody(email=" + str + ", platform=" + str2 + ", socialToken=" + str3 + ")";
    }
}
