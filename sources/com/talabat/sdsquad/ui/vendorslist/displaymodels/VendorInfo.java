package com.talabat.sdsquad.ui.vendorslist.displaymodels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorInfo;", "", "baseUrl", "", "digitCount", "", "(Ljava/lang/String;I)V", "getBaseUrl", "()Ljava/lang/String;", "getDigitCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfo {
    @NotNull
    private final String baseUrl;
    private final int digitCount;

    public VendorInfo(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        this.baseUrl = str;
        this.digitCount = i11;
    }

    public static /* synthetic */ VendorInfo copy$default(VendorInfo vendorInfo, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = vendorInfo.baseUrl;
        }
        if ((i12 & 2) != 0) {
            i11 = vendorInfo.digitCount;
        }
        return vendorInfo.copy(str, i11);
    }

    @NotNull
    public final String component1() {
        return this.baseUrl;
    }

    public final int component2() {
        return this.digitCount;
    }

    @NotNull
    public final VendorInfo copy(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        return new VendorInfo(str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorInfo)) {
            return false;
        }
        VendorInfo vendorInfo = (VendorInfo) obj;
        return Intrinsics.areEqual((Object) this.baseUrl, (Object) vendorInfo.baseUrl) && this.digitCount == vendorInfo.digitCount;
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final int getDigitCount() {
        return this.digitCount;
    }

    public int hashCode() {
        return (this.baseUrl.hashCode() * 31) + this.digitCount;
    }

    @NotNull
    public String toString() {
        String str = this.baseUrl;
        int i11 = this.digitCount;
        return "VendorInfo(baseUrl=" + str + ", digitCount=" + i11 + ")";
    }
}
