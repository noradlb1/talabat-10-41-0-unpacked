package com.talabat.feature.fees.data.remote.dto;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/fees/data/remote/dto/FeeDescriptionDetails;", "Ljava/io/Serializable;", "explanation", "", "(Ljava/lang/String;)V", "getExplanation", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeeDescriptionDetails implements Serializable {
    @Nullable
    private final String explanation;

    public FeeDescriptionDetails(@Nullable @Json(name = "explanation") String str) {
        this.explanation = str;
    }

    public static /* synthetic */ FeeDescriptionDetails copy$default(FeeDescriptionDetails feeDescriptionDetails, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = feeDescriptionDetails.explanation;
        }
        return feeDescriptionDetails.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.explanation;
    }

    @NotNull
    public final FeeDescriptionDetails copy(@Nullable @Json(name = "explanation") String str) {
        return new FeeDescriptionDetails(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeeDescriptionDetails) && Intrinsics.areEqual((Object) this.explanation, (Object) ((FeeDescriptionDetails) obj).explanation);
    }

    @Nullable
    public final String getExplanation() {
        return this.explanation;
    }

    public int hashCode() {
        String str = this.explanation;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.explanation;
        return "FeeDescriptionDetails(explanation=" + str + ")";
    }
}
