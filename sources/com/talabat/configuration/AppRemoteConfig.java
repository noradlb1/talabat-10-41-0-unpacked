package com.talabat.configuration;

import fwfd.com.fwfsdk.constant.FWFConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/configuration/AppRemoteConfig;", "", "ipAddress", "", "(Ljava/lang/String;)V", "getIpAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppRemoteConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final AppRemoteConfig DEFAULT = new AppRemoteConfig("");
    @NotNull
    private final String ipAddress;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/AppRemoteConfig$Companion;", "", "()V", "DEFAULT", "Lcom/talabat/configuration/AppRemoteConfig;", "getDEFAULT", "()Lcom/talabat/configuration/AppRemoteConfig;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AppRemoteConfig getDEFAULT() {
            return AppRemoteConfig.DEFAULT;
        }
    }

    public AppRemoteConfig(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FWFConstants.USER_ATTRIBUTE_IP_ADDRESS);
        this.ipAddress = str;
    }

    public static /* synthetic */ AppRemoteConfig copy$default(AppRemoteConfig appRemoteConfig, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = appRemoteConfig.ipAddress;
        }
        return appRemoteConfig.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.ipAddress;
    }

    @NotNull
    public final AppRemoteConfig copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FWFConstants.USER_ATTRIBUTE_IP_ADDRESS);
        return new AppRemoteConfig(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppRemoteConfig) && Intrinsics.areEqual((Object) this.ipAddress, (Object) ((AppRemoteConfig) obj).ipAddress);
    }

    @NotNull
    public final String getIpAddress() {
        return this.ipAddress;
    }

    public int hashCode() {
        return this.ipAddress.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.ipAddress;
        return "AppRemoteConfig(ipAddress=" + str + ")";
    }
}
