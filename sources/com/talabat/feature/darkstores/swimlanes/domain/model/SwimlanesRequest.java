package com.talabat.feature.darkstores.swimlanes.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesRequest;", "", "vendorId", "", "talabatBranchId", "isDarkstore", "", "productId", "productSku", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getProductId", "()Ljava/lang/String;", "getProductSku", "getTalabatBranchId", "getVendorId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-swimlanes_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesRequest {
    private final boolean isDarkstore;
    @NotNull
    private final String productId;
    @NotNull
    private final String productSku;
    @NotNull
    private final String talabatBranchId;
    @NotNull
    private final String vendorId;

    public SwimlanesRequest(@NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "talabatBranchId");
        Intrinsics.checkNotNullParameter(str3, "productId");
        Intrinsics.checkNotNullParameter(str4, "productSku");
        this.vendorId = str;
        this.talabatBranchId = str2;
        this.isDarkstore = z11;
        this.productId = str3;
        this.productSku = str4;
    }

    public static /* synthetic */ SwimlanesRequest copy$default(SwimlanesRequest swimlanesRequest, String str, String str2, boolean z11, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swimlanesRequest.vendorId;
        }
        if ((i11 & 2) != 0) {
            str2 = swimlanesRequest.talabatBranchId;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            z11 = swimlanesRequest.isDarkstore;
        }
        boolean z12 = z11;
        if ((i11 & 8) != 0) {
            str3 = swimlanesRequest.productId;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = swimlanesRequest.productSku;
        }
        return swimlanesRequest.copy(str, str5, z12, str6, str4);
    }

    @NotNull
    public final String component1() {
        return this.vendorId;
    }

    @NotNull
    public final String component2() {
        return this.talabatBranchId;
    }

    public final boolean component3() {
        return this.isDarkstore;
    }

    @NotNull
    public final String component4() {
        return this.productId;
    }

    @NotNull
    public final String component5() {
        return this.productSku;
    }

    @NotNull
    public final SwimlanesRequest copy(@NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "talabatBranchId");
        Intrinsics.checkNotNullParameter(str3, "productId");
        Intrinsics.checkNotNullParameter(str4, "productSku");
        return new SwimlanesRequest(str, str2, z11, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesRequest)) {
            return false;
        }
        SwimlanesRequest swimlanesRequest = (SwimlanesRequest) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) swimlanesRequest.vendorId) && Intrinsics.areEqual((Object) this.talabatBranchId, (Object) swimlanesRequest.talabatBranchId) && this.isDarkstore == swimlanesRequest.isDarkstore && Intrinsics.areEqual((Object) this.productId, (Object) swimlanesRequest.productId) && Intrinsics.areEqual((Object) this.productSku, (Object) swimlanesRequest.productSku);
    }

    @NotNull
    public final String getProductId() {
        return this.productId;
    }

    @NotNull
    public final String getProductSku() {
        return this.productSku;
    }

    @NotNull
    public final String getTalabatBranchId() {
        return this.talabatBranchId;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = ((this.vendorId.hashCode() * 31) + this.talabatBranchId.hashCode()) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        return ((((hashCode + (z11 ? 1 : 0)) * 31) + this.productId.hashCode()) * 31) + this.productSku.hashCode();
    }

    public final boolean isDarkstore() {
        return this.isDarkstore;
    }

    @NotNull
    public String toString() {
        String str = this.vendorId;
        String str2 = this.talabatBranchId;
        boolean z11 = this.isDarkstore;
        String str3 = this.productId;
        String str4 = this.productSku;
        return "SwimlanesRequest(vendorId=" + str + ", talabatBranchId=" + str2 + ", isDarkstore=" + z11 + ", productId=" + str3 + ", productSku=" + str4 + ")";
    }
}
