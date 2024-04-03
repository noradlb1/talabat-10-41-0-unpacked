package com.talabat.feature.fees.data.remote.dto;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/feature/fees/data/remote/dto/FeeDescription;", "Ljava/io/Serializable;", "feeType", "", "name", "description", "url", "urlText", "details", "Lcom/talabat/feature/fees/data/remote/dto/FeeDescriptionDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/fees/data/remote/dto/FeeDescriptionDetails;)V", "getDescription", "()Ljava/lang/String;", "getDetails", "()Lcom/talabat/feature/fees/data/remote/dto/FeeDescriptionDetails;", "getFeeType", "getName", "getUrl", "getUrlText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeeDescription implements Serializable {
    @NotNull
    private final String description;
    @Nullable
    private final FeeDescriptionDetails details;
    @NotNull
    private final String feeType;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58512name;
    @Nullable
    private final String url;
    @Nullable
    private final String urlText;

    public FeeDescription(@NotNull @Json(name = "fee_type") String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable @Json(name = "url_text") String str5, @Nullable FeeDescriptionDetails feeDescriptionDetails) {
        Intrinsics.checkNotNullParameter(str, "feeType");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        this.feeType = str;
        this.f58512name = str2;
        this.description = str3;
        this.url = str4;
        this.urlText = str5;
        this.details = feeDescriptionDetails;
    }

    public static /* synthetic */ FeeDescription copy$default(FeeDescription feeDescription, String str, String str2, String str3, String str4, String str5, FeeDescriptionDetails feeDescriptionDetails, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = feeDescription.feeType;
        }
        if ((i11 & 2) != 0) {
            str2 = feeDescription.f58512name;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = feeDescription.description;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = feeDescription.url;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = feeDescription.urlText;
        }
        String str9 = str5;
        if ((i11 & 32) != 0) {
            feeDescriptionDetails = feeDescription.details;
        }
        return feeDescription.copy(str, str6, str7, str8, str9, feeDescriptionDetails);
    }

    @NotNull
    public final String component1() {
        return this.feeType;
    }

    @NotNull
    public final String component2() {
        return this.f58512name;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @Nullable
    public final String component5() {
        return this.urlText;
    }

    @Nullable
    public final FeeDescriptionDetails component6() {
        return this.details;
    }

    @NotNull
    public final FeeDescription copy(@NotNull @Json(name = "fee_type") String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable @Json(name = "url_text") String str5, @Nullable FeeDescriptionDetails feeDescriptionDetails) {
        Intrinsics.checkNotNullParameter(str, "feeType");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        return new FeeDescription(str, str2, str3, str4, str5, feeDescriptionDetails);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeeDescription)) {
            return false;
        }
        FeeDescription feeDescription = (FeeDescription) obj;
        return Intrinsics.areEqual((Object) this.feeType, (Object) feeDescription.feeType) && Intrinsics.areEqual((Object) this.f58512name, (Object) feeDescription.f58512name) && Intrinsics.areEqual((Object) this.description, (Object) feeDescription.description) && Intrinsics.areEqual((Object) this.url, (Object) feeDescription.url) && Intrinsics.areEqual((Object) this.urlText, (Object) feeDescription.urlText) && Intrinsics.areEqual((Object) this.details, (Object) feeDescription.details);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final FeeDescriptionDetails getDetails() {
        return this.details;
    }

    @NotNull
    public final String getFeeType() {
        return this.feeType;
    }

    @NotNull
    public final String getName() {
        return this.f58512name;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getUrlText() {
        return this.urlText;
    }

    public int hashCode() {
        int hashCode = ((((this.feeType.hashCode() * 31) + this.f58512name.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str = this.url;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.urlText;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        FeeDescriptionDetails feeDescriptionDetails = this.details;
        if (feeDescriptionDetails != null) {
            i11 = feeDescriptionDetails.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.feeType;
        String str2 = this.f58512name;
        String str3 = this.description;
        String str4 = this.url;
        String str5 = this.urlText;
        FeeDescriptionDetails feeDescriptionDetails = this.details;
        return "FeeDescription(feeType=" + str + ", name=" + str2 + ", description=" + str3 + ", url=" + str4 + ", urlText=" + str5 + ", details=" + feeDescriptionDetails + ")";
    }
}
