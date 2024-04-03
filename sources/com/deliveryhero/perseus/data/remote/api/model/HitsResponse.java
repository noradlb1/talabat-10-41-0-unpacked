package com.deliveryhero.perseus.data.remote.api.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "", "status", "", "(Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "setStatus", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class HitsResponse {
    @SerializedName("status")
    @NotNull
    private String status;

    public HitsResponse(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "status");
        this.status = str;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }
}
