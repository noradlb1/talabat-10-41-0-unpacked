package com.deliveryhero.fluid.versioning;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/fluid/versioning/VersionConfig;", "", "minVersion", "Lcom/deliveryhero/fluid/versioning/ContractVersion;", "allowUnsupportedCapability", "", "allowDeprecatedCapability", "(Lcom/deliveryhero/fluid/versioning/ContractVersion;ZZ)V", "getAllowDeprecatedCapability", "()Z", "getAllowUnsupportedCapability", "getMinVersion", "()Lcom/deliveryhero/fluid/versioning/ContractVersion;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VersionConfig {
    private final boolean allowDeprecatedCapability;
    private final boolean allowUnsupportedCapability;
    @NotNull
    private final ContractVersion minVersion;

    public VersionConfig(@NotNull ContractVersion contractVersion, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(contractVersion, "minVersion");
        this.minVersion = contractVersion;
        this.allowUnsupportedCapability = z11;
        this.allowDeprecatedCapability = z12;
    }

    public static /* synthetic */ VersionConfig copy$default(VersionConfig versionConfig, ContractVersion contractVersion, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            contractVersion = versionConfig.minVersion;
        }
        if ((i11 & 2) != 0) {
            z11 = versionConfig.allowUnsupportedCapability;
        }
        if ((i11 & 4) != 0) {
            z12 = versionConfig.allowDeprecatedCapability;
        }
        return versionConfig.copy(contractVersion, z11, z12);
    }

    @NotNull
    public final ContractVersion component1() {
        return this.minVersion;
    }

    public final boolean component2() {
        return this.allowUnsupportedCapability;
    }

    public final boolean component3() {
        return this.allowDeprecatedCapability;
    }

    @NotNull
    public final VersionConfig copy(@NotNull ContractVersion contractVersion, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(contractVersion, "minVersion");
        return new VersionConfig(contractVersion, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        ContractVersion contractVersion = this.minVersion;
        ContractVersion contractVersion2 = null;
        VersionConfig versionConfig = obj instanceof VersionConfig ? (VersionConfig) obj : null;
        if (versionConfig != null) {
            contractVersion2 = versionConfig.minVersion;
        }
        return Intrinsics.areEqual((Object) contractVersion, (Object) contractVersion2);
    }

    public final boolean getAllowDeprecatedCapability() {
        return this.allowDeprecatedCapability;
    }

    public final boolean getAllowUnsupportedCapability() {
        return this.allowUnsupportedCapability;
    }

    @NotNull
    public final ContractVersion getMinVersion() {
        return this.minVersion;
    }

    public int hashCode() {
        return this.minVersion.hashCode();
    }

    @NotNull
    public String toString() {
        return "VersionConfig(minVersion=" + this.minVersion + ", allowUnsupportedCapability=" + this.allowUnsupportedCapability + ", allowDeprecatedCapability=" + this.allowDeprecatedCapability + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VersionConfig(ContractVersion contractVersion, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(contractVersion, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? false : z12);
    }
}
