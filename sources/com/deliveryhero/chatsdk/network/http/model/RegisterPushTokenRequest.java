package com.deliveryhero.chatsdk.network.http.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/chatsdk/network/http/model/RegisterPushTokenRequest;", "", "deviceToken", "", "deviceType", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDeviceToken", "getDeviceType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RegisterPushTokenRequest {
    @NotNull
    private final String appId;
    @NotNull
    private final String deviceToken;
    @NotNull
    private final String deviceType;

    public RegisterPushTokenRequest(@NotNull @Json(name = "device_id") String str, @NotNull @Json(name = "device_type") String str2, @NotNull @Json(name = "app_id") String str3) {
        Intrinsics.checkNotNullParameter(str, "deviceToken");
        Intrinsics.checkNotNullParameter(str2, "deviceType");
        Intrinsics.checkNotNullParameter(str3, "appId");
        this.deviceToken = str;
        this.deviceType = str2;
        this.appId = str3;
    }

    public static /* synthetic */ RegisterPushTokenRequest copy$default(RegisterPushTokenRequest registerPushTokenRequest, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = registerPushTokenRequest.deviceToken;
        }
        if ((i11 & 2) != 0) {
            str2 = registerPushTokenRequest.deviceType;
        }
        if ((i11 & 4) != 0) {
            str3 = registerPushTokenRequest.appId;
        }
        return registerPushTokenRequest.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.deviceToken;
    }

    @NotNull
    public final String component2() {
        return this.deviceType;
    }

    @NotNull
    public final String component3() {
        return this.appId;
    }

    @NotNull
    public final RegisterPushTokenRequest copy(@NotNull @Json(name = "device_id") String str, @NotNull @Json(name = "device_type") String str2, @NotNull @Json(name = "app_id") String str3) {
        Intrinsics.checkNotNullParameter(str, "deviceToken");
        Intrinsics.checkNotNullParameter(str2, "deviceType");
        Intrinsics.checkNotNullParameter(str3, "appId");
        return new RegisterPushTokenRequest(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterPushTokenRequest)) {
            return false;
        }
        RegisterPushTokenRequest registerPushTokenRequest = (RegisterPushTokenRequest) obj;
        return Intrinsics.areEqual((Object) this.deviceToken, (Object) registerPushTokenRequest.deviceToken) && Intrinsics.areEqual((Object) this.deviceType, (Object) registerPushTokenRequest.deviceType) && Intrinsics.areEqual((Object) this.appId, (Object) registerPushTokenRequest.appId);
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getDeviceToken() {
        return this.deviceToken;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    public int hashCode() {
        return (((this.deviceToken.hashCode() * 31) + this.deviceType.hashCode()) * 31) + this.appId.hashCode();
    }

    @NotNull
    public String toString() {
        return "RegisterPushTokenRequest(deviceToken=" + this.deviceToken + ", deviceType=" + this.deviceType + ", appId=" + this.appId + ')';
    }
}
