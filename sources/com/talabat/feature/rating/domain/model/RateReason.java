package com.talabat.feature.rating.domain.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/rating/domain/model/RateReason;", "", "id", "", "ratingReason", "", "enabledForRatings", "", "(ILjava/lang/String;[I)V", "getEnabledForRatings", "()[I", "getId", "()I", "getRatingReason", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RateReason {
    @NotNull
    private final int[] enabledForRatings;

    /* renamed from: id  reason: collision with root package name */
    private final int f58679id;
    @NotNull
    private final String ratingReason;

    public RateReason(int i11, @NotNull String str, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(str, "ratingReason");
        Intrinsics.checkNotNullParameter(iArr, "enabledForRatings");
        this.f58679id = i11;
        this.ratingReason = str;
        this.enabledForRatings = iArr;
    }

    public static /* synthetic */ RateReason copy$default(RateReason rateReason, int i11, String str, int[] iArr, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = rateReason.f58679id;
        }
        if ((i12 & 2) != 0) {
            str = rateReason.ratingReason;
        }
        if ((i12 & 4) != 0) {
            iArr = rateReason.enabledForRatings;
        }
        return rateReason.copy(i11, str, iArr);
    }

    public final int component1() {
        return this.f58679id;
    }

    @NotNull
    public final String component2() {
        return this.ratingReason;
    }

    @NotNull
    public final int[] component3() {
        return this.enabledForRatings;
    }

    @NotNull
    public final RateReason copy(int i11, @NotNull String str, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(str, "ratingReason");
        Intrinsics.checkNotNullParameter(iArr, "enabledForRatings");
        return new RateReason(i11, str, iArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RateReason)) {
            return false;
        }
        RateReason rateReason = (RateReason) obj;
        return this.f58679id == rateReason.f58679id && Intrinsics.areEqual((Object) this.ratingReason, (Object) rateReason.ratingReason) && Intrinsics.areEqual((Object) this.enabledForRatings, (Object) rateReason.enabledForRatings);
    }

    @NotNull
    public final int[] getEnabledForRatings() {
        return this.enabledForRatings;
    }

    public final int getId() {
        return this.f58679id;
    }

    @NotNull
    public final String getRatingReason() {
        return this.ratingReason;
    }

    public int hashCode() {
        return (((this.f58679id * 31) + this.ratingReason.hashCode()) * 31) + Arrays.hashCode(this.enabledForRatings);
    }

    @NotNull
    public String toString() {
        int i11 = this.f58679id;
        String str = this.ratingReason;
        String arrays = Arrays.toString(this.enabledForRatings);
        return "RateReason(id=" + i11 + ", ratingReason=" + str + ", enabledForRatings=" + arrays + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RateReason(int i11, String str, int[] iArr, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, str, iArr);
    }
}
