package com.deliveryhero.chatsdk.network.http.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/chatsdk/network/http/model/UploadFileResponse;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UploadFileResponse {
    @NotNull
    private final String url;

    public UploadFileResponse(@NotNull @Json(name = "image_url") String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
    }

    public static /* synthetic */ UploadFileResponse copy$default(UploadFileResponse uploadFileResponse, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = uploadFileResponse.url;
        }
        return uploadFileResponse.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final UploadFileResponse copy(@NotNull @Json(name = "image_url") String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new UploadFileResponse(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UploadFileResponse) && Intrinsics.areEqual((Object) this.url, (Object) ((UploadFileResponse) obj).url);
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "UploadFileResponse(url=" + this.url + ')';
    }
}
