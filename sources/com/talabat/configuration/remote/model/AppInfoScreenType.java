package com.talabat.configuration.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/configuration/remote/model/AppInfoScreenType;", "", "initiateAppInfo", "", "flowType", "", "(Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getFlowType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInitiateAppInfo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/talabat/configuration/remote/model/AppInfoScreenType;", "equals", "other", "hashCode", "toString", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoScreenType {
    @Nullable
    private final Integer flowType;
    @Nullable
    private final Boolean initiateAppInfo;

    public AppInfoScreenType() {
        this((Boolean) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public AppInfoScreenType(@Nullable @Json(name = "initiateAppInfo") Boolean bool, @Nullable @Json(name = "flowType") Integer num) {
        this.initiateAppInfo = bool;
        this.flowType = num;
    }

    public static /* synthetic */ AppInfoScreenType copy$default(AppInfoScreenType appInfoScreenType, Boolean bool, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = appInfoScreenType.initiateAppInfo;
        }
        if ((i11 & 2) != 0) {
            num = appInfoScreenType.flowType;
        }
        return appInfoScreenType.copy(bool, num);
    }

    @Nullable
    public final Boolean component1() {
        return this.initiateAppInfo;
    }

    @Nullable
    public final Integer component2() {
        return this.flowType;
    }

    @NotNull
    public final AppInfoScreenType copy(@Nullable @Json(name = "initiateAppInfo") Boolean bool, @Nullable @Json(name = "flowType") Integer num) {
        return new AppInfoScreenType(bool, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInfoScreenType)) {
            return false;
        }
        AppInfoScreenType appInfoScreenType = (AppInfoScreenType) obj;
        return Intrinsics.areEqual((Object) this.initiateAppInfo, (Object) appInfoScreenType.initiateAppInfo) && Intrinsics.areEqual((Object) this.flowType, (Object) appInfoScreenType.flowType);
    }

    @Nullable
    public final Integer getFlowType() {
        return this.flowType;
    }

    @Nullable
    public final Boolean getInitiateAppInfo() {
        return this.initiateAppInfo;
    }

    public int hashCode() {
        Boolean bool = this.initiateAppInfo;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.flowType;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.initiateAppInfo;
        Integer num = this.flowType;
        return "AppInfoScreenType(initiateAppInfo=" + bool + ", flowType=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppInfoScreenType(Boolean bool, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : num);
    }
}
