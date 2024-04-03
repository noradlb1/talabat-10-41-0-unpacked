package com.talabat.configuration.discovery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/configuration/discovery/NewAppVersion;", "", "message", "", "version", "shouldForceUpdate", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getMessage", "()Ljava/lang/String;", "getShouldForceUpdate", "()Z", "getVersion", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewAppVersion {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final NewAppVersion DEFAULT = new NewAppVersion((String) null, (String) null, false);
    @Nullable
    private final String message;
    private final boolean shouldForceUpdate;
    @Nullable
    private final String version;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/discovery/NewAppVersion$Companion;", "", "()V", "DEFAULT", "Lcom/talabat/configuration/discovery/NewAppVersion;", "getDEFAULT", "()Lcom/talabat/configuration/discovery/NewAppVersion;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NewAppVersion getDEFAULT() {
            return NewAppVersion.DEFAULT;
        }
    }

    public NewAppVersion() {
        this((String) null, (String) null, false, 7, (DefaultConstructorMarker) null);
    }

    public NewAppVersion(@Nullable String str, @Nullable String str2, boolean z11) {
        this.message = str;
        this.version = str2;
        this.shouldForceUpdate = z11;
    }

    public static /* synthetic */ NewAppVersion copy$default(NewAppVersion newAppVersion, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = newAppVersion.message;
        }
        if ((i11 & 2) != 0) {
            str2 = newAppVersion.version;
        }
        if ((i11 & 4) != 0) {
            z11 = newAppVersion.shouldForceUpdate;
        }
        return newAppVersion.copy(str, str2, z11);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final String component2() {
        return this.version;
    }

    public final boolean component3() {
        return this.shouldForceUpdate;
    }

    @NotNull
    public final NewAppVersion copy(@Nullable String str, @Nullable String str2, boolean z11) {
        return new NewAppVersion(str, str2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewAppVersion)) {
            return false;
        }
        NewAppVersion newAppVersion = (NewAppVersion) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) newAppVersion.message) && Intrinsics.areEqual((Object) this.version, (Object) newAppVersion.version) && this.shouldForceUpdate == newAppVersion.shouldForceUpdate;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public final boolean getShouldForceUpdate() {
        return this.shouldForceUpdate;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.message;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        int i12 = (hashCode + i11) * 31;
        boolean z11 = this.shouldForceUpdate;
        if (z11) {
            z11 = true;
        }
        return i12 + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        String str = this.message;
        String str2 = this.version;
        boolean z11 = this.shouldForceUpdate;
        return "NewAppVersion(message=" + str + ", version=" + str2 + ", shouldForceUpdate=" + z11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewAppVersion(String str, String str2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? false : z11);
    }
}
