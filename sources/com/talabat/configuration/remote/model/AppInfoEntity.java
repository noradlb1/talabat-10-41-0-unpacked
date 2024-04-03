package com.talabat.configuration.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/configuration/remote/model/AppInfoEntity;", "", "result", "Lcom/talabat/configuration/remote/model/AppInfoResultEntity;", "(Lcom/talabat/configuration/remote/model/AppInfoResultEntity;)V", "getResult", "()Lcom/talabat/configuration/remote/model/AppInfoResultEntity;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoEntity {
    @Nullable
    private final AppInfoResultEntity result;

    public AppInfoEntity() {
        this((AppInfoResultEntity) null, 1, (DefaultConstructorMarker) null);
    }

    public AppInfoEntity(@Nullable @Json(name = "result") AppInfoResultEntity appInfoResultEntity) {
        this.result = appInfoResultEntity;
    }

    public static /* synthetic */ AppInfoEntity copy$default(AppInfoEntity appInfoEntity, AppInfoResultEntity appInfoResultEntity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            appInfoResultEntity = appInfoEntity.result;
        }
        return appInfoEntity.copy(appInfoResultEntity);
    }

    @Nullable
    public final AppInfoResultEntity component1() {
        return this.result;
    }

    @NotNull
    public final AppInfoEntity copy(@Nullable @Json(name = "result") AppInfoResultEntity appInfoResultEntity) {
        return new AppInfoEntity(appInfoResultEntity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppInfoEntity) && Intrinsics.areEqual((Object) this.result, (Object) ((AppInfoEntity) obj).result);
    }

    @Nullable
    public final AppInfoResultEntity getResult() {
        return this.result;
    }

    public int hashCode() {
        AppInfoResultEntity appInfoResultEntity = this.result;
        if (appInfoResultEntity == null) {
            return 0;
        }
        return appInfoResultEntity.hashCode();
    }

    @NotNull
    public String toString() {
        AppInfoResultEntity appInfoResultEntity = this.result;
        return "AppInfoEntity(result=" + appInfoResultEntity + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppInfoEntity(AppInfoResultEntity appInfoResultEntity, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : appInfoResultEntity);
    }
}
