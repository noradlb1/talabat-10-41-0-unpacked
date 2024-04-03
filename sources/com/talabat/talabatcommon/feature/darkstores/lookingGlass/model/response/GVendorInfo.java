package com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GVendorInfo;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "gRestaurant", "getGRestaurant", "()Ljava/lang/Object;", "setGRestaurant", "(Ljava/lang/Object;)V", "logoUrl", "getLogoUrl", "setLogoUrl", "name", "getName", "setName", "status", "", "getStatus", "()I", "setStatus", "(I)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GVendorInfo {
    @SerializedName("description")
    @NotNull
    private String description = "";
    @SerializedName("raw_data")
    @Nullable
    private Object gRestaurant;
    @SerializedName("logo_url")
    @Nullable
    private String logoUrl;
    @SerializedName("name")
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private String f61547name = "";
    @SerializedName("status")
    private int status;

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Object getGRestaurant() {
        return this.gRestaurant;
    }

    @Nullable
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getName() {
        return this.f61547name;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setGRestaurant(@Nullable Object obj) {
        this.gRestaurant = obj;
    }

    public final void setLogoUrl(@Nullable String str) {
        this.logoUrl = str;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f61547name = str;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }
}
