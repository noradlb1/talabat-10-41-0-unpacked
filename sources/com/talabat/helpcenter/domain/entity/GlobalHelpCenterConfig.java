package com.talabat.helpcenter.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/helpcenter/domain/entity/GlobalHelpCenterConfig;", "", "helpCenterUrl", "", "(Ljava/lang/String;)V", "getHelpCenterUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterConfig {
    @NotNull
    private final String helpCenterUrl;

    public GlobalHelpCenterConfig(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "helpCenterUrl");
        this.helpCenterUrl = str;
    }

    public static /* synthetic */ GlobalHelpCenterConfig copy$default(GlobalHelpCenterConfig globalHelpCenterConfig, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = globalHelpCenterConfig.helpCenterUrl;
        }
        return globalHelpCenterConfig.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.helpCenterUrl;
    }

    @NotNull
    public final GlobalHelpCenterConfig copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "helpCenterUrl");
        return new GlobalHelpCenterConfig(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GlobalHelpCenterConfig) && Intrinsics.areEqual((Object) this.helpCenterUrl, (Object) ((GlobalHelpCenterConfig) obj).helpCenterUrl);
    }

    @NotNull
    public final String getHelpCenterUrl() {
        return this.helpCenterUrl;
    }

    public int hashCode() {
        return this.helpCenterUrl.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.helpCenterUrl;
        return "GlobalHelpCenterConfig(helpCenterUrl=" + str + ")";
    }
}
