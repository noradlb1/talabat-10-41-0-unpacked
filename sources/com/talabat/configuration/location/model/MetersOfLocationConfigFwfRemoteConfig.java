package com.talabat.configuration.location.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/configuration/location/model/MetersOfLocationConfigFwfRemoteConfig;", "", "metersOfLocationAwareness", "", "(Ljava/lang/Integer;)V", "getMetersOfLocationAwareness", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/talabat/configuration/location/model/MetersOfLocationConfigFwfRemoteConfig;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetersOfLocationConfigFwfRemoteConfig {
    @Nullable
    private final Integer metersOfLocationAwareness;

    public MetersOfLocationConfigFwfRemoteConfig() {
        this((Integer) null, 1, (DefaultConstructorMarker) null);
    }

    public MetersOfLocationConfigFwfRemoteConfig(@Nullable Integer num) {
        this.metersOfLocationAwareness = num;
    }

    public static /* synthetic */ MetersOfLocationConfigFwfRemoteConfig copy$default(MetersOfLocationConfigFwfRemoteConfig metersOfLocationConfigFwfRemoteConfig, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = metersOfLocationConfigFwfRemoteConfig.metersOfLocationAwareness;
        }
        return metersOfLocationConfigFwfRemoteConfig.copy(num);
    }

    @Nullable
    public final Integer component1() {
        return this.metersOfLocationAwareness;
    }

    @NotNull
    public final MetersOfLocationConfigFwfRemoteConfig copy(@Nullable Integer num) {
        return new MetersOfLocationConfigFwfRemoteConfig(num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MetersOfLocationConfigFwfRemoteConfig) && Intrinsics.areEqual((Object) this.metersOfLocationAwareness, (Object) ((MetersOfLocationConfigFwfRemoteConfig) obj).metersOfLocationAwareness);
    }

    @Nullable
    public final Integer getMetersOfLocationAwareness() {
        return this.metersOfLocationAwareness;
    }

    public int hashCode() {
        Integer num = this.metersOfLocationAwareness;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    @NotNull
    public String toString() {
        Integer num = this.metersOfLocationAwareness;
        return "MetersOfLocationConfigFwfRemoteConfig(metersOfLocationAwareness=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetersOfLocationConfigFwfRemoteConfig(Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 200 : num);
    }
}
