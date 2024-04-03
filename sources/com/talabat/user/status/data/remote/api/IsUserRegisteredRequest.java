package com.talabat.user.status.data.remote.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/talabat/user/status/data/remote/api/IsUserRegisteredRequest;", "", "providerId", "", "provider", "Lcom/talabat/user/status/data/remote/api/IsUserRegisteredRequest$Provider;", "providerkey", "deviceId", "countryId", "", "(Ljava/lang/String;Lcom/talabat/user/status/data/remote/api/IsUserRegisteredRequest$Provider;Ljava/lang/String;Ljava/lang/String;I)V", "getCountryId", "()I", "getDeviceId", "()Ljava/lang/String;", "getProvider", "()Lcom/talabat/user/status/data/remote/api/IsUserRegisteredRequest$Provider;", "getProviderId", "getProviderkey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Provider", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsUserRegisteredRequest {
    @SerializedName("countryId")
    private final int countryId;
    @SerializedName("udid")
    @NotNull
    private final String deviceId;
    @SerializedName("provider")
    @NotNull
    private final Provider provider;
    @SerializedName("providerId")
    @Nullable
    private final String providerId;
    @SerializedName("providerkey")
    @NotNull
    private final String providerkey;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/user/status/data/remote/api/IsUserRegisteredRequest$Provider;", "", "(Ljava/lang/String;I)V", "GOOGLE", "FACEBOOK", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Provider {
        GOOGLE,
        FACEBOOK
    }

    public IsUserRegisteredRequest(@Nullable String str, @NotNull Provider provider2, @NotNull String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(provider2, "provider");
        Intrinsics.checkNotNullParameter(str2, "providerkey");
        Intrinsics.checkNotNullParameter(str3, "deviceId");
        this.providerId = str;
        this.provider = provider2;
        this.providerkey = str2;
        this.deviceId = str3;
        this.countryId = i11;
    }

    public static /* synthetic */ IsUserRegisteredRequest copy$default(IsUserRegisteredRequest isUserRegisteredRequest, String str, Provider provider2, String str2, String str3, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = isUserRegisteredRequest.providerId;
        }
        if ((i12 & 2) != 0) {
            provider2 = isUserRegisteredRequest.provider;
        }
        Provider provider3 = provider2;
        if ((i12 & 4) != 0) {
            str2 = isUserRegisteredRequest.providerkey;
        }
        String str4 = str2;
        if ((i12 & 8) != 0) {
            str3 = isUserRegisteredRequest.deviceId;
        }
        String str5 = str3;
        if ((i12 & 16) != 0) {
            i11 = isUserRegisteredRequest.countryId;
        }
        return isUserRegisteredRequest.copy(str, provider3, str4, str5, i11);
    }

    @Nullable
    public final String component1() {
        return this.providerId;
    }

    @NotNull
    public final Provider component2() {
        return this.provider;
    }

    @NotNull
    public final String component3() {
        return this.providerkey;
    }

    @NotNull
    public final String component4() {
        return this.deviceId;
    }

    public final int component5() {
        return this.countryId;
    }

    @NotNull
    public final IsUserRegisteredRequest copy(@Nullable String str, @NotNull Provider provider2, @NotNull String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(provider2, "provider");
        Intrinsics.checkNotNullParameter(str2, "providerkey");
        Intrinsics.checkNotNullParameter(str3, "deviceId");
        return new IsUserRegisteredRequest(str, provider2, str2, str3, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IsUserRegisteredRequest)) {
            return false;
        }
        IsUserRegisteredRequest isUserRegisteredRequest = (IsUserRegisteredRequest) obj;
        return Intrinsics.areEqual((Object) this.providerId, (Object) isUserRegisteredRequest.providerId) && this.provider == isUserRegisteredRequest.provider && Intrinsics.areEqual((Object) this.providerkey, (Object) isUserRegisteredRequest.providerkey) && Intrinsics.areEqual((Object) this.deviceId, (Object) isUserRegisteredRequest.deviceId) && this.countryId == isUserRegisteredRequest.countryId;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final Provider getProvider() {
        return this.provider;
    }

    @Nullable
    public final String getProviderId() {
        return this.providerId;
    }

    @NotNull
    public final String getProviderkey() {
        return this.providerkey;
    }

    public int hashCode() {
        String str = this.providerId;
        return ((((((((str == null ? 0 : str.hashCode()) * 31) + this.provider.hashCode()) * 31) + this.providerkey.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.countryId;
    }

    @NotNull
    public String toString() {
        String str = this.providerId;
        Provider provider2 = this.provider;
        String str2 = this.providerkey;
        String str3 = this.deviceId;
        int i11 = this.countryId;
        return "IsUserRegisteredRequest(providerId=" + str + ", provider=" + provider2 + ", providerkey=" + str2 + ", deviceId=" + str3 + ", countryId=" + i11 + ")";
    }
}
