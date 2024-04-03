package com.talabat.feature.darkstoresvendor.data.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/model/TierTagsResponse;", "", "label", "", "message", "progressPercentage", "", "isHighlighted", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLabel", "()Ljava/lang/String;", "getMessage", "getProgressPercentage", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;)Lcom/talabat/feature/darkstoresvendor/data/model/TierTagsResponse;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TierTagsResponse {
    @Nullable
    private final Boolean isHighlighted;
    @Nullable
    private final String label;
    @Nullable
    private final String message;
    @Nullable
    private final Float progressPercentage;

    public TierTagsResponse() {
        this((String) null, (String) null, (Float) null, (Boolean) null, 15, (DefaultConstructorMarker) null);
    }

    public TierTagsResponse(@Nullable @Json(name = "label") String str, @Nullable @Json(name = "message") String str2, @Nullable @Json(name = "progress_percentage") Float f11, @Nullable @Json(name = "is_highlighted") Boolean bool) {
        this.label = str;
        this.message = str2;
        this.progressPercentage = f11;
        this.isHighlighted = bool;
    }

    public static /* synthetic */ TierTagsResponse copy$default(TierTagsResponse tierTagsResponse, String str, String str2, Float f11, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tierTagsResponse.label;
        }
        if ((i11 & 2) != 0) {
            str2 = tierTagsResponse.message;
        }
        if ((i11 & 4) != 0) {
            f11 = tierTagsResponse.progressPercentage;
        }
        if ((i11 & 8) != 0) {
            bool = tierTagsResponse.isHighlighted;
        }
        return tierTagsResponse.copy(str, str2, f11, bool);
    }

    @Nullable
    public final String component1() {
        return this.label;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final Float component3() {
        return this.progressPercentage;
    }

    @Nullable
    public final Boolean component4() {
        return this.isHighlighted;
    }

    @NotNull
    public final TierTagsResponse copy(@Nullable @Json(name = "label") String str, @Nullable @Json(name = "message") String str2, @Nullable @Json(name = "progress_percentage") Float f11, @Nullable @Json(name = "is_highlighted") Boolean bool) {
        return new TierTagsResponse(str, str2, f11, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TierTagsResponse)) {
            return false;
        }
        TierTagsResponse tierTagsResponse = (TierTagsResponse) obj;
        return Intrinsics.areEqual((Object) this.label, (Object) tierTagsResponse.label) && Intrinsics.areEqual((Object) this.message, (Object) tierTagsResponse.message) && Intrinsics.areEqual((Object) this.progressPercentage, (Object) tierTagsResponse.progressPercentage) && Intrinsics.areEqual((Object) this.isHighlighted, (Object) tierTagsResponse.isHighlighted);
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Float getProgressPercentage() {
        return this.progressPercentage;
    }

    public int hashCode() {
        String str = this.label;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f11 = this.progressPercentage;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Boolean bool = this.isHighlighted;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode3 + i11;
    }

    @Nullable
    public final Boolean isHighlighted() {
        return this.isHighlighted;
    }

    @NotNull
    public String toString() {
        String str = this.label;
        String str2 = this.message;
        Float f11 = this.progressPercentage;
        Boolean bool = this.isHighlighted;
        return "TierTagsResponse(label=" + str + ", message=" + str2 + ", progressPercentage=" + f11 + ", isHighlighted=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TierTagsResponse(String str, String str2, Float f11, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : f11, (i11 & 8) != 0 ? null : bool);
    }
}
