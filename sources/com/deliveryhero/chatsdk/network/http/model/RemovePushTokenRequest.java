package com.deliveryhero.chatsdk.network.http.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/chatsdk/network/http/model/RemovePushTokenRequest;", "", "deviceToken", "", "(Ljava/lang/String;)V", "getDeviceToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RemovePushTokenRequest {
    @NotNull
    private final String deviceToken;

    public RemovePushTokenRequest(@NotNull @Json(name = "device_id") String str) {
        Intrinsics.checkNotNullParameter(str, "deviceToken");
        this.deviceToken = str;
    }

    public static /* synthetic */ RemovePushTokenRequest copy$default(RemovePushTokenRequest removePushTokenRequest, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = removePushTokenRequest.deviceToken;
        }
        return removePushTokenRequest.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.deviceToken;
    }

    @NotNull
    public final RemovePushTokenRequest copy(@NotNull @Json(name = "device_id") String str) {
        Intrinsics.checkNotNullParameter(str, "deviceToken");
        return new RemovePushTokenRequest(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RemovePushTokenRequest) && Intrinsics.areEqual((Object) this.deviceToken, (Object) ((RemovePushTokenRequest) obj).deviceToken);
    }

    @NotNull
    public final String getDeviceToken() {
        return this.deviceToken;
    }

    public int hashCode() {
        return this.deviceToken.hashCode();
    }

    @NotNull
    public String toString() {
        return "RemovePushTokenRequest(deviceToken=" + this.deviceToken + ')';
    }
}
