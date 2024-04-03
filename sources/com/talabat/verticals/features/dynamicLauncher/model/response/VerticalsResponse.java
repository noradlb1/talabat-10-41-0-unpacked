package com.talabat.verticals.features.dynamicLauncher.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/talabat/verticals/features/dynamicLauncher/model/response/VerticalsResponse;", "", "()V", "error", "getError", "()Ljava/lang/Object;", "setError", "(Ljava/lang/Object;)V", "hasserror", "", "getHasserror", "()Ljava/lang/Boolean;", "setHasserror", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "result", "Lcom/talabat/verticals/features/dynamicLauncher/model/response/VerticalsResult;", "getResult", "()Lcom/talabat/verticals/features/dynamicLauncher/model/response/VerticalsResult;", "setResult", "(Lcom/talabat/verticals/features/dynamicLauncher/model/response/VerticalsResult;)V", "timestamp", "", "getTimestamp", "()Ljava/lang/String;", "setTimestamp", "(Ljava/lang/String;)V", "version", "getVersion", "setVersion", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsResponse {
    @SerializedName("error")
    @Nullable
    @Expose
    private Object error;
    @SerializedName("hasserror")
    @Nullable
    @Expose
    private Boolean hasserror;
    @SerializedName("result")
    @Nullable
    @Expose
    private VerticalsResult result;
    @SerializedName("timestamp")
    @Nullable
    @Expose
    private String timestamp;
    @SerializedName("version")
    @Nullable
    @Expose
    private String version;

    @Nullable
    public final Object getError() {
        return this.error;
    }

    @Nullable
    public final Boolean getHasserror() {
        return this.hasserror;
    }

    @Nullable
    public final VerticalsResult getResult() {
        return this.result;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public final void setError(@Nullable Object obj) {
        this.error = obj;
    }

    public final void setHasserror(@Nullable Boolean bool) {
        this.hasserror = bool;
    }

    public final void setResult(@Nullable VerticalsResult verticalsResult) {
        this.result = verticalsResult;
    }

    public final void setTimestamp(@Nullable String str) {
        this.timestamp = str;
    }

    public final void setVersion(@Nullable String str) {
        this.version = str;
    }
}
