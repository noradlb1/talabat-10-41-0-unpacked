package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ&\u0010\r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0004\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataResponse;", "", "error", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataErrorResponse;", "isError", "", "(Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataErrorResponse;Ljava/lang/Boolean;)V", "getError", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataErrorResponse;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataErrorResponse;Ljava/lang/Boolean;)Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataResponse;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetadataResponse {
    @Nullable
    private final MetadataErrorResponse error;
    @Nullable
    private final Boolean isError;

    public MetadataResponse(@Nullable @Json(name = "error_metadata") MetadataErrorResponse metadataErrorResponse, @Nullable @Json(name = "is_error") Boolean bool) {
        this.error = metadataErrorResponse;
        this.isError = bool;
    }

    public static /* synthetic */ MetadataResponse copy$default(MetadataResponse metadataResponse, MetadataErrorResponse metadataErrorResponse, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            metadataErrorResponse = metadataResponse.error;
        }
        if ((i11 & 2) != 0) {
            bool = metadataResponse.isError;
        }
        return metadataResponse.copy(metadataErrorResponse, bool);
    }

    @Nullable
    public final MetadataErrorResponse component1() {
        return this.error;
    }

    @Nullable
    public final Boolean component2() {
        return this.isError;
    }

    @NotNull
    public final MetadataResponse copy(@Nullable @Json(name = "error_metadata") MetadataErrorResponse metadataErrorResponse, @Nullable @Json(name = "is_error") Boolean bool) {
        return new MetadataResponse(metadataErrorResponse, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataResponse)) {
            return false;
        }
        MetadataResponse metadataResponse = (MetadataResponse) obj;
        return Intrinsics.areEqual((Object) this.error, (Object) metadataResponse.error) && Intrinsics.areEqual((Object) this.isError, (Object) metadataResponse.isError);
    }

    @Nullable
    public final MetadataErrorResponse getError() {
        return this.error;
    }

    public int hashCode() {
        MetadataErrorResponse metadataErrorResponse = this.error;
        int i11 = 0;
        int hashCode = (metadataErrorResponse == null ? 0 : metadataErrorResponse.hashCode()) * 31;
        Boolean bool = this.isError;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode + i11;
    }

    @Nullable
    public final Boolean isError() {
        return this.isError;
    }

    @NotNull
    public String toString() {
        MetadataErrorResponse metadataErrorResponse = this.error;
        Boolean bool = this.isError;
        return "MetadataResponse(error=" + metadataErrorResponse + ", isError=" + bool + ")";
    }
}
