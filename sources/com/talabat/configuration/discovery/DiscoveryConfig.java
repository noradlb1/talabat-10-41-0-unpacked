package com.talabat.configuration.discovery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/configuration/discovery/DiscoveryConfig;", "", "newAppVersion", "Lcom/talabat/configuration/discovery/NewAppVersion;", "(Lcom/talabat/configuration/discovery/NewAppVersion;)V", "getNewAppVersion", "()Lcom/talabat/configuration/discovery/NewAppVersion;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DiscoveryConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final DiscoveryConfig DEFAULT = new DiscoveryConfig(NewAppVersion.Companion.getDEFAULT());
    @Nullable
    private final NewAppVersion newAppVersion;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/discovery/DiscoveryConfig$Companion;", "", "()V", "DEFAULT", "Lcom/talabat/configuration/discovery/DiscoveryConfig;", "getDEFAULT", "()Lcom/talabat/configuration/discovery/DiscoveryConfig;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiscoveryConfig getDEFAULT() {
            return DiscoveryConfig.DEFAULT;
        }
    }

    public DiscoveryConfig() {
        this((NewAppVersion) null, 1, (DefaultConstructorMarker) null);
    }

    public DiscoveryConfig(@Nullable NewAppVersion newAppVersion2) {
        this.newAppVersion = newAppVersion2;
    }

    public static /* synthetic */ DiscoveryConfig copy$default(DiscoveryConfig discoveryConfig, NewAppVersion newAppVersion2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            newAppVersion2 = discoveryConfig.newAppVersion;
        }
        return discoveryConfig.copy(newAppVersion2);
    }

    @Nullable
    public final NewAppVersion component1() {
        return this.newAppVersion;
    }

    @NotNull
    public final DiscoveryConfig copy(@Nullable NewAppVersion newAppVersion2) {
        return new DiscoveryConfig(newAppVersion2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DiscoveryConfig) && Intrinsics.areEqual((Object) this.newAppVersion, (Object) ((DiscoveryConfig) obj).newAppVersion);
    }

    @Nullable
    public final NewAppVersion getNewAppVersion() {
        return this.newAppVersion;
    }

    public int hashCode() {
        NewAppVersion newAppVersion2 = this.newAppVersion;
        if (newAppVersion2 == null) {
            return 0;
        }
        return newAppVersion2.hashCode();
    }

    @NotNull
    public String toString() {
        NewAppVersion newAppVersion2 = this.newAppVersion;
        return "DiscoveryConfig(newAppVersion=" + newAppVersion2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DiscoveryConfig(NewAppVersion newAppVersion2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : newAppVersion2);
    }
}
