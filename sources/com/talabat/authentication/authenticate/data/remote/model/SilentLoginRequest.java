package com.talabat.authentication.authenticate.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J;\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/authentication/authenticate/data/remote/model/SilentLoginRequest;", "", "grantType", "", "clientId", "clientSecret", "username", "password", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SilentLoginRequest {
    @SerializedName("client_id")
    @NotNull
    private final String clientId;
    @SerializedName("client_secret")
    @NotNull
    private final String clientSecret;
    @SerializedName("grant_type")
    @NotNull
    private final String grantType;
    @SerializedName("password")
    @NotNull
    private final String password;
    @SerializedName("username")
    @NotNull
    private final String username;

    public SilentLoginRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "grantType");
        Intrinsics.checkNotNullParameter(str2, Profile.CLIENT_ID);
        Intrinsics.checkNotNullParameter(str3, "clientSecret");
        Intrinsics.checkNotNullParameter(str4, "username");
        Intrinsics.checkNotNullParameter(str5, "password");
        this.grantType = str;
        this.clientId = str2;
        this.clientSecret = str3;
        this.username = str4;
        this.password = str5;
    }

    private final String component1() {
        return this.grantType;
    }

    private final String component2() {
        return this.clientId;
    }

    private final String component3() {
        return this.clientSecret;
    }

    private final String component4() {
        return this.username;
    }

    private final String component5() {
        return this.password;
    }

    public static /* synthetic */ SilentLoginRequest copy$default(SilentLoginRequest silentLoginRequest, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = silentLoginRequest.grantType;
        }
        if ((i11 & 2) != 0) {
            str2 = silentLoginRequest.clientId;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = silentLoginRequest.clientSecret;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = silentLoginRequest.username;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = silentLoginRequest.password;
        }
        return silentLoginRequest.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final SilentLoginRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "grantType");
        Intrinsics.checkNotNullParameter(str2, Profile.CLIENT_ID);
        Intrinsics.checkNotNullParameter(str3, "clientSecret");
        Intrinsics.checkNotNullParameter(str4, "username");
        Intrinsics.checkNotNullParameter(str5, "password");
        return new SilentLoginRequest(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SilentLoginRequest)) {
            return false;
        }
        SilentLoginRequest silentLoginRequest = (SilentLoginRequest) obj;
        return Intrinsics.areEqual((Object) this.grantType, (Object) silentLoginRequest.grantType) && Intrinsics.areEqual((Object) this.clientId, (Object) silentLoginRequest.clientId) && Intrinsics.areEqual((Object) this.clientSecret, (Object) silentLoginRequest.clientSecret) && Intrinsics.areEqual((Object) this.username, (Object) silentLoginRequest.username) && Intrinsics.areEqual((Object) this.password, (Object) silentLoginRequest.password);
    }

    public int hashCode() {
        return (((((((this.grantType.hashCode() * 31) + this.clientId.hashCode()) * 31) + this.clientSecret.hashCode()) * 31) + this.username.hashCode()) * 31) + this.password.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.grantType;
        String str2 = this.clientId;
        String str3 = this.clientSecret;
        String str4 = this.username;
        String str5 = this.password;
        return "SilentLoginRequest(grantType=" + str + ", clientId=" + str2 + ", clientSecret=" + str3 + ", username=" + str4 + ", password=" + str5 + ")";
    }
}
