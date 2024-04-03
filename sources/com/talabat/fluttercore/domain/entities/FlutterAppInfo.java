package com.talabat.fluttercore.domain.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/talabat/fluttercore/domain/entities/FlutterAppInfo;", "", "isAmexAvailable", "", "termsAndConditionsBaseUrl", "", "(ZLjava/lang/String;)V", "()Z", "getTermsAndConditionsBaseUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterAppInfo {
    private final boolean isAmexAvailable;
    @NotNull
    private final String termsAndConditionsBaseUrl;

    public FlutterAppInfo(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "termsAndConditionsBaseUrl");
        this.isAmexAvailable = z11;
        this.termsAndConditionsBaseUrl = str;
    }

    public static /* synthetic */ FlutterAppInfo copy$default(FlutterAppInfo flutterAppInfo, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = flutterAppInfo.isAmexAvailable;
        }
        if ((i11 & 2) != 0) {
            str = flutterAppInfo.termsAndConditionsBaseUrl;
        }
        return flutterAppInfo.copy(z11, str);
    }

    public final boolean component1() {
        return this.isAmexAvailable;
    }

    @NotNull
    public final String component2() {
        return this.termsAndConditionsBaseUrl;
    }

    @NotNull
    public final FlutterAppInfo copy(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "termsAndConditionsBaseUrl");
        return new FlutterAppInfo(z11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterAppInfo)) {
            return false;
        }
        FlutterAppInfo flutterAppInfo = (FlutterAppInfo) obj;
        return this.isAmexAvailable == flutterAppInfo.isAmexAvailable && Intrinsics.areEqual((Object) this.termsAndConditionsBaseUrl, (Object) flutterAppInfo.termsAndConditionsBaseUrl);
    }

    @NotNull
    public final String getTermsAndConditionsBaseUrl() {
        return this.termsAndConditionsBaseUrl;
    }

    public int hashCode() {
        boolean z11 = this.isAmexAvailable;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.termsAndConditionsBaseUrl.hashCode();
    }

    public final boolean isAmexAvailable() {
        return this.isAmexAvailable;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isAmexAvailable;
        String str = this.termsAndConditionsBaseUrl;
        return "FlutterAppInfo(isAmexAvailable=" + z11 + ", termsAndConditionsBaseUrl=" + str + ")";
    }
}
