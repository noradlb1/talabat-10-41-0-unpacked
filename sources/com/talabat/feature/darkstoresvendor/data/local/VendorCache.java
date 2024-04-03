package com.talabat.feature.darkstoresvendor.data.local;

import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/local/VendorCache;", "", "()V", "vendorCode", "", "getVendorCode", "()Ljava/lang/String;", "setVendorCode", "(Ljava/lang/String;)V", "vendorResponse", "Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponse;", "cacheVendor", "", "clearCache", "getVendor", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorCache {
    @Nullable
    private String vendorCode;
    @Nullable
    private VendorResponse vendorResponse;

    public final synchronized void cacheVendor(@NotNull String str, @NotNull VendorResponse vendorResponse2) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(vendorResponse2, "vendorResponse");
        this.vendorCode = str;
        this.vendorResponse = vendorResponse2;
    }

    public final synchronized void clearCache() {
        this.vendorCode = null;
        this.vendorResponse = null;
    }

    @Nullable
    public final synchronized VendorResponse getVendor(@NotNull String str) {
        VendorResponse vendorResponse2;
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        vendorResponse2 = this.vendorResponse;
        if (!Intrinsics.areEqual((Object) this.vendorCode, (Object) str)) {
            vendorResponse2 = null;
        }
        return vendorResponse2;
    }

    @Nullable
    public final String getVendorCode() {
        return this.vendorCode;
    }

    public final void setVendorCode(@Nullable String str) {
        this.vendorCode = str;
    }
}
