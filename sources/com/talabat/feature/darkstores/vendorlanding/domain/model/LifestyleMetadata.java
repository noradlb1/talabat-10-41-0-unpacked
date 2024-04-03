package com.talabat.feature.darkstores.vendorlanding.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMetadata;", "", "error", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/MetadataError;", "isError", "", "(Lcom/talabat/feature/darkstores/vendorlanding/domain/model/MetadataError;Z)V", "getError", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/MetadataError;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMetadata {
    @NotNull
    private final MetadataError error;
    private final boolean isError;

    public LifestyleMetadata(@NotNull MetadataError metadataError, boolean z11) {
        Intrinsics.checkNotNullParameter(metadataError, "error");
        this.error = metadataError;
        this.isError = z11;
    }

    public static /* synthetic */ LifestyleMetadata copy$default(LifestyleMetadata lifestyleMetadata, MetadataError metadataError, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            metadataError = lifestyleMetadata.error;
        }
        if ((i11 & 2) != 0) {
            z11 = lifestyleMetadata.isError;
        }
        return lifestyleMetadata.copy(metadataError, z11);
    }

    @NotNull
    public final MetadataError component1() {
        return this.error;
    }

    public final boolean component2() {
        return this.isError;
    }

    @NotNull
    public final LifestyleMetadata copy(@NotNull MetadataError metadataError, boolean z11) {
        Intrinsics.checkNotNullParameter(metadataError, "error");
        return new LifestyleMetadata(metadataError, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LifestyleMetadata)) {
            return false;
        }
        LifestyleMetadata lifestyleMetadata = (LifestyleMetadata) obj;
        return Intrinsics.areEqual((Object) this.error, (Object) lifestyleMetadata.error) && this.isError == lifestyleMetadata.isError;
    }

    @NotNull
    public final MetadataError getError() {
        return this.error;
    }

    public int hashCode() {
        int hashCode = this.error.hashCode() * 31;
        boolean z11 = this.isError;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isError() {
        return this.isError;
    }

    @NotNull
    public String toString() {
        MetadataError metadataError = this.error;
        boolean z11 = this.isError;
        return "LifestyleMetadata(error=" + metadataError + ", isError=" + z11 + ")";
    }
}
