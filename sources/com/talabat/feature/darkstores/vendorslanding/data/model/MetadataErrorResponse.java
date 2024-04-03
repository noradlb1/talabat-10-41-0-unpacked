package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataErrorResponse;", "", "message", "", "code", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetadataErrorResponse {
    @Nullable
    private final String code;
    @Nullable
    private final String message;

    public MetadataErrorResponse(@Nullable @Json(name = "message") String str, @Nullable @Json(name = "code") String str2) {
        this.message = str;
        this.code = str2;
    }

    public static /* synthetic */ MetadataErrorResponse copy$default(MetadataErrorResponse metadataErrorResponse, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = metadataErrorResponse.message;
        }
        if ((i11 & 2) != 0) {
            str2 = metadataErrorResponse.code;
        }
        return metadataErrorResponse.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final String component2() {
        return this.code;
    }

    @NotNull
    public final MetadataErrorResponse copy(@Nullable @Json(name = "message") String str, @Nullable @Json(name = "code") String str2) {
        return new MetadataErrorResponse(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataErrorResponse)) {
            return false;
        }
        MetadataErrorResponse metadataErrorResponse = (MetadataErrorResponse) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) metadataErrorResponse.message) && Intrinsics.areEqual((Object) this.code, (Object) metadataErrorResponse.code);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String str = this.message;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.code;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.message;
        String str2 = this.code;
        return "MetadataErrorResponse(message=" + str + ", code=" + str2 + ")";
    }
}
