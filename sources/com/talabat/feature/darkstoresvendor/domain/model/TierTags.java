package com.talabat.feature.darkstoresvendor.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/domain/model/TierTags;", "", "label", "", "message", "progressPercentage", "", "isHighlighted", "", "(Ljava/lang/String;Ljava/lang/String;FZ)V", "()Z", "getLabel", "()Ljava/lang/String;", "getMessage", "getProgressPercentage", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TierTags {
    private final boolean isHighlighted;
    @NotNull
    private final String label;
    @NotNull
    private final String message;
    private final float progressPercentage;

    public TierTags(@NotNull String str, @NotNull String str2, float f11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, "message");
        this.label = str;
        this.message = str2;
        this.progressPercentage = f11;
        this.isHighlighted = z11;
    }

    public static /* synthetic */ TierTags copy$default(TierTags tierTags, String str, String str2, float f11, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tierTags.label;
        }
        if ((i11 & 2) != 0) {
            str2 = tierTags.message;
        }
        if ((i11 & 4) != 0) {
            f11 = tierTags.progressPercentage;
        }
        if ((i11 & 8) != 0) {
            z11 = tierTags.isHighlighted;
        }
        return tierTags.copy(str, str2, f11, z11);
    }

    @NotNull
    public final String component1() {
        return this.label;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    public final float component3() {
        return this.progressPercentage;
    }

    public final boolean component4() {
        return this.isHighlighted;
    }

    @NotNull
    public final TierTags copy(@NotNull String str, @NotNull String str2, float f11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, "message");
        return new TierTags(str, str2, f11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TierTags)) {
            return false;
        }
        TierTags tierTags = (TierTags) obj;
        return Intrinsics.areEqual((Object) this.label, (Object) tierTags.label) && Intrinsics.areEqual((Object) this.message, (Object) tierTags.message) && Intrinsics.areEqual((Object) Float.valueOf(this.progressPercentage), (Object) Float.valueOf(tierTags.progressPercentage)) && this.isHighlighted == tierTags.isHighlighted;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final float getProgressPercentage() {
        return this.progressPercentage;
    }

    public int hashCode() {
        int hashCode = ((((this.label.hashCode() * 31) + this.message.hashCode()) * 31) + Float.floatToIntBits(this.progressPercentage)) * 31;
        boolean z11 = this.isHighlighted;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isHighlighted() {
        return this.isHighlighted;
    }

    @NotNull
    public String toString() {
        String str = this.label;
        String str2 = this.message;
        float f11 = this.progressPercentage;
        boolean z11 = this.isHighlighted;
        return "TierTags(label=" + str + ", message=" + str2 + ", progressPercentage=" + f11 + ", isHighlighted=" + z11 + ")";
    }
}
