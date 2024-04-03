package com.talabat.splash.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "", "result", "Lcom/talabat/splash/domain/entity/AppInitResponseEntity;", "baseUrl", "", "(Lcom/talabat/splash/domain/entity/AppInitResponseEntity;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "getResult", "()Lcom/talabat/splash/domain/entity/AppInitResponseEntity;", "setResult", "(Lcom/talabat/splash/domain/entity/AppInitResponseEntity;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInitRootEntity {
    @Nullable
    private String baseUrl;
    @Nullable
    private AppInitResponseEntity result;

    public AppInitRootEntity() {
        this((AppInitResponseEntity) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public AppInitRootEntity(@Nullable AppInitResponseEntity appInitResponseEntity, @Nullable String str) {
        this.result = appInitResponseEntity;
        this.baseUrl = str;
    }

    public static /* synthetic */ AppInitRootEntity copy$default(AppInitRootEntity appInitRootEntity, AppInitResponseEntity appInitResponseEntity, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            appInitResponseEntity = appInitRootEntity.result;
        }
        if ((i11 & 2) != 0) {
            str = appInitRootEntity.baseUrl;
        }
        return appInitRootEntity.copy(appInitResponseEntity, str);
    }

    @Nullable
    public final AppInitResponseEntity component1() {
        return this.result;
    }

    @Nullable
    public final String component2() {
        return this.baseUrl;
    }

    @NotNull
    public final AppInitRootEntity copy(@Nullable AppInitResponseEntity appInitResponseEntity, @Nullable String str) {
        return new AppInitRootEntity(appInitResponseEntity, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInitRootEntity)) {
            return false;
        }
        AppInitRootEntity appInitRootEntity = (AppInitRootEntity) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) appInitRootEntity.result) && Intrinsics.areEqual((Object) this.baseUrl, (Object) appInitRootEntity.baseUrl);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final AppInitResponseEntity getResult() {
        return this.result;
    }

    public int hashCode() {
        AppInitResponseEntity appInitResponseEntity = this.result;
        int i11 = 0;
        int hashCode = (appInitResponseEntity == null ? 0 : appInitResponseEntity.hashCode()) * 31;
        String str = this.baseUrl;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    public final void setBaseUrl(@Nullable String str) {
        this.baseUrl = str;
    }

    public final void setResult(@Nullable AppInitResponseEntity appInitResponseEntity) {
        this.result = appInitResponseEntity;
    }

    @NotNull
    public String toString() {
        AppInitResponseEntity appInitResponseEntity = this.result;
        String str = this.baseUrl;
        return "AppInitRootEntity(result=" + appInitResponseEntity + ", baseUrl=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppInitRootEntity(AppInitResponseEntity appInitResponseEntity, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : appInitResponseEntity, (i11 & 2) != 0 ? null : str);
    }
}
