package com.deliveryhero.customerchat.fwf;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FeatureInfo;", "", "variation", "", "(Z)V", "getVariation", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureInfo {
    private final boolean variation;

    public FeatureInfo(@Json(name = "variation") boolean z11) {
        this.variation = z11;
    }

    public static /* synthetic */ FeatureInfo copy$default(FeatureInfo featureInfo, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = featureInfo.variation;
        }
        return featureInfo.copy(z11);
    }

    public final boolean component1() {
        return this.variation;
    }

    @NotNull
    public final FeatureInfo copy(@Json(name = "variation") boolean z11) {
        return new FeatureInfo(z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeatureInfo) && this.variation == ((FeatureInfo) obj).variation;
    }

    public final boolean getVariation() {
        return this.variation;
    }

    public int hashCode() {
        boolean z11 = this.variation;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "FeatureInfo(variation=" + this.variation + ')';
    }
}
